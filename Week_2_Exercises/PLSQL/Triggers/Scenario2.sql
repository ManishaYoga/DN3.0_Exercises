CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (transaction_id, account_id, transaction_type, amount, transaction_date)
    VALUES (:NEW.transaction_id, :NEW.account_id, :NEW.transaction_type, :NEW.amount, :NEW.transaction_date);
END LogTransaction;
