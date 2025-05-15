WITH buyer_in_2019 (buyer_id, orders_in_2019) AS
(SELECT buyer_id, count(*) as orders_in_2019 FROM Orders AS O
where o.order_date >= '2019-01-01' && o.order_date <= '2019-12-31'
group by o.buyer_id)

SELECT u.user_id as buyer_id, u.join_date, 
CASE 
when b19.orders_in_2019 is null THEN 0
else b19.orders_in_2019 end as orders_in_2019
 FROM Users u  LEFT JOIN buyer_in_2019 b19
ON u.user_id = b19.buyer_id;