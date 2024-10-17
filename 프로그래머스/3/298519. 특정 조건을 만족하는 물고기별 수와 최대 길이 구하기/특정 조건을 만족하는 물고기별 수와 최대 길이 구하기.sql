-- 코드를 작성해주세요
select count(FISH_TYPE) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having AVG(CASE WHEN LENGTH <= 10 THEN 10 ELSE LENGTH END) >= 33
order by FISH_TYPE asc;