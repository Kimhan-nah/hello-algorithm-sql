SELECT icecream.ingredient_type, SUM(first.total_order)
FROM first_half AS first
INNER JOIN icecream_info AS icecream ON first.flavor = icecream.flavor
GROUP BY icecream.ingredient_type;