drop database dang;-- 删除数据库
create database dang default character set utf8;-- 创建指定字符集的数据库
use dang;-- 进入dang数据库
DROP TABLE IF EXISTS d_book;-- 如果此表存在，则删除。
-- 创建d_book表
CREATE TABLE d_book (
  id int(12) NOT NULL auto_increment, -- 主键id，自增长。
  product_name varchar(100) NOT NULL,-- 商品名称
  fixed_price double NOT NULL,-- 商品定价
  dang_price double NOT NULL,-- 当当价
  product_pic varchar(200) default NULL,-- 图书图片的路径
  author varchar(200) NOT NULL,-- 作者
  publishing varchar(200) NOT NULL,-- 出版社
  publish_time long NOT NULL,-- 出版时间
  author_summary varchar(100) NOT NULL,-- 作者简介
  description varchar(100) default NULL,-- 商品描述
  score int(12) NOT NULL,   -- 顾客评分
  PRIMARY KEY  (id)-- 设置主键约束。
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 向d_book中插入数据。	
INSERT INTO d_book VALUES (1,'上课头疼的故事',200,180,'16.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (2,'上课头疼的故事',200,180,'17.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (3,'上课头疼的故事',200,180,'18.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (4,'上课头疼的故事',200,180,'19.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (5,'上课头疼的故事',200,180,'20.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (6,'上课头疼的故事',200,180,'21.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (7,'上课头疼的故事',200,180,'22.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (8,'上课头疼的故事',200,180,'23.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (9,'上课头疼的故事',200,180,'24.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (10,'上课头疼的故事',200,180,'2.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (11,'上课头疼的故事',200,180,'3.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (12,'上课睡觉的故事',200,180,'4.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (13,'上课睡觉的故事',200,180,'5.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (14,'上课睡觉的故事',200,180,'6.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (15,'上课睡觉的故事',200,180,'7.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (16,'上课睡觉的故事',200,180,'8.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (17,'上课睡觉的故事',200,180,'9.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (18,'上课睡觉的故事',200,180,'10.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (19,'上课睡觉的故事',200,180,'11.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (20,'上课睡觉的故事',200,180,'12.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (21,'上课睡觉的故事',200,180,'13.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (22,'上课睡觉的故事',200,180,'14.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
INSERT INTO d_book VALUES (23,'上课睡觉的故事',200,180,'15.jpg','我写的','地球出版社',1297927505048,'作者是好人','这真是一本好书啊',90);
-- 插入之后做一下查询，看是否插入成功。
select * from d_book;

-- 用户表
DROP TABLE IF EXISTS d_user;
CREATE TABLE d_user (
  id int(12) NOT NULL auto_increment, -- 主键
  email varchar(50) NOT NULL,-- 邮箱
  nickname varchar(50) default NULL,-- 昵称
  password varchar(50) NOT NULL,-- 密码
  PRIMARY KEY  (id),-- 主键
  UNIQUE KEY email (email) -- 唯一约束
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into d_user values(1,'qdchenming@tarena.com.cn','chenming','abc123');
select * from d_user;
DROP TABLE IF EXISTS d_item;
CREATE TABLE d_item (
  id int(12) NOT NULL auto_increment,
  order_id int(10) NOT NULL,-- 璁㈠崟id
  book_id int(10) NOT NULL,-- 鍥句功id
  book_name varchar(100) NOT NULL,-- 鍥句功鍚嶅瓧
  dang_price double NOT NULL,-- 褰撳綋浠?
  book_num int(10) NOT NULL,-- 璐拱鏁扮洰
  amount double NOT NULL,-- 鎬讳环
  PRIMARY KEY  (id)-- 涓婚敭绾︽潫
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS d_order;

CREATE TABLE d_order (
  id int(10) NOT NULL auto_increment,
  user_id int(10) NOT NULL,-- 鐢ㄦ埛id
  order_time long NOT NULL,-- 涓嬭鍗曠殑鏃堕棿
  order_desc varchar(100) default NULL,-- 璁㈠崟鎻忚堪
  total_price double NOT NULL,-- 鍏辫鎬讳环
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