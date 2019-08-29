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
import lab.crazyspark.bean.CSOffer;
import lab.crazyspark.bean.CSOfferItem;
import lab.crazyspark.utils.JDBCUitls;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.wrappers.StringTrimmedResultSet;

public class DoForOffer {
    public static void main(String args[]) {
        DoForOffer doForOffer  = new DoForOffer();
        doForOffer.doFreemarker();
    }

    public void doFreemarker() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/app/work/myDataConvert/src/main/resources"));
            Template template = cfg.getTemplate("offer.ftl");
            template.setNumberFormat("#");

            List<CSOffer> csoffers = new ArrayList<CSOffer>();

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource()) {
                @Override
                protected ResultSet wrap(ResultSet rs) {
                    return StringTrimmedResultSet.wrap(rs);
                }
            };

            String sql = "SELECT * from faenza.offers order by offerid";
            try {
                csoffers = runner.query(sql, new BeanListHandler<CSOffer>(CSOffer.class));

                for (CSOffer obj : csoffers) {
                    String offeritemsql = String.format("SELECT * from faenza.offeritems WHERE offerid = %s order by offerid, itemid",
                            obj.getOfferid());
                    List<CSOfferItem> offeritems = runner.query(offeritemsql, new BeanListHandler<CSOfferItem>(CSOfferItem.class));
                    obj.setOfferitems(offeritems);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Map root = new HashMap();
            root.put("offers", csoffers);

            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
