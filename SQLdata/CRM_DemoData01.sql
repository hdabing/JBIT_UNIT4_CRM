--����CRM��ռ�
Create tablespace CRM
datafile 'CRM.DBF'
size 100M
autoextend on;


--�������ݿ����Ա
Create user uCRM
identified by root
default tablespace CRM
temporary tablespace TEMP;


--������ԱȨ��
Grant resource,connect to uCRM;
