package lab.crazyspark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DoForFreemarker {
    public static void main(String args[]) {
        DoForFreemarker doForFreemarker = new DoForFreemarker();
        doForFreemarker.doFreemarker();
    }

    public void doFreemarker() {
        // 1.创建配置实例Cofiguration
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 2.设置模板文件目录
        // （1）src目录下的目录（template在src下）
        // cfg.setDirectoryForTemplateLoading(new File("src/template"));
        // （2）完整路径（template在src下）
        // cfg.setDirectoryForTemplateLoading(new File(
        // "D:/cpic-env/workspace/javaFreemarker/src/template"));
        // cfg.setDirectoryForTemplateLoading(new File("src/template"));
        // （3）工程目录下的目录（template/main在工程下）--推荐
        try {
            // cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));           
            // cfg.setObjectWrapper(new DefaultObjectWrapper());
            Template template = cfg.getTemplate("test.ftl");

            List<Student> students = new ArrayList<Student>();
            
            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());

            String sql = "SELECT * from students";
            try {
                // List<Student> students = runner.query(sql, new BeanListHandler<Student>(Student.class));
                students = runner.query(sql, new BeanListHandler<Student>(Student.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Student student = new  Student();
            // student.setId(1);
            // student.setName("demo-中国");
            // students.add(student);

            Map root = new HashMap();
            root.put("students",students);

            // Map<String, String> root = new HashMap<String, String>();
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