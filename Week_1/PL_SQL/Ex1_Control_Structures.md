-- Scenario 1: Senior Citizen Loan Discount
BEGIN
    FOR c IN (SELECT id, rate FROM loans JOIN customers ON loans.cust_id = customers.id WHERE age > 60) LOOP
        UPDATE loans 
        SET rate = rate - 1 
        WHERE id = c.id;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: VIP Promotion
BEGIN
    FOR c IN (SELECT id FROM accounts WHERE balance > 10000) LOOP
        UPDATE customers 
        SET is_vip = 'TRUE' 
        WHERE id = c.id;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Loan Due Reminders
BEGIN
    FOR rec IN (SELECT c.name, l.id, l.due_date 
                FROM loans l 
                JOIN customers c ON l.cust_id = c.id 
                WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.name || ', Loan ID ' || rec.id || ' is due on ' || rec.due_date);
    END LOOP;
END;
/