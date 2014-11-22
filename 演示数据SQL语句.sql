/*-------------添加用户资料-----------------*/

insert into Users values(usersid.nextval,'张三','admin',2,0);
insert into Users values(usersid.nextval,'李四','admin',3,0);
insert into Users values(usersid.nextval,'王二麻子','admin',4,0);
insert into Users values(usersid.nextval,'二麻子的弟','admin',4,0);
COMMIT;


/*-------------添加角色资料-----------------*/

insert into Role values(roleid.nextval,'总经理',0);
insert into Role values(roleid.nextval,'销售主管',0);
insert into Role values(roleid.nextval,'销售员',0);
COMMIT;



/*-----------------添加角色权限资料-----------------*/
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,2,id,0 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,3,id,1 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,4,id,1 from author;
COMMIT;


/*-----------------添加地区资料-----------------*/

insert into area values(areaid.nextval,'贵州地区',0);
insert into area values(areaid.nextval,'福建地区',0);
insert into area values(areaid.nextval,'四川地区',0);
insert into area values(areaid.nextval,'广东地区',0);
insert into area values(areaid.nextval,'湖南地区',0);
COMMIT;


/*-----------------添加客户等级资料-----------------*/
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


/*-----------------添加客户资料-----------------*/

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
insert into customercontact values
(customercontactid.nextval,'张三','男',1,'副经理','1810000000','1810000000','1810000000',0);
insert into customercontact values
(customercontactid.nextval,'李四','女',2,'销售主管','1810000001','1810000001','1810000001',0);
insert into customercontact values
(customercontactid.nextval,'王二麻子','男',3,'财务总监','1810000002','1810000002','1810000002',0);
COMMIT;


/*-----------------添加客户交往记录资料-----------------*/
insert into relationship values
(relationshipid.nextval,1,sysdate,'天怡豪生酒店','成交了$50000','新的生意','此单分批成交');
insert into relationship values
(relationshipid.nextval,2,sysdate,'辛巴克','成交了$999998','土豪的决意','跟土豪交了个盆友');
insert into relationship values
(relationshipid.nextval,3,sysdate,'农贸市场','成交了$3000','此单生意啦','小买卖的生意');
COMMIT;


/*-----------------添加订单-----------------*/

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


/*-----------------添加客户流失-----------------*/

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


/*-----------------添加服务明细表-----------------*/

insert into servicelist values
(servicelistid.nextval,1,1,1,1,'第一个服务','请帮忙装系统',1,sysdate,sysdate,sysdate,'1','1',1,1);
insert into servicelist values
(servicelistid.nextval,2,2,2,2,'第二个服务','键盘坏了',2,sysdate,sysdate,sysdate,'2','2',1,1);
insert into servicelist values
(servicelistid.nextval,3,3,3,3,'第三个服务','数据丢失了',3,sysdate,sysdate,sysdate,'3','3',1,1);
COMMIT;
