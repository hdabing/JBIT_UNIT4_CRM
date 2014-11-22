/*-----------��ɫ��-------------*/
Create table Role
(
id int primary key not null,
name varchar2(50) not null,--��ɫ����
isdel int not null--�Ƿ�ɾ��  0δɾ����1ɾ��
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
isdel int not null--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;

/*-----------�û���-------------*/
Create table Users
(
id int primary key not null,
username varchar2(50) not null,
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
name varchar2(50) not null,--��������
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�������ͱ�------------*/
Create table Service
(
id int primary key not null,
name varchar2(50),--������������
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
summary varchar2(50) not null,--��Ҫ
content varchar2(200) not null,--��������
state int default 0 not null,--����״̬
createtime date not null,--����ʱ��
granttime date,--����ʱ��
operatortime date,--����ʱ��
operatorcontent varchar2(200),--����������
resultcontent varchar2(200),--����������
agreelevel int default 1 not null,--�����
createuserid int not null--������id
);
COMMIT;


/*-----------����״̬��------------*/
Create table ServiceState
(
id int primary key not null,
name varchar2(50) not null,--����״̬����
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�ͻ��ȼ���------------*/
Create table CustomerLevel
(
id int primary key not null,
name varchar2(50) not null,
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------���ۻ����-----------*/
Create table Chances
(
id int primary key not null,
name varchar2(50) not null,--�ͻ�����
areaid int not null,--����id
levelid int not null,--�û��ȼ�id
managername varchar2(50) not null,--������
chancesfrom varchar2(50),--������Դ
phone varchar2(50) not null,--�绰
content varchar2(50),--��Ҫ
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
name varchar2(50) not null,--״̬����
isdel int--�Ƿ�ɾ��  0δɾ����1ɾ��
);
COMMIT;


/*-----------�ƻ���-----------*/
Create table ChancesPlan
(
id int primary key not null,
chancesid int not null,--���ۻ���id
plantime date not null,--�ƻ�����
planname varchar2(50),--�ƻ���
effect varchar2(50)--ִ��Ч��
);
COMMIT;


/*-----------�ͻ���------------*/
Create table Customer
(
id int primary key not null,
name varchar2(50) not null,--�ͻ�����
code varchar2(50),--�ͻ����
userid int not null,--�ͻ�����id
areaid int not null,--����id

levelid int not null,--�û��ȼ�id
managername varchar2(50) not null,--������
agreelevel int default 1 not null,--�����
creditlevel int default 1 not null,--������
address varchar2(200),--��ַ

postcode varchar2(50),--��������
phone varchar2(50),--�绰
fax varchar2(50),--����
website varchar2(200),--��ַ
bussinesscode varchar2(50),--Ӫҵִ��

regsmoney float default 0 not null,--ע���ʽ�
regbank varchar2(50),--������
landtaxcode varchar2(50),--��˰�ǼǺ�
legalperson varchar2(50),--����
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
name varchar2(50) not null,--��ϵ��
gender varchar2(50) not null,--�Ա�
customerid int not null,--�ͻ�id
position varchar2(50) not null,--ְλ
phone varchar2(50) not null,--�칫�绰
telephone varchar2(50),--�ֻ�
content varchar2(200),--��ע
isdel int not null--�Ƿ�ɾ��  0δɾ����1ɾ��
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
state varchar2(50) not null--״̬
);
COMMIT;


/*----------������¼��-------------*/
Create table Relationship
(
id int primary key not null,
customerid int not null,--�ͻ�id
relationtime date not null,--����ʱ��
address varchar2(200) not null,--�ص�
summary varchar2(200) not null,--��Ҫ
content varchar2(200),--��ע
detail varchar2(200)--��ϸ��Ϣ
);
COMMIT;


/*------------��ʷ����(����)-----------*/
Create table Orders
(
id int primary key not null,
customerid int not null,--�ͻ�id
ordertime date not null,--��������
address varchar2(200) not null,--�ͻ���ַ
state varchar2(200) not null,--״̬,0�ѷ���,1���տ�
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





/*----------------��ӻ�������(�����)--------------------*/

/*-------------����û�����-----------------*/
create sequence usersid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into Users values(usersid.nextval,'admin','admin',1,0);
COMMIT;


/*-------------��ӽ�ɫ����-----------------*/
create sequence roleid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into Role values(roleid.nextval,'����Ա',0);
COMMIT;


/*-------------���Ȩ������-----------------*/
create sequence authorid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;
insert into Author values(authorid.nextval,'L01','Ӫ������',1);
insert into Author values(authorid.nextval,'L0101','���ۻ������',4);
insert into Author values(authorid.nextval,'L0102','�ͻ������ƻ�',4);
insert into Author values(authorid.nextval,'L02','�ͻ�����',1);
insert into Author values(authorid.nextval,'L0201','�ͻ���Ϣ����',4);
insert into Author values(authorid.nextval,'L0202','�ͻ���ʧ����',4);
insert into Author values(authorid.nextval,'L03','�������',1);
insert into Author values(authorid.nextval,'L0301','���񴴽�',4);
insert into Author values(authorid.nextval,'L0302','�������',4);
insert into Author values(authorid.nextval,'L0303','������',4);
insert into Author values(authorid.nextval,'L0304','������',4);
insert into Author values(authorid.nextval,'L0305','����鵵',4);
insert into Author values(authorid.nextval,'L04','ͳ�Ʊ���',1);
insert into Author values(authorid.nextval,'L0401','�ͻ����׷���',4);
insert into Author values(authorid.nextval,'L0402','�ͻ����ɷ���',4);
insert into Author values(authorid.nextval,'L0403','�ͻ��������',4);
insert into Author values(authorid.nextval,'L0404','�ͻ���ʧ����',4);
insert into Author values(authorid.nextval,'L05','��������',1);
insert into Author values(authorid.nextval,'L0501','�ͻ��ȼ�����',4);
insert into Author values(authorid.nextval,'L0502','�������͹���',4);
insert into Author values(authorid.nextval,'L0503','�ͻ���������',4);
insert into Author values(authorid.nextval,'L0504','��ѯ��Ʒ��Ϣ',4);
insert into Author values(authorid.nextval,'L0505','��ѯ���',4);
insert into Author values(authorid.nextval,'L06','Ȩ�޹���',1);
insert into Author values(authorid.nextval,'L0601','�û�����',4);
insert into Author values(authorid.nextval,'L0602','��ɫ����',4);
COMMIT;


/*-------------��ӽ�ɫȨ������-----------------*/
create sequence roleauthorid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,1,id,0 from author;
COMMIT;


/*-----------------��ӵ�������-----------------*/
create sequence areaid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------��ӿͻ��ȼ�����-----------------*/
create sequence customerlevelid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------������ۻ�������-----------------*/
create sequence chancesid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;



/*-----------------������ۻ���״̬����-----------------*/
create sequence chancestateid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into chancestate values
(chancestateid.nextval,'δ����',0);
insert into chancestate values
(chancestateid.nextval,'������',0);
insert into chancestate values
(chancestateid.nextval,'�ѹ鵵',0);
insert into chancestate values
(chancestateid.nextval,'����ʧ��',0);
COMMIT;


/*-----------------��ӿͻ�����-----------------*/
create sequence customerid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------��ӿͻ���ϵ������-----------------*/
create sequence customercontactid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

/*-----------------��ӿͻ�������¼����-----------------*/
create sequence relationshipid
minvalue 1
maxvalue 99999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------��Ӷ���-----------------*/
create sequence ordersid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------��Ӷ�����ϸ��-----------------*/
create sequence orderlistid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------�����Ʒ��Ϣ-----------------*/
create sequence productid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into product values
(productid.nextval,'�㽶','�ֿܲ�','ˮ����',100,
'20140730',5000,'����','������','ˮ����');
insert into product values
(productid.nextval,'ƻ��','�ֿܲ�','ˮ����',150,
'20140731',4000,'����','��ʿɽ','ˮ����');
insert into product values
(productid.nextval,'����','�ֿܲ�','ˮ����',200,
'20140732',3000,'����','�����','ˮ����');
COMMIT;


/*-----------------��ӿͻ���ʧ-----------------*/
create sequence customerlostid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;



/*-----------��ӷ�������------------*/
create sequence serviceid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------��ӷ�������״̬------------*/
create sequence servicestateid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into servicestate values
(servicestateid.nextval,'�´���',0);
insert into servicestate values
(servicestateid.nextval,'�ѷ���',0);
insert into servicestate values
(servicestateid.nextval,'�Ѵ���',0);
insert into servicestate values
(servicestateid.nextval,'�ѹ鵵',0);
COMMIT;


/*-----------------��ӷ�����ϸ��-----------------*/
create sequence servicelistid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

