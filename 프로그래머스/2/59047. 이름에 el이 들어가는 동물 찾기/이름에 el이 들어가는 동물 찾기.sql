SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'DOG' AND LOWER(NAME) LIKE '%el%'
ORDER BY LOWER(NAME);