
SELECT 
s.sample_id,
s.dna_sequence,
s.species,
CASE 
    WHEN s.dna_sequence LIKE 'ATG%' THEN 1
    ELSE 0
END AS has_start,
CASE 
    WHEN s.dna_sequence LIKE "%TAA" OR s.dna_sequence LIKE "%TGA" OR s.dna_sequence LIKE "%TAG"  THEN 1
    ELSE 0
END AS has_stop,
CASE 
    WHEN s.dna_sequence LIKE "%ATAT%" THEN 1
    ELSE 0
END AS has_atat,

CASE 
    WHEN s.dna_sequence LIKE "%GGG%" OR s.dna_sequence LIKE "%GGGG%" THEN 1
    ELSE 0
END AS has_ggg
FROM
Samples s;