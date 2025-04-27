WITH manager (manager_id, report_count)
AS (SELECT e.managerId, COUNT(e.managerId) as count
    FROM Employee e
    WHERE e.managerId != "null"
    GROUP BY e.managerId)

SELECT e.name
FROM Employee e
JOIN manager m
ON e.id = m.manager_id
WHERE m.report_count >= 5

