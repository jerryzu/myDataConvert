

<#list objects as csobject>
package lab.crazyspark.dao;

import lab.crazyspark.aml.BeanCfg;
import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import lab.crazyspark.bean.${csobject.objectname};
import lab.crazyspark.excel.Excel${csobject.objectname};
import lab.crazyspark.utils.DBUtils;

public class ${csobject.objectname}DAO  {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(${csobject.objectname}.class, "${csobject.objectname}");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO ${csobject.tablename}(<#list csobject.properties as prop>${prop.propertyname}<#if prop_has_next>, </#if></#list>)VALUES(<#list csobject.properties as prop>?<#if prop_has_next>, </#if></#list>)";
            List<${csobject.objectname}> ${csobject.objectname?uncap_first}s = runner.query(sql, new BeanListHandler<${csobject.objectname}>(${csobject.objectname}.class));
            for (${csobject.objectname} ${csobject.objectname?uncap_first} : ${csobject.objectname?uncap_first}s) {
                Object[] params = {<#list csobject.properties as prop>${csobject.objectname?uncap_first}.get${prop.propertyname?cap_first}()<#if prop_has_next>, </#if></#list> };
                        targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Excel${csobject.objectname?cap_first}> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("${csobject.objectname?cap_first}");
        String sql = "SELECT * from ${csobject.tablename}";
        List<Excel${csobject.objectname?cap_first}> result = runner.query(sql, new BeanListHandler<Excel${csobject.objectname?cap_first}>(Excel${csobject.objectname?cap_first}.class));
        return result;
    }
}    
</#list>    