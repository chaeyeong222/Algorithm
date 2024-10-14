select id,
    case
    when a.s_rank / total_count <=0.25 then 'CRITICAL'
    WHEN a.s_rank / total_count <= 0.5 THEN 'HIGH'
    WHEN a.s_rank / total_count <= 0.75 THEN 'MEDIUM'
    ELSE 'LOW'
    END as COLONY_NAME 
from (select *, rank() over(order by SIZE_OF_COLONY desc) as s_rank, count(*) OVER() as total_count
from ecoli_data)a
order by 1;