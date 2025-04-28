SELECT T.id, (CASE WHEN T.p_id IS NULL THEN "Root" 
                WHEN T.id in (SELECT p_id from Tree) THEN "Inner" 
                ELSE "Leaf" END) as type
FROM 
Tree T;
