package lab.crazyspark.bean;

public class CSField {
    private String schemaname;
    private Integer tableid;
    private String tablename;
    private Integer ismasterkey;
    private Integer fieldid;
    private String fieldname;
    private String fielddesc;
    private String datatype;
    private Integer fieldlen;
    private String charused;
    private Integer scale;
    private Integer precision;
    private Integer nullable;
    private String remark;
    private Integer delivertableid;
    private Integer deliverfieldid;
    private Integer status;

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Integer getIsmasterkey() {
        return ismasterkey;
    }

    public void setIsmasterkey(Integer ismasterkey) {
        this.ismasterkey = ismasterkey;
    }

    public Integer getFieldid() {
        return fieldid;
    }

    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFielddesc() {
        return fielddesc;
    }

    public void setFielddesc(String fielddesc) {
        this.fielddesc = fielddesc;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Integer getFieldlen() {
        return fieldlen;
    }

    public void setFieldlen(Integer fieldlen) {
        this.fieldlen = fieldlen;
    }

    public String getCharused() {
        return charused;
    }

    public void setCharused(String charused) {
        this.charused = charused;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getNullable() {
        return nullable;
    }

    public void setNullable(Integer nullable) {
        this.nullable = nullable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelivertableid() {
        return delivertableid;
    }

    public void setDelivertableid(Integer delivertableid) {
        this.delivertableid = delivertableid;
    }

    public Integer getDeliverfieldid() {
        return deliverfieldid;
    }

    public void setDeliverfieldid(Integer deliverfieldid) {
        this.deliverfieldid = deliverfieldid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}