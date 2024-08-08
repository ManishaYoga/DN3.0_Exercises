CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    e_insufficient_funds EXCEPTION;
    v_from_balance NUMBER;
BEGIN
    -- Check the balance of the source account
    SELECT balance INTO v_from_balance FROM accounts WHERE account_id = p_from_account_id;
    
    -- Raise an exception if insufficient funds
    IF v_from_balance < p_amount THEN
        RAISE e_insufficient_funds;
    END IF;
    
    -- Deduct amount from source account
    UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    
    -- Add amount to destination account
    UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;
    
    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN e_insufficient_funds THEN
        -- Handle insufficient funds
        ROLLBACK;
        INSERT INTO error_log (error_message, error_time)
        VALUES ('Insufficient funds for account ' || p_from_account_id, SYSDATE);
    
    WHEN OTHERS THEN
        -- Handle other exceptions
        ROLLBACK;
        INSERT INTO error_log (error_message, error_time)
        VALUES (SQLERRM, SYSDATE);
END SafeTransferFunds;
