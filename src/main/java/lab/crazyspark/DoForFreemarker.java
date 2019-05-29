package lab.crazyspark;

import java.io.File;
import java.io.Writer;
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

public class DoForFreemarker {
    public static void main(String args[]) {
        DoForFreemarker doForFreemarker = new DoForFreemarker();
        doForFreemarker.doFreemarker();
    }

    public void doFreemarker() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));       
            Template template = cfg.getTemplate("test.ftl");

            List<Student> students = new ArrayList<Student>();
            
            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());

            String sql = "SELECT * from students";
            try {
                students = runner.query(sql, new BeanListHandler<Student>(Student.class));

                for(Student student :students) {
                    Teacher tech = new Teacher();
                    tech.setId(99999);
                    tech.setName("中文");
                    student.setTeachers(tech);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("students",students);

            root.put("name", "cxl");
            root.put("age", "25");

            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}