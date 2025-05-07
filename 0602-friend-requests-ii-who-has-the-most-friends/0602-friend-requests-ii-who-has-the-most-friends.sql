select *
from
(select friends.requester_id as id, count(*) as num
from
(SELECT requester_id from RequestAccepted
UNION ALL 
SELECT accepter_id from RequestAccepted) friends
GROUP BY friends.requester_id) id_num
ORDER BY id_num.num DESC
LIMIT 1;