-- 코드를 입력하세요
SELECT B.CATEGORY, sum(SALES) TOTAL_SALES
from BOOK_SALES S inner join BOOK B on s.BOOK_ID = b.BOOK_ID
where date_format(s.SALES_DATE, '%Y-%m') = '2022-01'
group by B.CATEGORY
order by CATEGORY;