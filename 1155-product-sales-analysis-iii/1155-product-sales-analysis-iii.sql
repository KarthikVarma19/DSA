# Write your MySQL query statement below
WITH product_firstyear AS
   (SELECT 
   s.product_id,
   s.year,
   s.quantity,
   s.price,
   pfy.first_year
    FROM 
    Sales s
    JOIN
    (SELECT s.product_id as product_id, MIN(s.year) as first_year
    FROM 
    Sales s
    GROUP BY s.product_id) pfy
    ON s.product_id = pfy.product_id)

SELECT pfy.product_id, pfy.first_year, pfy.quantity, pfy.price
FROM 
product_firstyear pfy
WHERE pfy.first_year = pfy.year;