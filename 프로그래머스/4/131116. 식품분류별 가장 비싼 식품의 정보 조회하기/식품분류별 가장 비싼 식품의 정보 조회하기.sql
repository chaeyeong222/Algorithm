select f.category, f.price AS max_price, f.product_name
from food_product f join
(
select  max(price) as max_price, category
from food_product
where category in ('과자', '국', '김치', '식용유')
group by category)m on f.category=m.category and f.price = m.max_price
order by f.price desc;