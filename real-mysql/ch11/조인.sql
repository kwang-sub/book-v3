explain 
select *
from employees e, dept_emp de
where e.emp_no = de.emp_no;


create table tb_test1
(
    user_id   int,
    user_type int,
    primary key (user_id)
);

create table tb_test2
(
    user_type char(1),
    type_desc varchar(10),
    primary key (user_type)
);

explain
select *
from tb_test1 tb1,
     tb_test2 tb2
where tb1.user_type = tb2.user_type;

explain
select *
from employees e
         left join dept_emp de on de.emp_no = e.emp_no
         left join departments d on d.dept_no = de.dept_no and d.dept_name = 'Development';
