package lab.crazyspark;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.dbutils.QueryRunner;

import lab.crazyspark.bean.ReportItem;
import lab.crazyspark.utils.JDBCUitls;

public class ExcelListener extends AnalysisEventListener<ReportItem> {
    // 自定义用于暂时存储data。
    // 可以通过实例获取该值
    private List<ReportItem> datas = new ArrayList<ReportItem>();

    // 每解析一行调用一次invoke方法
    public void invoke(ReportItem object, AnalysisContext context) {
        System.out.println("当前行：" + context.getCurrentRowNum());
        System.out.println(object);
        datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(datas);// 根据自己业务做处理
    }

    private void doSomething(List<ReportItem> list) {

    }

    // 解析结束后自动调用
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 1、入库调用接口
        QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());
        String sql = "insert into student values(?,?,?)";
        for (ReportItem item : datas) {
            try {
                runner.update(sql, new Object[] { item.getC_cde(), item.getC_name() });
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据更新完成");
        // try {
        // JDBCUitls.close(null, null, JDBCUitls.getConnection());
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
    }

    public List<ReportItem> getDatas() {
        return datas;
    }

    public void setDatas(List<ReportItem> datas) {
        this.datas = datas;
    }
}