SELECT ROUND(AVG(CASE 
                    WHEN IFNULL(LENGTH, 10) <= 10 THEN 10 
                    ELSE IFNULL(LENGTH, 10) 
                 END), 2) AS AVERAGE_LENGTH
FROM FISH_INFO;