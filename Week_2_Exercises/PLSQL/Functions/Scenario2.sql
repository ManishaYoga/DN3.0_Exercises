CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_annual_interest_rate NUMBER,
    p_loan_duration_years NUMBER
) RETURN NUMBER IS
    v_monthly_interest_rate NUMBER;
    v_number_of_payments NUMBER;
    v_monthly_installment NUMBER;
BEGIN
    -- Convert annual interest rate to monthly interest rate
    v_monthly_interest_rate := p_annual_interest_rate / 12 / 100;
    
    -- Calculate the number of monthly payments
    v_number_of_payments := p_loan_duration_years * 12;
    
    -- Calculate the monthly installment using the formula for an annuity
    v_monthly_installment := p_loan_amount * v_monthly_interest_rate / 
                             (1 - POWER(1 + v_monthly_interest_rate, -v_number_of_payments));
    
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
