# Write your MySQL query statement below
WITH bus_queue AS
    (SELECT 
    q.person_name,
    SUM(q.weight) OVER(ORDER BY q.turn) as total_weight
    FROM Queue q)

SELECT bq.person_name FROM bus_queue bq
WHERE bq.total_weight <= 1000
ORDER BY bq.total_weight DESC
LIMIT 1;
