-- 코드를 입력하세요m

SELECT MONTH(START_DATE) AS M, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
               WHERE MONTH(START_DATE)>=8 AND MONTH(START_DATE)<=10 
               GROUP BY CAR_ID
               HAVING COUNT(CAR_ID)>=5
                and (date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'))
GROUP BY M, CAR_ID
HAVING RECORDS>0
ORDER BY M,CAR_ID DESC


#SELECT MONTH(START_DATE) AS M, CAR_ID, COUNT(*) AS RECORDS
#FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#GROUP BY CAR_ID
#HAVING CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#               WHERE MONTH(START_DATE)>=8 AND MONTH(START_DATE)<=10 
#               GROUP BY CAR_ID
#               HAVING COUNT(CAR_ID)>=5)
#
#ORDER BY M,CAR_ID DESC