select *
from departments
where dept_no = 'd001';

select *
from departments
where dept_no = "d001";

select *
from departments
where dept_no = 'd''001';

create table tab_test(`table` varchar(20) not null);
insert into tab_test value ('''sdf');

explain
select t.*
from employee_name t
where 1 = 1
and t.emp_no > '0';

explain
select t.*
from dept_emp t
where 1 = 1
and t.from_date = '1993-08-03';

create table tb_boolean (bool_value BOOLEAN);
insert into tb_boolean values (false),(1), (2);
explain
select t.*
from tb_boolean t
where 1 = 1
and t.bool_value is true;

select 1 = 1, null = null, 1 = null;
select 1 <=> 1, null <=> null, 1 <=> null;
select !1;
select !true;
select NOT true;
select NOT false;
select NOT (1=1);

select 29 / 9;
select 29 div 9;
select mod(29, 9);
select 29 % 9;

select 'abc' REGEXP '^[x-z]]';
select 'baa' like '__a';

explain
select count(t.emp_no)
from employees t
where 1 = 1
and t.first_name like 'Christ%';

explain
select count(t.emp_no)
from employees t
where 1 = 1
and t.first_name like '%rist';

explain
select * from dept_emp
where dept_no = 'd005' and emp_no = 10001;

explain
select * from dept_emp
where dept_no between 'd003' and 'd005' and emp_no = 10001;