create database `mybatis-plus`;
use `mybatis-plus`;

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id    BIGINT(20)  NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

DELETE
FROM user;

INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');

alter table user
    add column update_time DATETIME NULL default CURRENT_TIMESTAMP ON UPDATE current_timestamp comment '更新时间';
alter table user
    add column create_time DATETIME NULL default CURRENT_TIMESTAMP comment '创建时间';

select now(); -- 查询当前时间
show variables like '%time_zone%'; -- 查询当前时区
set global time_zone = '+8:00'; -- 在标准时区上加+8小时,即东8区时间
set time_zone = '+08:00';
flush privileges; -- 立即生效

alter table user
    add version int default 1 not null;

CREATE TABLE goods
(
    id     BIGINT(20)              NOT NULL COMMENT '主键ID',
    name   VARCHAR(30) COMMENT '商品名称',
    code   VARCHAR(50) COMMENT '编号',
    price  DECIMAL(10, 2) unsigned not null default 0.00 comment '单价',
    remark VARCHAR(500)            null comment '备注',
    PRIMARY KEY (id)
);
alter table goods
    add column update_time DATETIME comment '更新时间';
alter table goods
    add column create_time DATETIME comment '创建时间';
alter table goods
    add version int default 1 not null;
alter table goods
    add deleted int default 0 not null;

truncate table user;