create table sys_tables
as
select table_schema, table_name, table_rows, table_comment
from  information_schema.tables
where table_schema in('nvhlclm','comm','finarp','nvhlpcis', 'reinsure' , 'vch');

create table sys_columns
as
select table_schema, table_name, column_name, ordinal_position, column_default, is_nullable, data_type, CHARACTER_MAXIMUM_LENGTH , numeric_precision, numeric_scale, column_comment
from information_schema.columns
where 1 = 1 and table_schema in('nvhlclm','comm','finarp','nvhlpcis', 'reinsure' , 'vch')
