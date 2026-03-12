# mvn clean 
# mvn package
# sudo systemctl start mysql.service
# sudo systemctl stop  mysql.service
sudo nohup java -jar target/min_java_backend-1.0-SNAPSHOT.jar > app.log 2>&1 &
