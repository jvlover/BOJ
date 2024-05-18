select concat(quarter(differentiation_date),'Q') quarter, count(*) ecoli_count
from ecoli_data
group by quarter

-- mssql도 문자열 붙이기 concat (여러개도 가능)
-- date 관련해서 연월일이나 분기 뽑아내는건 DATENAME(year, differentiation_date)
-- DATENAME(quarter, differentiation_date) 이런 식으로