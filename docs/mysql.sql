CREATE TABLE sys_user (
                          userId INT PRIMARY KEY AUTO_INCREMENT COMMENT '人员编号',
                          name VARCHAR(255) COMMENT '真实姓名',
                          code VARCHAR(255) COMMENT '客户号',
                          deptid VARCHAR(255) COMMENT '客户标识: 1=客户',
                          jobs VARCHAR(255) COMMENT '职业描述',
                          login_name VARCHAR(255) COMMENT '登陆名',
                          user_name VARCHAR(255) COMMENT '用户昵称',
                          user_type VARCHAR(2) DEFAULT '1' COMMENT '用户类型: 00=超级管理员, 1=平台用户, 客户根据表格导入信息: 务农、经营农村产业、个体、务工、经商办企业、行政事业单位国企人员',
                          card_type VARCHAR(255) DEFAULT '身份证' COMMENT '证件类型: 默认身份证',
                          phonenumber VARCHAR(255) COMMENT '号码',
                          phonenumbertem VARCHAR(255) COMMENT '备用号码',
                          sex INT DEFAULT 2 COMMENT '性别: 0=男, 1=女, 2=未知',
                          address VARCHAR(255) COMMENT '常住地址',
                          busaddress VARCHAR(255) COMMENT '经营地址',
                          idcard VARCHAR(255) NOT NULL COMMENT '证件号码',
                          password VARCHAR(255) COMMENT '密码: 根据系统配置定义',
                          salt VARCHAR(255) COMMENT '加密盐: 自动生成',
                          status INT DEFAULT 0 COMMENT '账号状态: 0=正常, 1=停用',
                          del_flag INT DEFAULT 0 COMMENT '逻辑删除标识: 0=存在, 2=删除',
                          street VARCHAR(255) COMMENT '街道',
                          vallage VARCHAR(255) NOT NULL COMMENT '村: 客户必填',
                          province VARCHAR(255) NOT NULL COMMENT '乡镇: 客户必填',
                          creditsite INT COMMENT '授信网点ID',
                          credited VARCHAR(255) COMMENT '是否授信',
                          credit_prod VARCHAR(255) COMMENT '授信产品',
                          credit_amount DECIMAL(18, 2) COMMENT '授信金额',
                          credit_time DATETIME COMMENT '授信时间',
                          credit_endTime DATETIME COMMENT '授信截止时间',
                          user_amount DECIMAL(18, 2) COMMENT '用信金额',
                          manager_id VARCHAR(255) COMMENT '柜员经理号',
                          manager_name VARCHAR(255) COMMENT '柜员经理姓名',
                          migrant BOOLEAN COMMENT '是否外出人员',
                          migrant_address VARCHAR(255) COMMENT '外出工作地址',
                          age INT COMMENT '年龄: 根据证件号码计算',
                          birthday DATE COMMENT '出生日期: 根据证件号码获取',
                          org_id INT NOT NULL COMMENT '站点ID'
);

CREATE TABLE sys_role (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE sys_user_role (
                               user_id INT,
                               role_id INT,
                               PRIMARY KEY (user_id, role_id)
);



CREATE TABLE sys_city (
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键: 自动生成',
                          pid INT COMMENT '父级ID',
                          cityname VARCHAR(255) NOT NULL COMMENT '名称',
                          type INT NOT NULL COMMENT '级别类型: 1=站点, 2=乡, 3=村',
                          count INT NOT NULL DEFAULT 0 COMMENT '人数: 默认0'
);

INSERT INTO sys_user (name, idcard, phonenumber, street, vallage, province, org_id)
VALUES
    ('张三', '110101198001012345', '13812345678', '北京市朝阳区', '西小区', '北京市', 1),
    ('李四', '120101198203014567', '13987654321', '上海市浦东新区', '南小区', '上海市', 2),
    ('王五', '310101198305016789', '13611112222', '广州市天河区', '北小区', '广东省', 3),
    ('赵六', '440101198507018901', '13522223333', '深圳市南山区', '东小区', '广东省', 1),
    ('刘七', '510101198610011234', '15033334444', '成都市锦江区', '中小区', '四川省', 2),
    ('陈八', '650101198711012345', '15844445555', '乌鲁木齐市天山区', '西小区', '新疆维吾尔自治区', 3),
    ('张九', '210101198901018901', '17755556666', '沈阳市沈河区', '北小区', '辽宁省', 1),
    ('李十', '330101199012015678', '18666667777', '杭州市西湖区', '南小区', '浙江省', 2),
    ('刘十一', '360101199101017890', '15877778888', '南昌市青山湖区', '东小区', '江西省', 3),
    ('陈十二', '430101199202019012', '13988889999', '长沙市芙蓉区', '中小区', '湖南省', 1);

INSERT INTO sys_city (pid, cityname, type, count)
VALUES
    (NULL, '大都市', 1, 1000000),
    (1, '中央区', 2, 250000),
    (2, '市中心', 3, 50000),
    (2, '市郊', 3, 45000),
    (1, '郊区', 2, 750000),
    (5, '山坡区', 3, 100000),
    (5, '山谷区', 3, 120000),
    (NULL, '小镇', 1, 800000),
    (8, '农村地区', 2, 500000),
    (9, '东村', 3, 70000),
    (9, '西村', 3, 60000);

INSERT INTO sys_user_role (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 2),
    (6, 3),
    (7, 1),
    (8, 2),
    (9, 3),
    (10, 1);

INSERT INTO sys_role (name)
VALUES
    ('超级管理员'),
    ('站点管理员'),
    ('客户');


COMMIT;