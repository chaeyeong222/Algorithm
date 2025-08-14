-- 코드를 입력하세요
SELECT distinct ch.car_id
from CAR_RENTAL_COMPANY_CAR cc join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cc.car_id = ch.car_id
where cc.car_type='세단' && date_format(ch.start_date,'%Y-%m')='2022-10'
order by ch.car_id desc;