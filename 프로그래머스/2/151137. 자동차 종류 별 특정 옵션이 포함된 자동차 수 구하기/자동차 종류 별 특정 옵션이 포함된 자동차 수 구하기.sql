SELECT car.car_type AS CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR AS car
where car.options LIKE '%통풍시트%' 
	OR car.options LIKE '%열선시트%' 
    OR car.options LIKE '%가죽시트%'
GROUP BY car.car_type
ORDER BY car.car_type ASC;