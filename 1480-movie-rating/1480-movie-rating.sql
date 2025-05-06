WITH user_rating_count (user_id, no_of_rating) AS
    
    (SELECT user_id, count(*) as no_of_rating
    FROM MovieRating mv
    GROUP BY mv.user_id),
    
    valid_user (user_name) AS
    (select u.name from user_rating_count urc 
    JOIN Users u
    ON urc.user_id = u.user_id
    ORDER BY urc.no_of_rating DESC, u.name 
    LIMIT 1 OFFSET 0),

    movie_avg (movie_id , avg_rat) AS
    (SELECT movie_id, avg(mr.rating) avg_rat FROM 
    MovieRating mr
    WHERE mr.created_at >= '2020-02-01' and mr.created_at <= '2020-02-29'
    GROUP BY mr.movie_id),

    valid_title (title) AS
    (SELECT m.title 
    FROM movie_avg mavg
    JOIN 
    Movies m
    ON mavg.movie_id = m.movie_id
    ORDER BY mavg.avg_rat DESC, m.title
    LIMIT 1 OFFSET 0),
    result_table (results) AS
    (select * 
    from valid_user 
    UNION ALL
    select * from valid_title)

select * from result_table;


