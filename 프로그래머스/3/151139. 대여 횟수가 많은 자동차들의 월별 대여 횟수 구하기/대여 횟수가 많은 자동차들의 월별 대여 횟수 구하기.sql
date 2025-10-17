select MONTH(START_DATE) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY

where MONTH(START_DATE) between 8 and 10 and car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE month(START_DATE) between 8 and 10
    group by car_id
    having count(*) >= 5
    )


# WHERE START_DATE >= '2022-08-01'
#   AND START_DATE <  '2022-11-01'
#   AND CAR_ID IN (
#     SELECT CAR_ID
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE START_DATE >= '2022-08-01'
#       AND START_DATE <  '2022-11-01'
#     GROUP BY CAR_ID
#     HAVING COUNT(*) >= 5
#   )

group by month, CAR_ID

order by MONTH ASC, CAR_ID DESC;