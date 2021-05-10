CREATE TABLE sys_user(
id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
name varchar(50) not null comment '用户名',
nick_name varchar(150) default null comment '昵称',
avatar varchar(150) default null comment '头像',
password varchar(100) default null comment '密码',
salt varchar(40) default null comment '加密盐',
email varchar(100) default null comment '邮箱',
mobile varchar(100) default null comment '手机号',
status tinyint(4) default null comment '状态 0禁用 1正常',
dept_id bigint(20) default null comment '机构ID',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
del_flag tinyint(4) default '0' comment '是否删除： -1已删除 0正常 ',
primary key (id),
unique key name_unique (name))
engine=innodb auto_increment=34 default charset=utf8 comment='用户管理';

create table sys_role(
id bigint(200) not null auto_increment comment '编号',
name varchar(100) default null comment '角色名称',
remark varchar(100) default null comment '备注',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
del_flag tinyint(4) default '0' comment '是否删除 -1删除 0正常',
primary key(id))
engine=innodb auto_increment=9 default charset=utf8 comment='角色管理';

create table sys_dept(
id bigint(20) not null auto_increment comment '编号',
name varchar(50) default null comment '机构名称',
parent_id bigint(20) default null comment '上级机构ID，一级机构为0',
order_num int(11) default null comment '排序',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
del_flag tinyint(4) default '0' comment '是否删除： -1删除   0正常',
primary key(id))
engine=innodb auto_increment=36 default charset=utf8 comment='机构管理';

create table sys_menu(
id bigint(20) not null auto_increment comment '编号',
name varchar(50) default null comment '菜单名称',
parent_id bigint(20) default null comment '父菜单id',
url varchar(200) default null comment '菜单url 类型1 普通页面（如用户管理，/sys/user） 类型2嵌套完整外部页面，以http（s）开头的连接  类型3：嵌套服务器页面，使用iframe：前缀+目标URL（如sql监控，iframe:/druid/login.html),iframe:前缀会替换成服务器地址）',
type int(11) default null comment '类型  0目录   1菜单   2按钮',
icon varchar(50) default null comment '菜单图标',
order_num int (11) default null comment '排序',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
del_flag tinyint(4) default '0' comment '是否删除   -1删除   0正常',
primary key(id))
engine=innodb auto_increment=45 default charset=utf8 comment='菜单管理';

create table sys_user_role(
id bigint(20) not null auto_increment comment '编号',
user_id bigint(20) default null comment '用户ID',
role_id bigint(20) default null comment '角色ID',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
primary key(id)
)engine=innodb auto_increment=76 default charset=utf8 comment='用户角色';

create table sys_role_menu(
id bigint(20) not null auto_increment comment'编号',
role_id bigint(20) default null comment '角色id',
menu_id bigint(20) default null comment '菜单ID',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
primary key(id))
engine=innodb auto_increment=469 default charset=utf8 comment='角色菜单';

create table sys_role_dept(
id bigint(20) not null comment '编号',
role_id bigint(20) default null comment '角色ID',
dept_id bigint(20) default null comment '机构ID',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
primary key(id))
engine=innodb auto_increment=4 default charset=utf8 comment ='角色机构';

create table sys_dict(
id bigint(20) not null auto_increment comment'编号',
value varchar(100) not null comment '数据值',
label varchar(100) not null comment '标签名',
type varchar(100) not null comment '类型',
description varchar(100) not null comment '描述',
sort decimal(10,0) not null comment '排序（升序）',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
remarks varchar(255) default null comment '备注信息',
del_flag tinyint(4) default '0' comment '是否删除  -1删除  0正常',
primary key(id))
engine=innodb auto_increment=5 default charset=utf8 comment='字典表';

create table sys_config(
id bigint(20) not null auto_increment comment '编号',
value varchar(100) not null comment '数据值',
label varchar(100) not null comment '标签名',
type varchar(100) not null comment '类型',
description varchar(100) not null comment '描述',
sort decimal(10,0) not null comment '排序（升序）',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
remarks varchar(255) default null comment '备注信息',
del_flag tinyint(4) default '0' comment '是否删除 -1删除 0正常',
primary key(id))
engine=innodb auto_increment=5 default charset=utf8 comment ='系统配置表';

create table sys_log(
id bigint(20) not null auto_increment comment '编号',
user_name varchar(50) default null comment '用户名',
operation varchar(50) default null comment '用户操作',
method varchar(200) default null comment '请求方法',
params varchar(5000) default null comment '请求参数',
time bigint(20) not null comment '执行时长（毫秒）',
ip varchar(64) default null comment 'ip地址',
create_by varchar(50) default null comment '创建人',
craete_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
primary key(id))
engine=innodb auto_increment=2798 default charset=utf8 comment ='系统操作日志';

create table sys_login_log(
id bigint(20) not null auto_increment comment '编号',
user_name varchar(50) default null comment '用户名',
status varchar(50) default null comment '登录状态（online：在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录',
ip varchar(64) default null comment 'ip地址',
create_by varchar(50) default null comment '创建人',
create_time datetime default null comment '创建时间',
last_update_by varchar(50) default null comment '更新人',
last_update_time datetime default null comment '更新时间',
primary key(id))
engine=innodb auto_increment=2798 default charset=utf8 comment='系统登录日志';