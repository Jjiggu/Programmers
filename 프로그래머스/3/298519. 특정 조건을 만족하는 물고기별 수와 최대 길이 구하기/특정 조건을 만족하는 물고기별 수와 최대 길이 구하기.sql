select count(FISH_TYPE) FISH_COUNT, max(LENGTH) MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE 
having avg(case when length <= 10 then 10 else length end) >= 33
order by FISH_TYPE;