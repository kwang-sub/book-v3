explain
with cte1 as (select * from departments)
select * from cte1;

explain
select cte1.*
from (select * from departments) cte1;

explain
with cte1 as (select emp_no, min(from_date) from salaries group by emp_no)
select *
from employees e
         join cte1 t1 on t1.emp_no = e.emp_no
         join cte1 t2 on t2.emp_no = e.emp_no;

with recursive cte(no) as (select 1 union all select (no + 1) from cte where no < 5)
select * from cte;