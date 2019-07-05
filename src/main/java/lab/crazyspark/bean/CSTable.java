package lab.crazyspark.bean;

import java.util.List;

public class CSTable {
    private Integer tableid;
    private String schemaname;
    private String tablename;
    private String tabledesc;
    private Integer enabled;
    private String bizsys;
    private String tablelayer;
    private String updatemethod;
    private String masterkey;
    private String updatefield;
    private String updatefrequency;
    private Integer deliverid;
    private String remark;
    private String parttype;
    private String partfield;
    private String distributionkey;
    private String topicname;
	private List<CSField> fields;

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTabledesc() {
        return tabledesc;
    }

    public void setTabledesc(String tabledesc) {
        this.tabledesc = tabledesc;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getBizsys() {
        return bizsys;
    }

    public void setBizsys(String bizsys) {
        this.bizsys = bizsys;
    }

    public String getTablelayer() {
        return tablelayer;
    }

    public void setTablelayer(String tablelayer) {
        this.tablelayer = tablelayer;
    }

    public String getUpdatemethod() {
        return updatemethod;
    }

    public void setUpdatemethod(String updatemethod) {
        this.updatemethod = updatemethod;
    }

    public String getMasterkey() {
        return masterkey;
    }

    public void setMasterkey(String masterkey) {
        this.masterkey = masterkey;
    }

    public String getUpdatefield() {
        return updatefield;
    }

    public void setUpdatefield(String updatefield) {
        this.updatefield = updatefield;
    }

    public String getUpdatefrequency() {
        return updatefrequency;
    }

    public void setUpdatefrequency(String updatefrequency) {
        this.updatefrequency = updatefrequency;
    }

    public Integer getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(Integer deliverid) {
        this.deliverid = deliverid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParttype() {
        return parttype;
    }

    public void setParttype(String parttype) {
        this.parttype = parttype;
    }

    public String getPartfield() {
        return partfield;
    }

    public void setPartfield(String partfield) {
        this.partfield = partfield;
    }

    public String getDistributionkey() {
        return distributionkey;
    }

    public void setDistributionkey(String distributionkey) {
        this.distributionkey = distributionkey;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public List<CSField> getFields() {
        return fields;
    }

    public void setFields(List<CSField> fields) {
        this.fields = fields;
    }
}