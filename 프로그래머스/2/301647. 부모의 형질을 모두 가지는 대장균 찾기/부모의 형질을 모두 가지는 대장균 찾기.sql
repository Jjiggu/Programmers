-- 코드를 작성해주세요
select C.id, C.genotype, C.PARENT_GENOTYPE
from (
    select A.ID, A.PARENT_ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
    from ECOLI_DATA as A
    left join ECOLI_DATA as B
    on A.parent_id = B.id
) as C
where C.GENOTYPE & C.PARENT_GENOTYPE = C.PARENT_GENOTYPE
order by C.ID asc;
