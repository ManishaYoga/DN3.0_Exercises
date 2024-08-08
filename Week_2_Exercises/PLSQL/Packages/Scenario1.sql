CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_date_of_birth IN DATE,
        p_address IN VARCHAR2
    );

    PROCEDURE UpdateCustomerDetails(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_date_of_birth IN DATE,
        p_address IN VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;


CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_date_of_birth IN DATE,
        p_address IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Customers (customer_id, name, date_of_birth, address, balance)
        VALUES (p_customer_id, p_name, p_date_of_birth, p_address, 0);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_date_of_birth IN DATE,
        p_address IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Customers
        SET name = p_name, date_of_birth = p_date_of_birth, address = p_address
        WHERE customer_id = p_customer_id;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance FROM Customers WHERE customer_id = p_customer_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
