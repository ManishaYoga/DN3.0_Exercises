DECLARE
    CURSOR c_loans IS
        SELECT loan_id, interest_rate
        FROM loans;

    v_loan_id loans.loan_id%TYPE;
    v_interest_rate loans.interest_rate%TYPE;
    v_new_interest_rate NUMBER;
    
    -- Define your new policy here, for example, increase by 1%
    PROCEDURE calculate_new_interest_rate(p_old_rate IN NUMBER, p_new_rate OUT NUMBER) IS
    BEGIN
        p_new_rate := p_old_rate + 1;
    END;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_loans%NOTFOUND;
        
        -- Calculate the new interest rate based on the policy
        calculate_new_interest_rate(v_interest_rate, v_new_interest_rate);
        
        -- Update the loan interest rate
        UPDATE loans
        SET interest_rate = v_new_interest_rate
        WHERE loan_id = v_loan_id;

        -- Optionally, print out the updated interest rate
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' New Interest Rate: ' || v_new_interest_rate);
    END LOOP;
    CLOSE c_loans;
    
    -- Commit the transaction to apply the changes
    COMMIT;
END;
