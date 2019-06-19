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