-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.1.146    Database: easypay
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bdf2_company`
--

DROP TABLE IF EXISTS `bdf2_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_company` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_company`
--

LOCK TABLES `bdf2_company` WRITE;
/*!40000 ALTER TABLE `bdf2_company` DISABLE KEYS */;
INSERT INTO `bdf2_company` VALUES ('MIS','MIS有限公司','MIS');
/*!40000 ALTER TABLE `bdf2_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_component`
--

DROP TABLE IF EXISTS `bdf2_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_component` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPONENT_ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_component`
--

LOCK TABLES `bdf2_component` WRITE;
/*!40000 ALTER TABLE `bdf2_component` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_dept`
--

DROP TABLE IF EXISTS `bdf2_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_dept` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_dept`
--

LOCK TABLES `bdf2_dept` WRITE;
/*!40000 ALTER TABLE `bdf2_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_excel_model`
--

DROP TABLE IF EXISTS `bdf2_excel_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_excel_model` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMMENT_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `COMPANYID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DATASOURCE_NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `DB_TYPE_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `END_COLUMN_` int(11) DEFAULT NULL,
  `END_ROW_` int(11) DEFAULT NULL,
  `EXCEL_SHEET_NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `HELP_DOC_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PRIMARYKEY_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PRIMARYKEY_TYPE_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PROCESSOR_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `SEQUENCE_NAME_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `START_COLUMN_` int(11) DEFAULT NULL,
  `START_ROW_` int(11) DEFAULT NULL,
  `TABLE_LABEL_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `TABEL_NAME_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_excel_model`
--

LOCK TABLES `bdf2_excel_model` WRITE;
/*!40000 ALTER TABLE `bdf2_excel_model` DISABLE KEYS */;
INSERT INTO `bdf2_excel_model` VALUES ('WaterMeterImport',NULL,'MIS','2018-01-15 01:29:21',NULL,NULL,0,2,NULL,NULL,'抄表导入',NULL,NULL,'waterMeterImportExcelProcessor',NULL,0,1,NULL,NULL);
/*!40000 ALTER TABLE `bdf2_excel_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_excel_model_detail`
--

DROP TABLE IF EXISTS `bdf2_excel_model_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_excel_model_detail` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `EXCEL_COLUMN_` int(11) DEFAULT NULL,
  `EXCEL_MODEL_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `INTERCEPTOR_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `TABLE_COLUMN_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_excel_model_detail`
--

LOCK TABLES `bdf2_excel_model_detail` WRITE;
/*!40000 ALTER TABLE `bdf2_excel_model_detail` DISABLE KEYS */;
INSERT INTO `bdf2_excel_model_detail` VALUES ('6ca638aaf8c31a36:-45f577b6:160f765d8ab:-7ffc',4,'WaterMeterImport','bdf2.requiredInterceptor','current_qty',NULL),('6ca638aaf8c31a36:-45f577b6:160f765d8ab:-7ffd',3,'WaterMeterImport','bdf2.requiredInterceptor','room_no',NULL),('6ca638aaf8c31a36:-45f577b6:160f765d8ab:-7ffe',2,'WaterMeterImport','bdf2.requiredInterceptor','building_code',NULL),('6ca638aaf8c31a36:-45f577b6:160f765d8ab:-7fff',1,'WaterMeterImport','bdf2.requiredInterceptor','monthly_cycle',NULL);
/*!40000 ALTER TABLE `bdf2_excel_model_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_group`
--

DROP TABLE IF EXISTS `bdf2_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_group` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_group`
--

LOCK TABLES `bdf2_group` WRITE;
/*!40000 ALTER TABLE `bdf2_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_group_member`
--

DROP TABLE IF EXISTS `bdf2_group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_group_member` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `DEPT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `GROUP_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `POSITION_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `USERNAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_group_member`
--

LOCK TABLES `bdf2_group_member` WRITE;
/*!40000 ALTER TABLE `bdf2_group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_message`
--

DROP TABLE IF EXISTS `bdf2_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_message` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `CONTENT_` varchar(1000) COLLATE utf8_bin NOT NULL,
  `READ_` tinyint(1) NOT NULL,
  `RECEIVER_` varchar(60) COLLATE utf8_bin NOT NULL,
  `REPLY_` tinyint(1) DEFAULT NULL,
  `SEND_DATE_` datetime DEFAULT NULL,
  `SENDER_` varchar(60) COLLATE utf8_bin NOT NULL,
  `TITLE_` varchar(60) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_message`
--

LOCK TABLES `bdf2_message` WRITE;
/*!40000 ALTER TABLE `bdf2_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_message_template`
--

DROP TABLE IF EXISTS `bdf2_message_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_message_template` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_message_template`
--

LOCK TABLES `bdf2_message_template` WRITE;
/*!40000 ALTER TABLE `bdf2_message_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_message_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_position`
--

DROP TABLE IF EXISTS `bdf2_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_position` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_position`
--

LOCK TABLES `bdf2_position` WRITE;
/*!40000 ALTER TABLE `bdf2_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_resource_allocation`
--

DROP TABLE IF EXISTS `bdf2_resource_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_resource_allocation` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `CREATE_DATE_` date DEFAULT NULL,
  `CREATE_USER_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_OWNER_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_resource_allocation`
--

LOCK TABLES `bdf2_resource_allocation` WRITE;
/*!40000 ALTER TABLE `bdf2_resource_allocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_resource_allocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_resource_owner`
--

DROP TABLE IF EXISTS `bdf2_resource_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_resource_owner` (
  `USERNAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` date DEFAULT NULL,
  `CREATE_USER_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`USERNAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_resource_owner`
--

LOCK TABLES `bdf2_resource_owner` WRITE;
/*!40000 ALTER TABLE `bdf2_resource_owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_resource_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_role`
--

DROP TABLE IF EXISTS `bdf2_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_role` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_role`
--

LOCK TABLES `bdf2_role` WRITE;
/*!40000 ALTER TABLE `bdf2_role` DISABLE KEYS */;
INSERT INTO `bdf2_role` VALUES ('404340ee-9963-4119-9269-487b274629c6','MIS','2017-10-28 23:44:10',NULL,'峰哥',NULL,'normal');
/*!40000 ALTER TABLE `bdf2_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_role_member`
--

DROP TABLE IF EXISTS `bdf2_role_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_role_member` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `DEPT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `GRANTED_` tinyint(1) DEFAULT NULL,
  `POSITION_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `ROLE_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `USERNAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `GROUP_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_role_member`
--

LOCK TABLES `bdf2_role_member` WRITE;
/*!40000 ALTER TABLE `bdf2_role_member` DISABLE KEYS */;
INSERT INTO `bdf2_role_member` VALUES ('2c159723-2f48-4321-9c7e-7b704e5906b9','2017-11-02 11:42:56',NULL,1,NULL,'404340ee-9963-4119-9269-487b274629c6','marchi',NULL),('b84a3e14-c9fc-4f9d-af60-84fdd34cee46','2017-11-03 10:23:43',NULL,1,NULL,'404340ee-9963-4119-9269-487b274629c6','tiger',NULL);
/*!40000 ALTER TABLE `bdf2_role_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_role_resource`
--

DROP TABLE IF EXISTS `bdf2_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_role_resource` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `PACKAGE_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `ROLE_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `URL_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_role_resource`
--

LOCK TABLES `bdf2_role_resource` WRITE;
/*!40000 ALTER TABLE `bdf2_role_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_url`
--

DROP TABLE IF EXISTS `bdf2_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_url` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `DESC_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `FOR_NAVIGATION_` tinyint(1) NOT NULL,
  `ICON_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  `ORDER_` int(11) DEFAULT NULL,
  `PARENT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `SYSTEM_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_url`
--

LOCK TABLES `bdf2_url` WRITE;
/*!40000 ALTER TABLE `bdf2_url` DISABLE KEYS */;
INSERT INTO `bdf2_url` VALUES ('0be2fd1a-6635-4db7-bb6a-24ef79007077','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','缴费管理',2,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('0cd21cf8-d2a3-45bf-9102-61c95cb19186','MIS',NULL,1,'url(skin>common/icons.gif) -240px -80px','角色维护',1,'326a9ff0-8e92-4594-a46d-7e2403c69710',NULL,'bdf2.core.view.role.RoleMaintain.d'),('0e1a8dc2-f6ac-4eaa-bf81-1e1c973ea9bf','MIS','building_info',1,'url(>skin>common/icons.gif) -0px -20px','楼宇资料',2,'67eb2a59-c3a8-4dff-b41c-1cadd42cd103',NULL,'com.pay.view.BuildingInfoManager.d'),('11b765f2-0b7a-4a34-8c16-f9d3f303db5f','MIS',NULL,1,'url(>skin>common/icons.gif) -140px -40px','换表历史记录',1,'43393b38-0dee-4ee2-92ae-4ff69abaa1cf',NULL,'com.pay.view.waterpay.ReplaceWaterMeterHistory.d'),('12af9070-144c-40bf-906c-be395b57c63d','MIS',NULL,1,'url(>skin>common/icons.gif) -300px -60px','抄表数据录入',2,'2ab8d939-e988-4fb2-a5f7-6fd9fffa0df4',NULL,'com.pay.view.waterpay.WaterMeterInput.d'),('14419aee-64fc-4f0c-a33b-a5162c46af39','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','按日汇总',1,'850f1bc7-95c0-4c8d-bbb4-39bf91ff3c91',NULL,'com.pay.view.waterpay.OrderSummaryForDay.d'),('14fd08e9-a149-4faf-87c6-fa1df16cc232','MIS',NULL,1,'url(skin>common/icons.gif) -142px -101px','用户维护',2,'d1880785-0c7d-4efe-86ad-297acf7c2a83',NULL,'bdf2.core.view.user.UserMaintain.d'),('1857dd84-8960-4526-8bc5-64b43fe726bb','MIS',NULL,1,'url(skin>common/icons.gif) -122px -81px','权限下放',5,'root-MIS',NULL,NULL),('1fd21d7d-8ef5-4c4e-b227-50b0e2153b64','MIS',NULL,1,'url(skin>common/icons.gif) -302px -61px','消息模版维护',5,'d1880785-0c7d-4efe-86ad-297acf7c2a83',NULL,'bdf2.core.view.messagetemplate.MessageTemplateMaintain.d'),('258ee9f3-e329-4320-9f9b-6332c8427f7f','MIS',NULL,1,'url(skin>common/icons.gif) -62px -141px','菜单维护',1,'d1880785-0c7d-4efe-86ad-297acf7c2a83',NULL,'bdf2.core.view.url.UrlMaintain.d'),('29623f3a-eeee-438d-b44a-af3bdcade029','MIS',NULL,1,'url(>skin>common/icons.gif) -300px -60px','收费记录',2,'0be2fd1a-6635-4db7-bb6a-24ef79007077',NULL,'com.pay.view.waterpay.PaymentHistory.d'),('29d225eb-8b78-41e8-8f44-f22957bf8e21','MIS',NULL,1,'dorado/res/com/bstek/bdf2/importexcel/view/icons/page_excel.png','导入演示',2,'9c14f169-6016-46e0-9ecc-0d7a2e6c61c2',NULL,'bdf2.importexcel.view.ImportExcel.d'),('2ab8d939-e988-4fb2-a5f7-6fd9fffa0df4','MIS',NULL,1,'url(>skin>common/icons.gif) -300px -60px','水费录入管理',4,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('326a9ff0-8e92-4594-a46d-7e2403c69710','MIS',NULL,1,'url(skin>common/icons.gif) -42px -41px','权限管理',2,'root-MIS',NULL,NULL),('3b3028a7-5a54-4d52-94fe-a7033322f03f','MIS',NULL,1,'url(skin>common/icons.gif) -102px -21px','角色成员维护',4,'326a9ff0-8e92-4594-a46d-7e2403c69710',NULL,'bdf2.core.view.role.member.RoleMemberMaintain.d'),('43393b38-0dee-4ee2-92ae-4ff69abaa1cf','MIS',NULL,1,'url(>skin>common/icons.gif) -120px -40px','历史记录',3,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('46ccbef4-7888-4869-be49-076ade783d4d','MIS',NULL,1,'url(skin>common/icons.gif) -262px -141px','角色成员管理',3,'1857dd84-8960-4526-8bc5-64b43fe726bb',NULL,'bdf2.authoritydelegation.view.role.member.RoleMemberMaintain.d'),('49ad4692-8b68-4549-8453-63946cc71277','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','按月汇总',2,'850f1bc7-95c0-4c8d-bbb4-39bf91ff3c91',NULL,'com.pay.view.waterpay.OrderSummaryForMonthly.d'),('52907b01-fbdc-409a-afa0-dd07942a1536','MIS',NULL,1,'dorado/res/com/bstek/bdf2/dbconsole/view/icons/database_refresh.png','数据库浏览器',1,'9dc7b352-3c32-4a2f-8698-27773583edd4',NULL,'bdf2.dbconsole.view.DbConsoleMaintain.d'),('589bdfa4-ecda-43e6-bfbf-d4537b858fe7','MIS','pricing_type',1,'url(>skin>common/icons.gif) -260px -100px','计价类型',3,'67eb2a59-c3a8-4dff-b41c-1cadd42cd103',NULL,'com.pay.view.PricingTypeManager.d'),('67eb2a59-c3a8-4dff-b41c-1cadd42cd103','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','基础资料管理',1,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('69877390-266e-4f17-ae00-3e98c547620d','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','抄表数据管理',3,'2ab8d939-e988-4fb2-a5f7-6fd9fffa0df4',NULL,'com.pay.view.waterpay.WaterMeterInputManager.d'),('771bd524-4a16-4f38-b8b7-9ec47272807f','MIS',NULL,1,'url(>skin>common/icons.gif) -160px -140px','欠费汇总',3,'850f1bc7-95c0-4c8d-bbb4-39bf91ff3c91',NULL,'com.pay.view.waterpay.ArrearsSummary.d'),('7a0b05e2-e043-458c-ba51-c581ebd38a6a','MIS',NULL,1,'url(skin>common/icons.gif) -101px -121px','群组维护',5,'326a9ff0-8e92-4594-a46d-7e2403c69710',NULL,'bdf2.core.view.group.GroupMaintain.d'),('83ff9581-3ee7-4e02-9854-ab75a8df760e','MIS',NULL,1,'url(>skin>common/icons.gif) -100px -20px','设置',6,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('84588218-459a-4ddb-aad8-be56d37a9b56','MIS','water_meter_user',1,'url(>skin>common/icons.gif) -140px -100px','用户资料',5,'67eb2a59-c3a8-4dff-b41c-1cadd42cd103',NULL,'com.pay.view.UserManager.d'),('84b71b81-e25b-485f-8c14-87b8c49ea053','MIS',NULL,1,'url(skin>common/icons.gif) -102px -21px','导入模板定义',1,'9c14f169-6016-46e0-9ecc-0d7a2e6c61c2',NULL,'bdf2.importexcel.view.ExcelMaintain.d'),('850f1bc7-95c0-4c8d-bbb4-39bf91ff3c91','MIS',NULL,1,'url(>skin>common/icons.gif) -240px -40px','报表',5,'e439fad9-7d6d-4055-93fe-4cd48b8e2a41',NULL,NULL),('9c14f169-6016-46e0-9ecc-0d7a2e6c61c2','MIS',NULL,1,'dorado/res/com/bstek/bdf2/importexcel/view/icons/page_excel.png','Excel导入',5,'root-MIS',NULL,NULL),('9dc7b352-3c32-4a2f-8698-27773583edd4','MIS',NULL,1,'dorado/res/com/bstek/bdf2/dbconsole/view/icons/server_database.png','数据库浏览器',8,'root-MIS',NULL,NULL),('a24fb406-bfb7-40fb-a569-f0e8c06e3d97','MIS','apportion_type',1,'url(>skin>common/icons.gif) -260px -100px','分摊类型',4,'67eb2a59-c3a8-4dff-b41c-1cadd42cd103',NULL,'com.pay.view.ApportionTypeManager.d'),('a8d55c1f-88ee-495b-ac42-6d9cadc96a52','MIS',NULL,1,'url(skin>common/icons.gif) -42px -41px','部门维护',3,'d1880785-0c7d-4efe-86ad-297acf7c2a83',NULL,'bdf2.core.view.dept.DeptMaintain.d'),('b2272aca-e5b3-4c9a-9b1d-e4742f4a3f8c','MIS',NULL,1,'url(skin>common/icons.gif) -181px -41px','组件权限维护',3,'326a9ff0-8e92-4594-a46d-7e2403c69710',NULL,'bdf2.core.view.role.component.RoleComponentMaintain.d'),('b36ded6c-6e0b-45fd-801b-763671a466f4','MIS',NULL,1,'url(skin>common/icons.gif) -262px -41px','岗位维护',4,'d1880785-0c7d-4efe-86ad-297acf7c2a83',NULL,'bdf2.core.view.position.PositionMaintain.d'),('c48f2ead-4067-4a28-a5cc-5be19900d837','MIS',NULL,1,'url(>skin>common/icons.gif) -300px -60px','收费',1,'0be2fd1a-6635-4db7-bb6a-24ef79007077',NULL,'com.pay.view.waterpay.Payment.d'),('c60a6aff-0b3c-4adf-984c-b7cf5c212e06','MIS',NULL,1,'url(>skin>common/icons.gif) -260px -20px','抄表数据初始化',1,'2ab8d939-e988-4fb2-a5f7-6fd9fffa0df4',NULL,'com.pay.view.waterpay.WaterMeterInputDataInit.d'),('cf13e4b8-41dc-4362-a573-45f79d51b1ac','MIS',NULL,1,'url(skin>common/icons.gif) -262px -41px','下放资源管理',1,'1857dd84-8960-4526-8bc5-64b43fe726bb',NULL,'bdf2.authoritydelegation.view.allocation.AllocationMaintain.d'),('d1880785-0c7d-4efe-86ad-297acf7c2a83','MIS',NULL,1,'url(skin>common/icons.gif) -100px -20px','系统默认基本信息维护',1,'root-MIS',NULL,NULL),('df63bcbb-4660-4e15-b594-d1bbb3bcbb53','MIS',NULL,1,'url(skin>common/icons.gif) -242px -141px','角色资源管理',2,'1857dd84-8960-4526-8bc5-64b43fe726bb',NULL,'bdf2.authoritydelegation.view.role.url.RoleUrlMaintain.d'),('e439fad9-7d6d-4055-93fe-4cd48b8e2a41','MIS',NULL,1,'url(>skin>common/icons.gif) -0px -120px','水费管理',2,NULL,NULL,NULL),('f142ed15-0d9c-4c07-adc2-a939cd791fc6','MIS',NULL,1,'url(>skin>common/icons.gif) -260px -60px','顾显屏',1,'83ff9581-3ee7-4e02-9854-ab75a8df760e',NULL,'com.pay.view.global.RxtxTest.d'),('f407a591-beec-4279-9545-23643c03eaf1','MIS',NULL,1,'url(skin>common/icons.gif) -262px -100px','URL权限维护',2,'326a9ff0-8e92-4594-a46d-7e2403c69710',NULL,'bdf2.core.view.role.url.RoleUrlMaintain.d'),('fba0dfa1-996d-43bc-8d77-6685a0d5b8fc','MIS',NULL,1,'url(>skin>common/icons.gif) -260px -40px','分组管理',3,'0be2fd1a-6635-4db7-bb6a-24ef79007077',NULL,'com.pay.view.RoomGroupManager.d'),('root-MIS','MIS',NULL,1,'url(skin>common/icons.gif) -102px -101px','系统管理',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bdf2_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_url_component`
--

DROP TABLE IF EXISTS `bdf2_url_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_url_component` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `AUTHORITY_TYPE_` varchar(10) COLLATE utf8_bin NOT NULL,
  `ROLE_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `URL_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `COMPONENT_ID_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_url_component`
--

LOCK TABLES `bdf2_url_component` WRITE;
/*!40000 ALTER TABLE `bdf2_url_component` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_url_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_user`
--

DROP TABLE IF EXISTS `bdf2_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_user` (
  `USERNAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  `ADDRESS_` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `ADMINISTRATOR_` tinyint(1) NOT NULL,
  `BIRTHDAY_` datetime DEFAULT NULL,
  `CNAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  `COMPANY_ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `CREATE_DATE_` datetime DEFAULT NULL,
  `EMAIL_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `ENABLED_` tinyint(1) NOT NULL,
  `ENAME_` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `MALE_` tinyint(1) NOT NULL,
  `MOBILE_` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` varchar(70) COLLATE utf8_bin NOT NULL,
  `SALT_` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`USERNAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_user`
--

LOCK TABLES `bdf2_user` WRITE;
/*!40000 ALTER TABLE `bdf2_user` DISABLE KEYS */;
INSERT INTO `bdf2_user` VALUES ('marchi',NULL,1,NULL,'系统管理员','MIS',NULL,'xxxx@xxxx.com',1,'Marchi',1,'18917888888','91f6a73cf60832c4dcc923fd8bb5ce31f857c4cc','599'),('tiger',NULL,1,NULL,'系统管理员','MIS',NULL,'78754534@qq.com',1,'Tiger',1,'15820288888','f098e0a3cca25db1b3825511962e171c44a73e81','19');
/*!40000 ALTER TABLE `bdf2_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_user_dept`
--

DROP TABLE IF EXISTS `bdf2_user_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_user_dept` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `DEPT_ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `USERNAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_user_dept`
--

LOCK TABLES `bdf2_user_dept` WRITE;
/*!40000 ALTER TABLE `bdf2_user_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_user_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bdf2_user_position`
--

DROP TABLE IF EXISTS `bdf2_user_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bdf2_user_position` (
  `ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `POSITION_ID_` varchar(60) COLLATE utf8_bin NOT NULL,
  `USERNAME_` varchar(60) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bdf2_user_position`
--

LOCK TABLES `bdf2_user_position` WRITE;
/*!40000 ALTER TABLE `bdf2_user_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `bdf2_user_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_apportion_type`
--

DROP TABLE IF EXISTS `pay_apportion_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_apportion_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apportion_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `percent` decimal(11,2) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_apportion_type`
--

LOCK TABLES `pay_apportion_type` WRITE;
/*!40000 ALTER TABLE `pay_apportion_type` DISABLE KEYS */;
INSERT INTO `pay_apportion_type` VALUES (1,'居民',0.10,'自用','marchi','2017-10-11 06:12:38.461000',NULL,NULL),(2,'其它',0.20,NULL,'marchi','2017-10-11 09:47:01.526000',NULL,NULL),(3,'租客',0.20,'备注','marchi','2017-10-20 07:43:52.785000',NULL,NULL);
/*!40000 ALTER TABLE `pay_apportion_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_building_detail`
--

DROP TABLE IF EXISTS `pay_building_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_building_detail` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `room_no` varchar(45) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `water_meter_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `monthly_qty` decimal(11,2) DEFAULT NULL,
  `apportion_type_id` int(11) DEFAULT NULL,
  `pricing_type_id` int(11) DEFAULT NULL,
  `contractor_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`,`room_no`),
  UNIQUE KEY `IDX_WMC` (`water_meter_code`,`code`,`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_building_detail`
--

LOCK TABLES `pay_building_detail` WRITE;
/*!40000 ALTER TABLE `pay_building_detail` DISABLE KEYS */;
INSERT INTO `pay_building_detail` VALUES ('1','101','7','10101',NULL,1,5,'6',1,NULL,0,'marchi','2017-10-31 10:23:46','marchi','2018-03-24 07:55:13'),('1','102','7','10102',60.00,1,1,'7',1,NULL,1,'marchi','2017-10-31 10:24:30',NULL,NULL),('1','104','阿什顿发','10346',NULL,2,5,'阿什顿发',1,NULL,0,'marchi','2018-04-13 10:38:30',NULL,NULL),('10','101','8','10103',35.00,3,2,'8',1,NULL,1,'marchi','2017-10-31 10:25:08',NULL,NULL),('10','102','9','10104',40.00,3,2,'9',1,NULL,1,'marchi','2017-10-31 10:25:48',NULL,NULL);
/*!40000 ALTER TABLE `pay_building_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_building_info`
--

DROP TABLE IF EXISTS `pay_building_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_building_info` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `housemaster` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `addr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_building_info`
--

LOCK TABLES `pay_building_info` WRITE;
/*!40000 ALTER TABLE `pay_building_info` DISABLE KEYS */;
INSERT INTO `pay_building_info` VALUES ('1','邱丹凤','13672489709','同和白水塘西横一路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('10','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('100','邱红娣','13808812461','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('101','叶新彩','13535371063','同和白水塘北街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('10123','泰',NULL,'大发发大水',NULL,1,'marchi','2018-02-05 09:13:37.768000',NULL,NULL),('102','邱炳林','13539836518','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('103','邱彦君','13352885456','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('104','邱新娣','13310897189','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('105','邱峙昊','13416298188','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('106','邱剑芳','13318740273','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('107','叶彩平','13539955511','同和白水塘北街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('108','邱宏彬、邱润才','13503022544、15800224099','同和白水塘北街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('109','邱秋兰、邱志有、邱新莲','13500036211','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('11','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('110','杨桂清','15913188830','同和白水塘北街四巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('111','邱志毅、邱志刚','13609048122、13802774580','同和白水塘北街四巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('112','邱东海','37378620','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('113','邱秋连','18054206673','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('114','邱志伟','13424471661','同和蟾蜍石北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('115','魏润娣','18028531467','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('116','邱福全','13676259190','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('117','叶彩有','13676259190','同和蟾蜍石北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('118','杨润娣','13416352588','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('119','叶彩有','13570360604','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('12','邱国良','13902253214','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('120','杨容','15913188830','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('121','邱丽梅','13725156811','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('122','邱新娣、邱国强','13310897189','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('123','邱志伟','13424471660','同和蟾蜍石北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('124','邱卫东','13710602388','同和白水塘西路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('125','邱超洪','13609014988','同和白水塘西路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('126','邱银娣','15918837769','同和白水塘西路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('127','经济社','37356041','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('128','经济社','37356041','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('129','经济社','37356041','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('13','邱润有','13538878048','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('130','经济社','37356041','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('131','经济社','37356041','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('132','经济社','37356041','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('133','杨建成','15820205714','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('134','杨灶田','13688873992','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('135','杨灶田','13688873992','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('136','邱炳华','37373781','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('137','邱炳华','37373781','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('138','邱为民','13318832880','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('139','邱为民','13318832880','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('14','经济社','37356041','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('140','何桂英','13676259190','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('141','叶润才','13802431332','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('142','邱建威、邱润平','13724041933','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('143','邱润平','13794326313','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('144','邱建良','13725229283','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('145','邱建年','13535012562','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('146','邱建威','13724041933','白水塘南路',' ',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('147','邱建威','13724041933','白水塘南路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('148','邱海峰','13808896990','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('149','邱国强','13802949132','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('15','经济社','37356041','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('150','邱国强','13802949132','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('151','邱记容','13719005556','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('152','邱志文','18011871331','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('153','杨月清','13432001730','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('154','杨春带','13928913553','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('155','杨春带','13928913553','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('156','杨春带','13928913553','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('157','杨志仁','13503047290','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('158','杨志仁','13503047290','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('159','杨志仁','13503047290','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('16','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('160','杨志雄','18927594572','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('161','杨志强','13802925489','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('162','杨月清、杨桂清','13432001730、15913188830','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('163','杨桂清','15913188830','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('164','','','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('165','杨桂清','15913188830','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('166','杨润年、杨国其、杨天生、  杨建成、杨水金','13710387921、13538981238、18922408771、15820205714、13533223000','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('167','杨润年、杨国其、杨天生、  杨建成、杨水金','13710387921、13538981238、18922408771、15820205714、13533223000','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('168','杨国其、杨桂娇、杨桂英','13538981238','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('169','杨桂有','13538885238','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('17','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('170','杨天生、杨国其、杨桂娇、杨桂英','18922408771、13538981238','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('171','杨天生、杨国其、杨桂娇、杨桂英','18922408771、13538981238','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('172','杨建成','15820205714','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('173','杨建成、杨天生','15820205714、18922408771','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('174','叶淑娣','13825197806','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('175','杨桂娣、杨桂梅、杨桂珍、杨润年','13533551430、13602824403、13660841212、13332834770','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('176','杨桂娣、杨桂梅、杨桂珍、杨润年','13533551430、13602824403、13660841212、13332834770','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('177','杨银英','13925136968','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('178','杨桂有','13538885238','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('179','杨桂有','13538885238','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('18','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('180','杨建成','15820205714','同和白水塘南一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('181','杨天生','18922408771','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('182','杨桂珍、徐伙连','13660841212、13332834770','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('183','杨贵明','13688873992','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('184','杨灶田','13688873992','同和白水塘南街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('185','杨灶田','13688873992','同和白水塘南街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('186','叶镜钦','15360537336','同和白水塘南街',' ',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('187','叶镜钦','15360537336','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('188','高来娣','15360537336','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('189','叶春好','13697457055','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('19','钟秀芳','13809246433','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('190','叶耀方','13711277335','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('191','叶耀文','15112009566','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('192','叶九仔','13432028399','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('193','徐庚娇','13432028399','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('194','叶天河','13602732818','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('195','叶柏如','13538799902','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('196','叶伟中、叶伟光、叶卓峰','13802958100、13710383190、13538799906','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('197','叶桂明、叶振华','13600050041','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('198','叶润添','13538717408','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('199','叶耀方','13711277335','同和白水塘南街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('2','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('20','叶润生','13802993240','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('200','','','同和白水塘南街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('201','杨光明','13538781588','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('202','叶天河','13902286810','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('203','叶伟中','13802958100','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('204','叶柏如','13763338871','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('205','叶九仔','13432028399','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('206','叶天才','18011701533','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('207','叶天才','18011701533','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('208','叶天河','13602732818','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('209','叶珠','13711632353','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('21','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('210','叶珠','13711632353','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('211','叶远东','13826287129','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('212','叶玉琼','13533846822','同和白水塘南二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('213','叶润福','13808812461','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('214','叶润生','13802993240','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('215','叶桂清','13503028410','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('216','杨志仁','13503047290','同和白水塘南街一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('217','叶水荣','15914216873','同和白水塘南街一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('218','叶智恒、叶宇明、叶文锋','15914216873','同和白水塘南街一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('219','杨志强','13533663690','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('22','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('220','杨秀英','13048015606','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('221','杨秀英','13048015606','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('222','杨凤连','13640721309','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('223','杨凤连','13533663690','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('224','张素娴','13503028410','同和白水塘南街一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('225','杨凤英','13640721309','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('226','杨国红','13433914596','同和白水塘南街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('227','叶柏如','13538799906','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('228','叶桂兰','15814871173','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('229','叶珠','13711632353','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('23','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('230','叶珠','13711632353','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('231','叶珠','13711632353','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('232','叶润添','13538718408','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('233','叶润添','13538717408','同和白水塘南街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('234','叶伟明','13609771668','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('235','叶记棠','15013364023','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('236','叶记棠','15013364023','同和白水塘南街三巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('237','叶记棠','15013364023','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('238','叶彩文','13688878823','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('239','叶文英','18666623203','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('24','经济社','37356041','同和白水塘西横二路','怡美',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('240','叶文英','18666623203','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('241','叶文英','18666623203','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('242','叶细妹','18826092319','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('243','叶细妹','18826092319','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('244','叶秋桂','13423672323','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('245','叶秋桂','13423672323','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('246','叶秋桂','13423672323','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('247','叶润才','13802431332','同和白水塘南街三巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('248','叶润添','13538717408','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('249','叶九春','13622231067','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('25','经济社','37356041','同和白水塘西横二路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('250','叶九春','13622231067','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('251','叶九春','13622231067','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('252','叶永忠、叶桂清、叶金才','13798011203、13503028410','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('253','叶银英','13724074281','同和白水塘南街三巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('254','叶银英','13724074281','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('255','叶润连','13544367455','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('256','魏志明','13710386681','同和白水塘东街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('257','魏志明','13710386681','同和白水塘东街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('258','魏志明','13710386681','同和白水塘东街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('259','魏志明','13802506823','同和白水塘东街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('26','邱仕奀','18011871331','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('260','邱水金','18922755493','同和白水塘东街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('261','吴二妹','18925111087','同和白水塘东街二巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('262','吴永忠','13711150866','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('263','邱润林','13538955184','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('264','邱记润','13527868038','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('265','邱胜锋','13902221407','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('266','邱维有','13602721268','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('267','邱维有','13602721268','同和白水塘东街二巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('268','邱炳桂','13719333392','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('269','邱炳桂','13719333392','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('27','邱永东、邱国强','13570122223、13802949132','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('270','邱素容','13500002685','同和白水塘东街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('271','邱东娣','13711649893','同和白水塘东街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('272','邱瑞连','13794323716','同和白水塘东街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('273','邱春梅','13726708930','同和白水塘东街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('274','杨月清','13432001730','同和白水塘东街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('275','邱春红','13119539282','同和白水塘东街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('276','杨燕婷','13129315227','同和白水塘东街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('277','邱国良','13902253214','同和白水塘东街四巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('278','邱玉珍','18922253106','同和白水塘东街四巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('279','杨志雄','18927594572','同和白水塘东街四巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('28','邱永东','13570122223','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('280','叶秋桂','13423672323','同和白水塘东街五巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('281','张善忠','13662424639','同和白水塘东街五巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('282','邱彩英、许卫林','18922755493、13711211320','同和白水塘东街五巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('283','邱新莲','13640843256','同和白水塘东街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('284','邹洁成','13503052299','同和白水塘东街六巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('285','邱容带','13711591028','同和白水塘东街六巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('286','叶秋桂','13423672323','同和白水塘东街六巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('287','韩冬梅','13719005556','同和白水塘东街六巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('288','邱俊武','13503033073','同和白水塘东街六巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('289','邱俊武','13503033073','同和白水塘东街六巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('29','邱润贵','15915975628','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('290','邱炳桂、邱记长',' ','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('291','邱润有','13538878048','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('292','杨志强','13802925489','同和蟾蜍石北街一巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('293','邱福全','13676259190','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('294','吴永洪','13711150866','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('295','邱树森','13076824208','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('296','邱国华','13725288866','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('297','邱威利','13711762297','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('298','邱威利','13711762297','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('299','宋旭群','13710387939','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('3','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('30','邱润贵','15915975628','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('300','宋日群','13719237701','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('301','邱美礼','13802530933','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('302','邱美礼','13802530933','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('303','杨志华','13710387921','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('304','杨志坚','13332834770','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('305','杨志华','13710387921','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('306','杨志坚','13332834770','同和蟾蜍石北街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('307','邱志强','13726798601','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('308','邱记旺','15915975628','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('309','朱婉娟','15915975628','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('31','邱伯就、邱国强、曾秀群','13711799949、13802949132、15975371716','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('310','朱婉娟','15915975628','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('311','朱婉娟','15915975628','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('312','宋旭群','13710387939','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('313','宋旭群','13710387939','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('314','邱润金','13724862882','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('315','邱年胜','13724094893','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('316','邱福安','13902221407','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('317','邱记润','13527868038','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('318','邱美礼','13802530933','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('319','邱开华','15913161255','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('32','邱伯就、邱国强、曾秀群','13711799949、13802949132、15975371716','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('320','邱记润、邱福安','13527868038、13902221407','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('321','邱松','15913161255','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('322','邱松','15913161255','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('323','邱年胜','13724094893','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('324','邱全','13719083796','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('325','邱春连','13138688625','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('326','邱信有','18925111087','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('327','吴记胜','13710362283','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('328','邱秋兰','13640843263','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('329','邱水连','37358961','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('33','邱卫东','13710602388','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('330','邱水连','37358961','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('331','邝丽娟','37358961','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('332','邱海明','37358961','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('333','何玉连','13711478125','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('334','徐木娣','13729851182','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('335','邱金胜','13729851182','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('336','邱年英','13650603521','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('337','邱年英','13650603521','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('338','邱水金','13609003861','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('339','邱水金、邱一春、邱永强','18922755493','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('34','邱金华','13711762297','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('340','魏牛仔','13710386681','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('341','邱润胜','13411174422','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('342','邱润才','15800224099','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('343','邱记连','13660590549','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('344','邱记连','13660590549','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('345','邱国强、邱志伟','13392464628、13424471660','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('346','邱连新','13609714213','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('347','邱连新','13609714213','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('348','邱连新','13609714213','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('349','邱连新','13609714213','同和白水塘中街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('35','邱国华','13725288866','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('350','邱金全','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('351','邱金全','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('352','邱金全','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('353','邱金全','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('354','邱金全','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('355','杨桂珍','13660841212','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('356','杨桂珍','13660841212','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('357','邱记连','13660590549','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('358','邱记连','13660590549','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('359','邱少阳','13824481010','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('36','邱志辉、邱永强、邱秀珍、  邱志文、邱国华','13602719873、18922755493、13302498148、18011871381、13725288866','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('360','邱志辉','13602719873','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('361','邱彩霞','13725428218','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('362','邱彩霞','13725428218','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('363','邱永红','13622283339','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('364','邱银英','13642643202','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('365','邱元娣','37373867','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('366','邱元娣','37373867','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('367','陈绍凤','15818809125','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('368','邝丽娟（五楼）、邱丽娟','37358961、13725156811','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('369','邱少波','15915973071','同和白水塘中街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('37','叶晋良','13660210129','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('370','杨添娣','13500036211','同和白水塘中街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('371','杨添娣','13500036211','同和白水塘中街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('372','杨蛇妹','13602721668','同和白水塘中街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('373','邱东林','13602721668','同和白水塘中街二巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('374','邱东泉','15360068237','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('375','邱九根、邱东泉、邱美礼','13006882328、15360068237、13802530933','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('376','邱九根','13006882328','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('377','邱九根','13006882328','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('378','邱水金','13903066522','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('379','邱水金','13903066522','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('38','邱全','13809246433','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('380','邱水金','13903066522','同和白水塘中街一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('381','邱国强','13802949132','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('382','邱秋霞','18022326189','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('383','邱秋霞','18022326189','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('384','邱秋霞','18022326189','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('385','邱少波','15915973071','同和蟾蜍石北巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('386','邱志刚','13802774580','同和蟾蜍石北巷','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('387','邱好','13826021588','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('388','杨佩玲','13533223000','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('389','邱彩红','18922334537','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('39','邱水清、邱水、邱炳坤、邝丽娟、邱东海、邱玉玲','13416298188、13535012562、37358961、37358961、37378620、13719083796','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('390','邱群英、邱华英','37358961','同和蟾蜍石北巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('391','叶九春','13622231067','同和白水塘南街三巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('392','杨建娣','13539921164','同和白水塘南一巷','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('4','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('40','邱水清、邱水、邱炳坤、邝丽娟、邱东海、邱玉玲','13416298188、13535012562、37358961、37358961、37378620、13719083796','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('41','邱春生','13527854730','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('42','邱润林','13538955184','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('43','邱全','18922253106','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('44','邱润有','13538878048','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('45','邱润有','13538878048','白水塘西街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('458','邱瑞平','13556155622','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('46','雷淑贤','13503022544','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('47','邱春生','13527854730','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('48','邱春生','13527854730','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('49','','','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('5','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('50','邱润贵','13672489709','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('506','邱炳林','13539836518','同和白水塘中街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('51','邱丹凤','13672489709','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('52','经济社','37356041','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('53','经济社','37356041','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('54','邱峙延','13926192818','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('55','邱水清','13416298188','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('56','邱记润','13527868038','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('57','邱记润','13527868038','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('58','邓璐','13527868038','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('59','邱浩锐','13602721668','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('6','经济社','37356041','同和白水塘西横二路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('60','邱浩锐','13602721668','白水塘西街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('61','邱添发','13809246433','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('62','邱添发','13809246433','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('63','邱记华','13119539282','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('64','邱记华','13119539282','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('65','邱东林','13602721668','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('66','邱东林','13602721668','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('67','邱记华','13119539282','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('68','邱东洪','13022022799','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('69','何华玲','','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('7','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('70','邱丽梅、邱东海','13725156811、18922478629','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('71','邱记长','18927553603','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('72','','','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('73','邱炳桂','13719333392','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('74','邱明德','13622839743','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('75','邱明光','13825019070','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('76','邱明光','13825019070','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('77','邱少根','13724092218','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('78','邱少根','13622822684','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('79','邱少根、邱瑞平','13622822684、13556155622','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('8','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('80','邱锦松','13922268694','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('81','邱丽梅','13725156811','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('82','邱子文','13719249673','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('83','邱子良','13119539282','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('84','邱子良','13119539282','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('85','邱记华','13119539282','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('86','宋三英','15915973071','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('87','李五妹','13539836518','白水塘北路','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('88','邱炳林','13539836518','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('89','邱炳辉','13660081801','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('9','经济社','37356041','同和白水塘西横一路','怡兴',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('90','邱炳桂','13719333392','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('91','邱明光','13825019070','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('92','邱明华','18122782708','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('93','邱明华','18666022346','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('94','邱春杰','13724092218','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('95','邱春杰','13724092218','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('96','邱瑞雄','13922268694','白水塘北路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('97','叶润福','13808812461','同和白水塘北街','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('98','经济社','37356041','同和白水塘北街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('99','经济社','37356041','同和白水塘北街','合资',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL),('999','与南二巷2号','','白水塘南路','',1,'sys','2017-10-30 08:49:27.000000',NULL,NULL);
/*!40000 ALTER TABLE `pay_building_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_building_info_backup`
--

DROP TABLE IF EXISTS `pay_building_info_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_building_info_backup` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `doorplate` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `housemaster` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `id_no` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nature` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `addr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_building_info_backup`
--

LOCK TABLES `pay_building_info_backup` WRITE;
/*!40000 ALTER TABLE `pay_building_info_backup` DISABLE KEYS */;
INSERT INTO `pay_building_info_backup` VALUES ('1','同和白水塘西横一路','1号',7,'邱丹凤','13672489709','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('10','同和白水塘西横一路','6号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('100','同和白水塘北街','07号',7,'邱红娣','13808812461','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('101','同和白水塘北街','09号',7,'叶新彩','13535371063','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('102','同和白水塘北街','04号',9,'邱炳林','13539836518','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('103','同和白水塘北街','06号',7,'邱彦君','13352885456','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('104','同和白水塘北街','08号',7,'邱新娣','13310897189','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('105','同和白水塘北街','10号',7,'邱峙昊','13416298188','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('106','同和白水塘北街','12号',7,'邱剑芳','13318740273','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('107','同和白水塘北街三巷','04号',7,'叶彩平','13539955511','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('108','同和白水塘北街三巷','02号',7,'邱宏彬、邱润才','13503022544、15800224099','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('109','同和白水塘北街','19号',7,'邱秋兰、邱志有、邱新莲','13500036211','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('11','同和白水塘西横一路','8号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('110','同和白水塘北街四巷','03号',7,'杨桂清','15913188830','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('111','同和白水塘北街四巷','01号',7,'邱志毅、邱志刚','13609048122、13802774580','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('112','同和白水塘北街','21号',8,'邱东海','37378620','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('113','同和蟾蜍石北路','45号',6,'邱秋连','18054206673','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('114','同和蟾蜍石北路','49号',6,'邱志伟','13424471661','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('115','同和蟾蜍石北路','51号',6,'魏润娣','18028531467','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('116','同和蟾蜍石北路','57号',6,'邱福全','13676259190','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('117','同和蟾蜍石北路','59号',6,'叶彩有','13676259190','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('118','同和蟾蜍石北路','61号',6,'杨润娣','13416352588','0037622','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('119','同和蟾蜍石北路','63号',5,'叶彩有','13570360604','0037664','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('12','同和白水塘西横二路','02号',0,'邱国良','13902253214','0043547','',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('120','同和蟾蜍石北路','65号',7,'杨容','15913188830','0037669','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('121','同和蟾蜍石北路','55号',7,'邱丽梅','13725156811','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('122','同和蟾蜍石北路','53号',6,'邱新娣、邱国强','13310897189','0037699','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('123','同和蟾蜍石北路','47号',7,'邱志伟','13424471660','0037649','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('124','同和白水塘西路','04号',7,'邱卫东','13710602388','0043582','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('125','同和白水塘西路','02号之一',7,'邱超洪','13609014988','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('126','同和白水塘西路','02号',7,'邱银娣','15918837769','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('127','白水塘南路','02号之一',2,'经济社','37356041','','电房',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('128','白水塘南路','02号',7,'经济社','37356041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('129','白水塘南路','04号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('13','同和白水塘西横二路','04号',7,'邱润有','13538878048','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('130','白水塘南路','06号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('131','白水塘南路','08号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('132','白水塘南路','08号之一',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('133','白水塘南路','10号',6,'杨建成','15820205714','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('134','白水塘南路','12号',7,'杨灶田','13688873992','0037668','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('135','白水塘南路','14号',6,'杨灶田','13688873992','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('136','白水塘南路','18号',6,'邱炳华','37373781','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('137','白水塘南路','20号',7,'邱炳华','37373781','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('138','白水塘南路','22号',6,'邱为民','13318832880','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('139','白水塘南路','24号',4,'邱为民','13318832880','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('14','同和白水塘西横二路','06号之三',1,'经济社','37356041','','水房',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('140','白水塘南路','26号',6,'何桂英','13676259190','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('141','同和白水塘南二巷','02号',7,'叶润才','13802431332','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('142','白水塘南路','17号',6,'邱建威、邱润平','13724041933','0037689','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('143','白水塘南路','15号',6,'邱润平','13794326313','0037644','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('144','白水塘南路','13号',7,'邱建良','13725229283','0037601','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('145','白水塘南路','11号',7,'邱建年','13535012562','0037645','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('146','白水塘南路','09号',7,'邱建威','13724041933','','住宅',NULL,' ',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('147','白水塘南路','09号之一',7,'邱建威','13724041933','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('148','白水塘南路','07号',8,'邱海峰','13808896990','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('149','白水塘南路','05号',8,'邱国强','13802949132','0043438','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('15','同和白水塘西横二路','06号之一',7,'经济社','37356041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('150','白水塘南路','05号之二',1,'邱国强','13802949132','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('151','白水塘南路','03号',7,'邱记容','13719005556','0037725','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('152','白水塘南路','01号',6,'邱志文','18011871331','0043339','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('153','同和白水塘南一巷','01号',6,'杨月清','13432001730','37687','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('154','同和白水塘南一巷','07号之一',1,'杨春带','13928913553','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('155','同和白水塘南一巷','07号',6,'杨春带','13928913553','37734','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('156','同和白水塘南一巷','05号',6,'杨春带','13928913553','37733','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('157','同和白水塘南一巷','09号',7,'杨志仁','13503047290','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('158','同和白水塘南一巷','09号之一',5,'杨志仁','13503047290','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('159','同和白水塘南一巷','03号',6,'杨志仁','13503047290','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('16','同和白水塘西横二路','01号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('160','同和白水塘南一巷','03号之一',6,'杨志雄','18927594572','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('161','同和白水塘南一巷','03号之二',6,'杨志强','13802925489','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('162','同和白水塘南一巷','13号',7,'杨月清、杨桂清','13432001730、15913188830','0037671.0037672','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('163','同和白水塘南一巷','11号',7,'杨桂清','15913188830','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('164','同和白水塘南一巷','15号之一',1,'','','','杨氏宗祠',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('165','同和白水塘南一巷','15号',7,'杨桂清','15913188830','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('166','同和白水塘南一巷','17号',6,'杨润年、杨国其、杨天生、  杨建成、杨水金','13710387921、13538981238、18922408771、15820205714、13533223000','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('167','同和白水塘南一巷','19号',7,'杨润年、杨国其、杨天生、  杨建成、杨水金','13710387921、13538981238、18922408771、15820205714、13533223000','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('168','同和白水塘南一巷','23号',7,'杨国其、杨桂娇、杨桂英','13538981238','37690','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('169','同和白水塘南一巷','21号',6,'杨桂有','13538885238','37663','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('17','同和白水塘西横二路','03号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('170','同和白水塘南一巷','29号',7,'杨天生、杨国其、杨桂娇、杨桂英','18922408771、13538981238','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('171','同和白水塘南一巷','29号之一',7,'杨天生、杨国其、杨桂娇、杨桂英','18922408771、13538981238','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('172','同和白水塘南一巷','25号',7,'杨建成','15820205714','37682','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('173','同和白水塘南一巷','27号',6,'杨建成、杨天生','15820205714、18922408771','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('174','同和白水塘南一巷','31号',6,'叶淑娣','13825197806','37656','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('175','同和白水塘南一巷','33号之一',7,'杨桂娣、杨桂梅、杨桂珍、杨润年','13533551430、13602824403、13660841212、13332834770','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('176','同和白水塘南一巷','33号',6,'杨桂娣、杨桂梅、杨桂珍、杨润年','13533551430、13602824403、13660841212、13332834770','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('177','同和白水塘南一巷','35号',8,'杨银英','13925136968','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('178','同和白水塘南一巷','02号之一',7,'杨桂有','13538885238','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('179','同和白水塘南一巷','02号',6,'杨桂有','13538885238','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('18','同和白水塘西横二路','05号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('180','同和白水塘南一巷','04号',6,'杨建成','15820205714','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('181','同和白水塘南一巷','06号',6,'杨天生','18922408771','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('182','同和白水塘南一巷','08号',7,'杨桂珍、徐伙连','13660841212、13332834770','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('183','同和白水塘南一巷','10号',6,'杨贵明','13688873992','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('184','同和白水塘南街','02号',7,'杨灶田','13688873992','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('185','同和白水塘南街','04号',7,'杨灶田','13688873992','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('186','同和白水塘南街','01号',7,'叶镜钦','15360537336','37660','住宅',NULL,' ',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('187','同和白水塘南街','03号',6,'叶镜钦','15360537336','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('188','同和白水塘南街','05号',7,'高来娣','15360537336','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('189','同和白水塘南街','09号',7,'叶春好','13697457055','43338','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('19','同和白水塘西横二路','06号',7,'钟秀芳','13809246433','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('190','同和白水塘南街','08号',6,'叶耀方','13711277335','43294','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('191','同和白水塘南街','11号',6,'叶耀文','15112009566','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('192','同和白水塘南街','13号之一',7,'叶九仔','13432028399','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('193','同和白水塘南街','13号',7,'徐庚娇','13432028399','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('194','同和白水塘南街','15号',7,'叶天河','13602732818','37694','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('195','同和白水塘南街','17号',7,'叶柏如','13538799902','37627','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('196','同和白水塘南街','10号',6,'叶伟中、叶伟光、叶卓峰','13802958100、13710383190、13538799906','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('197','同和白水塘南街','10号之一',6,'叶桂明、叶振华','13600050041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('198','同和白水塘南街','10号之二',6,'叶润添','13538717408','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('199','同和白水塘南街','06号',4,'叶耀方','13711277335','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('2','同和白水塘西横一路','3号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('20','同和白水塘西横二路','08号',7,'叶润生','13802993240','0043863','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('200','同和白水塘南街','06号之一',1,'','','','叶氏宗祠',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('201','同和白水塘南二巷','01号',6,'杨光明','13538781588','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('202','同和白水塘南二巷','03号',7,'叶天河','13902286810','37693','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('203','同和白水塘南二巷','04号',6,'叶伟中','13802958100','37700','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('204','同和白水塘南二巷','05号',7,'叶柏如','13763338871','37717','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('205','同和白水塘南二巷','06号',7,'叶九仔','13432028399','37678','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('206','同和白水塘南二巷','08号',4,'叶天才','18011701533','37713','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('207','同和白水塘南二巷','08号之一',7,'叶天才','18011701533','37713','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('208','同和白水塘南二巷','07号',5,'叶天河','13602732818','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('209','同和白水塘南二巷','10号之一',6,'叶珠','13711632353','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('21','同和白水塘西横二路','10号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('210','同和白水塘南二巷','10号',6,'叶珠','13711632353','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('211','同和白水塘南二巷','09号',6,'叶远东','13826287129','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('212','同和白水塘南二巷','11号',5,'叶玉琼','13533846822','43337','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('213','同和白水塘南街一巷','01号',7,'叶润福','13808812461','37629','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('214','同和白水塘南街一巷','03号',7,'叶润生','13802993240','37611','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('215','同和白水塘南街一巷','02号',6,'叶桂清','13503028410','37673','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('216','同和白水塘南街一巷','07号',6,'杨志仁','13503047290','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('217','同和白水塘南街一巷','05号',6,'叶水荣','15914216873','37665','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('218','同和白水塘南街一巷','04号',6,'叶智恒、叶宇明、叶文锋','15914216873','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('219','同和白水塘南街一巷','06号',6,'杨志强','13533663690','37711','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('22','同和白水塘西横二路','12号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('220','同和白水塘南街一巷','15号之一',7,'杨秀英','13048015606','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('221','同和白水塘南街一巷','15号',6,'杨秀英','13048015606','37623','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('222','同和白水塘南街一巷','11号之一',1,'杨凤连','13640721309','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('223','同和白水塘南街一巷','11号',4,'杨凤连','13533663690','37710','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('224','同和白水塘南街一巷','09号',6,'张素娴','13503028410','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('225','同和白水塘南街一巷','08号',5,'杨凤英','13640721309','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('226','同和白水塘南街一巷','13号',7,'杨国红','13433914596','37722','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('227','同和白水塘南街二巷','01号',6,'叶柏如','13538799906','37626','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('228','同和白水塘南街二巷','05号',6,'叶桂兰','15814871173','43297','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('229','同和白水塘南街二巷','03号',7,'叶珠','13711632353','37607','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('23','同和白水塘西横二路','14号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('230','同和白水塘南街二巷','03号之一',6,'叶珠','13711632353','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('231','同和白水塘南街二巷','03号之二',6,'叶珠','13711632353','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('232','同和白水塘南街二巷','02号',6,'叶润添','13538718408','37666','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('233','同和白水塘南街二巷','06号',6,'叶润添','13538717408','37667','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('234','同和白水塘南街三巷','02号',7,'叶伟明','13609771668','43953','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('235','同和白水塘南街三巷','06号',6,'叶记棠','15013364023','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('236','同和白水塘南街三巷','04号之一',5,'叶记棠','15013364023','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('237','同和白水塘南街三巷','04号',7,'叶记棠','15013364023','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('238','同和白水塘南街三巷','08号',4,'叶彩文','13688878823','37732','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('239','同和白水塘南街三巷','12号',6,'叶文英','18666623203','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('24','同和白水塘西横二路','16号',7,'经济社','37356041','','住宅',NULL,'怡美',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('240','同和白水塘南街三巷','12号之一',6,'叶文英','18666623203','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('241','同和白水塘南街三巷','10号',6,'叶文英','18666623203','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('242','同和白水塘南街三巷','14号',7,'叶细妹','18826092319','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('243','同和白水塘南街三巷','14号之一',7,'叶细妹','18826092319','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('244','同和白水塘南街三巷','18号',6,'叶秋桂','13423672323','37643','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('245','同和白水塘南街三巷','16号',6,'叶秋桂','13423672323','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('246','同和白水塘南街三巷','16号之一',5,'叶秋桂','13423672323','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('247','同和白水塘南街三巷','20号',6,'叶润才','13802431332','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('248','同和白水塘南街三巷','01号',6,'叶润添','13538717408','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('249','同和白水塘南街三巷','09号',6,'叶九春','13622231067','37692','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('25','同和白水塘西横二路','07号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('250','同和白水塘南街三巷','11号',7,'叶九春','13622231067','37692','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('251','同和白水塘南街三巷','13号',6,'叶九春','13622231067','37691','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('252','同和白水塘南街三巷','03号',8,'叶永忠、叶桂清、叶金才','13798011203、13503028410','37715','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('253','同和白水塘南街三巷','05号',5,'叶银英','13724074281','37705','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('254','同和白水塘南街三巷','05号之一',6,'叶银英','13724074281','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('255','同和白水塘南街三巷','01号之一',4,'叶润连','13544367455','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('256','同和白水塘东街','01号',6,'魏志明','13710386681','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('257','同和白水塘东街','03号',6,'魏志明','13710386681','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('258','同和白水塘东街','05号',7,'魏志明','13710386681','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('259','同和白水塘东街','07号',6,'魏志明','13802506823','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('26','白水塘西街','01号',7,'邱仕奀','18011871331','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('260','同和白水塘东街','02号',7,'邱水金','18922755493','37602','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('261','同和白水塘东街二巷','02号',6,'吴二妹','18925111087','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('262','同和白水塘东街二巷','04号',6,'吴永忠','13711150866','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('263','同和白水塘东街二巷','06号',7,'邱润林','13538955184','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('264','同和白水塘东街二巷','08号',7,'邱记润','13527868038','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('265','同和白水塘东街二巷','09号',6,'邱胜锋','13902221407','37603','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('266','同和白水塘东街二巷','07号',6,'邱维有','13602721268','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('267','同和白水塘东街二巷','05号',6,'邱维有','13602721268','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('268','同和白水塘东街二巷','03号之一',7,'邱炳桂','13719333392','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('269','同和白水塘东街二巷','03号',7,'邱炳桂','13719333392','43748','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('27','白水塘西街','03号',7,'邱永东、邱国强','13570122223、13802949132','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('270','同和白水塘东街二巷','01号',6,'邱素容','13500002685','43295','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('271','同和白水塘东街','09号',6,'邱东娣','13711649893','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('272','同和白水塘东街一巷','01号',6,'邱瑞连','13794323716','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('273','同和白水塘东街一巷','02号',6,'邱春梅','13726708930','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('274','同和白水塘东街三巷','03号',5,'杨月清','13432001730','37648','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('275','同和白水塘东街三巷','02号',4,'邱春红','13119539282','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('276','同和白水塘东街三巷','01号',4,'杨燕婷','13129315227','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('277','同和白水塘东街四巷','01号',6,'邱国良','13902253214','43439','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('278','同和白水塘东街四巷','02号',6,'邱玉珍','18922253106','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('279','同和白水塘东街四巷','03号',5,'杨志雄','18927594572','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('28','白水塘西街','05号',7,'邱永东','13570122223','0043334','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('280','同和白水塘东街五巷','03号',9,'叶秋桂','13423672323','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('281','同和白水塘东街五巷','02号',3,'张善忠','13662424639','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('282','同和白水塘东街五巷','01号',6,'邱彩英、许卫林','18922755493、13711211320','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('283','同和白水塘东街','04号',5,'邱新莲','13640843256','43335','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('284','同和白水塘东街六巷','01号',8,'邹洁成','13503052299','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('285','同和白水塘东街六巷','03号',6,'邱容带','13711591028','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('286','同和白水塘东街六巷','05号',6,'叶秋桂','13423672323','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('287','同和白水塘东街六巷','07号',3,'韩冬梅','13719005556','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('288','同和白水塘东街六巷','02号',6,'邱俊武','13503033073','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('289','同和白水塘东街六巷','04号',7,'邱俊武','13503033073','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('29','白水塘西街','07号之一',7,'邱润贵','15915975628','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('290','白水塘北路','18号之一',8,'邱炳桂、邱记长',' ','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('291','同和白水塘中街','02号',6,'邱润有','13538878048','37714','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('292','同和蟾蜍石北街一巷','01号',6,'杨志强','13802925489','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('293','同和蟾蜍石北街一巷','05号',6,'邱福全','13676259190','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('294','同和蟾蜍石北街一巷','07号',6,'吴永洪','13711150866','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('295','同和蟾蜍石北街一巷','09号',6,'邱树森','13076824208','37695','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('296','同和蟾蜍石北街一巷','09号之一',6,'邱国华','13725288866','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('297','同和蟾蜍石北街一巷','13号之一',6,'邱威利','13711762297','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('298','同和蟾蜍石北街一巷','13号',6,'邱威利','13711762297','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('299','同和蟾蜍石北街一巷','11号之一',6,'宋旭群','13710387939','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('3','同和白水塘西横一路','5号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('30','白水塘西街','07号',7,'邱润贵','15915975628','0037610','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('300','同和蟾蜍石北街一巷','11号',6,'宋日群','13719237701','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('301','同和蟾蜍石北街一巷','12号',7,'邱美礼','13802530933','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('302','同和蟾蜍石北街一巷','10号',6,'邱美礼','13802530933','37658','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('303','同和蟾蜍石北街一巷','08号',6,'杨志华','13710387921','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('304','同和蟾蜍石北街一巷','04号',6,'杨志坚','13332834770','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('305','同和蟾蜍石北街一巷','06号',6,'杨志华','13710387921','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('306','同和蟾蜍石北街一巷','02号',6,'杨志坚','13332834770','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('307','同和白水塘中街','04号',6,'邱志强','13726798601','37621','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('308','同和白水塘中街','01号',2,'邱记旺','15915975628','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('309','同和白水塘中街','06号',6,'朱婉娟','15915975628','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('31','白水塘西街','02号',6,'邱伯就、邱国强、曾秀群','13711799949、13802949132、15975371716','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('310','同和白水塘中街','06号之一',7,'朱婉娟','15915975628','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('311','同和白水塘中街','06号之二',7,'朱婉娟','15915975628','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('312','同和白水塘中街','08号',6,'宋旭群','13710387939','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('313','同和白水塘中街','08号之一',6,'宋旭群','13710387939','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('314','同和白水塘中街','03号',6,'邱润金','13724862882','37686','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('315','同和白水塘中街','05号',5,'邱年胜','13724094893','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('316','同和白水塘中街','10号',6,'邱福安','13902221407','37604','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('317','同和白水塘中街','12号',7,'邱记润','13527868038','37730','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('318','同和白水塘中街','18号',8,'邱美礼','13802530933','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('319','同和白水塘中街','14号',8,'邱开华','15913161255','37618','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('32','白水塘西街','02号之一',6,'邱伯就、邱国强、曾秀群','13711799949、13802949132、15975371716','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('320','同和白水塘中街','16号',7,'邱记润、邱福安','13527868038、13902221407','37729','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('321','同和白水塘中街','22号之一',7,'邱松','15913161255','37632','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('322','同和白水塘中街','22号',7,'邱松','15913161255','37632','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('323','同和白水塘中街','26号',7,'邱年胜','13724094893','37630','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('324','同和白水塘中街','24号',7,'邱全','13719083796','37723','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('325','同和白水塘中街','28号',6,'邱春连','13138688625','37706','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('326','同和白水塘中街','30号',7,'邱信有','18925111087','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('327','同和白水塘中街','32号',7,'吴记胜','13710362283','37712','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('328','同和白水塘中街','09号',7,'邱秋兰','13640843263','37620','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('329','同和白水塘中街','07号',8,'邱水连','37358961','43142','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('33','白水塘西街','04号',7,'邱卫东','13710602388','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('330','同和白水塘中街','07号之二',8,'邱水连','37358961','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('331','同和白水塘中街','07号之一',7,'邝丽娟','37358961','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('332','同和白水塘中街','07号之三',1,'邱海明','37358961','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('333','同和白水塘中街','34号',8,'何玉连','13711478125','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('334','同和白水塘中街','36号',7,'徐木娣','13729851182','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('335','同和白水塘中街','36号之一',8,'邱金胜','13729851182','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('336','同和白水塘中街','38号',5,'邱年英','13650603521','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('337','同和白水塘中街','38号之一',3,'邱年英','13650603521','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('338','同和白水塘中街','40号',8,'邱水金','13609003861','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('339','同和白水塘中街','42号',6,'邱水金、邱一春、邱永强','18922755493','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('34','白水塘西街','06号',7,'邱金华','13711762297','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('340','同和白水塘中街','44号',7,'魏牛仔','13710386681','37709','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('341','同和白水塘中街','46号',7,'邱润胜','13411174422','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('342','同和白水塘中街','48号',6,'邱润才','15800224099','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('343','同和白水塘中街','50号',7,'邱记连','13660590549','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('344','同和白水塘中街','52号',6,'邱记连','13660590549','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('345','同和白水塘中街','54号',6,'邱国强、邱志伟','13392464628、13424471660','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('346','同和白水塘中街','56号',8,'邱连新','13609714213','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('347','同和白水塘中街','56号之一',8,'邱连新','13609714213','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('348','同和白水塘中街','58号',6,'邱连新','13609714213','37683','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('349','同和白水塘中街','60号',4,'邱连新','13609714213','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('35','白水塘西街','08号',7,'邱国华','13725288866','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('350','同和白水塘中街','62号',7,'邱金全','13602719873','43577','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('351','同和白水塘中街','62号之二',6,'邱金全','13602719873','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('352','同和白水塘中街','62号之四',2,'邱金全','13602719873','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('353','同和白水塘中街','62号之一',6,'邱金全','13602719873','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('354','同和白水塘中街','62号之三',8,'邱金全','13602719873','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('355','同和白水塘中街','64号',7,'杨桂珍','13660841212','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('356','同和白水塘中街','64号之一',1,'杨桂珍','13660841212','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('357','同和白水塘中街','13号',6,'邱记连','13660590549','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('358','同和白水塘中街','13号之一',1,'邱记连','13660590549','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('359','同和白水塘中街','15号',7,'邱少阳','13824481010','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('36','白水塘西街','10号',7,'邱志辉、邱永强、邱秀珍、  邱志文、邱国华','13602719873、18922755493、13302498148、18011871381、13725288866','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('360','同和白水塘中街','17号',7,'邱志辉','13602719873','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('361','同和白水塘中街','19号',7,'邱彩霞','13725428218','37696','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('362','同和白水塘中街','19号之一',7,'邱彩霞','13725428218','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('363','同和白水塘中街','21号',7,'邱永红','13622283339','37662','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('364','同和白水塘中街','23号',7,'邱银英','13642643202','43575','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('365','同和白水塘中街','29号之一',7,'邱元娣','37373867','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('366','同和白水塘中街','29号',8,'邱元娣','37373867','37650','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('367','同和白水塘中街','27号',8,'陈绍凤','15818809125','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('368','同和白水塘中街','25号',8,'邝丽娟（五楼）、邱丽娟','37358961、13725156811','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('369','同和白水塘中街二巷','1号',6,'邱少波','15915973071','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('37','白水塘西街','12号',6,'叶晋良','13660210129','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('370','同和白水塘中街二巷','2号之一',6,'杨添娣','13500036211','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('371','同和白水塘中街二巷','2号',5,'杨添娣','13500036211','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('372','同和白水塘中街二巷','3号',6,'杨蛇妹','13602721668','46134','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('373','同和白水塘中街二巷','3号之一',6,'邱东林','13602721668','37703','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('374','同和白水塘中街一巷','5号',6,'邱东泉','15360068237','43578','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('375','同和白水塘中街一巷','5号之一',7,'邱九根、邱东泉、邱美礼','13006882328、15360068237、13802530933','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('376','同和白水塘中街一巷','3号之一',7,'邱九根','13006882328','37641','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('377','同和白水塘中街一巷','3号',6,'邱九根','13006882328','37641','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('378','同和白水塘中街一巷','2号',7,'邱水金','13903066522','37625','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('379','同和白水塘中街一巷','4号',7,'邱水金','13903066522','37624','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('38','白水塘西街','14号',6,'邱全','13809246433','37721','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('380','同和白水塘中街一巷','1号',4,'邱水金','13903066522','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('381','白水塘南路','05号之一',8,'邱国强','13802949132','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('382','同和蟾蜍石北巷','01号',9,'邱秋霞','18022326189','43574','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('383','同和蟾蜍石北巷','01号之一',6,'邱秋霞','18022326189','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('384','同和蟾蜍石北巷','01号之二',4,'邱秋霞','18022326189','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('385','同和蟾蜍石北巷','03号',4,'邱少波','15915973071','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('386','同和蟾蜍石北巷','05号',7,'邱志刚','13802774580','37670','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('387','同和蟾蜍石北巷','07号',6,'邱好','13826021588','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('388','同和蟾蜍石北巷','09号',7,'杨佩玲','13533223000','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('389','同和蟾蜍石北巷','11号',6,'邱彩红','18922334537','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('39','白水塘西街','20号',9,'邱水清、邱水、邱炳坤、邝丽娟、邱东海、邱玉玲','13416298188、13535012562、37358961、37358961、37378620、13719083796','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('390','同和蟾蜍石北巷','13号',7,'邱群英、邱华英','37358961','37697','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('391','同和白水塘南街三巷','15号',8,'叶九春','13622231067','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('392','同和白水塘南一巷','33号之二',4,'杨建娣','13539921164','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('4','同和白水塘西横一路','7号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('40','白水塘西街','20号之一',9,'邱水清、邱水、邱炳坤、邝丽娟、邱东海、邱玉玲','13416298188、13535012562、37358961、37358961、37378620、13719083796','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('41','白水塘西街','24号',6,'邱春生','13527854730','37676','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('42','白水塘西街','22号',2,'邱润林','13538955184','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('43','白水塘西街','26号',2,'邱全','18922253106','37731','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('44','白水塘西街','28号',7,'邱润有','13538878048','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('45','白水塘西街','28号之一',7,'邱润有','13538878048','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('458','白水塘北路','25号之二',6,'邱瑞平','13556155622','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('46','白水塘西街','34号',7,'雷淑贤','13503022544','0037657','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('47','白水塘西街','30号',7,'邱春生','13527854730','0037675','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('48','白水塘西街','32号',3,'邱春生','13527854730','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('49','白水塘西街','28号之二',1,'','','','邱氏宗祠',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('5','同和白水塘西横一路','9号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('50','白水塘西街','36号之一',7,'邱润贵','13672489709','0037606','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('506','同和白水塘中街','11号',9,'邱炳林','13539836518','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('51','白水塘西街','36号',7,'邱丹凤','13672489709','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('52','白水塘西街','38号',6,'经济社','37356041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('53','白水塘西街','38号之一',6,'经济社','37356041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('54','白水塘西街','40号之一',6,'邱峙延','13926192818','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('55','白水塘西街','40号',7,'邱水清','13416298188','0037724','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('56','白水塘西街','11号之二',5,'邱记润','13527868038','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('57','白水塘西街','11号之一',5,'邱记润','13527868038','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('58','白水塘西街','11号',7,'邓璐','13527868038','0043437','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('59','白水塘西街','09号之一',6,'邱浩锐','13602721668','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('6','同和白水塘西横二路','06号之二',9,'经济社','37356041','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('60','白水塘西街','09号',7,'邱浩锐','13602721668','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('61','白水塘北路','01号',6,'邱添发','13809246433','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('62','白水塘北路','03号',7,'邱添发','13809246433','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('63','白水塘北路','05号之一',7,'邱记华','13119539282','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('64','白水塘北路','05号',7,'邱记华','13119539282','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('65','白水塘北路','07号之一',7,'邱东林','13602721668','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('66','白水塘北路','07号',7,'邱东林','13602721668','0037716','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('67','白水塘北路','09号',6,'邱记华','13119539282','0037613','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('68','白水塘北路','11号',8,'邱东洪','13022022799','0043333','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('69','白水塘北路','11号之一',7,'何华玲','','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('7','同和白水塘西横一路','2号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('70','白水塘北路','13号',6,'邱丽梅、邱东海','13725156811、18922478629','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('71','白水塘北路','15号',3,'邱记长','18927553603','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('72','白水塘北路','17号之一',6,'','','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('73','白水塘北路','17号',3,'邱炳桂','13719333392','0043300','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('74','白水塘北路','19号',7,'邱明德','13622839743','0043293','',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('75','白水塘北路','21号之一',7,'邱明光','13825019070','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('76','白水塘北路','21号',6,'邱明光','13825019070','0043393','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('77','白水塘北路','23号',3,'邱少根','13724092218','0043576','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('78','白水塘北路','25号',6,'邱少根','13622822684','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('79','白水塘北路','25号之一',6,'邱少根、邱瑞平','13622822684、13556155622','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('8','同和白水塘西横一路','4号',7,'经济社','37356041','','住宅',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('80','白水塘北路','27号',7,'邱锦松','13922268694','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('81','白水塘北路','29号',6,'邱丽梅','13725156811','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('82','白水塘北路','02号',6,'邱子文','13719249673','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('83','白水塘北路','02号之一',2,'邱子良','13119539282','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('84','白水塘北路','04号',6,'邱子良','13119539282','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('85','白水塘北路','06号',7,'邱记华','13119539282','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('86','白水塘北路','08号',7,'宋三英','15915973071','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('87','白水塘北路','10号',7,'李五妹','13539836518','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('88','白水塘北路','12号',9,'邱炳林','13539836518','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('89','白水塘北路','14号',7,'邱炳辉','13660081801','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('9','同和白水塘西横一路','4号之一',2,'经济社','37356041','','电房',NULL,'怡兴',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('90','白水塘北路','16号',8,'邱炳桂','13719333392','0043330','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('91','白水塘北路','18号',7,'邱明光','13825019070','0043394','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('92','白水塘北路','20号',7,'邱明华','18122782708','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('93','白水塘北路','22号',7,'邱明华','18666022346','0043583','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('94','白水塘北路','24号',4,'邱春杰','13724092218','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('95','白水塘北路','24号之一',7,'邱春杰','13724092218','0043298','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('96','白水塘北路','26号',5,'邱瑞雄','13922268694','','住宅',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('97','同和白水塘北街','05号',2,'叶润福','13808812461','','饭店',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('98','同和白水塘北街','01号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('99','同和白水塘北街','03号',7,'经济社','37356041','','住宅',NULL,'合资',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL),('999','白水塘南路','28号',0,'与南二巷2号','','','',NULL,'',1,'sys','2017-10-30 00:49:27.000000',NULL,NULL);
/*!40000 ALTER TABLE `pay_building_info_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_order_info`
--

DROP TABLE IF EXISTS `pay_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_order_info` (
  `order_code` varchar(45) COLLATE utf8_bin NOT NULL,
  `building_code` varchar(45) COLLATE utf8_bin NOT NULL,
  `room_no` varchar(45) COLLATE utf8_bin NOT NULL,
  `monthly_cycle` int(11) DEFAULT NULL,
  `water_before_qty` decimal(11,2) DEFAULT NULL,
  `water_current_qty` decimal(11,2) DEFAULT NULL,
  `actual_qty` decimal(11,2) DEFAULT NULL,
  `water_apportion_qty` decimal(11,2) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `water_price` decimal(11,2) DEFAULT NULL,
  `garbage_price` decimal(11,2) DEFAULT NULL,
  `apportion_price` decimal(11,2) DEFAULT NULL,
  `late_fee` decimal(11,2) DEFAULT NULL,
  `network_price` decimal(11,2) DEFAULT NULL,
  `sewage_price` decimal(11,2) DEFAULT NULL,
  `other_price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `pay_date` timestamp NULL DEFAULT NULL,
  `toll_collector` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`order_code`,`building_code`,`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_order_info`
--

LOCK TABLES `pay_order_info` WRITE;
/*!40000 ALTER TABLE `pay_order_info` DISABLE KEYS */;
INSERT INTO `pay_order_info` VALUES ('20180201172708000','1','101',201802,30.00,40.00,10.00,1.00,3.50,35.00,0.00,3.50,0.00,0.00,0.00,0.00,38.50,1,NULL,'2018-03-24 08:04:07','marchi','marchi','2018-02-07 02:21:12','marchi','2018-03-24 08:04:07'),('20180201172708000','1','102',201802,50.00,60.00,10.00,1.00,3.50,35.00,0.00,3.50,0.00,0.00,0.00,0.00,38.50,0,NULL,NULL,NULL,'marchi','2018-02-07 02:21:12','marchi','2018-02-07 02:21:12'),('20180201172708000','10','101',201802,30.00,35.00,5.00,1.00,3.90,19.50,0.00,3.90,0.00,0.00,0.00,0.00,23.40,1,NULL,'2018-03-24 08:06:17','marchi','marchi','2018-02-07 02:21:12','marchi','2018-03-24 08:06:17'),('20180201172708000','10','102',201802,36.00,40.00,4.00,0.80,3.90,15.60,0.00,3.10,0.00,0.00,0.00,0.00,18.70,1,NULL,'2018-03-24 08:06:17','marchi','marchi','2018-02-07 02:21:12','marchi','2018-03-24 08:06:17');
/*!40000 ALTER TABLE `pay_order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_pricing_type`
--

DROP TABLE IF EXISTS `pay_pricing_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_pricing_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pricing_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `pricing_desc` varchar(200) COLLATE utf8_bin NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_pricing_type`
--

LOCK TABLES `pay_pricing_type` WRITE;
/*!40000 ALTER TABLE `pay_pricing_type` DISABLE KEYS */;
INSERT INTO `pay_pricing_type` VALUES (1,'居民','2009-08由2.4调为2.8|2012-08由2.8调为3.5',3.50,'marchi','2017-10-11 04:02:39.185000',NULL,NULL),(2,'出租','2012.08由3.2调为3.9',3.90,'marchi','2017-10-17 02:57:57.130000',NULL,NULL),(3,'商业','2012.08由4.2调为4.95',4.95,'marchi','2017-10-17 02:58:28.737000',NULL,NULL),(4,'高价','2012.08由4.4调为5.15',5.15,'marchi','2017-10-17 02:58:56.115000',NULL,NULL),(5,'其它','其它',10.00,'marchi','2017-10-20 07:42:21.904000',NULL,NULL);
/*!40000 ALTER TABLE `pay_pricing_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_replace_water_meter_history`
--

DROP TABLE IF EXISTS `pay_replace_water_meter_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_replace_water_meter_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `room_no` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `old_water_meter_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `qty` decimal(11,2) DEFAULT NULL,
  `new_water_meter_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `buinlding` (`building_code`,`room_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_replace_water_meter_history`
--

LOCK TABLES `pay_replace_water_meter_history` WRITE;
/*!40000 ALTER TABLE `pay_replace_water_meter_history` DISABLE KEYS */;
INSERT INTO `pay_replace_water_meter_history` VALUES (1,'00101','101','0010101',NULL,'0010102','换表','marchi','2017-10-23 04:10:13','marchi','2017-10-23 04:10:13'),(2,'00101','101','0010101',NULL,'0010102','换表','marchi','2017-10-23 04:20:32','marchi','2017-10-23 04:20:32'),(3,'00101','101','0010102',NULL,'0010103','换表','marchi','2017-10-23 04:22:41','marchi','2017-10-23 04:22:41'),(4,'00101','101','0010103',NULL,'0010104','换表','marchi','2017-10-23 04:24:04','marchi','2017-10-23 04:24:04'),(5,'00101','101','0010104',25.00,'0010105',NULL,'marchi','2017-10-30 02:25:57','marchi','2017-10-30 02:25:57');
/*!40000 ALTER TABLE `pay_replace_water_meter_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_room_group`
--

DROP TABLE IF EXISTS `pay_room_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_room_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_room_group`
--

LOCK TABLES `pay_room_group` WRITE;
/*!40000 ALTER TABLE `pay_room_group` DISABLE KEYS */;
INSERT INTO `pay_room_group` VALUES (1,'锋哥','锋哥',1,'marchi','2017-11-02 03:04:31');
/*!40000 ALTER TABLE `pay_room_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_user`
--

DROP TABLE IF EXISTS `pay_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `id_card_no` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `addr` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `print_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_user`
--

LOCK TABLES `pay_user` WRITE;
/*!40000 ALTER TABLE `pay_user` DISABLE KEYS */;
INSERT INTO `pay_user` VALUES (6,'邹洁成',1,NULL,'同和白水塘东街六巷','邹洁成',NULL,'13503052299',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(7,'朱婉娟',1,NULL,'同和白水塘中街','朱婉娟',NULL,'15915975628',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(8,'钟秀芳',1,NULL,'同和白水塘西横二路','钟秀芳',NULL,'13809246433',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(9,'张素娴',1,NULL,'同和白水塘南街一巷','张素娴',NULL,'13503028410',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(10,'张善忠',1,NULL,'同和白水塘东街五巷','张善忠',NULL,'13662424639',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(12,'叶珠',1,NULL,'同和白水塘南二巷','叶珠',NULL,'13711632353',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(14,'叶远东',1,NULL,'同和白水塘南二巷','叶远东',NULL,'13826287129',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(15,'叶玉琼',1,NULL,'同和白水塘南二巷','叶玉琼',NULL,'13533846822',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(17,'叶银英',1,NULL,'同和白水塘南街三巷','叶银英',NULL,'13724074281',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(18,'叶耀文',1,NULL,'同和白水塘南街','叶耀文',NULL,'15112009566',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(19,'叶耀方',1,NULL,'同和白水塘南街','叶耀方',NULL,'13711277335',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(20,'叶新彩',1,NULL,'同和白水塘北街','叶新彩',NULL,'13535371063',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(21,'叶细妹',1,NULL,'同和白水塘南街三巷','叶细妹',NULL,'18826092319',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(22,'叶文英',1,NULL,'同和白水塘南街三巷','叶文英',NULL,'18666623203',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(24,'叶伟中',1,NULL,'同和白水塘南街','叶伟中',NULL,'13802958100',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(25,'叶伟明',1,NULL,'同和白水塘南街三巷','叶伟明',NULL,'13609771668',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(26,'叶天河',1,NULL,'同和白水塘南二巷','叶天河',NULL,'13602732818',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(27,'叶天河',1,NULL,'同和白水塘南二巷','叶天河',NULL,'13902286810',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(28,'叶天才',1,NULL,'同和白水塘南二巷','叶天才',NULL,'18011701533',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(29,'叶水荣',1,NULL,'同和白水塘南街一巷','叶水荣',NULL,'15914216873',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(30,'叶淑娣',1,NULL,'同和白水塘南一巷','叶淑娣',NULL,'13825197806',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(31,'叶润添',1,NULL,'同和白水塘南街三巷','叶润添',NULL,'13538717408',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(32,'叶润添',1,NULL,'同和白水塘南街三巷','叶润添',NULL,'13538718408',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(33,'叶润生',1,NULL,'同和白水塘西横二路','叶润生',NULL,'13802993240',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(34,'叶润连',1,NULL,'同和白水塘南街三巷','叶润连',NULL,'13544367455',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(35,'叶润福',1,NULL,'同和白水塘北街','叶润福',NULL,'13808812461',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(36,'叶润才',1,NULL,'同和白水塘南二巷','叶润才',NULL,'13802431332',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(37,'叶秋桂',1,NULL,'同和白水塘南街三巷','叶秋桂',NULL,'13423672323',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(38,'叶九仔',1,NULL,'同和白水塘南二巷','叶九仔',NULL,'13432028399',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(39,'叶九春',1,NULL,'同和白水塘南街三巷','叶九春',NULL,'13622231067',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(40,'叶镜钦',1,NULL,'同和白水塘南街','叶镜钦',NULL,'15360537336',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(41,'叶晋良',1,NULL,'白水塘西街','叶晋良',NULL,'13660210129',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(42,'叶记棠',1,NULL,'同和白水塘南街三巷','叶记棠',NULL,'15013364023',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(43,'叶桂清',1,NULL,'同和白水塘南街三巷','叶桂清',NULL,'13503028410',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(45,'叶桂兰',1,NULL,'同和白水塘南街二巷','叶桂兰',NULL,'15814871173',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(46,'叶春好',1,NULL,'同和白水塘南街','叶春好',NULL,'13697457055',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(47,'叶彩有',1,NULL,'同和蟾蜍石北路','叶彩有',NULL,'13676259190',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(48,'叶彩有',1,NULL,'同和蟾蜍石北路','叶彩有',NULL,'13570360604',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(49,'叶彩文',1,NULL,'同和白水塘南街三巷','叶彩文',NULL,'13688878823',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(50,'叶彩平',1,NULL,'同和白水塘北街三巷','叶彩平',NULL,'13539955511',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(51,'叶柏如',1,NULL,'同和白水塘南二巷','叶柏如',NULL,'13538799902',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(52,'叶柏如',1,NULL,'同和白水塘南二巷','叶柏如',NULL,'13538799906',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(53,'叶柏如',1,NULL,'同和白水塘南二巷','叶柏如',NULL,'13763338871',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(54,'杨志雄',1,NULL,'同和白水塘南一巷','杨志雄',NULL,'18927594572',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(55,'杨志仁',1,NULL,'同和白水塘南一巷','杨志仁',NULL,'13503047290',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(56,'杨志强',1,NULL,'同和蟾蜍石北街一巷','杨志强',NULL,'13533663690',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(57,'杨志强',1,NULL,'同和蟾蜍石北街一巷','杨志强',NULL,'13802925489',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(58,'杨志坚',1,NULL,'同和蟾蜍石北街一巷','杨志坚',NULL,'13332834770',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(59,'杨志华',1,NULL,'同和蟾蜍石北街一巷','杨志华',NULL,'13710387921',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(60,'杨灶田',1,NULL,'同和白水塘南街','杨灶田',NULL,'13688873992',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(62,'杨月清',1,NULL,'同和白水塘南一巷','杨月清',NULL,'13432001730',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(63,'杨银英',1,NULL,'同和白水塘南一巷','杨银英',NULL,'13925136968',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(64,'杨燕婷',1,NULL,'同和白水塘东街三巷','杨燕婷',NULL,'13129315227',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(65,'杨秀英',1,NULL,'同和白水塘南街一巷','杨秀英',NULL,'13048015606',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(66,'杨添娣',1,NULL,'同和白水塘中街二巷','杨添娣',NULL,'13500036211',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(68,'杨天生',1,NULL,'同和白水塘南一巷','杨天生',NULL,'18922408771',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(69,'杨蛇妹',1,NULL,'同和白水塘中街二巷','杨蛇妹',NULL,'13602721668',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(70,'叶永忠',1,NULL,'同和白水塘南街三巷','叶永忠',NULL,'13798011203',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(71,'叶桂清',1,NULL,'同和白水塘南街三巷','叶桂清',NULL,'13503028410',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(72,'叶金才',1,NULL,'同和白水塘南街三巷','叶金才',NULL,'',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(73,'叶伟中',1,NULL,'同和白水塘南街','叶伟中',NULL,'13802958100',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(74,'叶伟光',1,NULL,'同和白水塘南街','叶伟光',NULL,'13710383190',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(75,'叶卓峰',1,NULL,'同和白水塘南街','叶卓峰',NULL,'13538799906',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(76,'叶桂明',1,NULL,'同和白水塘南街','叶桂明',NULL,'13600050041',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(77,'叶振华',1,NULL,'同和白水塘南街','叶振华',NULL,'',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(78,'杨月清',1,NULL,'同和白水塘南一巷','杨月清',NULL,'13432001730',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(79,'杨桂清',1,NULL,'同和白水塘北街四巷','杨桂清',NULL,'15913188830',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(80,'杨天生',1,NULL,'同和白水塘南一巷','杨天生',NULL,'18922408771',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(81,'杨国其',1,NULL,'同和白水塘南一巷','杨国其',NULL,'13538981238',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(82,'杨桂娇',1,NULL,'同和白水塘南一巷','杨桂娇',NULL,'',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL),(83,'杨桂英',1,NULL,'同和白水塘南一巷','杨桂英',NULL,'',NULL,1,'sys','2017-10-30 07:30:56.000000',NULL,NULL);
/*!40000 ALTER TABLE `pay_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_water_meter_info`
--

DROP TABLE IF EXISTS `pay_water_meter_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_water_meter_info` (
  `water_meter_code` varchar(45) COLLATE utf8_bin NOT NULL,
  `open_date` date DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  `current_qty` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`water_meter_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_water_meter_info`
--

LOCK TABLES `pay_water_meter_info` WRITE;
/*!40000 ALTER TABLE `pay_water_meter_info` DISABLE KEYS */;
INSERT INTO `pay_water_meter_info` VALUES ('00101','2017-10-20',NULL,0,1,NULL,'marchi','2017-10-20 08:56:25',NULL,NULL),('00102','2017-10-20',NULL,0,1,NULL,'marchi','2017-10-20 08:56:50',NULL,NULL);
/*!40000 ALTER TABLE `pay_water_meter_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_water_meter_input_building`
--

DROP TABLE IF EXISTS `pay_water_meter_input_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_water_meter_input_building` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `monthly_cycle` int(11) NOT NULL,
  `building_code` varchar(45) COLLATE utf8_bin NOT NULL,
  `before_qty` decimal(11,2) DEFAULT NULL,
  `current_qty` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`,`building_code`,`monthly_cycle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_water_meter_input_building`
--

LOCK TABLES `pay_water_meter_input_building` WRITE;
/*!40000 ALTER TABLE `pay_water_meter_input_building` DISABLE KEYS */;
INSERT INTO `pay_water_meter_input_building` VALUES ('20180201172708000',201802,'1',NULL,100.00,2,'marchi','2018-02-06 10:47:36','marchi','2018-02-06 10:47:36'),('20180201172708000',201802,'10',NULL,75.00,2,'marchi','2018-02-06 10:47:36','marchi','2018-02-06 10:47:36'),('20180301151916000',201803,'1',NULL,0.00,0,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21'),('20180301151916000',201803,'10',NULL,0.00,0,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21');
/*!40000 ALTER TABLE `pay_water_meter_input_building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_water_meter_input_detail`
--

DROP TABLE IF EXISTS `pay_water_meter_input_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_water_meter_input_detail` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `monthly_cycle` int(11) NOT NULL,
  `building_code` varchar(45) COLLATE utf8_bin NOT NULL,
  `room_no` varchar(45) COLLATE utf8_bin NOT NULL,
  `water_meter_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `before_qty` decimal(11,2) DEFAULT NULL,
  `current_qty` decimal(11,2) DEFAULT NULL,
  `garbage_price` decimal(11,2) DEFAULT NULL,
  `network_price` decimal(11,2) DEFAULT NULL,
  `sewage_price` decimal(11,2) DEFAULT NULL,
  `other_price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`,`monthly_cycle`,`building_code`,`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_water_meter_input_detail`
--

LOCK TABLES `pay_water_meter_input_detail` WRITE;
/*!40000 ALTER TABLE `pay_water_meter_input_detail` DISABLE KEYS */;
INSERT INTO `pay_water_meter_input_detail` VALUES ('20180201172708000',201802,'1','101','10101',30.00,123.40,0.00,0.00,0.00,0.00,1,NULL,'marchi','2018-02-06 10:47:36','tiger','2018-02-09 16:02:13'),('20180201172708000',201802,'1','102','10102',50.00,124.50,0.00,0.00,0.00,0.00,1,NULL,'marchi','2018-02-06 10:47:36','tiger','2018-02-09 16:02:13'),('20180201172708000',201802,'10','101','10103',30.00,125.60,0.00,0.00,0.00,0.00,1,NULL,'marchi','2018-02-06 10:47:36','tiger','2018-02-09 16:02:13'),('20180201172708000',201802,'10','102','10104',36.00,126.70,0.00,0.00,0.00,0.00,1,NULL,'marchi','2018-02-06 10:47:36','tiger','2018-02-09 16:02:13'),('20180301151916000',201803,'1','101','10101',40.00,0.00,0.00,0.00,0.00,0.00,0,NULL,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21'),('20180301151916000',201803,'1','102','10102',60.00,0.00,0.00,0.00,0.00,0.00,0,NULL,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21'),('20180301151916000',201803,'10','101','10103',35.00,0.00,0.00,0.00,0.00,0.00,0,NULL,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21'),('20180301151916000',201803,'10','102','10104',40.00,0.00,0.00,0.00,0.00,0.00,0,NULL,'marchi','2018-03-24 07:19:21','marchi','2018-03-24 07:19:21');
/*!40000 ALTER TABLE `pay_water_meter_input_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_water_meter_input_header`
--

DROP TABLE IF EXISTS `pay_water_meter_input_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_water_meter_input_header` (
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `monthly_cycle` int(11) NOT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `before_qty` decimal(11,2) DEFAULT NULL,
  `current_qty` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `create_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_modify_user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_water_meter_input_header`
--

LOCK TABLES `pay_water_meter_input_header` WRITE;
/*!40000 ALTER TABLE `pay_water_meter_input_header` DISABLE KEYS */;
INSERT INTO `pay_water_meter_input_header` VALUES ('20180201172708000',201802,'2018-02-01','2018-02-28',NULL,175.00,2,NULL,'marchi','2018-02-06 10:47:36','marchi','2018-02-07 02:21:12'),('20180301151916000',201803,'2018-03-01','2018-03-31',NULL,NULL,0,NULL,'marchi','2018-03-24 07:19:20','marchi','2018-03-24 07:19:20');
/*!40000 ALTER TABLE `pay_water_meter_input_header` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-20 17:43:56
