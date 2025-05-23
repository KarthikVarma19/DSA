
WITH user_confirmation (user_id, confirm_count, total_req_user) as
    (SELECT s.user_id, COUNT(CASE WHEN c.action="confirmed" THEN 1 END) as confirm_count, COUNT(s.user_id) as total_req_user
    FROM Signups as s
    LEFT JOIN Confirmations as c
    ON s.user_id = c.user_id
    GROUP BY s.user_id
    )

SELECT user_id, ROUND(confirm_count * 1.0/total_req_user, 2) as confirmation_rate
FROM user_confirmation;