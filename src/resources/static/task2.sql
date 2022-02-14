drop table if exists public.cats_stat;

select
    avg(tail_length) as tail_length_mean,
    percentile_cont(0.5) within group(order by tail_length) as tail_length_median,
    mode() within group(order by tail_length) as tail_length_mode,

    avg(whiskers_length) as whiskers_length_mean,
    percentile_cont(0.5) within group(order by whiskers_length) as whiskers_length_median,
    mode() within group(order by whiskers_length) as whiskers_length_mode
into cats_stat
from cats