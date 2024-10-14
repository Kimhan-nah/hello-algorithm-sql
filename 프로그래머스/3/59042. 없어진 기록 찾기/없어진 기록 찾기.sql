SELECT outs.animal_id, outs.name 
FROM ANIMAL_INS AS ins
RIGHT JOIN ANIMAL_OUTS AS outs
ON ins.animal_id = outs.animal_id
WHERE ins.animal_id is null
ORDER BY outs.animal_id;