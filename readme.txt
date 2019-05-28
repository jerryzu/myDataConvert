mvn archetype:generate

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=ojdbc -DartifactId=ojdbc6 -Dversion=11.2.0.4.0-atlassian-hosted -Dpackaging=jar -DgeneratePom=true
mvn compile
mvn package
mvn exec:java -Dexec.mainClass="lab.crazyspark.Demo"
mvn exec:java -Dexec.mainClass="lab.crazyspark.DoForReport"
