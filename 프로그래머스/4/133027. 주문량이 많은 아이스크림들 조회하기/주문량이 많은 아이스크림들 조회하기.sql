
select a.flavor
from
(select f.flavor, f.total_order + ifnull(j.julysum,0) as totalSum
from first_half f left join
(select flavor, sum(total_order) as julysum
from july 
group by flavor)j on f.flavor = j.flavor
order by totalSum desc
limit 3)a;