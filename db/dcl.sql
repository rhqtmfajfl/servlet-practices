SHOW TABLES;

DESC guestbook;

-- insert

insert into guestbook values(null,"홍길동","1234","HI!",now());


-- select 
select * from guestbook order by reg_date desc;

select no, name, date_format(reg_date, "%Y/%m/%d %H%i%s") as reg_date, message 
from guestbook order by reg_date desc;


-- delete

delete from guestbook 
where no = 1 and password='1234'; 

-- 패스워드가 같아야 삭제 되게끔