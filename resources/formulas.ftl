<#list formulas as formula>
/***************指标名称:${formula.c_name}******************/
指标名称:${formula.c_name}
指标公式表:${formula.table_name}
主键:${formula.n_seq}
指标代码:${formula.c_cde}
指标提取规则(开发环境SQL)：
${formula.dev_c_sql!}
指标提取规则(生产环境SQL)：
${formula.prd_c_sql!}
月度指标:${formula.c_month!}
季度指标:${formula.c_season!}
半年度指标:${formula.c_half_year!}
</#list>