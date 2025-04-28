SELECT ct.customer_id
FROM
(SELECT customer_id, COUNT(c.product_key) as count_uniqueproducts_bought
FROM 
    (SELECT * FROM 
    Customer
    GROUP BY customer_id, product_key) as c
GROUP BY c.customer_id) ct
WHERE ct.count_uniqueproducts_bought = (select count(*) from Product);
