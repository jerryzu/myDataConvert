package lab.crazyspark;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class FormulaItem extends BaseRowModel {
    @ExcelProperty(value = "主键", index = 0)
    private Integer n_seq;

    @ExcelProperty(value = "指标代码", index = 1)
    private String c_cde;

    @ExcelProperty(value = "指标名称", index = 2)
    private String c_name;

    @ExcelProperty(value = "指标提取规则", index = 3)
    private String c_sql;

    @ExcelProperty(value = "指标提取规则", index = 3)
    private String dev_c_sql;
    
    @ExcelProperty(value = "指标提取规则", index = 3)
    private String prd_c_sql;

    @ExcelProperty(value = "月度指标", index = 4)
    private String c_month;

    @ExcelProperty(value = "季度指标", index = 5)
    private String c_season;

    @ExcelProperty(value = "半年度指标", index = 6)
    private String c_half_year;

    @ExcelProperty(value = "指标公式表", index = 6)
    private String table_name;

    public Integer getN_seq() {
        return n_seq;
    }

    public void setN_seq(Integer n_seq) {
        this.n_seq = n_seq;
    }

    public String getC_cde() {
        return c_cde;
    }

    public void setC_cde(String c_cde) {
        this.c_cde = c_cde;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getc_sql() {
        return c_sql;
    }

    public void setc_sql(String c_sql) {
        this.c_sql = c_sql;
    }

    public String getdev_c_sql() {
        return dev_c_sql;
    }

    public void setdev_c_sql(String dev_c_sql) {
        this.dev_c_sql = dev_c_sql;
    }

    public String getprd_c_sql() {
        return prd_c_sql;
    }

    public void setprd_c_sql(String prd_c_sql) {
        this.prd_c_sql = prd_c_sql;
    }


    public String getc_month() {
        return c_month;
    }

    public void setc_month(String c_month) {
        this.c_month = c_month;
    }

    public String getc_season() {
        return c_season;
    }

    public void setc_season(String c_season) {
        this.c_season = c_season;
    }

    public String getc_half_year() {
        return c_half_year;
    }

    public void setc_half_year(String c_half_year) {
        this.c_half_year = c_half_year;
    }

    public String gettable_name() {
        return table_name;
    }

    public void settable_name(String table_name) {
        this.table_name = table_name;
    }

    @Override
    public String toString() {
        return "ReportItem [n_seq=" + n_seq + ", c_cde=" + c_cde + ", c_name=" + c_name + ", c_sql=" + c_sql
                + ", c_month=" + c_month + ", c_season=" + c_season + ", c_half_year=" + c_half_year + "]";
    }
}