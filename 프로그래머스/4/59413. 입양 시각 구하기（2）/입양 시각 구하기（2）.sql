WITH RECURSIVE TIME AS (SELECT 0 AS HOUR -- 시작점 설정
                        UNION ALL
                        SELECT HOUR+1 -- 반복문 설정
                        FROM TIME
                        WHERE HOUR < 23) -- 종료점 설정

SELECT B.HOUR, COUNT(A.ANIMAL_ID) COUNT
FROM ANIMAL_OUTS A RIGHT JOIN TIME B
ON HOUR(A.DATETIME) = B.HOUR
GROUP BY HOUR
ORDER BY HOUR