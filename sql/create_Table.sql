-- auto-generated definition
create table user
(
    id                bigint                             null comment '主键',
    user_Account      varchar(512)                       not null comment '登录账号',
    user_Password     varchar(512)                       not null comment '密码',
    user_Name         varchar(512)                       null comment '用户名称',
    role              bigint   default 0                 not null comment '用户权限',
    valid             tinyint  default 0                 not null comment '用户状态',
    create_Time       datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_Time       datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    logic_Delete      int      default 0                 not null comment '逻辑删除',
    invitation_Number varchar(128)                       null comment '邀请编号'
)
    comment '用户表';