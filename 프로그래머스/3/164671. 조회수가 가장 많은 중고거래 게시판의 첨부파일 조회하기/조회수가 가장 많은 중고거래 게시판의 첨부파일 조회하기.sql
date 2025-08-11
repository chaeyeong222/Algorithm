-- 코드를 입력하세요
select concat('/home/grep/src/', ugb.board_id, '/', ugf.file_id, ugf.file_name,file_ext) as file_path 
from USED_GOODS_BOARD ugb join USED_GOODS_FILE ugf on ugb.board_id = ugf.board_id
where ugb.views = 
(select max(views)
 from USED_GOODS_BOARD
)
order by file_id desc;