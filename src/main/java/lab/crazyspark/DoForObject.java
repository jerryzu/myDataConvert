package lab.crazyspark;

import java.io.File;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.OutputStreamWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.wrappers.StringTrimmedResultSet;

public class DoForObject {
    public static void main(String args[]) {
        DoForObject doForObject = new DoForObject();
        doForObject.doFreemarker();
    }

    public void doFreemarker() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));
            Template template = cfg.getTemplate("insert.ftl");

            List<CSObject> csobjects = new ArrayList<CSObject>();

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource()) {
                @Override
                protected ResultSet wrap(ResultSet rs) {
                    return StringTrimmedResultSet.wrap(rs);
                }
            };

            String sql = "SELECT * from sys_objects where objectname <> 'Company' order by objectid";
            try {
                csobjects = runner.query(sql, new BeanListHandler<CSObject>(CSObject.class));

                for (CSObject obj : csobjects) {
                    String propsql = String.format("SELECT * from sys_properties WHERE objectid = %s",
                            obj.getObjectid());
                    List<CSProperty> props = runner.query(propsql, new BeanListHandler<CSProperty>(CSProperty.class));
                    for (CSProperty prop : props) {
                        String propvalidatorsql = String.format(
                                "SELECT * FROM sys_prop_validator  WHERE validatorid >= 1 and objectid = %d and propertyid = %d",
                                prop.getObjectid(), prop.getPropertyid());
                        List<CSPropValidator> prop_validators = runner.query(propvalidatorsql,
                                new BeanListHandler<CSPropValidator>(CSPropValidator.class));
                        prop.setPropValidators(prop_validators);
                    }
                    obj.setProperties(props);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("objects", csobjects);

            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}