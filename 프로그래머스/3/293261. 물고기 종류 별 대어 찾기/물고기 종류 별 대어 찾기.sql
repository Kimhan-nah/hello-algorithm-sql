SELECT 
	fish.id AS ID, 
    name.fish_name AS FISH_NAME,
    fish.length AS LENGTH
FROM FISH_INFO AS fish
INNER JOIN FISH_NAME_INFO AS name ON fish.fish_type = name.fish_type
INNER JOIN (
	SELECT 
    	fish.fish_type,
    	MAX(fish.length) AS max_length
    FROM FISH_INFO AS fish
    GROUP BY fish.fish_type
) AS max_fish
ON fish.fish_type = max_fish.fish_type AND fish.length = max_fish.max_length
ORDER BY fish.id ASC;