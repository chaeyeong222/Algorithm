-- 코드를 입력하세요
SELECT fp.PRODUCT_ID, fp.PRODUCT_NAME, sum(fp.price*fo.amount) as TOTAL_SALES
FROM FOOD_PRODUCT fp JOIN FOOD_ORDER fo ON fp.PRODUCT_ID = fo.PRODUCT_ID
WHERE date_format(fo.PRODUCE_DATE, '%Y-%m') = "2022-05"
group by fp.product_id
order by total_sales desc, product_id asc;