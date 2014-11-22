/*-------------添加用户资料-----------------*/
create sequence usersid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into Users values(usersid.nextval,'admin','admin',1,0);
insert into Users values(usersid.nextval,'张三','admin',2,0);
insert into Users values(usersid.nextval,'李四','admin',3,0);
insert into Users values(usersid.nextval,'王二麻子','admin',4,0);
insert into Users values(usersid.nextval,'二麻子的弟','admin',4,0);
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
insert into Role values(roleid.nextval,'总经理',0);
insert into Role values(roleid.nextval,'销售主管',0);
insert into Role values(roleid.nextval,'销售员',0);
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
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,2,id,0 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,3,id,1 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,4,id,1 from author;
COMMIT;


/*-----------------添加地区资料-----------------*/
create sequence areaid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into area values(areaid.nextval,'贵州地区',0);
insert into area values(areaid.nextval,'福建地区',0);
insert into area values(areaid.nextval,'四川地区',0);
insert into area values(areaid.nextval,'广东地区',0);
insert into area values(areaid.nextval,'湖南地区',0);
COMMIT;


/*-----------------添加客户等级资料-----------------*/
create sequence customerlevelid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into customerlevel
values(customerlevelid.nextval,'战略合作伙伴',0);
insert into customerlevel
values(customerlevelid.nextval,'重点开发客户',0);
insert into customerlevel
values(customerlevelid.nextval,'大客户',0);
insert into customerlevel
values(customerlevelid.nextval,'合作伙伴',0);
insert into customerlevel
values(customerlevelid.nextval,'普通客户',0);
COMMIT;


/*-----------------添加销售机会资料-----------------*/
create sequence chancesid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into chances
values(chancesid.nextval,'贵州三宝',1,1,'张三',
'网络广告','1810000000','概要1',95,'靠网络广告来的',
1,1,sysdate,sysdate,1,0);
insert into chances
values(chancesid.nextval,'福州好利多',2,2,'李四',
'上门拜访','1810000001','概要2',98,'上门拜访来的',
1,1,sysdate,sysdate,2,0);
insert into chances
values(chancesid.nextval,'安溪铁观音',1,1,'王二麻子',
'无意中发现','1810000002','概要3',79,'在街上溜达看到',
1,1,sysdate,sysdate,3,0);
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

insert into customer values
(customerid.nextval,'贵州六建集团','GZLJJT',1,1,
1,'李爸刚',1,1,'贵州省贵阳市',
'550001','1800000000','0851-500000','http://www.gzljjt.com','100001',
500000,'中国建设银行','1000001','李爸',9999998,
'1000001','1000001',0,0
);
insert into customer values
(customerid.nextval,'福建达利园','FJDLY',2,2,
2,'陈开心',2,2,'福建省厦门市',
'550001','1800000001','0592-500001','http://www.fjdly.com','100002',
500001,'中国农业银行','1000002','陈开心',8888888,
'100002','1000002',0,0
);
insert into customer values
(customerid.nextval,'沃尔玛超市','WEMCS',3,3,
3,'汤姆杰',3,3,'贵州省遵义市',
'550003','1800000000','0851-500003','http://www.wemsupermarket.com','100001',
500000,'中国工商银行','1000003','汤姆',7777778,
'1000003','1000003',0,0
);
insert into customer values
(customerid.nextval,'星力百货','XLBH',3,3,
3,'星力哥',3,3,'广东省东莞市',
'550004','1800000000','0851-500004','http://www.xinlimarket.com','100001',
500000,'中国工商银行','1000003','捷克',7777778,
'1000003','1000003',0,0
);
insert into customer values
(customerid.nextval,'夜郎丰业集团','YLFYJT',3,3,
3,'刘建',3,3,'贵州省贵阳市',
'550003','1800000000','0851-500003','http://www.wemsupermarket.com','100001',
500000,'中国工商银行','1000003','刘建',7777778,
'1000003','1000003',0,0
);
COMMIT;


/*-----------------添加客户联系人资料-----------------*/
create sequence customercontactid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into customercontact values
(customercontactid.nextval,'张三','男',1,'副经理','1810000000','1810000000','1810000000',0);
insert into customercontact values
(customercontactid.nextval,'李四','女',2,'销售主管','1810000001','1810000001','1810000001',0);
insert into customercontact values
(customercontactid.nextval,'王二麻子','男',3,'财务总监','1810000002','1810000002','1810000002',0);
COMMIT;


/*-----------------添加客户交往记录资料-----------------*/
create sequence relationshipid
minvalue 1
maxvalue 99999
start with 1
increment by 1
cache 20;
COMMIT;

insert into relationship values
(relationshipid.nextval,1,sysdate,'天怡豪生酒店','成交了$50000','新的生意','此单分批成交');
insert into relationship values
(relationshipid.nextval,2,sysdate,'辛巴克','成交了$999998','土豪的决意','跟土豪交了个盆友');
insert into relationship values
(relationshipid.nextval,3,sysdate,'农贸市场','成交了$3000','此单生意啦','小买卖的生意');
COMMIT;


/*-----------------添加订单-----------------*/
create sequence ordersid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into orders values
(ordersid.nextval,1,to_date('2013-01-01','yyyy-mm-dd'),'贵阳乌当','已发货',5000);
insert into orders values
(ordersid.nextval,2,sysdate,'贵阳南明','已收款',4000);
insert into orders values
(ordersid.nextval,3,sysdate,'贵阳云岩','已发货',3000);
insert into orders values
(ordersid.nextval,2,sysdate,'贵阳云岩','已发货',3000);
insert into orders values
(ordersid.nextval,2,sysdate,'贵阳云岩','已发货',3000);
COMMIT;


/*-----------------添加订单明细表-----------------*/
create sequence orderlistid
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into orderlist values
(orderlistid.nextval,1,1,1,5000,5000);
insert into orderlist values
(orderlistid.nextval,2,2,1,4000,4000);
insert into orderlist values
(orderlistid.nextval,3,3,1,3000,3000);
insert into orderlist values
(orderlistid.nextval,4,3,1,3000,3000);
insert into orderlist values
(orderlistid.nextval,5,3,1,3000,3000);
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

insert into customerlost values
(customerlostid.nextval,1,to_date('2013-01-01','yyyy-mm-dd'),sysdate,'暂缓措施','没有','流失预警');
COMMIT;


/*-----------添加服务类型------------*/
create sequence serviceid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into service values
(serviceid.nextval,'咨询',0);
insert into service values
(serviceid.nextval,'建议',0);
insert into service values
(serviceid.nextval,'投诉',0);
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

insert into servicelist values
(servicelistid.nextval,1,1,1,1,'第一个服务','请帮忙装系统',1,sysdate,sysdate,sysdate,'1','1',1,1);
insert into servicelist values
(servicelistid.nextval,2,2,2,2,'第二个服务','键盘坏了',2,sysdate,sysdate,sysdate,'2','2',1,1);
insert into servicelist values
(servicelistid.nextval,3,3,3,3,'第三个服务','数据丢失了',3,sysdate,sysdate,sysdate,'3','3',1,1);
COMMIT;
