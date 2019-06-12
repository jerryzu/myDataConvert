package lab.crazyspark;

import java.util.Date;
import java.util.List;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/*
SELECT  o.objectid objectid, o.objectname objectname,  f.fieldid propertyid, f.fieldname propertyname, f.fielddesc, f.datatype, f.remark
FROM sys_fields f
inner join sys_objects o
    on f.tablename = o.tablename
order by o.objectid, f.fieldid
*/
public class CSProperty {
    private Integer objectid;
    private Integer propertyid;
	private String propertyname;
    private String datatype;
	private List<CSPropValidator> prop_validators;


	public void setPropValidators(List<CSPropValidator> prop_validators) {
		this.prop_validators = prop_validators;
	}

	public List<CSPropValidator>  getPropValidators() {
		return prop_validators;
    }
    
    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }
}