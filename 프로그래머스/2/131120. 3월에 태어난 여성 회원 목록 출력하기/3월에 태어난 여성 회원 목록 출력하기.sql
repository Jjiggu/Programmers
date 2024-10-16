-- 코드를 입력하세요
SELECT member_id, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTHH
from MEMBER_PROFILE
where DATE_OF_BIRTH like '%03%' and TLNO is not NULL and GENDER = "W"
order by MEMBER_ID asc;