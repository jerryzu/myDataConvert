<#list objects as csobject>
package lab.crazyspark.bean;

import lab.crazyspark.annotation.Entity;

@Entity(table = "${csobject.tablename}")
public class ${csobject.objectname} {
    <#list csobject.properties as prop>
    <#if prop.propValidators??>
    <#list prop.propValidators as prop_validator>
    ${prop_validator.validatorname}
    </#list>
</#if> 
    private ${prop.datatype} ${prop.propertyname};
    </#list>

    public void print() {
        System.out.println(String.format("${csobject.objectname}:<#list csobject.properties as prop>  ${prop.propertyname}%s</#list>"<#list csobject.properties as prop>,  ${prop.propertyname}</#list>));   
    }

    <#list csobject.properties as prop>
    public  ${prop.datatype} get${prop.propertyname?cap_first}() {
        return ${prop.propertyname};
    }

    public void set${prop.propertyname?cap_first}(${prop.datatype} ${prop.propertyname}) {
        this.${prop.propertyname} = ${prop.propertyname};
    }
    </#list>
}
</#list>