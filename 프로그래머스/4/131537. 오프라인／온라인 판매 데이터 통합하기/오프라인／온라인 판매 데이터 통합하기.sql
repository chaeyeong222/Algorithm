-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from online_sale 
where DATE_FORMAT(SALES_DATE,'%Y-%m')='2022-03'
union
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null, SALES_AMOUNT
from offline_sale 
where DATE_FORMAT(SALES_DATE,'%Y-%m')='2022-03' 
order by 1,2,3;