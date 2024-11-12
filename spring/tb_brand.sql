use mybatisDb;  
drop table if exists tb_brand;  
create table tb_brand( 
id int primary key auto_increment,  
brand_name varchar(20),  company_name varchar(20),  
orderd int,  
description varchar(100),  
status int  );  
insert into tb_brand(brand_name, company_name, orderd, description, status) VALUES('三只松鼠','三只松鼠有限',5,'好好',0), ('asd','asda',100,'sdasd',1); 
select *from tb_brand;