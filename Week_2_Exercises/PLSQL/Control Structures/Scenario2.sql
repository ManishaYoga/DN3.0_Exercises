DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000;
    v_customer_id customers.customer_id%TYPE;
    v_balance customers.balance%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_balance;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        -- Set the IsVIP flag to TRUE
        UPDATE customers
        SET IsVIP = 'TRUE'
        WHERE customer_id = v_customer_id;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
END;
