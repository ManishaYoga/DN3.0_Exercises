DECLARE
    CURSOR loan_cursor IS
        SELECT customer_id, loan_due_date
        FROM loans
        WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30;
    v_customer_id loans.customer_id%TYPE;
    v_loan_due_date loans.loan_due_date%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_customer_id, v_loan_due_date;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        -- Print reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_customer_id || 
                             ' has a loan due on ' || TO_CHAR(v_loan_due_date, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE loan_cursor;
END;
