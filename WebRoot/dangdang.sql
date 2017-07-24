drop database dang;-- ɾ�����ݿ�
create database dang default character set utf8;-- ����ָ���ַ��������ݿ�
use dang;-- ����dang���ݿ�
DROP TABLE IF EXISTS d_book;-- ����˱���ڣ���ɾ����
-- ����d_book��
CREATE TABLE d_book (
  id int(12) NOT NULL auto_increment, -- ����id����������
  product_name varchar(100) NOT NULL,-- ��Ʒ����
  fixed_price double NOT NULL,-- ��Ʒ����
  dang_price double NOT NULL,-- ������
  product_pic varchar(200) default NULL,-- ͼ��ͼƬ��·��
  author varchar(200) NOT NULL,-- ����
  publishing varchar(200) NOT NULL,-- ������
  publish_time long NOT NULL,-- ����ʱ��
  author_summary varchar(100) NOT NULL,-- ���߼��
  description varchar(100) default NULL,-- ��Ʒ����
  score int(12) NOT NULL,   -- �˿�����
  PRIMARY KEY  (id)-- ��������Լ����
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ��d_book�в������ݡ�	
INSERT INTO d_book VALUES (1,'�Ͽ�ͷ�۵Ĺ���',200,180,'16.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (2,'�Ͽ�ͷ�۵Ĺ���',200,180,'17.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (3,'�Ͽ�ͷ�۵Ĺ���',200,180,'18.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (4,'�Ͽ�ͷ�۵Ĺ���',200,180,'19.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (5,'�Ͽ�ͷ�۵Ĺ���',200,180,'20.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (6,'�Ͽ�ͷ�۵Ĺ���',200,180,'21.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (7,'�Ͽ�ͷ�۵Ĺ���',200,180,'22.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (8,'�Ͽ�ͷ�۵Ĺ���',200,180,'23.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (9,'�Ͽ�ͷ�۵Ĺ���',200,180,'24.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (10,'�Ͽ�ͷ�۵Ĺ���',200,180,'2.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (11,'�Ͽ�ͷ�۵Ĺ���',200,180,'3.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (12,'�Ͽ�˯���Ĺ���',200,180,'4.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (13,'�Ͽ�˯���Ĺ���',200,180,'5.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (14,'�Ͽ�˯���Ĺ���',200,180,'6.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (15,'�Ͽ�˯���Ĺ���',200,180,'7.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (16,'�Ͽ�˯���Ĺ���',200,180,'8.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (17,'�Ͽ�˯���Ĺ���',200,180,'9.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (18,'�Ͽ�˯���Ĺ���',200,180,'10.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (19,'�Ͽ�˯���Ĺ���',200,180,'11.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (20,'�Ͽ�˯���Ĺ���',200,180,'12.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (21,'�Ͽ�˯���Ĺ���',200,180,'13.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (22,'�Ͽ�˯���Ĺ���',200,180,'14.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
INSERT INTO d_book VALUES (23,'�Ͽ�˯���Ĺ���',200,180,'15.jpg','��д��','���������',1297927505048,'�����Ǻ���','������һ�����鰡',90);
-- ����֮����һ�²�ѯ�����Ƿ����ɹ���
select * from d_book;

-- �û���
DROP TABLE IF EXISTS d_user;
CREATE TABLE d_user (
  id int(12) NOT NULL auto_increment, -- ����
  email varchar(50) NOT NULL,-- ����
  nickname varchar(50) default NULL,-- �ǳ�
  password varchar(50) NOT NULL,-- ����
  PRIMARY KEY  (id),-- ����
  UNIQUE KEY email (email) -- ΨһԼ��
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into d_user values(1,'qdchenming@tarena.com.cn','chenming','abc123');
select * from d_user;
DROP TABLE IF EXISTS d_item;
CREATE TABLE d_item (
  id int(12) NOT NULL auto_increment,
  order_id int(10) NOT NULL,-- 订单id
  book_id int(10) NOT NULL,-- 图书id
  book_name varchar(100) NOT NULL,-- 图书名字
  dang_price double NOT NULL,-- 当当�?
  book_num int(10) NOT NULL,-- 购买数目
  amount double NOT NULL,-- 总价
  PRIMARY KEY  (id)-- 主键约束
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS d_order;

CREATE TABLE d_order (
  id int(10) NOT NULL auto_increment,
  user_id int(10) NOT NULL,-- 用户id
  order_time long NOT NULL,-- 下订单的时间
  order_desc varchar(100) default NULL,-- 订单描述
  total_price double NOT NULL,-- 共计总价
  PRIMARY KEY  (id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS d_receive_address;
CREATE TABLE d_receive_address (
  id int(12) NOT NULL auto_increment,
  user_id int(12) NOT NULL,
  receive_name varchar(50) NOT NULL,
  full_address varchar(50) NOT NULL,
  postal_code varchar(50) NOT NULL,
  mobile varchar(50) NOT NULL,
  phone varchar(50) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from d_item;