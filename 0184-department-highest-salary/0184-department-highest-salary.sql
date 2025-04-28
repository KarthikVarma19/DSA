WITH department_highestsalary (departmentId, departmentHighestSalary, departmentName) AS
    (SELECT e.departmentId, MAX(e.salary) as departmentHighestSalary, d.name
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
    GROUP BY e.departmentId)

SELECT dhst.departmentName as Department,
    e.name as Employee,
    e.salary as Salary
FROM Employee e, department_highestsalary dhst
WHERE e.departmentId = dhst.departmentId AND e.salary = dhst.departmentHighestSalary