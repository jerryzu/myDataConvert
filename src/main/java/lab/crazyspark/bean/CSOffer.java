package lab.crazyspark.bean;

import java.util.List;

public class CSOffer {
	private Integer offerid;
	private String offerno;
	private String Inquirer;
	private double amount;
	private String contact;
	private String city;
	private Integer prodid;
	private String address;
	private String remark;
	private List<CSOfferItem> offeritems;

	public Integer getOfferid() {
		return offerid;
	}

	public void setOfferid(Integer offerid) {
		this.offerid = offerid;
	}

	public String getOfferno() {
		return offerno;
	}

	public void setOfferno(String offerno) {
		this.offerno = offerno;
	}

	public String getInquirer() {
		return Inquirer;
	}

	public void setInquirer(String inquirer) {
		Inquirer = inquirer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public List<CSOfferItem> getOfferitems() {
		return offeritems;
	}

	public void setOfferitems(List<CSOfferItem> offeritems) {
		this.offeritems = offeritems;
	}
	
}