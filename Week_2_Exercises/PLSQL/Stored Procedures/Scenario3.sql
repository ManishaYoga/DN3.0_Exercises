CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_from_balance NUMBER;
BEGIN
    -- Check the balance of the source account
    SELECT balance INTO v_from_balance FROM accounts WHERE account_id = p_from_account_id;
    
    -- Check if the source account has sufficient balance
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
    END IF;
    
    -- Deduct the amount from the source account
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;
    
    -- Add the amount to the destination account
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;
    
    -- Commit the transaction
    COMMIT;
END TransferFunds;
