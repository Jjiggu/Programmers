-- 코드를 입력하세요
SELECT month(START_DATE) as MONTH, CAR_ID, count(*) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where month(START_DATE) between 8 and 10 and CAR_ID in (
    select CAR_ID 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where month(START_DATE) between 8 and 10
    group by CAR_ID
    having(count(*) >= 5)
)
group by CAR_ID, month
order by 1 asc, CAR_ID desc;