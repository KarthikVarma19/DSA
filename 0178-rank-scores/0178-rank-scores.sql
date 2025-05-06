with score_rank (score, ranks) AS
    (
        SELECT 
            s.score,
            ROW_NUMBER() OVER (ORDER BY s.score DESC) AS ranks
        FROM 
            Scores s
        GROUP BY 
            s.score
    )
SELECT 
    s.score, 
    sr.ranks as `rank`
FROM 
    Scores s
JOIN score_rank sr 
ON s.score = sr.score
ORDER BY sr.ranks;