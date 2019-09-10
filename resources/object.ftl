<#list objects as csobject>
package lab.aml.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lab.aml.constraint.IDTypeCheck;
import lab.aml.constraint.SexCheck;
import lab.aml.annotation.Key;

public class ${csobject.objectname} {
    <#list csobject.properties as prop> <#if (prop.identifyprop! == '1')>@Key</#if><#if prop.propValidators??><#list prop.propValidators as prop_validator>@${prop_validator.validatorname}</#list></#if> 
private ${prop.datatype} ${prop.propertyname};
    
    </#list>

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