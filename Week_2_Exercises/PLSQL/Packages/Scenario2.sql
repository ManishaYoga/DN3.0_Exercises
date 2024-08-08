CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireNewEmployee(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_hire_date IN DATE,
        p_department_id IN NUMBER,
        p_salary IN NUMBER
    );

    PROCEDURE UpdateEmployeeDetails(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_hire_date IN DATE,
        p_department_id IN NUMBER,
        p_salary IN NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_employee_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireNewEmployee(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_hire_date IN DATE,
        p_department_id IN NUMBER,
        p_salary IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Employees (employee_id, name, hire_date, department_id, salary)
        VALUES (p_employee_id, p_name, p_hire_date, p_department_id, p_salary);
    END HireNewEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_hire_date IN DATE,
        p_department_id IN NUMBER,
        p_salary IN NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET name = p_name, hire_date = p_hire_date, department_id = p_department_id, salary = p_salary
        WHERE employee_id = p_employee_id;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary INTO v_salary FROM Employees WHERE employee_id = p_employee_id;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
