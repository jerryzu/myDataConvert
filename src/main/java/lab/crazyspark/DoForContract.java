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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lab.crazyspark.bean.CSContract;
import lab.crazyspark.bean.CSContractItem;
import lab.crazyspark.utils.JDBCUitls;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.wrappers.StringTrimmedResultSet;

public class DoForContract {
    public static void main(String args[]) {
        DoForContract doForContract  = new DoForContract();
        doForContract.doFreemarker();
    }

    public void doFreemarker() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        
        OutputStreamWriter out = null;
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));
            //cfg.setDirectoryForTemplateLoading(new File("D:\\work\\myDataConvert\\src\\main\\resources"));
            
            cfg.setDefaultEncoding("UTF-8");
            cfg.setNumberFormat("0.00");
            // cfg.setObjectWrapper(new DefaultObjectWrapper());

			Template template = cfg.getTemplate("faenza-contract.xml","utf-8");
			//Template template = cfg.getTemplate("contract.ftl","utf-8");
            template.setNumberFormat("#");

            List<CSContract> cscontracts = new ArrayList<CSContract>();

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource()) {
                @Override
                protected ResultSet wrap(ResultSet rs) {
                    return StringTrimmedResultSet.wrap(rs);
                }
            };

            String sql = "SELECT * from faenza.contracts order by contractid";

            try {
                cscontracts = runner.query(sql, new BeanListHandler<CSContract>(CSContract.class));

                for (CSContract obj : cscontracts) {
                    String contractitemsql = String.format("SELECT * from faenza.contractdetails WHERE contractid = %s order by contractid, itemid",
                            obj.getContractid());
                    List<CSContractItem> contractitems = runner.query(contractitemsql, new BeanListHandler<CSContractItem>(CSContractItem.class));
                    obj.setContractitems(contractitems);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("contracts", cscontracts);

            out = new OutputStreamWriter(System.out, "UTF-8");
            
            FileOutputStream  fos = new FileOutputStream("/app/1.xml", false);
            out = new OutputStreamWriter(fos, "UTF-8");

            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        } finally {
            try{
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
}

