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

public class DoForFormula {
    public static void main(String args[]) {
        DoForFormula doForFormula = new DoForFormula();
        doForFormula.doFormula();
    }

    public void doFormula() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));
            Template template = cfg.getTemplate("formulas.ftl");

            List<FormulaItem> formulas = new ArrayList<FormulaItem>();

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());

            String sql = "SELECT * from vw_rul_diff_dev_prd order by c_cde";
            try {
                formulas = runner.query(sql, new BeanListHandler<FormulaItem>(FormulaItem.class));
                // for (FormulaItem item : formulas) {
                // try {
                // Template template = cfg.getTemplate("formula.ftl");
                // Map root = new HashMap();
                // root.put("formula", item);
                // Writer out = new OutputStreamWriter(System.out);
                // template.process(root, out);
                // out.flush();
                // } catch (IOException | TemplateException e) {
                // e.printStackTrace();
                // }
                // }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("formulas", formulas);
            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}