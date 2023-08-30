mvn clean install -f business-application-kjar-executable/pom.xml -DgenerateModel=YES  
mvn clean install -f  business-application-kjar-non-executable/pom.xml -DgenerateModel=NO
cd kie-server && mvn clean package && mvn spring-boot:run