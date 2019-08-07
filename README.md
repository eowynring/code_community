## 问答社区
## 资料
[spring文档](https://spring.io/guides)

[Github授权登录(OAuth)](https://developer.github.com/apps/building-github-apps/creating-a-github-app/)

[SpringDataSource](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)

## 工具
git

maven

## 脚本
```sql
create table USER
(
	ID int auto_increment primary key not null ,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT
);


```