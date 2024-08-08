DECLARE
    CURSOR c_transactions IS
        SELECT customer_id, account_id, transaction_type, amount, transaction_date
        FROM transactions
        WHERE TRUNC(transaction_date, 'MM') = TRUNC(SYSDATE, 'MM');

    v_customer_id transactions.customer_id%TYPE;
    v_account_id transactions.account_id%TYPE;
    v_transaction_type transactions.transaction_type%TYPE;
    v_amount transactions.amount%TYPE;
    v_transaction_date transactions.transaction_date%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customer_id, v_account_id, v_transaction_type, v_amount, v_transaction_date;
        EXIT WHEN c_transactions%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || v_transaction_type);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_transaction_date);
        DBMS_OUTPUT.PUT_LINE('-------------------------');
    END LOOP;
    CLOSE c_transactions;
END;
