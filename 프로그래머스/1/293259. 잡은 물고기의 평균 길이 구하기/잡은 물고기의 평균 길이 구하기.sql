SELECT ROUND(AVG(CASE 
                    WHEN IFNULL(LENGTH, 0) <= 10 THEN 10 
                    ELSE IFNULL(LENGTH, 0) 
                 END), 2) AS AVERAGE_LENGTH
FROM FISH_INFO;
