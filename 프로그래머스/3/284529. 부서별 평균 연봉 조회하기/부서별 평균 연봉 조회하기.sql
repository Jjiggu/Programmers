-- 코드를 작성해주세요
select hd.DEPT_ID, hd.DEPT_NAME_EN, round(avg(he.sal)) as AVG_SAL
from HR_EMPLOYEES he join HR_DEPARTMENT hd on he.DEPT_ID = hd.DEPT_ID
group by hd.DEPT_ID, he.DEPT_ID
order by AVG_SAL desc