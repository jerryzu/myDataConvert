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
}