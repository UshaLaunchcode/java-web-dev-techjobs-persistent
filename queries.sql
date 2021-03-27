## Part 1: Test it with SQL

--list the columns and their data types in the table.
select column_name,data_type
 from information_schema.columns
 where table_schema = 'techjobs'
 and table_name = 'job';

## Part 2: Test it with SQL

--write a query to list the names of the employers in St. Louis City.
 select name
 from employer
 where location = "St.Louis";

## Part 3: Test it with SQL

Drop table job;

## Part 4: Test it with SQL

Select name, description
from techjobs.skill
where skill.id in (select skills_id from job_skills where jobs_id is not null)
order by skill.name ASC;

