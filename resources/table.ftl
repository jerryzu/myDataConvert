<#list tables as t>
drop table if exists `${t.tablename}`;
create table `${t.tablename}`(
  <#list t.fields as field>
<#if field.datatype?lower_case == "datetime" ||field.datatype == "longtext" ||field.datatype == "date" || field.datatype == "timestamp"  || field.datatype == "smallint">`${field.fieldname}` ${field.datatype} comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
<#elseif (field.datatype == "varchar" ||field.datatype == "char")>`${field.fieldname}` ${field.datatype}(${field.fieldlen!0}<#if (field.charused!"b") == "c"> </#if>)   comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
<#elseif (field.datatype == "float")>`${field.fieldname}` ${field.datatype}   comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
<#elseif (field.datatype == "numeric" || field.datatype == "decimal")>
<#if ((field.precision_!0) == 0) || ((field.scale_!0) == 0)> 
`${field.fieldname}` ${field.datatype}<#if field_has_next>,</#if>
<#elseif field.scale_ == 0>			
`${field.fieldname}` ${field.datatype}(${field.precision_})  comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
<#else>			
`${field.fieldname}` ${field.datatype}(${field.precision_},${field.scale_})   comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
</#if>
<#else>
`${field.fieldname}`  ${field.datatype}   comment  '${field.fielddesc!""}' <#if field_has_next>,</#if>
</#if> 	
</#list>
) comment='${t.tabledesc!""}'
/*!50500 partition by range  columns(pt)
(partition pt${.now?string("yyyyMMdd")}000000 values less than ('${.now?string("yyyyMMdd")}999999') engine = innodb) */;
</#list>


