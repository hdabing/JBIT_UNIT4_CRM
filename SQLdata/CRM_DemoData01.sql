--创建CRM表空间
Create tablespace CRM
datafile 'CRM.DBF'
size 100M
autoextend on;


--创建数据库操作员
Create user uCRM
identified by root
default tablespace CRM
temporary tablespace TEMP;


--给操作员权限
Grant resource,connect to uCRM;
