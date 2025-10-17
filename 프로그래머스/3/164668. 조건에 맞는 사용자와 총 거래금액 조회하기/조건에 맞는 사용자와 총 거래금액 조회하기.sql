select gu.USER_ID, gu.NICKNAME, sum(gb.PRICE) TOTAL_SALES
from USED_GOODS_USER gu inner join USED_GOODS_BOARD gb on gu.USER_ID = gb.WRITER_ID
where gb.STATUS = 'DONE'
group by gu.user_id, gu.NICKNAME
having sum(gb.price) >= 700000
order by TOTAL_SALES