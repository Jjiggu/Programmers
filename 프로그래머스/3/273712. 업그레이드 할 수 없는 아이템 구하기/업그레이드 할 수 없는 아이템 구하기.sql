select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from ITEM_INFO ii 
left join ITEM_TREE it on it.PARENT_ITEM_ID = ii.ITEM_ID
where it.PARENT_ITEM_ID is null
order by ii.ITEM_ID desc
