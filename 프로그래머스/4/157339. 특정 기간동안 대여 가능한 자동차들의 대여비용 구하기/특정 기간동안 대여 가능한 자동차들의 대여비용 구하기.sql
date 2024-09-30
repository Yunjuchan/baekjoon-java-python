SELECT 
    C.CAR_ID, 
    C.CAR_TYPE, 
    FLOOR(C.DAILY_FEE * 30 * (1 - DP.DISCOUNT_RATE / 100)) AS FEE
FROM 
    CAR_RENTAL_COMPANY_CAR C
LEFT JOIN 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY RH 
    ON C.CAR_ID = RH.CAR_ID 
    AND RH.START_DATE <= '2022-11-30' 
    AND RH.END_DATE >= '2022-11-01'
JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP 
    ON C.CAR_TYPE = DP.CAR_TYPE 
    AND DP.DURATION_TYPE = '30일 이상'
WHERE 
    C.CAR_TYPE IN ('세단', 'SUV')
    AND RH.HISTORY_ID IS NULL
HAVING 
    FEE >= 500000 AND FEE < 2000000
ORDER BY 
    FEE DESC, 
    C.CAR_TYPE ASC, 
    C.CAR_ID DESC;