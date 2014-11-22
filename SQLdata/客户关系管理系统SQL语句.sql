/*-----------角色表-------------*/
Create table Role
(
id int primary key not null,
name varchar2(50) not null,--角色名称
isdel int not null--是否删除  0未删除，1删除
);
COMMIT;

/*-----------权限表-------------*/
Create table Author
(
id int primary key not null,
code varchar2(20) not null,--对应javascript的Entity编码
name varchar2(20) not null,--权限名称
authorlevel int not null--权限级次(用来打印空格数量)
);
COMMIT;

/*----------角色权限表-----------*/
Create table RoleAuthor
(
id int primary key not null,
roleid int not null,--角色id
authorid int not null,--权限id
isdel int not null--是否删除  0未删除，1删除
);
COMMIT;

/*-----------用户表-------------*/
Create table Users
(
id int primary key not null,
username varchar2(50) not null,
password varchar2(50) not null,
roleid int default 0 not null,--角色id
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*------------商品表------------*/
Create table Product
(
id int primary key not null,
name varchar2(20) not null,
storename varchar2(20) not null,--仓库名称
housename varchar2(20) not null,--货位名称
quantity int default 0 not null,--数量
batch varchar2(20) not null,--批次
price float default 0 not null,--价格
unit varchar2(20) not null,--单位
model varchar2(20) not null,--型号
content varchar2(200)--备注
);
COMMIT;


/*------------地区表-------------*/
Create table Area
(
id int primary key not null,
name varchar2(50) not null,--地区名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------服务类型表------------*/
Create table Service
(
id int primary key not null,
name varchar2(50),--服务类型名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------服务明细表------------*/
Create table ServiceList
(
id int primary key not null,
customerid int not null,--客户id
operatorid int not null,--操作人id
userid int default 0 not null,--指派人员id
serviceid int not null,--服务类型id
summary varchar2(50) not null,--概要
content varchar2(200) not null,--服务请求
state int default 0 not null,--服务状态
createtime date not null,--创建时间
granttime date,--分配时间
operatortime date,--处理时间
operatorcontent varchar2(200),--服务处理内容
resultcontent varchar2(200),--处理结果内容
agreelevel int default 1 not null,--满意度
createuserid int not null--创建人id
);
COMMIT;


/*-----------服务状态表------------*/
Create table ServiceState
(
id int primary key not null,
name varchar2(50) not null,--服务状态名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------客户等级表------------*/
Create table CustomerLevel
(
id int primary key not null,
name varchar2(50) not null,
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------销售机会表-----------*/
Create table Chances
(
id int primary key not null,
name varchar2(50) not null,--客户名称
areaid int not null,--区域id
levelid int not null,--用户等级id
managername varchar2(50) not null,--负责人
chancesfrom varchar2(50),--机会来源
phone varchar2(50) not null,--电话
content varchar2(50),--概要
successrate int default 0 not null,--成功率
chancesdesc varchar2(200) not null,--机会描述
createuserid int not null,--创建人id
userid int not null,--指派人员id
createtime date not null,--创建时间
chancestime date not null,--指派时间
state int default 1 not null,--状态
issuccess int default 0 not null--是否成功0未成功,1成功
);
COMMIT;


/*-----------销售机会状态表-----------*/
Create table ChanceState
(
id int primary key not null,
name varchar2(50) not null,--状态名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------计划表-----------*/
Create table ChancesPlan
(
id int primary key not null,
chancesid int not null,--销售机会id
plantime date not null,--计划日期
planname varchar2(50),--计划项
effect varchar2(50)--执行效果
);
COMMIT;


/*-----------客户表------------*/
Create table Customer
(
id int primary key not null,
name varchar2(50) not null,--客户名称
code varchar2(50),--客户编号
userid int not null,--客户经理id
areaid int not null,--区域id

levelid int not null,--用户等级id
managername varchar2(50) not null,--负责人
agreelevel int default 1 not null,--满意度
creditlevel int default 1 not null,--信誉度
address varchar2(200),--地址

postcode varchar2(50),--邮政编码
phone varchar2(50),--电话
fax varchar2(50),--传真
website varchar2(200),--网址
bussinesscode varchar2(50),--营业执照

regsmoney float default 0 not null,--注册资金
regbank varchar2(50),--开户行
landtaxcode varchar2(50),--地税登记号
legalperson varchar2(50),--法人
bussinessmoney float default 0 not null,--年营业额

bankaccount varchar2(50),--银行账号
nationaltaxcode varchar2(50),--国税登记号
islost int default 0,--是否流失
isdel int default 0--是否删除  0未删除，1删除
);
COMMIT;


/*------------客户联系人表-----------*/
Create table CustomerContact
(
id int primary key not null,
name varchar2(50) not null,--联系人
gender varchar2(50) not null,--性别
customerid int not null,--客户id
position varchar2(50) not null,--职位
phone varchar2(50) not null,--办公电话
telephone varchar2(50),--手机
content varchar2(200),--备注
isdel int not null--是否删除  0未删除，1删除
);
COMMIT;


/*------------客户流失表-----------*/
Create table CustomerLost
(
id int primary key not null,
customerid int not null,--客户id
lastorder date not null,--最后下单日期
lostday date not null,--确认流失日期
content varchar2(200),--暂缓措施
lostcause varchar2(200),--流失原因
state varchar2(50) not null--状态
);
COMMIT;


/*----------交往记录表-------------*/
Create table Relationship
(
id int primary key not null,
customerid int not null,--客户id
relationtime date not null,--交往时间
address varchar2(200) not null,--地点
summary varchar2(200) not null,--概要
content varchar2(200),--备注
detail varchar2(200)--详细信息
);
COMMIT;


/*------------历史订单(主表)-----------*/
Create table Orders
(
id int primary key not null,
customerid int not null,--客户id
ordertime date not null,--订单日期
address varchar2(200) not null,--送货地址
state varchar2(200) not null,--状态,0已发货,1已收款
amount float default 0 not null--总金额
);
COMMIT;


/*------------历史订单(子表)-----------*/
Create table Orderlist
(
id int primary key not null,
orderid int not null,--订单编号
productid int not null,--商品编号
quantity int not null,--数量
price float default 0 not null,--单价
amount float default 0 not null--金额
);
COMMIT;





/*----------------添加基础数据(必须的)--------------------*/

/*-------------添加用户资料-----------------*/
create sequence usersid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into Users values(usersid.nextval,'admin','admin',1,0);
COMMIT;


/*-------------添加角色资料-----------------*/
create sequence roleid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into Role values(roleid.nextval,'管理员',0);
COMMIT;


/*-------------添加权限资料-----------------*/
create sequence authorid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;
insert into Author values(authorid.nextval,'L01','营销管理',1);
insert into Author values(authorid.nextval,'L0101','销售机会管理',4);
insert into Author values(authorid.nextval,'L0102','客户开发计划',4);
insert into Author values(authorid.nextval,'L02','客户管理',1);
insert into Author values(authorid.nextval,'L0201','客户信息管理',4);
insert into Author values(authorid.nextval,'L0202','客户流失管理',4);
insert into Author values(authorid.nextval,'L03','服务管理',1);
insert into Author values(authorid.nextval,'L0301','服务创建',4);
insert into Author values(authorid.nextval,'L0302','服务分配',4);
insert into Author values(authorid.nextval,'L0303','服务处理',4);
insert into Author values(authorid.nextval,'L0304','服务反馈',4);
insert into Author values(authorid.nextval,'L0305','服务归档',4);
insert into Author values(authorid.nextval,'L04','统计报表',1);
insert into Author values(authorid.nextval,'L0401','客户贡献分析',4);
insert into Author values(authorid.nextval,'L0402','客户构成分析',4);
insert into Author values(authorid.nextval,'L0403','客户服务分析',4);
insert into Author values(authorid.nextval,'L0404','客户流失分析',4);
insert into Author values(authorid.nextval,'L05','基础数据',1);
insert into Author values(authorid.nextval,'L0501','客户等级管理',4);
insert into Author values(authorid.nextval,'L0502','服务类型管理',4);
insert into Author values(authorid.nextval,'L0503','客户地区管理',4);
insert into Author values(authorid.nextval,'L0504','查询产品信息',4);
insert into Author values(authorid.nextval,'L0505','查询库存',4);
insert into Author values(authorid.nextval,'L06','权限管理',1);
insert into Author values(authorid.nextval,'L0601','用户管理',4);
insert into Author values(authorid.nextval,'L0602','角色管理',4);
COMMIT;


/*-------------添加角色权限资料-----------------*/
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


/*-----------------添加地区资料-----------------*/
create sequence areaid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加客户等级资料-----------------*/
create sequence customerlevelid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加销售机会资料-----------------*/
create sequence chancesid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;



/*-----------------添加销售机会状态资料-----------------*/
create sequence chancestateid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into chancestate values
(chancestateid.nextval,'未分配',0);
insert into chancestate values
(chancestateid.nextval,'开发中',0);
insert into chancestate values
(chancestateid.nextval,'已归档',0);
insert into chancestate values
(chancestateid.nextval,'开发失败',0);
COMMIT;


/*-----------------添加客户资料-----------------*/
create sequence customerid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加客户联系人资料-----------------*/
create sequence customercontactid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

/*-----------------添加客户交往记录资料-----------------*/
create sequence relationshipid
minvalue 1
maxvalue 99999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加订单-----------------*/
create sequence ordersid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加订单明细表-----------------*/
create sequence orderlistid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------------添加商品信息-----------------*/
create sequence productid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into product values
(productid.nextval,'香蕉','总仓库','水果区',100,
'20140730',5000,'公斤','清香型','水果类');
insert into product values
(productid.nextval,'苹果','总仓库','水果区',150,
'20140731',4000,'公斤','富士山','水果类');
insert into product values
(productid.nextval,'西瓜','总仓库','水果区',200,
'20140732',3000,'公斤','甜脆型','水果类');
COMMIT;


/*-----------------添加客户流失-----------------*/
create sequence customerlostid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;



/*-----------添加服务类型------------*/
create sequence serviceid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;


/*-----------添加服务类型状态------------*/
create sequence servicestateid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into servicestate values
(servicestateid.nextval,'新创建',0);
insert into servicestate values
(servicestateid.nextval,'已分配',0);
insert into servicestate values
(servicestateid.nextval,'已处理',0);
insert into servicestate values
(servicestateid.nextval,'已归档',0);
COMMIT;


/*-----------------添加服务明细表-----------------*/
create sequence servicelistid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

