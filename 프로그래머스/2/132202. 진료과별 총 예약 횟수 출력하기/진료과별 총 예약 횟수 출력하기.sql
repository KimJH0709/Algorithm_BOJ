-- 코드를 입력하세요
SELECT mcdp_cd as '진료과코드', count(pt_no) as '5월예약건수'
from appointment
where year(apnt_ymd) = '2022' and month(apnt_ymd) = '05'
group by mcdp_cd
order by 5월예약건수, 진료과코드