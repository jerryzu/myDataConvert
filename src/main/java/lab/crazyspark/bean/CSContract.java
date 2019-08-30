package lab.crazyspark.bean;

import java.util.List;

public class CSContract {
	private Integer contractid;
	private String contractno;
	private Integer refid;
	private String client;
	private String liaison;
	private String contact;
	private String fax;
	private String city;
	private Integer prodid;
	private String prodname;
	private double totalprice;
	private String address;
	private String remark;
	private List<CSContractItem> contractitems;

	public Integer getContractid() {
		return contractid;
	}

	public void setContractid(Integer contractid) {
		this.contractid = contractid;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public Integer getRefid() {
		return refid;
	}

	public void setRefid(Integer refid) {
		this.refid = refid;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getLiaison() {
		return liaison;
	}

	public void setLiaison(String liaison) {
		this.liaison = liaison;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<CSContractItem> getContractitems() {
		return contractitems;
	}

	public void setContractitems(List<CSContractItem> contractitems) {
		this.contractitems = contractitems;
	}
}