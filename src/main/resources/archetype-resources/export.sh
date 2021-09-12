mvn clean install
mvn -pl ${artifactId}-startup -Denv.EZYFOX_SERVER_HOME=deploy -Pezyfox-deploy clean install
