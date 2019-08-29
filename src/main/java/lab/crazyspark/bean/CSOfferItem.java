package lab.crazyspark.bean;

import java.util.List;

public class CSOfferItem {
	private Integer offeritemid;
	private Integer offerid;
	private Integer itemid;
	private String itemname;
	private String brandname;
	private String modelnumber;
	private String specs;
	private double unitprice;
	private double quotedprice;
	private String picture;
	private String setuppicture;
	private String remark;

	public Integer getOfferitemid() {
		return offeritemid;
	}

	public void setOfferitemid(Integer offeritemid) {
		this.offeritemid = offeritemid;
	}

	public Integer getOfferid() {
		return offerid;
	}

	public void setOfferid(Integer offerid) {
		this.offerid = offerid;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getModelnumber() {
		return modelnumber;
	}

	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public double getQuotedprice() {
		return quotedprice;
	}

	public void setQuotedprice(double quotedprice) {
		this.quotedprice = quotedprice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSetuppicture() {
		return setuppicture;
	}

	public void setSetuppicture(String setuppicture) {
		this.setuppicture = setuppicture;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}