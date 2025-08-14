SELECT 
    ch.history_id,
    FLOOR(
        (DATEDIFF(ch.end_date, ch.start_date) + 1) * cc.daily_fee
        * (1 - IFNULL(cp.discount_rate, 0) / 100)
    ) AS fee
FROM CAR_RENTAL_COMPANY_CAR cc
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ch 
    ON cc.car_id = ch.car_id
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN cp 
    ON cc.car_type = cp.car_type
    AND (
        (cp.duration_type = '90일 이상' AND DATEDIFF(ch.end_date, ch.start_date) + 1 >= 90) OR
        (cp.duration_type = '30일 이상' AND DATEDIFF(ch.end_date, ch.start_date) + 1 >= 30 AND DATEDIFF(ch.end_date, ch.start_date) + 1 < 90) OR
        (cp.duration_type = '7일 이상' AND DATEDIFF(ch.end_date, ch.start_date) + 1 >= 7 AND DATEDIFF(ch.end_date, ch.start_date) + 1 < 30)
    )
WHERE cc.car_type = '트럭'
ORDER BY fee DESC, ch.history_id DESC;
