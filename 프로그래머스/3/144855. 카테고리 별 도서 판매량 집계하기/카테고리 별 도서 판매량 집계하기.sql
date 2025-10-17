select B.CATEGORY, sum(SALES) TOTAL_SALES
from  BOOK_SALES BS inner join BOOK B on BS.BOOK_ID = B.BOOK_ID
where date_format(BS.SALES_DATE, '%Y-%m') = '2022-01'
group by B.CATEGORY
order by CATEGORY;