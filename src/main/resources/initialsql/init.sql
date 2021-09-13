create table cd_malfunction_type
(
    id integer not null
        constraint malfunction_type_pkey
            primary key,
    name varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1)
);

comment on table cd_malfunction_type is '故障类型';

comment on column cd_malfunction_type.id is 'id';

comment on column cd_malfunction_type.name is '名称';

comment on column cd_malfunction_type.created_by is '创建人';

comment on column cd_malfunction_type.created_time is '创建时间';

comment on column cd_malfunction_type.updated_by is '更新人';

comment on column cd_malfunction_type.updated_time is '更新时间';

comment on column cd_malfunction_type.is_delete is '软删标识符';

alter table cd_malfunction_type owner to postgres;

create table cd_malfunction_level
(
    id integer not null
        constraint malfunction_level_pkey
            primary key,
    name varchar(32),
    description varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1)
);

comment on table cd_malfunction_level is '故障等级';

comment on column cd_malfunction_level.id is 'id';

comment on column cd_malfunction_level.name is '名称';

comment on column cd_malfunction_level.description is '说明';

comment on column cd_malfunction_level.created_by is '创建人';

comment on column cd_malfunction_level.created_time is '创建时间';

comment on column cd_malfunction_level.updated_by is '更新人';

comment on column cd_malfunction_level.updated_time is '更新时间';

comment on column cd_malfunction_level.is_delete is '软删标识符';

alter table cd_malfunction_level owner to postgres;

create table cd_factory_layout
(
    id integer not null
        constraint factory_layout_pkey
            primary key,
    child_id integer,
    parent_id integer,
    name varchar(32),
    responsible varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_factory_layout is '车间、工序、工位从BF那边获取，此表仅维护关系';

comment on column cd_factory_layout.id is 'id';

comment on column cd_factory_layout.child_id is '关系中的子';

comment on column cd_factory_layout.parent_id is '关系中的父';

comment on column cd_factory_layout.name is '名称';

comment on column cd_factory_layout.responsible is '负责人';

comment on column cd_factory_layout.created_by is '创建人';

comment on column cd_factory_layout.created_time is '创建时间';

comment on column cd_factory_layout.updated_by is '更新人';

comment on column cd_factory_layout.updated_time is '更新时间';

comment on column cd_factory_layout.is_delete is '软删标识符';

comment on column cd_factory_layout.enterprise is '引用企业机构表';

alter table cd_factory_layout owner to postgres;

create table cd_equipment
(
    id serial not null
        constraint cd_equipments_pkey
            primary key,
    picture varchar(256),
    code varchar(32),
    name varchar(32),
    responsible integer,
    production_line integer,
    process integer,
    asset integer,
    equipment_group integer,
    description varchar(1024),
    is_auto_dispatch varchar(1),
    status integer,
    model varchar(32),
    manufacturer varchar(32),
    specification varchar(32),
    serial_number varchar(32),
    date_of_production date,
    date_of_installation date,
    date_of_first_use date,
    expires_years integer,
    date_of_expiration date,
    custom_attributes text,
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_equipment is '设备详情';

comment on column cd_equipment.id is 'id';

comment on column cd_equipment.picture is '图片的url';

comment on column cd_equipment.code is 'fromBF';

comment on column cd_equipment.name is 'fromBF';

comment on column cd_equipment.responsible is 'fromBF';

comment on column cd_equipment.production_line is 'fromBF';

comment on column cd_equipment.process is 'fromBF';

comment on column cd_equipment.asset is 'fromBF';

comment on column cd_equipment.equipment_group is '设备组';

comment on column cd_equipment.description is '描述';

comment on column cd_equipment.is_auto_dispatch is '自动分派';

comment on column cd_equipment.status is '引用状态表';

comment on column cd_equipment.model is '型号';

comment on column cd_equipment.manufacturer is '厂家';

comment on column cd_equipment.specification is '规格';

comment on column cd_equipment.serial_number is '出厂编号';

comment on column cd_equipment.date_of_production is '出厂日期';

comment on column cd_equipment.date_of_installation is '安装日期';

comment on column cd_equipment.date_of_first_use is '首次使用';

comment on column cd_equipment.expires_years is '报废年限';

comment on column cd_equipment.date_of_expiration is '报废期限';

comment on column cd_equipment.custom_attributes is 'json格式的自定义属性';

comment on column cd_equipment.created_by is '创建人';

comment on column cd_equipment.created_time is '创建时间';

comment on column cd_equipment.updated_by is '更新人';

comment on column cd_equipment.updated_time is '更新时间';

comment on column cd_equipment.is_delete is '软删标识符';

comment on column cd_equipment.enterprise is '引用企业机构表';

alter table cd_equipment owner to postgres;

create table cd_equipment_group
(
    id serial not null
        constraint cd_equipment_groups_pkey
            primary key,
    name varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_equipment_group is '设备组';

comment on column cd_equipment_group.id is 'id';

comment on column cd_equipment_group.name is '名称';

comment on column cd_equipment_group.created_by is '创建人';

comment on column cd_equipment_group.created_time is '创建时间';

comment on column cd_equipment_group.updated_by is '更新人';

comment on column cd_equipment_group.updated_time is '更新时间';

comment on column cd_equipment_group.is_delete is '软删除标识符';

comment on column cd_equipment_group.enterprise is '引用机构表';

alter table cd_equipment_group owner to postgres;

create table cd_equipment_configuration
(
    id integer not null,
    equipment_id integer not null,
    code varchar(32),
    param varchar(32),
    type varchar(32),
    unit varchar(32),
    max varchar(32),
    min varchar(32),
    default_value varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(32),
    enterprise integer,
    constraint cd_equipment_configuration_pk
        primary key (id, equipment_id)
);

comment on table cd_equipment_configuration is '设备参数配置';

comment on column cd_equipment_configuration.id is 'id';

comment on column cd_equipment_configuration.equipment_id is '引用设备';

comment on column cd_equipment_configuration.code is '编号';

comment on column cd_equipment_configuration.param is '参数';

comment on column cd_equipment_configuration.type is '类型';

comment on column cd_equipment_configuration.unit is '单位';

comment on column cd_equipment_configuration.max is '上限';

comment on column cd_equipment_configuration.min is '下限';

comment on column cd_equipment_configuration.default_value is '默认值';

comment on column cd_equipment_configuration.created_by is '创建人';

comment on column cd_equipment_configuration.created_time is '创建时间';

comment on column cd_equipment_configuration.updated_by is '更新人';

comment on column cd_equipment_configuration.updated_time is '更新时间';

comment on column cd_equipment_configuration.is_delete is '软删标识符';

comment on column cd_equipment_configuration.enterprise is '引用机构表';

alter table cd_equipment_configuration owner to postgres;

create table cd_equipment_status
(
    id integer not null
        constraint cd_equipment_status_pkey
            primary key,
    name varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_equipment_status is '设备状态表';

comment on column cd_equipment_status.id is 'id';

comment on column cd_equipment_status.name is '名称';

comment on column cd_equipment_status.created_by is '创建人';

comment on column cd_equipment_status.created_time is '创建时间';

comment on column cd_equipment_status.updated_by is '更新人';

comment on column cd_equipment_status.updated_time is '更新时间';

comment on column cd_equipment_status.is_delete is '软删标识符';

comment on column cd_equipment_status.enterprise is '引用机构表';

alter table cd_equipment_status owner to postgres;

create table cd_maintenance
(
    id serial not null
        constraint cd_maintenance_pkey
            primary key,
    equipment integer,
    code varchar(32),
    status varchar(32),
    workshop integer,
    area integer,
    process integer,
    submitter integer,
    submit_time date,
    malfunction_desc text,
    malfunction_photos varchar(512),
    malfunction_type varchar(128),
    malfunction_level varchar(128),
    auditor integer,
    audit_time date,
    dispatcher integer,
    dispatch_time date,
    dispatch_info varchar(1024),
    maintenance_deadline date,
    maintenance_personnel integer,
    maintenance_desc varchar(1024),
    maintenance_finish_time date,
    troubleshooting_time varchar(32),
    maintenance_time varchar(32),
    precautions varchar(32),
    validator integer,
    validate_time date,
    validate_desc varchar(1024),
    validate_judgement varchar(32),
    maintenance_photos varchar(512),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_maintenance is '设备维护';

comment on column cd_maintenance.id is 'id';

comment on column cd_maintenance.equipment is '引用设备详情表';

comment on column cd_maintenance.code is '编号';

comment on column cd_maintenance.status is '状态';

comment on column cd_maintenance.workshop is '引用工厂布局';

comment on column cd_maintenance.area is '引用工厂布局';

comment on column cd_maintenance.process is '引用工厂布局';

comment on column cd_maintenance.submitter is '引用人员';

comment on column cd_maintenance.submit_time is '提交时间';

comment on column cd_maintenance.malfunction_desc is '故障描述';

comment on column cd_maintenance.malfunction_photos is '图片url';

comment on column cd_maintenance.malfunction_type is '引用故障类型配置表';

comment on column cd_maintenance.malfunction_level is '引用故障等级配置表';

comment on column cd_maintenance.auditor is '引用人员';

comment on column cd_maintenance.audit_time is '审核时间';

comment on column cd_maintenance.dispatcher is '引用人员';

comment on column cd_maintenance.dispatch_time is '分派时间';

comment on column cd_maintenance.dispatch_info is '分派信息';

comment on column cd_maintenance.maintenance_deadline is '截至时间';

comment on column cd_maintenance.maintenance_personnel is '引用人员';

comment on column cd_maintenance.maintenance_desc is '维修描述';

comment on column cd_maintenance.maintenance_finish_time is '维修完成时间';

comment on column cd_maintenance.troubleshooting_time is '单位小时';

comment on column cd_maintenance.maintenance_time is '单位小时';

comment on column cd_maintenance.precautions is '预防措施';

comment on column cd_maintenance.validator is '引用人员';

comment on column cd_maintenance.validate_time is '验证时间';

comment on column cd_maintenance.validate_desc is '验证说明';

comment on column cd_maintenance.validate_judgement is '验证判定';

comment on column cd_maintenance.maintenance_photos is 'url';

comment on column cd_maintenance.created_by is '创建人';

comment on column cd_maintenance.created_time is '创建时间';

comment on column cd_maintenance.updated_by is '更新人';

comment on column cd_maintenance.updated_time is '更新时间';

comment on column cd_maintenance.is_delete is '软删标识符';

comment on column cd_maintenance.enterprise is '引用机构表';

alter table cd_maintenance owner to postgres;

create table cd_maintenance_status
(
    id integer not null
        constraint cd_maintenance_status_pkey
            primary key,
    name varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1)
);

comment on table cd_maintenance_status is '设备维护状态表';

comment on column cd_maintenance_status.id is 'id';

comment on column cd_maintenance_status.name is '名称';

comment on column cd_maintenance_status.created_by is '创建人';

comment on column cd_maintenance_status.created_time is '创建时间';

comment on column cd_maintenance_status.updated_by is '更新人';

comment on column cd_maintenance_status.updated_time is '更新时间';

comment on column cd_maintenance_status.is_delete is '软删标识符';

alter table cd_maintenance_status owner to postgres;

create table cd_maintenance_consumption
(
    id serial not null
        constraint cd_maintenance_consumption_pkey
            primary key,
    maintenance integer,
    spare_part integer,
    number integer,
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_maintenance_consumption is '设备维护消耗';

comment on column cd_maintenance_consumption.id is 'id';

comment on column cd_maintenance_consumption.maintenance is '引用维修单';

comment on column cd_maintenance_consumption.spare_part is '引用备件';

comment on column cd_maintenance_consumption.number is '消耗数量';

comment on column cd_maintenance_consumption.created_by is '创建人';

comment on column cd_maintenance_consumption.created_time is '创建时间';

comment on column cd_maintenance_consumption.updated_by is '更新人';

comment on column cd_maintenance_consumption.updated_time is '更新时间';

comment on column cd_maintenance_consumption.is_delete is '软删标识符';

comment on column cd_maintenance_consumption.enterprise is '引用机构表';

alter table cd_maintenance_consumption owner to postgres;

create table cd_maintenance_feedback
(
    id integer not null
        constraint cd_maintenance_feedback_pkey
            primary key,
    maintenance varchar(1024),
    response varchar(32),
    quality varchar(32),
    onsite_management varchar(32),
    overall varchar(32),
    description varchar(32),
    provider varchar(32),
    is_anonymous varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_maintenance_feedback is '设备维护反馈';

comment on column cd_maintenance_feedback.id is 'id';

comment on column cd_maintenance_feedback.maintenance is '维修单号';

comment on column cd_maintenance_feedback.response is '响应性';

comment on column cd_maintenance_feedback.quality is '维修质量';

comment on column cd_maintenance_feedback.onsite_management is '现场5S';

comment on column cd_maintenance_feedback.overall is '总体评价';

comment on column cd_maintenance_feedback.description is '补充说明';

comment on column cd_maintenance_feedback.provider is '评价人';

comment on column cd_maintenance_feedback.is_anonymous is '是否匿名提交';

comment on column cd_maintenance_feedback.created_by is '创建人';

comment on column cd_maintenance_feedback.created_time is '创建时间';

comment on column cd_maintenance_feedback.updated_by is '更新人';

comment on column cd_maintenance_feedback.updated_time is '更新时间';

comment on column cd_maintenance_feedback.is_delete is '软删标识符';

comment on column cd_maintenance_feedback.enterprise is '引用机构表';

alter table cd_maintenance_feedback owner to postgres;

create table cd_spare_part
(
    id integer not null
        constraint cd_spare_parts_pkey
            primary key,
    code varchar(32),
    name varchar(32),
    specification varchar(32),
    stock varchar(32),
    unit varchar(32),
    replacement_period varchar(32),
    min_stock varchar(32),
    max_stock varchar(32),
    is_univesal varchar(32),
    is_fragile varchar(32),
    type varchar(32),
    use_period varchar(32),
    remark varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_spare_part is '备品备件';

comment on column cd_spare_part.id is 'id';

comment on column cd_spare_part.code is '编号';

comment on column cd_spare_part.name is '名称';

comment on column cd_spare_part.specification is '规格';

comment on column cd_spare_part.stock is '库存';

comment on column cd_spare_part.unit is '计量单位';

comment on column cd_spare_part.replacement_period is '更换周期';

comment on column cd_spare_part.min_stock is '最低库存';

comment on column cd_spare_part.max_stock is '最高库存';

comment on column cd_spare_part.is_univesal is '通用件';

comment on column cd_spare_part.is_fragile is '易损件';

comment on column cd_spare_part.type is '类型';

comment on column cd_spare_part.use_period is '使用周期';

comment on column cd_spare_part.remark is '备注';

comment on column cd_spare_part.created_by is '创建人';

comment on column cd_spare_part.created_time is '创建时间';

comment on column cd_spare_part.updated_by is '更新人';

comment on column cd_spare_part.updated_time is '更新时间';

comment on column cd_spare_part.is_delete is '软删标识符';

comment on column cd_spare_part.enterprise is '引用机构表';

alter table cd_spare_part owner to postgres;

create table cd_spare_parts_in
(
    id integer not null
        constraint cd_spare_parts_in_pkey
            primary key,
    code varchar(32),
    type varchar(32),
    spare_part integer,
    repaire varchar(32),
    maintenance varchar(32),
    number integer,
    vendor varchar(32),
    batch_no varchar(32),
    receiver integer,
    receive_time date,
    remark varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_spare_parts_in is '备件入库';

comment on column cd_spare_parts_in.id is 'id';

comment on column cd_spare_parts_in.code is '编号';

comment on column cd_spare_parts_in.type is '类型';

comment on column cd_spare_parts_in.spare_part is '备件';

comment on column cd_spare_parts_in.repaire is '维修编号';

comment on column cd_spare_parts_in.maintenance is '保养编号';

comment on column cd_spare_parts_in.number is '数量';

comment on column cd_spare_parts_in.vendor is '供应商';

comment on column cd_spare_parts_in.batch_no is '批次号';

comment on column cd_spare_parts_in.receiver is '引用人员';

comment on column cd_spare_parts_in.receive_time is '收件时间';

comment on column cd_spare_parts_in.remark is '备注';

comment on column cd_spare_parts_in.created_by is '创建人';

comment on column cd_spare_parts_in.created_time is '创建时间';

comment on column cd_spare_parts_in.updated_by is '更新人';

comment on column cd_spare_parts_in.updated_time is '更新时间';

comment on column cd_spare_parts_in.is_delete is '软删标识符';

comment on column cd_spare_parts_in.enterprise is '引用机构表';

alter table cd_spare_parts_in owner to postgres;

create table cd_spare_parts_out
(
    id integer not null
        constraint cd_spare_parts_out_pkey
            primary key,
    code varchar(32),
    spare_part varchar(32),
    reason integer,
    maintenance varchar(32),
    maintenance_ varchar(32),
    number integer,
    batch_no varchar(32),
    replacement_period integer,
    sender integer,
    receiver integer,
    receive_time date,
    remark varchar(32),
    untitled12 varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise numeric(4,2)
);

comment on table cd_spare_parts_out is '备件出库';

comment on column cd_spare_parts_out.id is 'id';

comment on column cd_spare_parts_out.code is '编号';

comment on column cd_spare_parts_out.spare_part is '备件';

comment on column cd_spare_parts_out.reason is '引用领用原因配置表';

comment on column cd_spare_parts_out.maintenance is '维修编号';

comment on column cd_spare_parts_out.maintenance_ is '保养编号';

comment on column cd_spare_parts_out.number is '数量';

comment on column cd_spare_parts_out.batch_no is '批次号';

comment on column cd_spare_parts_out.replacement_period is '更换周期';

comment on column cd_spare_parts_out.sender is '引用人员';

comment on column cd_spare_parts_out.receiver is '引用人员';

comment on column cd_spare_parts_out.receive_time is '领件时间';

comment on column cd_spare_parts_out.remark is '备注';

comment on column cd_spare_parts_out.untitled12 is '备件更换提醒';

comment on column cd_spare_parts_out.created_by is '创建人';

comment on column cd_spare_parts_out.created_time is '创建时间';

comment on column cd_spare_parts_out.updated_by is '更新人';

comment on column cd_spare_parts_out.updated_time is '更新时间';

comment on column cd_spare_parts_out.is_delete is '软删标识符';

comment on column cd_spare_parts_out.enterprise is '引用机构表';

alter table cd_spare_parts_out owner to postgres;

create table cd_spare_parts_warehouse
(
    id integer not null
        constraint cd_spare_parts_warehouse_pkey
            primary key,
    code varchar(32),
    name varchar(32),
    mark varchar(32),
    responsible integer,
    description text,
    remark varchar(32),
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on table cd_spare_parts_warehouse is '备件库房';

comment on column cd_spare_parts_warehouse.id is 'id';

comment on column cd_spare_parts_warehouse.code is '编号';

comment on column cd_spare_parts_warehouse.name is '名称';

comment on column cd_spare_parts_warehouse.mark is '代号';

comment on column cd_spare_parts_warehouse.responsible is '引用人员';

comment on column cd_spare_parts_warehouse.description is '描述';

comment on column cd_spare_parts_warehouse.remark is '备注';

comment on column cd_spare_parts_warehouse.created_by is '创建人';

comment on column cd_spare_parts_warehouse.created_time is '创建时间';

comment on column cd_spare_parts_warehouse.updated_by is '更新人';

comment on column cd_spare_parts_warehouse.updated_time is '更新时间';

comment on column cd_spare_parts_warehouse.is_delete is '软删标识符';

comment on column cd_spare_parts_warehouse.enterprise is '引用机构表';

alter table cd_spare_parts_warehouse owner to postgres;

create table cd_equipment_management_summary
(
    id serial not null
        constraint cd_equipment_managment_summary_pkey
            primary key,
    type varchar(32),
    person integer,
    "group" integer,
    summary_time date,
    summary text,
    created_by varchar(32),
    created_time date,
    updated_by varchar(32),
    updated_time date,
    is_delete varchar(1),
    enterprise integer
);

comment on column cd_equipment_management_summary.id is 'id';

comment on column cd_equipment_management_summary.type is 'monthly/weekly';

comment on column cd_equipment_management_summary.person is '引用人员表';

comment on column cd_equipment_management_summary."group" is '引用group表';

comment on column cd_equipment_management_summary.summary_time is '时间';

comment on column cd_equipment_management_summary.summary is '小结';

comment on column cd_equipment_management_summary.created_by is '创建人';

comment on column cd_equipment_management_summary.created_time is '创建时间';

comment on column cd_equipment_management_summary.updated_by is '更新人';

comment on column cd_equipment_management_summary.updated_time is '更新时间';

comment on column cd_equipment_management_summary.is_delete is '软删标识符';

comment on column cd_equipment_management_summary.enterprise is '引用企业机构表';

alter table cd_equipment_management_summary owner to postgres;

create table cd_equipment_basic_picture
(
    file_id varchar(64) not null
        constraint cd_equipment_basic_picture_pk
            primary key,
    file_content bytea
);

alter table cd_equipment_basic_picture owner to postgres;

create table cd_basic_configs
(
    easy_mode boolean,
    auto_dispatch boolean,
    enable_validation boolean,
    maintenance_alarm boolean,
    maintenance_waiting varchar(256),
    down_time varchar(256),
    maintenance_dispatch_time varchar(256),
    malfunction_types varchar(5000),
    malfunction_level varchar(5000),
    equipment_management_summary boolean,
    spare_part_management boolean,
    id integer
);

alter table cd_basic_configs owner to postgres;

