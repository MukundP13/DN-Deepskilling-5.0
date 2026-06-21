-- Scenario 1: Process Monthly Interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts 
    SET balance = balance * 1.01 
    WHERE account_type = 'SAVINGS';
    COMMIT;
END;
/

-- Scenario 2: Update Employee Bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_dept IN VARCHAR2,
    p_bonus_pct IN NUMBER
) AS
BEGIN
    UPDATE employees 
    SET salary = salary * (1 + (p_bonus_pct / 100)) 
    WHERE department = p_dept;
    COMMIT;
END;
/

-- Scenario 3: Transfer Funds with Balance Check
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_src_id IN NUMBER,
    p_dest_id IN NUMBER,
    p_amt IN NUMBER
) AS
    v_bal NUMBER;
BEGIN
    SELECT balance INTO v_bal FROM accounts WHERE id = p_src_id FOR UPDATE;
    
    IF v_bal < p_amt THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE accounts SET balance = balance - p_amt WHERE id = p_src_id;
    UPDATE accounts SET balance = balance + p_amt WHERE id = p_dest_id;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/