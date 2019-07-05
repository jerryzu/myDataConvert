package lab.crazyspark;

import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
// import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.bean.ReportItem;
import lab.crazyspark.utils.JDBCUitls;

public class DoForReport {

    public static void main(String args[]) {
        DoForReport doForReport = new DoForReport();
        doForReport.writeExcel();
    }

    public void writeExcel() {
        try {

            // 2代表sheetNo,不可以重复,如果两个sheet的sheetNo相同则输出时只会有一个sheet
            Sheet sheet1 = new Sheet(1, 5, ReportItem.class);
            sheet1.setSheetName("第一个sheet");

            Sheet sheet2 = new Sheet(2, 1, ReportItem.class);
            sheet2.setSheetName("第二个sheet");

            // QueryRunner runner = new QueryRunner(JdbcUtils.getDS());

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());
            
            String sql = "SELECT * from all_report_data where rownum < 5 order by batch_id, c_cde";

            // return runner.query(sql,id,new BeanHandler<User>(User.class));
            
            List<ReportItem> result = runner.query(sql, new BeanListHandler<ReportItem>(ReportItem.class));
            
            OutputStream os = new FileOutputStream(new File("/app/work/myDataConvert/all_report_data.xlsx"));
            ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX, true);

            writer.write(result, sheet1);
            writer.write(result, sheet2);

            writer.finish();
            System.out.println("数据已写出");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}