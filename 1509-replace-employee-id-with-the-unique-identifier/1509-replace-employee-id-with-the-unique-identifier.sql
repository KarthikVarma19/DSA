SELECT 
    EU.unique_id AS unique_id,  E.name AS name
FROM EmployeeUNI EU
RIGHT JOIN Employees E 
ON EU.id = E.id;

