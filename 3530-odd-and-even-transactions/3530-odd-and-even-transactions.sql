select 
trans_odd_even.transaction_date,
SUM(trans_odd_even.odd_sum) as odd_sum,
SUM(trans_odd_even.even_sum) as even_sum
from 
(
select 
t.transaction_date,
case
    when MOD(t.amount, 2) = 1 THEN t.amount
    ELSE 0
END AS odd_sum,
case
    when MOD(t.amount, 2) = 0 THEN t.amount
    ELSE 0
END AS even_sum
from
transactions t) trans_odd_even 
GROUP BY trans_odd_even.transaction_date
ORDER BY trans_odd_even.transaction_date;