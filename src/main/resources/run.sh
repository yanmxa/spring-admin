#nohup java -jar human-resousce-management-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > log.file 2>&1 &

java -jar ./human-resousce-management-0.0.1-SNAPSHOT.jar --spring.config.location=./application.yaml