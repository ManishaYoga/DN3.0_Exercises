CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_age IN NUMBER,
    p_address IN VARCHAR2
) IS
    e_duplicate_customer EXCEPTION;
BEGIN
    -- Attempt to insert a new customer
    INSERT INTO customers (customer_id, name, age, address)
    VALUES (p_customer_id, p_name, p_age, p_address);
    
    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        -- Handle duplicate customer ID
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Customer ID ' || p_customer_id || ' already exists');
    
    WHEN OTHERS THEN
        -- Handle other exceptions
        ROLLBACK;
        INSERT INTO error_log (error_message, error_time)
        VALUES (SQLERRM, SYSDATE);
END AddNewCustomer;
