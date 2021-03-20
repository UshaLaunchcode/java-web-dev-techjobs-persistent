## Part 1: Test it with SQL

--list the columns and their data types in the table.
select column_name,data_type
 from information_schema.columns
 where table_schema = 'techjobs'
 and table_name = 'job';

--Job: Column (Datatype):
--id       (int)
--employer (String)
--name     (String)
--skills   (String)

--## Part 2: Test it with SQL

--## Part 3: Test it with SQL

--## Part 4: Test it with SQL