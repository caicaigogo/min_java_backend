## mysql服务
启动mysql服务器, 记得加sudo

sudo mysqld_safe --user=mysql

登陆mysql, 接着输入密码

mysql -uroot -p

## 后端服务

在idea 入口类点三角形进行执行

## 测试

curl http://localhost:8080/api/users

curl -X GET http://localhost:8080/api/users
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "someemail@someemailprovider.com"}'
curl -X DELETE http://localhost:8080/api/users/2
curl -X PUT http://localhost:8080/api/users/1 -H "Content-Type: application/json" -d '{"name": "John Doe rename", "email": "someemail_rename@someemailprovider.com"}'
