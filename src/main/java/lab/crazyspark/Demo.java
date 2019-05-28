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

public class Demo {

    /**
     * 读取excel并插入mysql中 sheet第一个参数为sheetNo代表sheet的编号,第二个参数表示从第几行开始读,最小是1, new
     * Sheet(1,0,Student.class)发现无输出结果
     * 
     * @throws FileNotFoundException
     */
    // @SuppressWarnings("deprecation")
    // @Test
    // public void readExcel() throws FileNotFoundException {
    // InputStream inputStream = new FileInputStream("d:/excelTest/test.xlsx");
    // try {
    // // 解析每行结果在listener中处理
    // ExcelListener listener = new ExcelListener();

    // ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX,
    // null, listener);
    // excelReader.read(new Sheet(1, 1, Student.class));
    // } catch (Exception e) {

    // } finally {
    // try {
    // inputStream.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // }

    /**
     * 查询测试
     */
    // @Test
    // public void queryByGroup() {
    // // QueryRunner runner = new QueryRunner(JdbcUtils.getDS());
    // String sql = "SELECT * from student group by teacher,id";
    // try {
    // // List<Student> query = runner.query(sql, new
    // BeanListHandler<Student>(Student.class));
    // for (Student student : query) {
    // System.out.println(student.getName() + "----" + student.getTeacher());
    // }

    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }

    /**
     * 将查询结果写出到excel中 在写excel的过程中,含有模型的写入,对于sheet的第二个参数是忽略的,全部从左侧第一行进行读写
     */
    // @Test
    public static void main(String args[]) {
        Demo demo = new Demo();
        demo.writeExcel();
    }

    public void writeExcel() {
        try {
            OutputStream os = new FileOutputStream(new File("/app/work/myDataConvert/new.xlsx"));
            ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX, true);

            // 2代表sheetNo,不可以重复,如果两个sheet的sheetNo相同则输出时只会有一个sheet
            Sheet sheet1 = new Sheet(1, 5, Student.class);
            sheet1.setSheetName("第一个sheet");

            Sheet sheet2 = new Sheet(2, 1, Student.class);
            sheet2.setSheetName("第二个sheet");

            // QueryRunner runner = new QueryRunner(JdbcUtils.getDS());

            QueryRunner runner = new QueryRunner(JDBCUitls.getDataSource());
            
            String sql = "SELECT * from student group by teacher,id";

            // return runner.query(sql,id,new BeanHandler<User>(User.class));
            
            List<Student> result = runner.query(sql, new BeanListHandler<Student>(Student.class));

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