/*-----------角色表-------------*/
Create table Role
(
id int primary key not null,
name varchar2(20) not null,--角色名称
isdel int--是否删除  0未删除，1删除
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
isdel int--是否删除  0未删除，1删除
);
COMMIT;

/*-----------用户表-------------*/
Create table Users
(
id int primary key not null,
username varchar2(20) not null,
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
name varchar2(20) not null,--地区名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------服务类型表------------*/
Create table Service
(
id int primary key not null,
name varchar2(20),--服务类型名称
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
summary varchar2(20) not null,--概要
content varchar2(200) not null,--服务请求
state int default 0 not null,--服务状态
createtime date not null,--创建时间
granttime date,--分配时间
operatortime date,--处理时间
operatorcontent varchar2(200),--服务处理内容
resultcontent varchar2(200),--处理结果内容
agreelevel int default 1,--满意度
createuserid int not null--创建人id
);
COMMIT;


/*-----------服务状态表------------*/
Create table ServiceState
(
id int primary key not null,
name varchar2(20) not null,--服务状态名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------客户等级表------------*/
Create table CustomerLevel
(
id int primary key not null,
name varchar2(20) not null,
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------销售机会表-----------*/
Create table Chances
(
id int primary key not null,
name varchar2(20) not null,--客户名称
areaid int not null,--区域id
levelid int not null,--用户等级id
managername varchar2(20) not null,--负责人
chancesfrom varchar2(20),--机会来源
phone varchar2(20) not null,--电话
content varchar2(20),--概要
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
name varchar2(20) not null,--状态名称
isdel int--是否删除  0未删除，1删除
);
COMMIT;


/*-----------计划表-----------*/
Create table ChancesPlan
(
id int primary key not null,
chancesid int not null,--销售机会id
plantime date not null,--计划日期
planname varchar2(20),--计划项
effect varchar2(20)--执行效果
);
COMMIT;


/*-----------客户表------------*/
Create table Customer
(
id int primary key not null,
name varchar2(20) not null,--客户名称
code varchar2(20),--客户编号
userid int not null,--客户经理id
areaid int not null,--区域id

levelid int not null,--用户等级id
managername varchar2(20) not null,--负责人
agreelevel int default 1 not null,--满意度
creditlevel int default 1 not null,--信誉度
address varchar2(50),--地址

postcode varchar2(20),--邮政编码
phone varchar2(20),--电话
fax varchar2(20),--传真
website varchar2(50),--网址
bussinesscode varchar2(50),--营业执照

regsmoney float default 0 not null,--注册资金
regbank varchar2(20),--开户行
landtaxcode varchar2(50),--地税登记号
legalperson varchar2(20),--法人
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
name varchar2(20) not null,--联系人
gender varchar2(20) not null,--性别
customerid int not null,--客户id
position varchar2(20) not null,--职位
phone varchar2(20) not null,--办公电话
telephone varchar2(20),--手机
content varchar2(200),--备注
isdel int--是否删除  0未删除，1删除
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
state varchar2(20) not null--状态
);
COMMIT;


/*----------交往记录表-------------*/
Create table Relationship
(
id int primary key not null,
customerid int not null,--客户id
relationtime date not null,--交往时间
address varchar2(20) not null,--地点
summary varchar2(20) not null,--概要
content varchar2(20),--备注
detail varchar2(200)--详细信息
);
COMMIT;


/*------------历史订单(主表)-----------*/
Create table Orders
(
id int primary key not null,
customerid int not null,--客户id
ordertime date not null,--订单日期
address varchar2(50) not null,--送货地址
state varchar2(20) not null,--状态,0已发货,1已收款
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

