SELECT 
    u.name, 
    CASE 
        WHEN r.travelled_distance IS NULL THEN 0 
        ELSE r.travelled_distance 
    END AS travelled_distance
FROM 
    Users u
LEFT JOIN
    (SELECT 
         user_id, 
         SUM(distance) AS travelled_distance
     FROM 
         Rides
     GROUP BY 
         user_id
    ) r
ON 
    u.id = r.user_id
ORDER BY r.travelled_distance DESC, name ASC;
