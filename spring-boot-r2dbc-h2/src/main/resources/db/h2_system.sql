create table ability
(
   ability_id           bigint(20) not null auto_increment comment '能力id',
   hirer_id              bigint(20) comment '租户id',
   ability_name         varchar(128) comment '能力名',
   ability_ename        varchar(128) comment '能力英文名',
   ability_version      varchar(8) comment '能力版本号',
   input_protocal       varchar(32) default NULL comment '接入协议  json、 xml、 ws，可复选要求逗号（,）分割',
   output_protocal      varchar(8) default NULL comment '接出协议 json、xml、ws  hsf等，只能单选',
   output_trans_protocal varchar(8) comment '接出传输协议 http https rpc',
   is_message_check     int(1) comment '是否报文校验 0 不校验，1 校验',
   ability_type         int(1) comment '能力类型， 0 普通类型 1 组合类型',
   app_code_source      int(1) comment 'appCode来源：0头；1体',
   app_code_path        varchar(64) comment 'appCode路径',
   attend_status        int(1) default NULL comment '值班状态 0：签退  1： 签到',
   checkin_time         datetime comment '签到时间',
   checkout_time        datetime comment '签退时间',
   primary key (ability_id)
);


create table ability_ext_custom
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   overtime             int(4) comment '落地超时时间（单位：秒）',
   retry_time           int(2) comment '落地重试次数'
);


/*==============================================================*/
/* Table: ability_ext                                           */
/*==============================================================*/
create table ability_ext
(
   ability_ext_id       bigint(20) not null auto_increment comment '能力订购id',
   ability_id           bigint(20) comment '能力id',
   req_jar_filename     varchar(256) comment '入参jar包名',
   req_jar_content      longtext comment '入参jar包内容',
   req_class_name       varchar(256) comment '入参class类名',
   rsp_jar_filename     varchar(256) comment '出参jar包名',
   rsp_jar_content      longtext comment '出参jar包内容',
   rsp_class_name       varchar(256) comment '出参class类名',
   primary key (ability_ext_id)
);



/*==============================================================*/
/* Table: ability_logic                                         */
/*==============================================================*/
create table ability_logic
(
   ability_id           bigint(20) comment '能力id',
   logic_script         longtext comment '组合逻辑脚本'
);




/*==============================================================*/
/* Table: ability_param                                         */
/*==============================================================*/
create table ability_param
(
   ability_id           bigint(20)  comment '能力id',
   req_jsonschema_filename varchar(256) comment '入参jsonSchema文件名',
   req_jsonschema       longtext comment '入参jsonSchema',
   rsp_jsonschema_filename varchar(256) comment '出参jsonSchema文件名',
   rsp_jsonschema       longtext comment '出参jsonSchema',
   req_json_template    longtext comment '入参json模板',
   rsp_json_template    longtext comment '出参json模板',
   rsp_xml_template     longtext comment '出参xml模板',
   req_xml_template     longtext comment '入参xml模板',
   req_ws_template      longtext comment '入参ws模板',
   rsp_ws_template      longtext comment '出参ws模板',
   req_xsd              longtext comment '请求xsd',
   req_xsd_file         varchar(256) comment '请求xsd文件名',
   resp_xsd             longtext default NULL comment '响应xsd',
   resp_xsd_file        varchar(256) default NULL comment '响应xsd文件名'
);




/*==============================================================*/
/* Table: ability_plugin                                        */
/*==============================================================*/
create table ability_plugin
(
   ability_plugin_id    bigint(20) not null auto_increment comment '能力插件关系表id',
   ability_id           bigint(20) comment '能力id',
   plugin_id            bigint(20) comment '插件实例id'
);




/*==============================================================*/
/* Table: ability_plugin_ext_ip                                 */
/*==============================================================*/
create table ability_plugin_ext_ip
(
   plugin_id            bigint(20) not null comment '插件id',
   app_hirerId          bigint(20) comment '租户id',
   app_code             varchar(12) comment '应用编码',
   ip_while_list        varchar(1024) comment 'ip白名单（逗号分隔）'
);




/*==============================================================*/
/* Table: ability_plugin_jwt                                    */
/*==============================================================*/
create table ability_plugin_jwt
(
   ability_plugin_id    bigint(20) comment '能力插件关系表id',
   timestamp_path       varchar(64) comment '从javaBean中获取时间戳的路径',
   trans_id_path        varchar(64) comment '从javaBean中获取业务流水路径',
   token_path            varchar(64) comment '从javaBean中获取token路径',
   enhanced_validation int(1)  COMMENT '是否增强验证0 否 1是'
);




/*==============================================================*/
/* Table: ability_plugin_jwt_ext                                */
/*==============================================================*/
/*create table ability_plugin_jwt_ext
(
   plugin_id            bigint(20) comment '插件id',
   app_hirerId          bigint(20) comment '租户id',
   app_code             varchar(12) comment '应用编码',
   app_secret           varchar(32) comment 'appsecret',
   enhanced_validation int(1)  COMMENT '是否增强验证0 否 1是',
   public_secrets varchar(1024) COMMENT '增强验证发起机构公密',
);*/




/*==============================================================*/
/* Table: ability_plugin_rate                                   */
/*==============================================================*/
create table ability_plugin_rate
(
   ability_plugin_id    bigint(20)  comment '能力插件关系表id',
   rate_limit_id        bigint(20) comment '流量控制插件id',
   range_primary_key    bigint(20) comment '关联主键id (生效范围涉及的表的主键id)',
   threshold            int comment '阀值'
);




/*==============================================================*/
/* Table: ability_plugin_token                                  */
/*==============================================================*/
create table ability_plugin_token
(
   ability_plugin_id    bigint(20)  comment '能力插件关系表id',
   client_id            bigint(20) comment '客户端id',
   client_secret        varchar(32) comment '客户端秘钥',
   username             varchar(16) comment '用户名',
   password             varchar(32) comment '密码'
);




/*==============================================================*/
/* Table: ability_provide_deploy                                */
/*==============================================================*/
create table ability_provide_deploy
(
   ability_id           bigint(20) comment '能力id',
   app_id               bigint(20) comment '应用id',
   region_id            bigint(20)  comment '应用分区id',
   deploy_status        int(1) comment '部署状态 0 待部署  1 部署成功 2 部署失败'
);




/*==============================================================*/
/* Table: ability_provide_dubbo_custom                          */
/*==============================================================*/
create table ability_provide_dubbo_custom
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   group_name           varchar(32) comment '组别',
   version              varchar(8) comment '版本号',
   interface_name       varchar(512) comment '接口类名',
   method_name          varchar(32) comment '接口方法名'
);




/*==============================================================*/
/* Table: ability_provide_dubbo_custom_input                    */
/*==============================================================*/
create table ability_provide_dubbo_custom_input
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   args_name            varchar(512) comment '参数类名',
   args_path            varchar(512) comment '参数路径',
   sort                 int(1) comment '入参顺序'
);




/*==============================================================*/
/* Table: ability_provide_hsf_custom                            */
/*==============================================================*/
create table ability_provide_hsf_custom
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   group_name           varchar(32) comment '组别',
   version              varchar(8) comment '版本号',
   interface_name       varchar(512) comment '接口类名',
   method_name          varchar(32) comment '接口方法名'
);




/*==============================================================*/
/* Table: ability_provide_hsf_custom_input                      */
/*==============================================================*/
create table ability_provide_hsf_custom_input
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   args_name            varchar(512) comment '参数类名',
   args_path            varchar(512) comment '参数路径',
   sort                 int(1) comment '入参顺序'
);




/*==============================================================*/
/* Table: ability_provide_http_custom                           */
/*==============================================================*/
create table ability_provide_http_custom
(
   ability_id           bigint(20) comment '能力id',
   region_id            bigint(20) comment '应用分区id',
   epr_path             varchar(64) comment '服务路径'
);




/*==============================================================*/
/* Table: ability_ws_ext                                        */
/*==============================================================*/
create table ability_ws_ext
(
   ability_id           bigint(20) comment '能力id',
   target_soap          longtext comment '落地方soap报文格式',
   target_url           varchar(256) comment '落地方请求地址',
   ability_wsdl         longtext comment 'ability对外提供的ws服务的wsdl(非落地)'
);




/*==============================================================*/
/* Table: app                                                   */
/*==============================================================*/
create table app
(
   app_id               bigint(20) not null auto_increment comment '应用主键id',
   hirer_id              bigint(20) comment '租户id',
   app_name             varchar(200) comment '应用名',
   app_code             varchar(50) comment '应用编码',
   attend_status        int(1) default NULL comment '值班状态 0：签退  1： 签到',
   is_provider          int(1) comment '是否为提供者 0： 否 1： 是',
   primary key (app_id)
);




/*==============================================================*/
/* Table: app_subscribe_deploy                                  */
/*==============================================================*/
create table app_subscribe_deploy
(
   ability_id           bigint(20) comment '能力id',
   app_id               bigint(20)  comment '应用主键id'
);



/*==============================================================*/
/* Table: plugin                                                */
/*==============================================================*/
create table plugin
(
   plugin_id            bigint(20) not null auto_increment comment '插件id',
   hirer_id              bigint(20) comment '租户id',
   plugin_type          varchar(64) comment '插件类别',
   plugin_name          varchar(32) comment '插件名',
   plugin_ename         varchar(32) comment '插件英文名',
   primary key (plugin_id)
);




/*==============================================================*/
/* Table: plugin_ext_rate                                       */
/*==============================================================*/
create table plugin_ext_rate
(
   plugin_id            bigint(20) comment '插件id',
   rate_type            int(1) comment '流控类型 0 秒 1 分 2 时 3 日 4 并发',
   effective_range      int(1) comment '生效范围 0 能力 1 消费者'
);




/*==============================================================*/
/* Table: plugin_priority                                       */
/*==============================================================*/
create table plugin_priority
(
   ability_plugin_id    bigint(20)  comment '能力插件关系表id',
   priority             int(1) comment '优先级 0 低 1 中 2 高'
);




/*==============================================================*/
/* Table: plugin_route                                          */
/*==============================================================*/
create table plugin_route
(
   plugin_id            bigint(20) comment '插件实例id',
   route_plugin_name    varchar(64) comment '路由插件中文名',
   route_plugin_ename   varchar(16) comment '路由插件英文名',
   route_logic          longtext comment '路由逻辑',
   priority             int(2) comment '优先级',
   args_first           varchar(16) comment '入参一',
   args_second          varchar(16) comment '入参二',
   args_third           varchar(16) comment '入参三',
   args_fourth          varchar(16) comment '入参四'
);




/*==============================================================*/
/* Table: plugin_route_column                                   */
/*==============================================================*/
create table plugin_route_column
(
   ability_plugin_id    bigint(20)  comment '能力插件关系表id',
   column_path          varchar(64) comment '字段路径',
   column_key           varchar(16) comment '字段key'
);




/*==============================================================*/
/* Table: plugin_route_ext                                      */
/*==============================================================*/
create table plugin_route_ext
(
   ability_plugin_id    bigint(20)  comment '能力插件关系表id',
   route_ext_desc       varchar(256) comment '附加信息描述',
   ext_key              varchar(16) comment '附加key值',
   ext_value            varchar(16) comment '附加value值'
);




/*==============================================================*/
/* Table: region                                                */
/*==============================================================*/
create table region
(
   region_id            bigint(20) not null auto_increment comment '应用分区id',
   region_name          varchar(64) comment '分区名',
   region_code          varchar(16) comment '分区编码',
   app_id               bigint(20) comment '应用id',
   region_type          int(1) comment '分区类型 0 正常 1 灰度  2 mock',
   haddr_policy         int(1) not null default 0 comment '落地地址选择策略 0:随机  1:最少并发 2:能力权值  3:轮循',
   protocol             varchar(16) not null comment '通讯协议 json  xml   ws 等多选(,分隔)',
   call_protocol int(1) DEFAULT NULL COMMENT '调用协议0:http; 1:https',
    call_authenticate int(1) DEFAULT NULL COMMENT '认证方式 0单项认证；1双向认证',
    trust_all_certificate int(1) DEFAULT NULL COMMENT '是否信任所有证书 0:否;1:是',
   is_calling_agent   int(1) comment '是否调用代理 0 不调用 1 调用',
   attend_status        int(1) default NULL comment '值班状态 0 签退 1 签到',
   primary key (region_id)
);




/*==============================================================*/
/* Table: region_addr                                           */
/*==============================================================*/
create table region_addr
(
   region_addr_id       bigint(20) not null auto_increment comment '分区地址id',
   region_id            bigint(20) comment '应用分区id',
   addr_type            int(1) comment '地址类型 0 落地 1 代理',
   capacity             int(1) comment '能力指数  1-9 能力权值策略使用',
   ip                   varchar(32) comment '地址',
   port                 varchar(8) comment '端口',
   attend_status        int(1) default NULL comment '值班状态 0：签退  1： 签到',
   primary key (region_addr_id)
);


CREATE TABLE region_certificate (
	region_certificate_id BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '分区证书id',
	region_id BIGINT (20) DEFAULT NULL COMMENT '应用分区id',
	certificate longtext COMMENT '客户端证书内容',
	cer_keypass VARCHAR (32) DEFAULT NULL COMMENT '私钥口令',
	trust_keystore longtext COMMENT '证书库内容',
	trust_keystore_keypass VARCHAR (32) DEFAULT NULL COMMENT '证书库口令',
	PRIMARY KEY (region_certificate_id)
);




/*==============================================================*/
/* Table: rsp_code                                              */
/*==============================================================*/
create table rsp_code
(
   rsp_code_id          bigint(20) not null auto_increment comment '响应编码id',
   rsp_name             varchar(64) comment '响应名称',
   rsp_code             varchar(48) comment '响应编码',
   rsp_desc             varchar(64) comment '响应描述',
   primary key (rsp_code_id)
);



/*==============================================================*/
/* Table: sub_ability                                           */
/*==============================================================*/
create table sub_ability
(
   ability_id           bigint(20) comment '能力id',
   parent_ability_id    bigint(20) comment '主能力id'
);



create table system_code_value
(
   code_id              bigint(20) not null auto_increment comment '主键id',
   type_code            varchar(48) not null comment '分类',
   dic_code             varchar(48) comment '编码',
   dic_value            varchar(48) comment '值',
   sort                 int(2) comment '排序',
   flag                 varchar(2) comment '0 有效, 1 无效',
   primary key (code_id)
);


create table system_code_type
(
   type_id              bigint(20) not null auto_increment,
   type_code            varchar(48),
   type_name            varchar(64),
   remark               varchar(256) comment '描述',
   primary key (type_id)
);

/*==============================================================*/
/* Table: defined_exception                                     */
/*==============================================================*/
create table defined_exception
(
   defined_exception_id bigint(20) not null auto_increment,
   input_protocal       varchar(8) default NULL comment '接入协议  json、 xml',
   output_protocal      varchar(8) default NULL comment '接出协议 json、xml、dubbo、hsf',
   exception_logic      longtext comment '异常逻辑脚本',
   remark               varchar(256) comment '描述',
   primary key (defined_exception_id)
);

/*==============================================================*/
/* Table: hparty_check_append                                   */
/*==============================================================*/
DROP TABLE IF EXISTS `hparty_check_append`;
create table hparty_check_append
(
   plugin_id            bigint(20) not null comment '插件id',
   append_content       varchar(16) comment '拼装内容'
) COMMENT='落地校验报文组装表';

/*==============================================================*/
/* Table: hparty_check_token                                    */
/*==============================================================*/
create table hparty_check_token
(
   plugin_id            bigint(20)  comment '插件id',
   region_code          varchar(16) comment '分区编码',
   client_id            varchar(64) comment '客户端id',
   access_token         varchar(64) comment '请求token',
   call_protocol        int(1) comment '调用协议:0json;1表单'
) COMMENT='落地校验token记录表';



/*==============================================================*/
/* Table: rate_limiter_ability                                  */
/*==============================================================*/
create table rate_limiter_ability
(
   ability_id           bigint(20) comment '能力id',
   rate                 int default NULL comment '每秒允许的请求数',
   capacity             int default NULL comment '总的容量限制'
);

/*==============================================================*/
/* Table: rate_limiter_subscribe                                */
/*==============================================================*/
create table rate_limiter_subscribe
(
   ability_id           bigint(20) comment '能力id',
   app_id               bigint(20) comment '应用主键id',
   rate                 int default NULL comment '每秒允许的请求数',
   capacity             int default NULL comment '总的容量限制'
);

CREATE TABLE `plugin_oauth_client_details` (
  `plugin_id` bigint(20) NOT NULL COMMENT '插件id',
  `app_id` bigint(20) DEFAULT NULL COMMENT '应用id',
  `client_id` varchar(128) NOT NULL COMMENT 'appid',
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL COMMENT '密码',
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '支持的授权方式',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL COMMENT 'access_token有效期（单位秒）',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT 'refresh_token有效期（单位秒）',
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
) COMMENT='oauth2的client表';

CREATE TABLE `app_secret` (
  `app_id` bigint(20) NOT NULL COMMENT '应用id',
  `app_code` varchar(12) comment '应用编码',
  `app_secret` varchar(32) DEFAULT NULL COMMENT 'appsecret',
  `cluster_id` bigint(20) DEFAULT NULL COMMENT '集群id',
  `public_secrets` varchar(1024) DEFAULT NULL COMMENT '增强验证发起机构公密',
) COMMENT='jwt校验插件扩展表';