<#list tables as t>
alter table `${t.tablename}` comment = '${t.tabledesc!""}';
<#list t.fields as field>
alter table `${t.tablename}` modify column <#if field.datatype?lower_case == "datetime" ||field.datatype == "longtext" ||field.datatype == "date" || field.datatype == "timestamp"  || field.datatype == "smallint">`${field.fieldname}` ${field.datatype} comment  '${field.fielddesc!""}'
<#elseif (field.datatype == "varchar" ||field.datatype == "char")>`${field.fieldname}` ${field.datatype}(${field.fieldlen!0}<#if (field.charused!"b") == "c"> </#if>)   comment  '${field.fielddesc!""}' 
<#elseif (field.datatype == "float")>`${field.fieldname}` ${field.datatype}   comment  '${field.fielddesc!""}'
<#elseif (field.datatype == "numeric" || field.datatype == "decimal")>
<#if ((field.precision_!0) == 0) || ((field.scale_!0) == 0)> `${field.fieldname}` ${field.datatype}<#elseif field.scale_ == 0>`${field.fieldname}` ${field.datatype}(${field.precision_})  comment  '${field.fielddesc!""}'<#else>`${field.fieldname}` ${field.datatype}(${field.precision_},${field.scale_})   comment  '${field.fielddesc!""}' </#if>
<#else>`${field.fieldname}`  ${field.datatype}   comment  '${field.fielddesc!""}'</#if>;
</#list>
</#list>