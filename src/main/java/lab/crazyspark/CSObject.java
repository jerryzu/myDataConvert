package lab.crazyspark;

import java.util.List;

public class CSObject {
	private Integer objectid;
	private String objectname;
	private String tablename;
	private String remark;
	private String tabledesc;
	private List<CSProperty> props;

	public Integer getObjectid() {
		return objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTabledesc() {
		return tabledesc;
	}

	public void setTabledesc(String tabledesc) {
		this.tabledesc = tabledesc;
	}
	
	public void setProperties(List<CSProperty> props) {
		this.props = props;
	}

	public List<CSProperty>  getProperties() {
		return props;
	}

}