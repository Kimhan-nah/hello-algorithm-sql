-- trim(leading '0' from date_format(now(), '%H'))
SELECT HOUR(datetime), COUNT(animal_id)
FROM animal_outs
WHERE TIME(datetime) BETWEEN '09:00:00' AND '19:59:59'
GROUP BY HOUR(datetime)
ORDER BY HOUR(datetime) ASC;