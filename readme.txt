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