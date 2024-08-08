CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    e_employee_not_found EXCEPTION;
    v_salary NUMBER;
BEGIN
    -- Check if the employee exists and get their current salary
    SELECT salary INTO v_salary FROM employees WHERE employee_id = p_employee_id;
    
    -- If no rows are found, raise an exception
    IF SQL%NOTFOUND THEN
        RAISE e_employee_not_found;
    END IF;
    
    -- Update the salary by the given percentage
    UPDATE employees SET salary = salary + (salary * p_percentage / 100) WHERE employee_id = p_employee_id;
    
    -- Commit the transaction
    COMMIT;
    
EXCEPTION
    WHEN e_employee_not_found THEN
        -- Handle employee not found
        INSERT INTO error_log (error_message, error_time)
        VALUES ('Employee ID ' || p_employee_id || ' not found', SYSDATE);
    
    WHEN OTHERS THEN
        -- Handle other exceptions
        ROLLBACK;
        INSERT INTO error_log (error_message, error_time)
        VALUES (SQLERRM, SYSDATE);
END UpdateSalary;
