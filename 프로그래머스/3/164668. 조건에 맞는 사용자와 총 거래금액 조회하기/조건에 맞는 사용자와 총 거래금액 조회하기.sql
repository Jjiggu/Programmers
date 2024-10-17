-- 코드를 입력하세요
SELECT uu.USER_ID, uu.NICKNAME, SUM(ub.PRICE) as TOTAL_SALES
from USED_GOODS_USER uu join USED_GOODS_BOARD ub on uu.USER_ID = ub.WRITER_ID 
where ub.STATUS = 'DONE'
group by uu.USER_ID, uu.NICKNAME
having sum(ub.PRICE) >= 700000
order by TOTAL_SALES asc;

