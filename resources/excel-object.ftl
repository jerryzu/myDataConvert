<#list objects as csobject>
            Sheet ${csobject.objectname?uncap_first} = new Sheet(${csobject.objectid}, 5, Excel${csobject.objectname}.class);
            List<Excel${csobject.objectname}> ${csobject.objectname?uncap_first}result = Excel${csobject.objectname}.Exp2Excel(runner, writer, ${csobject.objectname?uncap_first});
            writer.write(${csobject.objectname?uncap_first}result, ${csobject.objectname?uncap_first});

</#list>

<#list objects as csobject>
Excel${csobject.objectname}

package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Excel${csobject.objectname}  extends BaseRowModel {
    <#list csobject.properties as prop>
     @ExcelProperty(value = "${prop.propertyname}", index = ${prop_index})
    private ${prop.datatype} ${prop.propertyname};
    </#list>

    public void print() {
        System.out.println(String.format("${csobject.objectname}:<#list csobject.properties as prop>  ${prop.propertyname}%s</#list>"<#list csobject.properties as prop>,  ${prop.propertyname}</#list>));   
    }

    public static List<Excel${csobject.objectname}> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("${csobject.objectname}");
        String sql = "SELECT * from ${csobject.tablename}";
        List<Excel${csobject.objectname}> result = runner.query(sql, new BeanListHandler<Excel${csobject.objectname}>(Excel${csobject.objectname}.class));
        return result;
    }

    <#list csobject.properties as prop>
    public  ${prop.datatype} get${prop.propertyname}() {
        return ${prop.propertyname};
    }

    public void set${prop.propertyname}(${prop.datatype} ${prop.propertyname}) {
        this.${prop.propertyname} = ${prop.propertyname};
    }
    </#list>
}
</#list>