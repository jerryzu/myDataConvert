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
import lab.crazyspark.bean.CSTable;
import lab.crazyspark.bean.CSField;
import lab.crazyspark.utils.JDBCUitls;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.wrappers.StringTrimmedResultSet;

public class DoForTable {
    public static void main(String args[]) {
        DoForTable doForTable = new DoForTable();
        doForTable.doFreemarker();
    }

    public void doFreemarker() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));
            Template template = cfg.getTemplate("table.ftl");
            template.setNumberFormat("#");

            List<CSTable> cstables = new ArrayList<CSTable>();

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource()) {
                @Override
                protected ResultSet wrap(ResultSet rs) {
                    return StringTrimmedResultSet.wrap(rs);
                }
            };

            String sql = "SELECT * from sys_tables order by tableid";
            try {
                cstables = runner.query(sql, new BeanListHandler<CSTable>(CSTable.class));

                for (CSTable obj : cstables) {
                    String fieldsql = String.format("SELECT * from sys_fields WHERE tableid = %s order by fieldid",
                            obj.getTableid());
                    List<CSField> fields = runner.query(fieldsql, new BeanListHandler<CSField>(CSField.class));
                    obj.setFields(fields);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("tables", cstables);

            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}