SELECT count(*) as FISH_COUNT,
    max(length) AS MAX_LENGTH,
    fish_type AS FISH_TYPE
FROM (SELECT ID, FISH_TYPE, TIME,
      IFNULL(LENGTH, 10) AS LENGTH
      FROM fish_info) FISHINFO
GROUP BY fish_type
HAVING SUM(length)/COUNT(*) >= 33
-- 평균 길이가 33cm 이상인 물고기들
ORDER BY fish_type asc