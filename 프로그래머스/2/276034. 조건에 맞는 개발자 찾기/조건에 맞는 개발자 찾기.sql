-- 코드를 작성해주세요
select id, email, first_name, last_name
from developers
where SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE NAME IN ('Python', 'C#'))
order by 1 asc;