mvn archetype:generate

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=ojdbc -DartifactId=ojdbc6 -Dversion=11.2.0.4.0-atlassian-hosted -Dpackaging=jar -DgeneratePom=true
mvn compile
mvn package
mvn exec:java -Dexec.mainClass="lab.crazyspark.Demo"
mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForReport"

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
