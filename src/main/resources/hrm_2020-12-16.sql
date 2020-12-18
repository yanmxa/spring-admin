# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.29)
# Database: hrm
# Generation Time: 2020-12-16 03:12:19 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table salary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `xing_ming` varchar(255) DEFAULT NULL COMMENT '姓名',
  `yue_fen` varchar(255) DEFAULT NULL COMMENT '月份',
  `bu_men` varchar(255) DEFAULT NULL COMMENT '部门',
  `gong_hao` varchar(255) DEFAULT NULL COMMENT '工号',
  `gang_ji_gong_zi` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '岗级工资',
  `ji_xiao_gong_zi` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '绩效工资',
  `bao_mi_bu_tie` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '保密补贴',
  `jiao_tong_bu_tie` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '交通补贴',
  `wu_ye_bu_tie` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '物业补贴',
  `ban_zu_zhang_jin_tie` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '班组长津贴',
  `gang_ji_gong_zi_bu_fa` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '岗级工资补发',
  `an_quan_jiang_li` decimal(18,2) DEFAULT NULL COMMENT '安全奖励',
  `zhi_liang_jiang_li` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '质量奖励',
  `ji_xiao_yu_fa` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '绩效预发',
  `gao_chou` decimal(18,2) DEFAULT NULL COMMENT '稿酬',
  `ji_xiao_kou_jian` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '绩效扣减',
  `si_ji_bu_tie` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '司机补贴',
  `zhi_ban_bu_tie` decimal(18,2) DEFAULT NULL COMMENT '值班补贴',
  `jie_jia_ri_gong_zuo_bu_tie` decimal(18,2) DEFAULT NULL COMMENT '节假日工作补贴',
  `ji_xiao_bu_fa` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '绩效补发',
  `gong_ji_jin` decimal(18,2) DEFAULT NULL COMMENT '公积金',
  `yang_lao_bao_xian` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '养老保险',
  `zhi_ye_nian_jin` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '职业年金',
  `yi_liao_bao_xian` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '医疗保险',
  `shi_ye_bao_xian` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '失业保险',
  `da_bing_bao_xian` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '大病保险',
  `da_e_yi_liao_bu_zhu` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '大额医疗补助',
  `ge_ren_suo_de_shui` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '个人所得税',
  `che_wei_fei` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '车位费',
  `dai_kuan` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '贷款',
  `ying_fa_he_ji` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '应发合计',
  `shi_fa_he_ji` decimal(18,2) NOT NULL DEFAULT '0.00' COMMENT '实发合计',
  `bei_zhu` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;

INSERT INTO `salary` (`id`, `updateTime`, `xing_ming`, `yue_fen`, `bu_men`, `gong_hao`, `gang_ji_gong_zi`, `ji_xiao_gong_zi`, `bao_mi_bu_tie`, `jiao_tong_bu_tie`, `wu_ye_bu_tie`, `ban_zu_zhang_jin_tie`, `gang_ji_gong_zi_bu_fa`, `an_quan_jiang_li`, `zhi_liang_jiang_li`, `ji_xiao_yu_fa`, `gao_chou`, `ji_xiao_kou_jian`, `si_ji_bu_tie`, `zhi_ban_bu_tie`, `jie_jia_ri_gong_zuo_bu_tie`, `ji_xiao_bu_fa`, `gong_ji_jin`, `yang_lao_bao_xian`, `zhi_ye_nian_jin`, `yi_liao_bao_xian`, `shi_ye_bao_xian`, `da_bing_bao_xian`, `da_e_yi_liao_bu_zhu`, `ge_ren_suo_de_shui`, `che_wei_fei`, `dai_kuan`, `ying_fa_he_ji`, `shi_fa_he_ji`, `bei_zhu`)
VALUES
	(22,'2020-12-15 17:29:21','admin','2020-12','一部','2002',1.00,1.00,2.00,3.00,4.00,5.00,3.00,1.00,-1.00,-3.00,-5.00,-7.00,-9.00,-11.00,-13.00,-15.00,-17.00,-19.00,-21.00,-23.00,-25.00,-27.00,-29.00,-31.00,-33.00,-35.00,-37.00,-39.00,'-41'),
	(23,'2020-12-15 17:29:21','张三','2020-12','一部','2004',2.00,2.00,3.00,4.00,5.00,6.00,4.00,2.00,0.00,-2.00,-4.00,-6.00,-8.00,-10.00,-12.00,-14.00,-16.00,-18.00,-20.00,-22.00,-24.00,-26.00,-28.00,-30.00,-32.00,-34.00,-36.00,-38.00,'-40'),
	(24,'2020-12-15 17:29:21','李四','2020-12','二部','2005',3.00,3.00,4.00,5.00,6.00,7.00,5.00,3.00,1.00,-1.00,-3.00,-5.00,-7.00,-9.00,-11.00,-13.00,-15.00,-17.00,-19.00,-21.00,-23.00,-25.00,-27.00,-29.00,-31.00,-33.00,-35.00,-37.00,'-39'),
	(25,'2020-12-15 17:29:21','赵五','2020-12','二部','2006',4.00,4.00,5.00,6.00,7.00,8.00,6.00,4.00,2.00,0.00,-2.00,-4.00,-6.00,-8.00,-10.00,-12.00,-14.00,-16.00,-18.00,-20.00,-22.00,-24.00,-26.00,-28.00,-30.00,-32.00,-34.00,-36.00,'-38'),
	(26,'2020-12-15 17:29:21','王六','2020-12','三部','2007',5.00,5.00,6.00,7.00,8.00,9.00,7.00,5.00,3.00,1.00,-1.00,-3.00,-5.00,-7.00,-9.00,-11.00,-13.00,-15.00,-17.00,-19.00,-21.00,-23.00,-25.00,-27.00,-29.00,-31.00,-33.00,-35.00,'-37');

/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table salary_meta
# ------------------------------------------------------------

DROP TABLE IF EXISTS `salary_meta`;

CREATE TABLE `salary_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `property` varchar(255) DEFAULT NULL,
  `detail` text,
  `history` text,
  `sort` int(11) DEFAULT '0',
  `isDecimal` tinyint(1) DEFAULT NULL COMMENT '是否为数值，1为是，0不是',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '可用状态，0不可用，1可用',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `salary_meta` WRITE;
/*!40000 ALTER TABLE `salary_meta` DISABLE KEYS */;

INSERT INTO `salary_meta` (`id`, `name`, `type`, `property`, `detail`, `history`, `sort`, `isDecimal`, `status`, `createTime`, `updateTime`)
VALUES
	(28,'姓名','基本信息','固定属性','不可删除','员工名字  ',1,0,1,'2020-12-04 09:29:23','2020-12-15 14:43:36'),
	(32,'月份','基本信息','固定属性','不可删除',NULL,4,0,1,'2020-12-04 10:36:48','2020-12-10 18:18:03'),
	(33,'部门','基本信息','固定属性','不可删除','部门名称  部门  ',3,0,1,'2020-12-04 16:33:54','2020-12-15 14:43:02'),
	(34,'工号','基本信息','固定属性','不可删除','员工编号  ',2,0,1,'2020-12-09 16:53:07','2020-12-15 14:43:22'),
	(35,'岗级工资','岗位绩效','固定工资','无',NULL,5,1,1,'2020-12-15 15:01:35','2020-12-15 15:01:35'),
	(36,'绩效工资','岗位绩效','固定工资','无',NULL,6,1,1,'2020-12-15 15:02:21','2020-12-15 15:02:21'),
	(37,'保密补贴','岗位绩效','固定工资','无',NULL,7,1,1,'2020-12-15 15:03:33','2020-12-15 15:03:33'),
	(38,'交通补贴','津贴补','固定工资','无',NULL,8,1,1,'2020-12-15 15:11:12','2020-12-15 15:11:12'),
	(39,'物业补贴','津贴补','固定工资','无',NULL,9,1,1,'2020-12-15 15:12:48','2020-12-15 15:12:48'),
	(40,'班组长津贴','津贴补','固定工资','无',NULL,10,1,1,'2020-12-15 15:14:26','2020-12-15 15:14:26'),
	(41,'岗级工资补发','岗位绩效','浮动工资','无',NULL,11,1,1,'2020-12-15 15:32:34','2020-12-15 15:32:34'),
	(42,'安全奖励','其他奖励','浮动工资','无',NULL,12,1,1,'2020-12-15 15:35:19','2020-12-15 15:41:49'),
	(43,'质量奖励','其他奖励','浮动工资','无',NULL,13,1,1,'2020-12-15 15:42:59','2020-12-15 15:42:59'),
	(44,'绩效预发','岗位绩效','浮动工资','无',NULL,14,1,1,'2020-12-15 15:45:56','2020-12-15 15:45:56'),
	(45,'稿酬','其他补贴','浮动工资','无',NULL,15,1,1,'2020-12-15 15:46:45','2020-12-15 15:47:07'),
	(46,'绩效扣减','岗位绩效','浮动工资','无',NULL,16,1,1,'2020-12-15 15:52:32','2020-12-15 15:52:32'),
	(47,'司机补贴','其他补贴','浮动工资','无',NULL,17,1,1,'2020-12-15 15:53:01','2020-12-15 15:53:01'),
	(48,'值班补贴','其他补贴','浮动工资','无',NULL,18,1,1,'2020-12-15 15:54:35','2020-12-15 15:54:48'),
	(49,'节假日工作补贴','其他补贴','浮动工资','无','节假日补贴  ',19,1,1,'2020-12-15 15:56:04','2020-12-15 15:57:33'),
	(50,'绩效补发','岗位绩效','浮动工资','无',NULL,20,1,1,'2020-12-15 15:58:01','2020-12-15 15:58:01'),
	(51,'公积金','五险一金','无','无',NULL,21,1,1,'2020-12-15 15:59:18','2020-12-15 15:59:46'),
	(52,'养老保险','五险一金','无','无',NULL,22,1,1,'2020-12-15 16:00:20','2020-12-15 16:00:20'),
	(53,'职业年金','五险一金','无','无',NULL,23,1,1,'2020-12-15 16:00:47','2020-12-15 16:00:47'),
	(54,'医疗保险','五险一金','无','无',NULL,24,1,1,'2020-12-15 16:01:09','2020-12-15 16:01:09'),
	(55,'失业保险','五险一金','无','无',NULL,25,1,1,'2020-12-15 16:01:37','2020-12-15 16:01:37'),
	(56,'大病保险','五险一金','无','无',NULL,26,1,1,'2020-12-15 16:02:01','2020-12-15 16:02:01'),
	(57,'大额医疗补助','五险一金','无','无',NULL,27,1,1,'2020-12-15 16:03:17','2020-12-15 16:03:17'),
	(58,'个人所得税','个人所得税','无','无',NULL,28,1,1,'2020-12-15 16:03:51','2020-12-15 16:03:51'),
	(59,'车位费','扣款','无','无',NULL,29,1,1,'2020-12-15 16:04:36','2020-12-15 16:04:36'),
	(60,'贷款','扣款','无','无',NULL,30,1,1,'2020-12-15 16:05:23','2020-12-15 16:05:23'),
	(61,'应发合计','无','无','无',NULL,31,1,1,'2020-12-15 16:05:43','2020-12-15 16:05:43'),
	(62,'实发合计','无','无','无',NULL,32,1,1,'2020-12-15 16:06:20','2020-12-15 16:06:20'),
	(63,'备注','无','无','无',NULL,33,0,1,'2020-12-15 16:06:55','2020-12-15 16:06:55');

/*!40000 ALTER TABLE `salary_meta` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `no` varchar(255) DEFAULT NULL COMMENT '编号',
  `parentId` int(32) DEFAULT NULL COMMENT '上级部门',
  `ancestors` varchar(50) DEFAULT NULL COMMENT '祖级列表',
  `deptName` varchar(255) DEFAULT NULL COMMENT '名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `status` bit(1) NOT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

LOCK TABLES `sys_department` WRITE;
/*!40000 ALTER TABLE `sys_department` DISABLE KEYS */;

INSERT INTO `sys_department` (`id`, `no`, `parentId`, `ancestors`, `deptName`, `sort`, `status`, `createTime`, `updateTime`)
VALUES
	(17,'001',0,'0','二〇二研究所',1,b'1','2020-12-09 14:25:35','2020-12-10 20:53:20'),
	(20,'001016',17,'0,17','一部',1,b'1','2020-12-09 14:40:24','2020-12-09 15:13:34'),
	(21,'001017',17,'0,17','二部',2,b'1','2020-12-09 14:40:36','2020-12-09 15:13:46'),
	(22,'001018',17,'0,17','三部',3,b'1','2020-12-09 14:40:54','2020-12-09 15:13:55'),
	(23,'001019',17,'0,17','四部',4,b'1','2020-12-09 14:43:03','2020-12-09 15:14:06'),
	(25,'001020',17,'0,17','五部',5,b'1','2020-12-09 14:43:52','2020-12-09 15:14:18');

/*!40000 ALTER TABLE `sys_department` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `ip` varchar(64) DEFAULT NULL COMMENT '请求ip',
  `description` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `params` varchar(255) DEFAULT NULL COMMENT '参数值',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `time` bigint(20) DEFAULT NULL COMMENT '执行时间',
  `type` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `method` varchar(255) DEFAULT NULL COMMENT '执行方法',
  `exceptionDetail` text COMMENT '异常详细信息',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;

INSERT INTO `sys_log` (`id`, `username`, `ip`, `description`, `params`, `browser`, `time`, `type`, `method`, `exceptionDetail`, `createTime`)
VALUES
	(46,'admin','192.168.43.182','获取日志列表','{ tableRequest: TableRequest(page=1, limit=10, offset=0) logQuery: LogQuery(userName=null, logType=INFO) }','Chrome 8',13,'ERROR','com.nood.hrm.controller.LogController.logList()','org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'logQuery\' in \'class com.nood.hrm.common.logger.dto.LogQuery\'\n	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:96)\n	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:441)\n	at com.sun.proxy.$Proxy97.selectOne(Unknown Source)\n	at org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:160)\n	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:87)\n	at org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:152)\n	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:85)\n	at com.sun.proxy.$Proxy221.getFuzzyLogCount(Unknown Source)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)\n	at com.sun.proxy.$Proxy222.getFuzzyLogCount(Unknown Source)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl.getFuzzyInfoLogByPage(LogServiceImpl.java:28)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl$$FastClassBySpringCGLIB$$c9f24675.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:687)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl$$EnhancerBySpringCGLIB$$ad08e941.getFuzzyInfoLogByPage(<generated>)\n	at com.nood.hrm.controller.LogController.logList(LogController.java:41)\n	at com.nood.hrm.controller.LogController$$FastClassBySpringCGLIB$$39ca2064.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:64)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)\n	at com.nood.hrm.common.logger.aspect.LogAspect.saveSysLog(LogAspect.java:49)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\n	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:72)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)\n	at com.nood.hrm.controller.LogController$$EnhancerBySpringCGLIB$$5b071b53.logList(<generated>)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:893)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:807)\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:327)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:119)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:113)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\n	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)\n	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n	at java.lang.Thread.run(Thread.java:748)\nCaused by: org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'logQuery\' in \'class com.nood.hrm.common.logger.dto.LogQuery\'\n	at org.apache.ibatis.reflection.Reflector.getGetInvoker(Reflector.java:374)\n	at org.apache.ibatis.reflection.MetaClass.getGetInvoker(MetaClass.java:164)\n	at org.apache.ibatis.reflection.wrapper.BeanWrapper.getBeanProperty(BeanWrapper.java:162)\n	at org.apache.ibatis.reflection.wrapper.BeanWrapper.get(BeanWrapper.java:49)\n	at org.apache.ibatis.reflection.MetaObject.getValue(MetaObject.java:122)\n	at org.apache.ibatis.scripting.xmltags.DynamicContext$ContextMap.get(DynamicContext.java:102)\n	at org.apache.ibatis.scripting.xmltags.DynamicContext$ContextAccessor.getProperty(DynamicContext.java:113)\n	at org.apache.ibatis.ognl.OgnlRuntime.getProperty(OgnlRuntime.java:3338)\n	at org.apache.ibatis.ognl.ASTProperty.getValueBody(ASTProperty.java:121)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTChain.getValueBody(ASTChain.java:141)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTNotEq.getValueBody(ASTNotEq.java:50)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTAnd.getValueBody(ASTAnd.java:61)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.Ognl.getValue(Ognl.java:560)\n	at org.apache.ibatis.ognl.Ognl.getValue(Ognl.java:524)\n	at org.apache.ibatis.scripting.xmltags.OgnlCache.getValue(OgnlCache.java:46)\n	at org.apache.ibatis.scripting.xmltags.ExpressionEvaluator.evaluateBoolean(ExpressionEvaluator.java:32)\n	at org.apache.ibatis.scripting.xmltags.IfSqlNode.apply(IfSqlNode.java:34)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.lambda$apply$0(MixedSqlNode.java:32)\n	at java.util.ArrayList.forEach(ArrayList.java:1257)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.apply(MixedSqlNode.java:32)\n	at org.apache.ibatis.scripting.xmltags.TrimSqlNode.apply(TrimSqlNode.java:55)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.lambda$apply$0(MixedSqlNode.java:32)\n	at java.util.ArrayList.forEach(ArrayList.java:1257)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.apply(MixedSqlNode.java:32)\n	at org.apache.ibatis.scripting.xmltags.DynamicSqlSource.getBoundSql(DynamicSqlSource.java:39)\n	at org.apache.ibatis.mapping.MappedStatement.getBoundSql(MappedStatement.java:305)\n	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:87)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:147)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:76)\n	at sun.reflect.GeneratedMethodAccessor317.invoke(Unknown Source)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427)\n	... 138 more\n','2020-12-15 09:07:50'),
	(48,'admin','192.168.43.182','获取日志列表','{ tableRequest: TableRequest(page=1, limit=10, offset=0) logQuery: LogQuery(userName=null, logType=INFO) }','Chrome 8',1,'ERROR','com.nood.hrm.controller.LogController.logList()','org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'logQuery\' in \'class com.nood.hrm.common.logger.dto.LogQuery\'\n	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:96)\n	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:441)\n	at com.sun.proxy.$Proxy97.selectOne(Unknown Source)\n	at org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:160)\n	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:87)\n	at org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:152)\n	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:85)\n	at com.sun.proxy.$Proxy221.getFuzzyLogCount(Unknown Source)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215)\n	at com.sun.proxy.$Proxy222.getFuzzyLogCount(Unknown Source)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl.getFuzzyInfoLogByPage(LogServiceImpl.java:28)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl$$FastClassBySpringCGLIB$$c9f24675.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:687)\n	at com.nood.hrm.common.logger.service.impl.LogServiceImpl$$EnhancerBySpringCGLIB$$ad08e941.getFuzzyInfoLogByPage(<generated>)\n	at com.nood.hrm.controller.LogController.logList(LogController.java:41)\n	at com.nood.hrm.controller.LogController$$FastClassBySpringCGLIB$$39ca2064.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:64)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)\n	at com.nood.hrm.common.logger.aspect.LogAspect.saveSysLog(LogAspect.java:49)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\n	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:72)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)\n	at com.nood.hrm.controller.LogController$$EnhancerBySpringCGLIB$$5b071b53.logList(<generated>)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:893)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:807)\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:327)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:119)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:113)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\n	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)\n	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n	at java.lang.Thread.run(Thread.java:748)\nCaused by: org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'logQuery\' in \'class com.nood.hrm.common.logger.dto.LogQuery\'\n	at org.apache.ibatis.reflection.Reflector.getGetInvoker(Reflector.java:374)\n	at org.apache.ibatis.reflection.MetaClass.getGetInvoker(MetaClass.java:164)\n	at org.apache.ibatis.reflection.wrapper.BeanWrapper.getBeanProperty(BeanWrapper.java:162)\n	at org.apache.ibatis.reflection.wrapper.BeanWrapper.get(BeanWrapper.java:49)\n	at org.apache.ibatis.reflection.MetaObject.getValue(MetaObject.java:122)\n	at org.apache.ibatis.scripting.xmltags.DynamicContext$ContextMap.get(DynamicContext.java:102)\n	at org.apache.ibatis.scripting.xmltags.DynamicContext$ContextAccessor.getProperty(DynamicContext.java:113)\n	at org.apache.ibatis.ognl.OgnlRuntime.getProperty(OgnlRuntime.java:3338)\n	at org.apache.ibatis.ognl.ASTProperty.getValueBody(ASTProperty.java:121)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTChain.getValueBody(ASTChain.java:141)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTNotEq.getValueBody(ASTNotEq.java:50)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.ASTAnd.getValueBody(ASTAnd.java:61)\n	at org.apache.ibatis.ognl.SimpleNode.evaluateGetValueBody(SimpleNode.java:212)\n	at org.apache.ibatis.ognl.SimpleNode.getValue(SimpleNode.java:258)\n	at org.apache.ibatis.ognl.Ognl.getValue(Ognl.java:560)\n	at org.apache.ibatis.ognl.Ognl.getValue(Ognl.java:524)\n	at org.apache.ibatis.scripting.xmltags.OgnlCache.getValue(OgnlCache.java:46)\n	at org.apache.ibatis.scripting.xmltags.ExpressionEvaluator.evaluateBoolean(ExpressionEvaluator.java:32)\n	at org.apache.ibatis.scripting.xmltags.IfSqlNode.apply(IfSqlNode.java:34)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.lambda$apply$0(MixedSqlNode.java:32)\n	at java.util.ArrayList.forEach(ArrayList.java:1257)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.apply(MixedSqlNode.java:32)\n	at org.apache.ibatis.scripting.xmltags.TrimSqlNode.apply(TrimSqlNode.java:55)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.lambda$apply$0(MixedSqlNode.java:32)\n	at java.util.ArrayList.forEach(ArrayList.java:1257)\n	at org.apache.ibatis.scripting.xmltags.MixedSqlNode.apply(MixedSqlNode.java:32)\n	at org.apache.ibatis.scripting.xmltags.DynamicSqlSource.getBoundSql(DynamicSqlSource.java:39)\n	at org.apache.ibatis.mapping.MappedStatement.getBoundSql(MappedStatement.java:305)\n	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:87)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:147)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)\n	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:76)\n	at sun.reflect.GeneratedMethodAccessor317.invoke(Unknown Source)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427)\n	... 138 more\n','2020-12-15 09:07:56'),
	(81,'张三','192.168.43.182','删除所有INFO日志','{ }','Chrome 8',10,'INFO','com.nood.hrm.controller.LogController.delAllByInfo()',NULL,'2020-12-15 09:18:42'),
	(82,'张三','192.168.43.182','获取日志列表','{ tableRequest: TableRequest(page=1, limit=10, offset=0) logQuery: LogQuery(userName=null, logType=INFO) }','Chrome 8',4,'INFO','com.nood.hrm.controller.LogController.logList()',NULL,'2020-12-15 09:18:42'),
	(83,'张三','192.168.43.182','获取日志列表','{ tableRequest: TableRequest(page=1, limit=10, offset=0) logQuery: LogQuery(userName=admin, logType=INFO) }','Chrome 8',12,'INFO','com.nood.hrm.controller.LogController.logList()',NULL,'2020-12-15 09:18:45'),
	(84,'张三','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:20:15'),
	(85,'张三','192.168.43.182','获取日志列表','{ tableRequest: TableRequest(page=1, limit=10, offset=0) logQuery: LogQuery(userName=null, logType=INFO) }','Chrome 8',5,'INFO','com.nood.hrm.controller.LogController.logList()',NULL,'2020-12-15 09:20:15'),
	(86,'张三','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',7,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:30:22'),
	(87,'张三','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',4,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:32:04'),
	(88,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',7,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:51:56'),
	(89,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 2 }','Chrome 8',34,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 09:52:04'),
	(90,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:52:13'),
	(91,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 2 }','Chrome 8',13,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 09:52:17'),
	(92,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:52:21'),
	(93,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:52:44'),
	(94,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',13,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:55:12'),
	(95,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',8,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:55:43'),
	(96,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 1 }','Chrome 8',29,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 09:55:53'),
	(97,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:55:57'),
	(98,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',5,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 09:57:18'),
	(99,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',4,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:58:27'),
	(100,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 09:58:37'),
	(101,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 1 }','Chrome 8',17,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 09:58:43'),
	(102,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:00:19'),
	(103,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',4,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:00:58'),
	(104,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:01:14'),
	(105,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:01:32'),
	(106,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27], departmentIds=null) }','Chrome 8',22,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-15 10:06:51'),
	(107,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:06:57'),
	(108,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',1,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:08:56'),
	(109,'admin','192.168.43.182','批量删除薪酬字段','{ idList: [33] }','Chrome 8',14,'INFO','com.nood.hrm.controller.SalaryController.DeleteMetaByIdList()',NULL,'2020-12-15 10:47:46'),
	(110,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=33, name=部门名称, type=基本信息, property=1, detail=不可删除, history=null, isDecimal=0, status=1, sort=1) }','Chrome 8',0,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 10:47:55'),
	(111,'admin','192.168.43.182','删除薪酬字段','{ salaryMeta: SalaryMeta(id=33, name=null, type=null, property=null, detail=null, history=null, isDecimal=null, status=null, sort=null) }','Chrome 8',2,'ERROR','com.nood.hrm.controller.SalaryController.deleteMeta()','java.lang.NullPointerException\n	at net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinString(PinyinHelper.java:302)\n	at com.nood.hrm.util.PinyinUtil.hanziToPinyin(PinyinUtil.java:131)\n	at com.nood.hrm.controller.SalaryController.cannotUpdate(SalaryController.java:179)\n	at com.nood.hrm.controller.SalaryController.deleteMeta(SalaryController.java:113)\n	at com.nood.hrm.controller.SalaryController$$FastClassBySpringCGLIB$$ee828822.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:64)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)\n	at com.nood.hrm.common.logger.aspect.LogAspect.saveSysLog(LogAspect.java:49)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\n	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:72)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)\n	at com.nood.hrm.controller.SalaryController$$EnhancerBySpringCGLIB$$104d9dc6.deleteMeta(<generated>)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:893)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:807)\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:327)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:119)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:113)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\n	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)\n	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n	at java.lang.Thread.run(Thread.java:748)\n','2020-12-15 10:48:01'),
	(112,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=33, name=部门名称, type=基本信息, property=1, detail=不可删除, history=null, isDecimal=0, status=1, sort=1) }','Chrome 8',0,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 10:48:59'),
	(113,'admin','192.168.43.182','批量删除薪酬字段','{ idList: [33] }','Chrome 8',4,'INFO','com.nood.hrm.controller.SalaryController.DeleteMetaByIdList()',NULL,'2020-12-15 10:49:09'),
	(114,'admin','192.168.43.182','删除薪酬字段','{ salaryMeta: SalaryMeta(id=33, name=null, type=null, property=null, detail=null, history=null, isDecimal=null, status=null, sort=null) }','Chrome 8',0,'ERROR','com.nood.hrm.controller.SalaryController.deleteMeta()','java.lang.NullPointerException\n	at net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinString(PinyinHelper.java:302)\n	at com.nood.hrm.util.PinyinUtil.hanziToPinyin(PinyinUtil.java:131)\n	at com.nood.hrm.controller.SalaryController.cannotUpdate(SalaryController.java:179)\n	at com.nood.hrm.controller.SalaryController.deleteMeta(SalaryController.java:113)\n	at com.nood.hrm.controller.SalaryController$$FastClassBySpringCGLIB$$ee828822.invoke(<generated>)\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:64)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)\n	at com.nood.hrm.common.logger.aspect.LogAspect.saveSysLog(LogAspect.java:49)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\n	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:72)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)\n	at com.nood.hrm.controller.SalaryController$$EnhancerBySpringCGLIB$$104d9dc6.deleteMeta(<generated>)\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n	at java.lang.reflect.Method.invoke(Method.java:498)\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:893)\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:807)\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:327)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:119)\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:113)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:105)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:218)\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:212)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\n	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:110)\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:80)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:336)\n	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211)\n	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:183)\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n	at java.lang.Thread.run(Thread.java:748)\n','2020-12-15 10:49:14'),
	(115,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',11,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 10:52:19'),
	(116,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',5,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 11:15:12'),
	(117,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',6,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 14:34:03'),
	(118,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=33, name=部门, type=基本信息, property=固定属性, detail=不可删除, history=部门名称  部门  , isDecimal=0, status=1, sort=1) }','Chrome 8',98,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 14:43:03'),
	(119,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=34, name=工号, type=基本信息, property=固定属性, detail=不可删除, history=员工编号  , isDecimal=0, status=1, sort=3) }','Chrome 8',35,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 14:43:22'),
	(120,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=28, name=姓名, type=基本信息, property=固定属性, detail=不可删除, history=员工名字  , isDecimal=0, status=1, sort=4) }','Chrome 8',43,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 14:43:36'),
	(121,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=35, name=岗级工资, type=岗位绩效, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=5) }','Chrome 8',323,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:01:36'),
	(122,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=36, name=绩效工资, type=岗位绩效, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=6) }','Chrome 8',50,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:02:21'),
	(123,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=37, name=保密补贴, type=岗位绩效, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=7) }','Chrome 8',66,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:03:33'),
	(124,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=38, name=交通补贴, type=津贴补, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=8) }','Chrome 8',58,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:11:12'),
	(125,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=39, name=物业补贴, type=津贴补, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=9) }','Chrome 8',66,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:12:48'),
	(126,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=40, name=班组长津贴, type=津贴补, property=固定工资, detail=无, history=null, isDecimal=1, status=1, sort=10) }','Chrome 8',56,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:14:26'),
	(127,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=41, name=岗级工资补发, type=岗位绩效, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=11) }','Chrome 8',69,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:32:34'),
	(128,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=42, name=安全奖励, type=其他奖励, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=11) }','Chrome 8',69,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:35:20'),
	(129,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=42, name=安全奖励, type=其他奖励, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=12) }','Chrome 8',110,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 15:41:48'),
	(130,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=43, name=质量奖励, type=其他奖励, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=13) }','Chrome 8',61,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:42:59'),
	(131,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=44, name=绩效预发, type=岗位绩效, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=14) }','Chrome 8',57,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:45:56'),
	(132,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=45, name=稿酬, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=16) }','Chrome 8',70,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:46:46'),
	(133,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=45, name=稿酬, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=15) }','Chrome 8',60,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 15:47:06'),
	(134,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=46, name=绩效扣减, type=岗位绩效, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=16) }','Chrome 8',69,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:52:32'),
	(135,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=47, name=司机补贴, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=17) }','Chrome 8',67,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:53:01'),
	(136,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=48, name=值班补贴, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=17) }','Chrome 8',54,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:54:35'),
	(137,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=48, name=值班补贴, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=18) }','Chrome 8',62,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 15:54:47'),
	(138,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=49, name=节假日补贴, type=其他补贴, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=19) }','Chrome 8',70,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:56:04'),
	(139,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=49, name=节假日工作补贴, type=其他补贴, property=浮动工资, detail=无, history=节假日补贴  , isDecimal=1, status=1, sort=19) }','Chrome 8',64,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 15:57:33'),
	(140,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=50, name=绩效补发, type=岗位绩效, property=浮动工资, detail=无, history=null, isDecimal=1, status=1, sort=20) }','Chrome 8',59,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:58:01'),
	(141,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=51, name=公积金, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=20) }','Chrome 8',66,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 15:59:18'),
	(142,'admin','192.168.43.182','更新字段','{ salaryMeta: SalaryMeta(id=51, name=公积金, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=21) }','Chrome 8',68,'INFO','com.nood.hrm.controller.SalaryController.updateMeta()',NULL,'2020-12-15 15:59:46'),
	(143,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=52, name=养老保险, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=22) }','Chrome 8',58,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:00:21'),
	(144,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=53, name=职业年金, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=23) }','Chrome 8',59,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:00:47'),
	(145,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=54, name=医疗保险, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=24) }','Chrome 8',55,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:01:09'),
	(146,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=55, name=失业保险, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=25) }','Chrome 8',55,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:01:37'),
	(147,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=56, name=大病保险, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=26) }','Chrome 8',57,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:02:02'),
	(148,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=57, name=大额医疗补助, type=五险一金, property=无, detail=无, history=null, isDecimal=1, status=1, sort=27) }','Chrome 8',60,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:03:17'),
	(149,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=58, name=个人所得税, type=个人所得税, property=无, detail=无, history=null, isDecimal=1, status=1, sort=28) }','Chrome 8',51,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:03:51'),
	(150,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=59, name=车位费, type=扣款, property=无, detail=无, history=null, isDecimal=1, status=1, sort=29) }','Chrome 8',54,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:04:36'),
	(151,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=60, name=贷款, type=扣款, property=无, detail=无, history=null, isDecimal=1, status=1, sort=30) }','Chrome 8',50,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:05:23'),
	(152,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=61, name=应发合计, type=无, property=无, detail=无, history=null, isDecimal=1, status=1, sort=31) }','Chrome 8',58,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:05:43'),
	(153,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=62, name=实发合计, type=无, property=无, detail=无, history=null, isDecimal=1, status=1, sort=32) }','Chrome 8',61,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:06:20'),
	(154,'admin','192.168.43.182','添加字段','{ salaryMeta: SalaryMeta(id=63, name=备注, type=无, property=无, detail=无, history=null, isDecimal=0, status=1, sort=33) }','Chrome 8',59,'INFO','com.nood.hrm.controller.SalaryController.saveMeta()',NULL,'2020-12-15 16:06:55'),
	(155,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',17,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:23:29'),
	(156,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:26:29'),
	(157,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:26:33'),
	(158,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 8 }','Chrome 8',37,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 16:26:40'),
	(159,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:26:45'),
	(160,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 9 }','Chrome 8',9,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 16:26:49'),
	(161,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',1,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:26:52'),
	(162,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',1,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:26:56'),
	(163,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 2 }','Chrome 8',8,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-15 16:27:00'),
	(164,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-15 16:27:05'),
	(165,'admin','192.168.43.182','下载薪酬数据模板','{ response: com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@35fe99d5 }','Chrome 8',2258,'INFO','com.nood.hrm.controller.SalaryController.downloadSalaryMeta()',NULL,'2020-12-15 16:31:31'),
	(166,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',38,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:38:40'),
	(167,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',10,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:38:48'),
	(168,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',5,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:38:59'),
	(169,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:39:11'),
	(170,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',6,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:39:23'),
	(171,'admin','192.168.43.182','下载薪酬数据模板','{ response: com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@1ba56421 }','Chrome 8',1936,'INFO','com.nood.hrm.controller.SalaryController.downloadSalaryMeta()',NULL,'2020-12-15 16:39:31'),
	(172,'admin','192.168.43.182','下载薪酬数据模板','{ response: com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@1bf1d0b9 }','Chrome 8',2100,'INFO','com.nood.hrm.controller.SalaryController.downloadSalaryMeta()',NULL,'2020-12-15 16:40:30'),
	(173,'admin','192.168.43.182','下载薪酬数据模板','{ response: com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@61e24e7f }','Chrome 8',2134,'INFO','com.nood.hrm.controller.SalaryController.downloadSalaryMeta()',NULL,'2020-12-15 16:46:00'),
	(174,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',35,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:47:27'),
	(175,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',4,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 16:54:15'),
	(176,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',52,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 17:00:01'),
	(177,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[20, 21, 22, 23, 25]) }','Chrome 8',19,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 17:15:19'),
	(178,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 20], departmentIds=null) }','Chrome 8',15,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-15 17:32:04'),
	(179,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27], departmentIds=null) }','Chrome 8',25,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-15 17:44:36'),
	(180,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[20, 21, 22, 23, 25]) }','Chrome 8',11,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 17:45:00'),
	(181,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[]) }','Chrome 8',7,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 17:45:52'),
	(182,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',5,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 17:46:16'),
	(183,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',131,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 17:53:14'),
	(184,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[]) }','Chrome 8',19,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 17:59:33'),
	(185,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[21, 22]) }','Chrome 8',9,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 18:00:04'),
	(186,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[20, 21, 22]) }','Chrome 8',8,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 18:00:36'),
	(187,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[20]) }','Chrome 8',5,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 18:01:08'),
	(188,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[20]) }','Chrome 8',5,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-15 18:01:30'),
	(189,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-15 18:03:38'),
	(190,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',26,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 08:31:00'),
	(191,'admin','192.168.43.182','添加权限','{ permission: Permission(parentId=27, name=删除, css=null, href=, type=2, permission=biz:salary:delete, sort=100, child=null) }','Chrome 8',16,'INFO','com.nood.hrm.controller.PermissionController.savePermission()',NULL,'2020-12-16 08:35:25'),
	(192,'admin','192.168.43.182','更新权限','{ permission: Permission(parentId=27, name=删除, css=null, href=, type=1, permission=biz:salary:del, sort=100, child=null) }','Chrome 8',20,'INFO','com.nood.hrm.controller.PermissionController.updatePermission()',NULL,'2020-12-16 08:35:46'),
	(193,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',9,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 08:37:46'),
	(194,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',25,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:03:32'),
	(195,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',9,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:07:31'),
	(196,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',12,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:11:33'),
	(197,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',5,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:12:11'),
	(198,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:13:28'),
	(199,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',27,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:20:22'),
	(200,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',8,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:21:44'),
	(201,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',4,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 09:22:36'),
	(202,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 29], departmentIds=null) }','Chrome 8',33,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:07:28'),
	(203,'admin','192.168.43.182','更新权限','{ permission: Permission(parentId=27, name=删除, css=null, href=, type=2, permission=biz:salary:del, sort=100, child=null) }','Chrome 8',5,'INFO','com.nood.hrm.controller.PermissionController.updatePermission()',NULL,'2020-12-16 10:08:08'),
	(204,'admin','192.168.43.182','添加权限','{ permission: Permission(parentId=27, name=查询, css=null, href=, type=2, permission=biz:salary:query, sort=100, child=null) }','Chrome 8',13,'INFO','com.nood.hrm.controller.PermissionController.savePermission()',NULL,'2020-12-16 10:12:26'),
	(205,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 30], departmentIds=null) }','Chrome 8',16,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:12:46'),
	(206,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 29, 30], departmentIds=null) }','Chrome 8',13,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:20:29'),
	(207,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 30], departmentIds=null) }','Chrome 8',9,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:22:07'),
	(208,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',6,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 10:48:25'),
	(209,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 30], departmentIds=null) }','Chrome 8',10,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:48:49'),
	(210,'admin','192.168.43.182','修改角色权限','{ roleDto: RoleDto(permissionIds=null, departmentIds=[21, 22]) }','Chrome 8',9,'INFO','com.nood.hrm.controller.RoleController.uthDataScope()',NULL,'2020-12-16 10:48:59'),
	(211,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-16 10:49:10'),
	(212,'admin','192.168.43.182','更新用户','{ userDto: UserDto(departmentName=null, roleName=null) roleId: 9 }','Chrome 8',10,'INFO','com.nood.hrm.controller.UserController.updateUser()',NULL,'2020-12-16 10:49:16'),
	(213,'admin','192.168.43.182','绘制部门树','{ departmentDto: DepartmentDto(id=null, parentId=null, checkArr=0, title=null) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.buildDeptAll()',NULL,'2020-12-16 10:49:23'),
	(214,'张三','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 10:49:42'),
	(215,'张三','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',3,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 10:49:54'),
	(216,'admin','192.168.43.182','更新角色','{ roleDto: RoleDto(permissionIds=[1, 2, 3, 4, 5, 25, 28, 7, 8, 9, 10, 11, 23, 12, 13, 14, 15, 24, 16, 26, 27, 29, 30], departmentIds=null) }','Chrome 8',8,'INFO','com.nood.hrm.controller.RoleController.updateRole()',NULL,'2020-12-16 10:56:05'),
	(217,'admin','192.168.43.182','查询部门','{ department: Department(no=null, parentId=null, ancestors=null, deptName=, sort=null, status=1) }','Chrome 8',2,'INFO','com.nood.hrm.controller.DepartmentController.getDeptAll()',NULL,'2020-12-16 10:57:13');

/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `css` varchar(30) DEFAULT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `type` tinyint(1) NOT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `icon` varchar(1000) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;

INSERT INTO `sys_permission` (`id`, `parentId`, `name`, `css`, `href`, `type`, `permission`, `icon`, `sort`)
VALUES
	(1,0,'系统管理','','',1,'','<i class=\"iconfont layui-icon\">&#xe770;</i>   ',1),
	(2,1,'用户管理','fa-user','/api/getPage?pageName=user/user-list',1,'','<i class=\"iconfont\">&#xe6a7;</i>',3),
	(3,2,'查询','','',2,'sys:user:query',NULL,100),
	(4,2,'新增','','',2,'sys:user:add',NULL,100),
	(5,2,'删除',NULL,NULL,2,'sys:user:del',NULL,100),
	(7,0,'权限管理','fa-gears','',1,'',NULL,3),
	(8,7,'菜单','fa-cog','/api/getPage?pageName=permission/permission-list',1,'',NULL,2),
	(9,8,'查询','','',2,'sys:menu:query',NULL,100),
	(10,8,'新增','','',2,'sys:menu:add',NULL,100),
	(11,8,'删除','','',2,'sys:menu:del',NULL,100),
	(12,7,'角色','fa-user-secret','/api/getPage?pageName=role/role-list',1,'','<i class=\"iconfont\">&#xe6a7;</i>',1),
	(13,12,'查询','','',2,'sys:role:query',NULL,100),
	(14,12,'新增','','',2,'sys:role:add',NULL,100),
	(15,12,'删除','','',2,'sys:role:del',NULL,100),
	(16,0,'薪酬管理','','',1,'',NULL,2),
	(19,0,'数据源监控','fa-eye','druid/index.html',1,'',NULL,9),
	(20,0,'接口swagger','fa-file-pdf-o','swagger-ui.html',1,'',NULL,10),
	(21,0,'代码生成','fa-wrench','/api/getPage?pageName=generate/edit',1,'generate:edit',NULL,11),
	(22,0,'日志查询','fa-reorder','/api/getPage?pageName=log/log-list',1,'sys:log:query',NULL,13),
	(23,8,'修改',NULL,NULL,2,'sys:menu:edit',NULL,100),
	(24,12,'修改',NULL,NULL,2,'sys:role:edit',NULL,100),
	(25,2,'修改',NULL,NULL,2,'sys:user:edit',NULL,100),
	(26,16,'导入工资数据','','/api/getPage?pageName=salary/salary-import',1,'',NULL,5),
	(27,16,'工资查询','','/api/getPage?pageName=salary/salary-list',1,'',NULL,2),
	(28,1,'部门管理','','/api/getPage?pageName=dept/dept-list',1,'',NULL,2),
	(29,27,'删除',NULL,'',2,'biz:salary:del',NULL,100),
	(30,27,'查询',NULL,'',2,'biz:salary:query',NULL,100);

/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `dataScope` char(1) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;

INSERT INTO `sys_role` (`id`, `name`, `description`, `dataScope`, `createTime`, `updateTime`)
VALUES
	(1,'管理员','管理员','1','2017-05-01 13:25:39','2020-12-16 10:56:05'),
	(2,'部门领导','普通用户','3','2017-08-01 21:47:31','2020-12-10 16:43:12'),
	(8,'普通员工','','5','2020-12-10 16:47:33','2020-12-10 16:48:04'),
	(9,'二部三部分管领导','可以查看二部和三部员工的数据','2','2020-12-10 16:53:12','2020-12-16 10:49:00');

/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role_department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_department`;

CREATE TABLE `sys_role_department` (
  `roleId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`departmentId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

LOCK TABLES `sys_role_department` WRITE;
/*!40000 ALTER TABLE `sys_role_department` DISABLE KEYS */;

INSERT INTO `sys_role_department` (`roleId`, `departmentId`)
VALUES
	(9,21),
	(9,22);

/*!40000 ALTER TABLE `sys_role_department` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `roleId` int(11) NOT NULL,
  `permissionId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `fk_sysrolepermission_permissionId` (`permissionId`),
  CONSTRAINT `fk_permission_roleId` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_sysrolepermission_permissionId` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;

INSERT INTO `sys_role_permission` (`roleId`, `permissionId`)
VALUES
	(1,1),
	(2,1),
	(8,1),
	(9,1),
	(1,2),
	(2,2),
	(8,2),
	(9,2),
	(1,3),
	(2,3),
	(8,3),
	(9,3),
	(1,4),
	(8,4),
	(9,4),
	(1,5),
	(8,5),
	(9,5),
	(1,7),
	(2,7),
	(8,7),
	(9,7),
	(1,8),
	(2,8),
	(8,8),
	(9,8),
	(1,9),
	(2,9),
	(8,9),
	(9,9),
	(1,10),
	(2,10),
	(8,10),
	(9,10),
	(1,11),
	(2,11),
	(8,11),
	(9,11),
	(1,12),
	(2,12),
	(8,12),
	(9,12),
	(1,13),
	(2,13),
	(8,13),
	(9,13),
	(1,14),
	(2,14),
	(8,14),
	(9,14),
	(1,15),
	(2,15),
	(8,15),
	(9,15),
	(1,16),
	(2,16),
	(8,16),
	(9,16),
	(1,23),
	(2,23),
	(8,23),
	(9,23),
	(1,24),
	(2,24),
	(8,24),
	(9,24),
	(1,25),
	(8,25),
	(9,25),
	(1,26),
	(2,26),
	(8,26),
	(9,26),
	(1,27),
	(2,27),
	(8,27),
	(9,27),
	(1,28),
	(8,28),
	(9,28),
	(1,29),
	(1,30),
	(9,30);

/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_user`;

CREATE TABLE `sys_role_user` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `fk_roleId` (`roleId`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `sys_role_user` WRITE;
/*!40000 ALTER TABLE `sys_role_user` DISABLE KEYS */;

INSERT INTO `sys_role_user` (`userId`, `roleId`)
VALUES
	(1,1),
	(31,2),
	(30,8),
	(29,9),
	(32,9);

/*!40000 ALTER TABLE `sys_role_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentId` int(11) DEFAULT NULL COMMENT '部门id',
  `no` varchar(255) NOT NULL DEFAULT '' COMMENT '员工编号',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(60) NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `headImgUrl` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;

INSERT INTO `sys_user` (`id`, `departmentId`, `no`, `username`, `password`, `nickname`, `headImgUrl`, `phone`, `telephone`, `email`, `birthday`, `sex`, `status`, `createTime`, `updateTime`)
VALUES
	(1,20,'2002','admin','$2a$10$7HH70F3UEXy5g4mSMXY4wes/YB1cYR.VbxtL7kFV/pecYMCiF9Hcu','管理员',NULL,NULL,'158784879852','12@qq.com',NULL,1,1,'2019-04-08 00:20:51','2020-12-15 09:58:43'),
	(29,20,'2004','张三','$2a$10$j45.WKsxvlPykvfSxu/HxehrsZoRS4LBEe4tlRD.x9vdNlC9nkW/2','员工',NULL,NULL,'',NULL,NULL,1,1,'2020-12-10 16:22:09','2020-12-16 10:49:16'),
	(30,21,'2005','李四','$2a$10$OEibOw1n7JB/1RL6h1ig8eeNtGG6Cxr2ogN9PNTo2ecL1ZQfmY6Hi','员工',NULL,NULL,'',NULL,NULL,1,1,'2020-12-10 16:24:25','2020-12-15 16:26:40'),
	(31,21,'2006','赵六','$2a$10$BAQ8QwKjOGqCueNQHp5iFuTEdjACHDaYUcc7tVuHpj3OtcDJhbrFq','员工',NULL,NULL,'',NULL,NULL,1,1,'2020-12-10 16:25:46','2020-12-15 16:27:01'),
	(32,22,'2007','王六','$2a$10$ml8t2.DisLPvm35cS1Nus.JJErLQEd.LnL0RWNqDTQXG4PLSQ1Twi','员工',NULL,NULL,'',NULL,NULL,1,1,'2020-12-10 16:51:51','2020-12-15 16:26:49');

/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
