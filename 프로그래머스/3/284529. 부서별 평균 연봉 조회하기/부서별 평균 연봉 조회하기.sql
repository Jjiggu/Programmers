select hd.DEPT_ID, hd.DEPT_NAME_EN, round(avg(he.SAL)) AVG_SAL
from HR_DEPARTMENT hd inner join HR_EMPLOYEES he on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by AVG_SAL desc;