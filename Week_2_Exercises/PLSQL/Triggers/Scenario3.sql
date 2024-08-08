CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Ensure the deposit amount is positive
    IF :NEW.transaction_type = 'DEPOSIT' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive');
    END IF;
    
    -- Ensure the withdrawal amount does not exceed the balance
    IF :NEW.transaction_type = 'WITHDRAWAL' THEN
        SELECT balance INTO v_balance FROM accounts WHERE account_id = :NEW.account_id;
        IF :NEW.amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds for withdrawal');
        END IF;
    END IF;
END CheckTransactionRules;
