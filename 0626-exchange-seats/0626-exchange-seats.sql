# increment the id of odd by +1 even by -1 if the id is odd and count(*) tables is odd then keep id same
WITH table_count (total_students) AS 
    (SELECT count(*) from Seat),

    seat_swap_table (id, new_id) AS
    (SELECT s.id,
        CASE
            WHEN s.id % 2 = 1 AND s.id = tc.total_students THEN s.id
            WHEN s.id % 2 = 1 THEN s.id + 1
            ELSE s.id - 1
        END AS new_id
    FROM 
    Seat s, table_count tc)


SELECT sst.id, st.student
FROM seat_swap_table sst
LEFT JOIN Seat st
ON sst.new_id = st.id;
