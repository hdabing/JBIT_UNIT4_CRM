/*-----------��ɫ��-------------*/
Create table Role
(
id int primary key not null,
name varchar2(20) not null,--��ɫ����
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;

/*-----------Ȩ�ޱ�-------------*/
Create table Author
(
id int primary key not null,
code varchar2(20) not null,--��Ӧjavascript��Entity����
name varchar2(20) not null,--Ȩ������
authorlevel int not null--Ȩ�޼���(������ӡ�ո�����)
);
COMMIT;

/*----------��ɫȨ�ޱ�-----------*/
Create table RoleAuthor
(
id int primary key not null,
roleid int not null,--��ɫid
authorid int not null,--Ȩ��id
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;

/*-----------�û���-------------*/
Create table Users
(
id int primary key not null,
username varchar2(20) not null,
password varchar2(50) not null,
roleid int default 0 not null,--��ɫid
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*------------��Ʒ��------------*/
Create table Product
(
id int primary key not null,
name varchar2(20) not null,
storename varchar2(20) not null,--�ֿ�����
housename varchar2(20) not null,--��λ����
quantity int default 0 not null,--����
batch varchar2(20) not null,--����
price float default 0 not null,--�۸�
unit varchar2(20) not null,--��λ
model varchar2(20) not null,--�ͺ�
content varchar2(200)--��ע
);
COMMIT;


/*------------������-------------*/
Create table Area
(
id int primary key not null,
name varchar2(20) not null,--��������
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�������ͱ�------------*/
Create table Service
(
id int primary key not null,
name varchar2(20),--������������
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------������ϸ��------------*/
Create table ServiceList
(
id int primary key not null,
customerid int not null,--�ͻ�id
operatorid int not null,--������id
userid int default 0 not null,--ָ����Աid
serviceid int not null,--��������id
summary varchar2(20) not null,--��Ҫ
content varchar2(200) not null,--��������
state int default 0 not null,--����״̬
createtime date not null,--����ʱ��
granttime date,--����ʱ��
operatortime date,--����ʱ��
operatorcontent varchar2(200),--����������
resultcontent varchar2(200),--����������
agreelevel int default 1,--�����
createuserid int not null--������id
);
COMMIT;


/*-----------����״̬��------------*/
Create table ServiceState
(
id int primary key not null,
name varchar2(20) not null,--����״̬����
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�ͻ��ȼ���------------*/
Create table CustomerLevel
(
id int primary key not null,
name varchar2(20) not null,
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------���ۻ����-----------*/
Create table Chances
(
id int primary key not null,
name varchar2(20) not null,--�ͻ�����
areaid int not null,--����id
levelid int not null,--�û��ȼ�id
managername varchar2(20) not null,--������
chancesfrom varchar2(20),--������Դ
phone varchar2(20) not null,--�绰
content varchar2(20),--��Ҫ
successrate int default 0 not null,--�ɹ���
chancesdesc varchar2(200) not null,--��������
createuserid int not null,--������id
userid int not null,--ָ����Աid
createtime date not null,--����ʱ��
chancestime date not null,--ָ��ʱ��
state int default 1 not null,--״̬
issuccess int default 0 not null--�Ƿ�ɹ�0δ�ɹ�,1�ɹ�
);
COMMIT;


/*-----------���ۻ���״̬��-----------*/
Create table ChanceState
(
id int primary key not null,
name varchar2(20) not null,--״̬����
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�ƻ���-----------*/
Create table ChancesPlan
(
id int primary key not null,
chancesid int not null,--���ۻ���id
plantime date not null,--�ƻ�����
planname varchar2(20),--�ƻ���
effect varchar2(20)--ִ��Ч��
);
COMMIT;


/*-----------�ͻ���------------*/
Create table Customer
(
id int primary key not null,
name varchar2(20) not null,--�ͻ�����
code varchar2(20),--�ͻ����
userid int not null,--�ͻ�����id
areaid int not null,--����id

levelid int not null,--�û��ȼ�id
managername varchar2(20) not null,--������
agreelevel int default 1 not null,--�����
creditlevel int default 1 not null,--������
address varchar2(50),--��ַ

postcode varchar2(20),--��������
phone varchar2(20),--�绰
fax varchar2(20),--����
website varchar2(50),--��ַ
bussinesscode varchar2(50),--Ӫҵִ��

regsmoney float default 0 not null,--ע���ʽ�
regbank varchar2(20),--������
landtaxcode varchar2(50),--��˰�ǼǺ�
legalperson varchar2(20),--����
bussinessmoney float default 0 not null,--��Ӫҵ��

bankaccount varchar2(50),--�����˺�
nationaltaxcode varchar2(50),--��˰�ǼǺ�
islost int default 0,--�Ƿ���ʧ
isdel int default 0--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*------------�ͻ���ϵ�˱�-----------*/
Create table CustomerContact
(
id int primary key not null,
name varchar2(20) not null,--��ϵ��
gender varchar2(20) not null,--�Ա�
customerid int not null,--�ͻ�id
position varchar2(20) not null,--ְλ
phone varchar2(20) not null,--�칫�绰
telephone varchar2(20),--�ֻ�
content varchar2(200),--��ע
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*------------�ͻ���ʧ��-----------*/
Create table CustomerLost
(
id int primary key not null,
customerid int not null,--�ͻ�id
lastorder date not null,--����µ�����
lostday date not null,--ȷ����ʧ����
content varchar2(200),--�ݻ���ʩ
lostcause varchar2(200),--��ʧԭ��
state varchar2(20) not null--״̬
);
COMMIT;


/*----------������¼��-------------*/
Create table Relationship
(
id int primary key not null,
customerid int not null,--�ͻ�id
relationtime date not null,--����ʱ��
address varchar2(20) not null,--�ص�
summary varchar2(20) not null,--��Ҫ
content varchar2(20),--��ע
detail varchar2(200)--��ϸ��Ϣ
);
COMMIT;


/*------------��ʷ����(����)-----------*/
Create table Orders
(
id int primary key not null,
customerid int not null,--�ͻ�id
ordertime date not null,--��������
address varchar2(50) not null,--�ͻ���ַ
state varchar2(20) not null,--״̬,0�ѷ���,1���տ�
amount float default 0 not null--�ܽ��
);
COMMIT;


/*------------��ʷ����(�ӱ�)-----------*/
Create table Orderlist
(
id int primary key not null,
orderid int not null,--�������
productid int not null,--��Ʒ���
quantity int not null,--����
price float default 0 not null,--����
amount float default 0 not null--���
);
COMMIT;

