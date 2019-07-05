package lab.crazyspark.bean;

import java.util.Date;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ReportItem extends BaseRowModel {
    @ExcelProperty(value = "主键", index = 0)
    private Integer n_seq;

    @ExcelProperty(value = "指标代码", index = 1)
    private String c_cde;

    @ExcelProperty(value = "指标名称", index = 2)
    private String c_name;

    @ExcelProperty(value = "指标值", index = 3)
    private String n_num;

    @ExcelProperty(value = "报送频率", index = 4)
    private String frequency;

    @ExcelProperty(value = "报送机构编码", index = 5)
    private String dept;

    @ExcelProperty(value = "报送机构级别", index = 6)
    private String dept_level;

    @ExcelProperty(value = "year", index = 7)
    private String year;

    @ExcelProperty(value = "month", index = 8)
    private String month;

    @ExcelProperty(value = "创建时间", index = 9)
    private Date crt_tm;

    @ExcelProperty(value = "上报批次", index = 10)
    private String batch_id;

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

    public String getN_num() {
        return n_num;
    }

    public void setN_num(String n_num) {
        this.n_num = n_num;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept_level() {
        return dept_level;
    }

    public void setDept_level(String dept_level) {
        this.dept_level = dept_level;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getCrt_tm() {
        return crt_tm;
    }

    public void setCrt_tm(Date crt_tm) {
        this.crt_tm = crt_tm;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    @Override
    public String toString() {
        return "ReportItem [n_seq=" + n_seq + ", c_cde=" + c_cde + ", c_name=" + c_name + ", n_num=" + n_num
                + ", frequency=" + frequency + ", dept=" + dept + ", dept_level=" + dept_level + ", year=" + year
                + ", month=" + month + ", crt_tm=" + crt_tm + ", batch_id=" + batch_id + "]";
    }
}