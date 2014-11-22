/*-------------����û�����-----------------*/

insert into Users values(usersid.nextval,'����','admin',2,0);
insert into Users values(usersid.nextval,'����','admin',3,0);
insert into Users values(usersid.nextval,'��������','admin',4,0);
insert into Users values(usersid.nextval,'�����ӵĵ�','admin',4,0);
COMMIT;


/*-------------��ӽ�ɫ����-----------------*/

insert into Role values(roleid.nextval,'�ܾ���',0);
insert into Role values(roleid.nextval,'��������',0);
insert into Role values(roleid.nextval,'����Ա',0);
COMMIT;



/*-----------------��ӽ�ɫȨ������-----------------*/
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,2,id,0 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,3,id,1 from author;
insert into roleauthor(id,roleid,authorid,isdel)
select roleauthorid.nextval,4,id,1 from author;
COMMIT;


/*-----------------��ӵ�������-----------------*/

insert into area values(areaid.nextval,'���ݵ���',0);
insert into area values(areaid.nextval,'��������',0);
insert into area values(areaid.nextval,'�Ĵ�����',0);
insert into area values(areaid.nextval,'�㶫����',0);
insert into area values(areaid.nextval,'���ϵ���',0);
COMMIT;


/*-----------------��ӿͻ��ȼ�����-----------------*/
insert into customerlevel
values(customerlevelid.nextval,'ս�Ժ������',0);
insert into customerlevel
values(customerlevelid.nextval,'�ص㿪���ͻ�',0);
insert into customerlevel
values(customerlevelid.nextval,'��ͻ�',0);
insert into customerlevel
values(customerlevelid.nextval,'�������',0);
insert into customerlevel
values(customerlevelid.nextval,'��ͨ�ͻ�',0);
COMMIT;


/*-----------------������ۻ�������-----------------*/
insert into chances
values(chancesid.nextval,'��������',1,1,'����',
'������','1810000000','��Ҫ1',95,'������������',
1,1,sysdate,sysdate,1,0);
insert into chances
values(chancesid.nextval,'���ݺ�����',2,2,'����',
'���Űݷ�','1810000001','��Ҫ2',98,'���Űݷ�����',
1,1,sysdate,sysdate,2,0);
insert into chances
values(chancesid.nextval,'��Ϫ������',1,1,'��������',
'�����з���','1810000002','��Ҫ3',79,'�ڽ�����￴��',
1,1,sysdate,sysdate,3,0);
COMMIT;


/*-----------------��ӿͻ�����-----------------*/

insert into customer values
(customerid.nextval,'������������','GZLJJT',1,1,
1,'��ָ�',1,1,'����ʡ������',
'550001','1800000000','0851-500000','http://www.gzljjt.com','100001',
500000,'�й���������','1000001','���',9999998,
'1000001','1000001',0,0
);
insert into customer values
(customerid.nextval,'��������԰','FJDLY',2,2,
2,'�¿���',2,2,'����ʡ������',
'550001','1800000001','0592-500001','http://www.fjdly.com','100002',
500001,'�й�ũҵ����','1000002','�¿���',8888888,
'100002','1000002',0,0
);
insert into customer values
(customerid.nextval,'�ֶ��곬��','WEMCS',3,3,
3,'��ķ��',3,3,'����ʡ������',
'550003','1800000000','0851-500003','http://www.wemsupermarket.com','100001',
500000,'�й���������','1000003','��ķ',7777778,
'1000003','1000003',0,0
);
insert into customer values
(customerid.nextval,'�����ٻ�','XLBH',3,3,
3,'������',3,3,'�㶫ʡ��ݸ��',
'550004','1800000000','0851-500004','http://www.xinlimarket.com','100001',
500000,'�й���������','1000003','�ݿ�',7777778,
'1000003','1000003',0,0
);
insert into customer values
(customerid.nextval,'ҹ�ɷ�ҵ����','YLFYJT',3,3,
3,'����',3,3,'����ʡ������',
'550003','1800000000','0851-500003','http://www.wemsupermarket.com','100001',
500000,'�й���������','1000003','����',7777778,
'1000003','1000003',0,0
);
COMMIT;


/*-----------------��ӿͻ���ϵ������-----------------*/
insert into customercontact values
(customercontactid.nextval,'����','��',1,'������','1810000000','1810000000','1810000000',0);
insert into customercontact values
(customercontactid.nextval,'����','Ů',2,'��������','1810000001','1810000001','1810000001',0);
insert into customercontact values
(customercontactid.nextval,'��������','��',3,'�����ܼ�','1810000002','1810000002','1810000002',0);
COMMIT;


/*-----------------��ӿͻ�������¼����-----------------*/
insert into relationship values
(relationshipid.nextval,1,sysdate,'���������Ƶ�','�ɽ���$50000','�µ�����','�˵������ɽ�');
insert into relationship values
(relationshipid.nextval,2,sysdate,'���Ϳ�','�ɽ���$999998','�����ľ���','���������˸�����');
insert into relationship values
(relationshipid.nextval,3,sysdate,'ũó�г�','�ɽ���$3000','�˵�������','С����������');
COMMIT;


/*-----------------��Ӷ���-----------------*/

insert into orders values
(ordersid.nextval,1,to_date('2013-01-01','yyyy-mm-dd'),'�����ڵ�','�ѷ���',5000);
insert into orders values
(ordersid.nextval,2,sysdate,'��������','���տ�',4000);
insert into orders values
(ordersid.nextval,3,sysdate,'��������','�ѷ���',3000);
insert into orders values
(ordersid.nextval,2,sysdate,'��������','�ѷ���',3000);
insert into orders values
(ordersid.nextval,2,sysdate,'��������','�ѷ���',3000);
COMMIT;


/*-----------------��Ӷ�����ϸ��-----------------*/
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


/*-----------------��ӿͻ���ʧ-----------------*/

insert into customerlost values
(customerlostid.nextval,1,to_date('2013-01-01','yyyy-mm-dd'),sysdate,'�ݻ���ʩ','û��','��ʧԤ��');
COMMIT;


/*-----------��ӷ�������------------*/
create sequence serviceid
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;
COMMIT;

insert into service values
(serviceid.nextval,'��ѯ',0);
insert into service values
(serviceid.nextval,'����',0);
insert into service values
(serviceid.nextval,'Ͷ��',0);
COMMIT;


/*-----------------��ӷ�����ϸ��-----------------*/

insert into servicelist values
(servicelistid.nextval,1,1,1,1,'��һ������','���æװϵͳ',1,sysdate,sysdate,sysdate,'1','1',1,1);
insert into servicelist values
(servicelistid.nextval,2,2,2,2,'�ڶ�������','���̻���',2,sysdate,sysdate,sysdate,'2','2',1,1);
insert into servicelist values
(servicelistid.nextval,3,3,3,3,'����������','���ݶ�ʧ��',3,sysdate,sysdate,sysdate,'3','3',1,1);
COMMIT;
