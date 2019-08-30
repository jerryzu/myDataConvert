mvn archetype:generate

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4.0 -Dpackaging=jar -DgeneratePom=true
mvn compile
mvn package
mvn exec:java -Dexec.mainClass="lab.crazyspark.Demo"
mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForReport"
mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForOffer"
mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForContract"



driverClassName=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@10.19.1.2:1521:uatora02
username=txbs
password=txbs

show variables like "character_set_%"
set character_set_database=utf8;
SET NAMES 'utf8';

[jerry@j myDataConvert]$ git add .
[jerry@j myDataConvert]$ git commit -m"freemarker"
[jerry@j myDataConvert]$ git push
[jerry@j myDataConvert]$ vim /etc/my.cnf.d/server.cnf

[mysqld]
init-connect='SET NAMES utf8'
character-set-server = utf8

CREATE TABLE
students
(
        id INT,
        name VARCHAR(32),
        teacher VARCHAR(32)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 DEFAULT COLLATE=utf8mb4_unicode_ci;

public Template[] list(Connection conn, String owner, String catagory) {
String sql;
QueryRunner runner = new QueryRunner();
BeanListHandler&lt;Template&gt; handler = new BeanListHandler&lt;Template&gt;(Template.class);
sql = "SELECT * FROM GEN_TEMPLATE WHERE OWNER = ? AND CATAGORY = ?";
try {
        List<Template> aList = runner.query(conn, sql, handler, new Object[] { owner, catagory });
        return aList.toArray(new Template[0]);
} catch (Exception ex) {
        throw new GenException(ex, "èˉ??????¨??·?¨???????è?¨?????????????????????");
}
}

select replace(replace('全世界无产者',chr(13),''),chr(10),'') || '联合起来！' from dual;

 create table vw_rul_dev as select * from vw_rul@svr；

？？？？？
暂时在属性注释中，增加propid为0,注释用于对象(类)本身

---------------------------------------------------------
drop table rpt_fxq_tb_company_ms;
CREATE TABLE
    rpt_fxq_tb_company_ms
    (
        head_no VARCHAR(20) COMMENT '法人机构报告机构编码',
        company_code1 VARCHAR(20) COMMENT '机构网点代码',
        company_code2 VARCHAR(16) COMMENT '金融机构编码',
        company_name VARCHAR(160) COMMENT '机构名称',
        bord_flag VARCHAR(2) COMMENT '境内外标识',
        pt VARCHAR(15) COMMENT '分区字段'
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='机构对照表' PARTITION BY RANGE  COLUMNS(pt)
(PARTITION pt20190704000000 VALUES LESS THAN ('20190704999999') ENGINE = InnoDB) ;
       
INSERT INTO rpt_fxq_tb_company_ms (head_no, company_code1, company_code2, company_name, bord_flag, pt)
SELECT head_no, company_code1, company_code2, company_name, bord_flag, '20190704000000' pt
FROM tb_company;

SELECT *
FROM rpt_fxq_tb_company_ms partition (pt20170527000000)；


	
show create table ods_cthx_web_org_dpt_map

 mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForTable" -Dexec.cleanupDaemonThreads=false

在 工作表设置 出现 XML 错误
原因:	无效值
文件:	D:\work\myDataConvert\1.xml
组:	Worksheet
标志:	Table
ATTRIB:	ExpandedRowCount
值:	5

1、合并单元格：
        要实现上图前两列单元格合并，需要在ftl模板中对应行对应列的Cell单元格中添加ss:MergeDown="${size}"，这表示向下合并几格，如上图向下合并2格，其中size最好设为动态的。

2、导出的Excel表格只能在WPS中展示，但用office2007打不开：
         查找了很久原因，发现是因为在ftl模板中每一行数据前两格都被设置出现姓名、医生角色两个合并单元格。
        解决办法：在设置每行数据时，对合并单元格姓名、医生角色进行index判断，使每个医生的第一行数据设置合并单元格，其余数据行不能出现合并单元格，如符合条件<#if f_index % (size+1) == 0 >才允许显示。
3、Excel表格中的数据换行：
在需要换行的单元格中设置ss:WrapText="1"，调节需要换行的那一行的整体高度：<Row ss:AutoFitHeight="0" ss:Height="37.5" >

try {
// 导出
    request.setCharacterEncoding("UTF-8");
    response.setContentType("application/x-download;");
    response.setHeader("Content-disposition", "attachment; filename="
            + new String("导出的文件名字.xls".getBytes("gb2312"), "ISO8859-1"));
    freemarkerConfiguration.getTemplate("export-format-requisition.xml").process(data,response.getWriter());
}catch (Exception e){
    log.error("文件下载异常", e);
    e.printStackTrace();
}

导出xlsx格式：
 response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
 response.addHeader("Content-Disposition", "attachment;filename=fileName" + ".xlsx");
创建工作薄的时候，用Workbook workbook = new XSSFWorkbook();
这样可以正常导出xlsx格式

导出xls格式：
 response.setContentType("application/vnd.ms-excel");
  response.addHeader("Content-Disposition", "attachment;filename=fileName"+".xls");
创建工作薄的时候，用Workbook workbook = new HSSFWorkbook();
这样可以正常导出xls格式

<w:tbl>
<w:tr>
	<w:tc>
	--重新开启合并
	<w:vmerge w:val="restart"/>
	--合并操作继续
	<w:vmerge w:val="continue"/>
	</w:tc>
</w:tr>
</w:tbl>