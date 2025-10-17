select fi.ID, fn.FISH_NAME, fi.LENGTH
from FISH_INFO fi inner join FISH_NAME_INFO fn on fi.FISH_TYPE = fn.FISH_TYPE
where fi.LENGTH = (
    SELECT MAX(fi2.LENGTH)
    from FISH_INFO fi2
    where fi2.FISH_TYPE = fi.FISH_TYPE
)
and fi.LENGTH > 10
order by fi.ID ASC;

