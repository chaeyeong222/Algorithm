select fi.id, fni.fish_name, fi.length
from fish_info as fi join fish_name_info as fni on fi.fish_type=fni.fish_type
join (
select fish_type, max(length) as maxlength
from fish_info
group by fish_type) as maxfi on fi.fish_type=maxfi.fish_type and fi.length = maxfi.maxlength
order by fi.id asc;
