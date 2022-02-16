drop table if exists cat_colors_info;

select
    color,
    count(*)
into cat_colors_info
from cats
group by color;

select * from cat_colors_info