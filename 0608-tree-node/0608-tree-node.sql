SELECT T.id, (CASE WHEN T.p_id IS NULL THEN "Root" 
                WHEN p_child_count.count_child >= 1 THEN "Inner" 
                ELSE "Leaf" END) as type
FROM 
Tree T
LEFT JOIN 
(SELECT p_id, count(p_id) as count_child
FROM Tree
GROUP BY p_id)  p_child_count
ON T.id = p_child_count.p_id;
