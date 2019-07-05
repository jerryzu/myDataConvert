package lab.crazyspark.bean;

import java.util.Date;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class CSPropValidator {
    private Integer objectid;
    private Integer propertyid;
	private String validatorid;
    private String validatorname;

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

    public String getValidatorid() {
        return validatorid;
    }

    public void setValidatorid(String validatorid) {
        this.validatorid = validatorid;
    }

    public String getValidatorname() {
        return validatorname;
    }

    public void setValidatorname(String validatorname) {
        this.validatorname = validatorname;
    }
}


