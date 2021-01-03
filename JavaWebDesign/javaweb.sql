/*
Navicat MySQL Data Transfer

Source Server         : offers
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : javaweb

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2021-01-03 10:36:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_applicant`
-- ----------------------------
DROP TABLE IF EXISTS `tb_applicant`;
CREATE TABLE `tb_applicant` (
  `APPLICANT_ID` int NOT NULL AUTO_INCREMENT,
  `APPLICANT_EMAIL` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICANT_PWD` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICANT_REGISTDATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`APPLICANT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_applicant
-- ----------------------------
INSERT INTO `tb_applicant` VALUES ('3', '1438617535@qq.com', 'pmy0607+', '2020-12-28 17:22:18');
INSERT INTO `tb_applicant` VALUES ('4', 'applicant@qq.com', '123456', '2020-12-28 22:34:55');
INSERT INTO `tb_applicant` VALUES ('5', 'pmy@qq.com', '123456', '2020-12-28 22:48:14');
INSERT INTO `tb_applicant` VALUES ('6', 'asasdf', 'asdf', '2020-12-28 22:49:17');
INSERT INTO `tb_applicant` VALUES ('7', 'fasafsd', 'asdfasdf', '2020-12-28 23:02:53');
INSERT INTO `tb_applicant` VALUES ('8', 'asfasf', 'asdfasdf', '2020-12-28 23:03:31');
INSERT INTO `tb_applicant` VALUES ('9', 'afdasf', 'asdf', '2020-12-28 23:04:55');
INSERT INTO `tb_applicant` VALUES ('12', 'asdf', 'asdf', null);
INSERT INTO `tb_applicant` VALUES ('13', 'company@qq.com', 'aaa', '2020-12-29 08:51:35');
INSERT INTO `tb_applicant` VALUES ('14', 'company1@qq.com', 'aaa', '2020-12-29 08:56:16');
INSERT INTO `tb_applicant` VALUES ('15', 'applicant55@qq.com', 'asdf', '2020-12-29 10:07:21');
INSERT INTO `tb_applicant` VALUES ('16', 'applicantTest@qq.com', 'asdfasdf', '2020-12-29 13:52:13');
INSERT INTO `tb_applicant` VALUES ('17', 'companyTest2@qq.com', 'asdf', '2020-12-29 20:34:38');
INSERT INTO `tb_applicant` VALUES ('18', 'applicantT2@qq.com', 'asdf', '2020-12-29 21:20:42');
INSERT INTO `tb_applicant` VALUES ('19', 'applicant1@qq.com', '123456', '2021-01-02 10:51:53');
INSERT INTO `tb_applicant` VALUES ('20', 'test@qq.com', '123456', '2021-01-02 20:20:03');

-- ----------------------------
-- Table structure for `tb_company`
-- ----------------------------
DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE `tb_company` (
  `COMPANY_ID` int NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPANY_ADDRESS` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPANY_SIZE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPANY_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPANY_BRIEF` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `COMPANY_STATE` int DEFAULT NULL,
  `COMPANY_SORT` int DEFAULT NULL,
  `COMPANY_VIEWNUM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `COMPANY_PIC` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPANY_EMAIL` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `COMPANY_PWD` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_company
-- ----------------------------
INSERT INTO `tb_company` VALUES ('1', '嗷嗷嗷', null, null, null, null, null, null, null, null, 'pmysaf', '23234');
INSERT INTO `tb_company` VALUES ('2', '明源公司', '杭州', '中型企业', '互联网公司', '这是一家互联网公司', '1', null, '1500', '6e0a8a9365ed7e7d.jpg', 'company@qq.com', '123456');
INSERT INTO `tb_company` VALUES ('9', '阿里巴巴', '北京', '小型企业', '电商', '', null, null, '2000', '3bcec7a5b3aae8c.jpg', 'company1@qq.com', '123456');
INSERT INTO `tb_company` VALUES ('10', '尤尼克斯', '日本', '大型企业', '运动', '服务于运动行业', null, null, '10000', '-16fde2321d40216.jpg', 'test@qq.com', '123456');

-- ----------------------------
-- Table structure for `tb_job`
-- ----------------------------
DROP TABLE IF EXISTS `tb_job`;
CREATE TABLE `tb_job` (
  `JOB_ID` int NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` int NOT NULL,
  `JOB_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_HIRINGNUM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_SALARY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_ADDRESS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_DESC` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_ENDTIME` timestamp NULL DEFAULT NULL,
  `JOB_STATE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_job
-- ----------------------------
INSERT INTO `tb_job` VALUES ('3', '2', '前端设计师', '4-8人', '5000-6000', '长沙', '\r\n            ', '2020-12-10 11:41:12', '结束招聘');
INSERT INTO `tb_job` VALUES ('4', '2', 'python开发', '11-18人', '3000-7000', '南京', 'python开发', '2020-12-03 11:45:48', '招聘中');
INSERT INTO `tb_job` VALUES ('7', '2', 'JSP设计师', '10人', '5000-7000', '深圳', '从事JSP设计', '2021-01-14 14:53:40', '招聘中');
INSERT INTO `tb_job` VALUES ('18', '9', 'Java后端开发', '5', '20000', '湖南张家界', '湖南张家界', null, '在聘');
INSERT INTO `tb_job` VALUES ('20', '2', '羽毛球教练', '4', '2000', '张家界', '张家界', null, '招聘中');
INSERT INTO `tb_job` VALUES ('21', '2', '乒乓球教练', '3', '20000', '常宁', '常宁', null, '招聘中');
INSERT INTO `tb_job` VALUES ('22', '2', '篮球教练', '20', '5000', '常德', '常德', null, '招聘中');
INSERT INTO `tb_job` VALUES ('24', '10', '线下代理', '2', '4000-6000', '任意', '任意', null, '招聘中');

-- ----------------------------
-- Table structure for `tb_jobapply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_jobapply`;
CREATE TABLE `tb_jobapply` (
  `APPLY_ID` int NOT NULL AUTO_INCREMENT,
  `JOB_ID` int NOT NULL,
  `APPLICANT_ID` int NOT NULL,
  `APPLY_DATE` timestamp NULL DEFAULT NULL,
  `APPLY_STATE` int DEFAULT NULL,
  `COMPANY_ID` int NOT NULL,
  PRIMARY KEY (`APPLY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_jobapply
-- ----------------------------
INSERT INTO `tb_jobapply` VALUES ('41', '3', '19', '2021-01-02 10:52:40', '1', '2');
INSERT INTO `tb_jobapply` VALUES ('42', '4', '19', '2021-01-02 10:52:42', '1', '2');
INSERT INTO `tb_jobapply` VALUES ('43', '7', '19', '2021-01-02 10:52:43', '1', '2');
INSERT INTO `tb_jobapply` VALUES ('44', '18', '19', '2021-01-02 10:52:44', null, '9');
INSERT INTO `tb_jobapply` VALUES ('45', '20', '19', '2021-01-02 10:52:44', '0', '2');
INSERT INTO `tb_jobapply` VALUES ('46', '21', '19', '2021-01-02 10:52:45', '1', '2');
INSERT INTO `tb_jobapply` VALUES ('50', '3', '4', '2021-01-02 18:39:23', '0', '2');
INSERT INTO `tb_jobapply` VALUES ('51', '4', '4', '2021-01-02 18:39:25', null, '2');
INSERT INTO `tb_jobapply` VALUES ('53', '3', '20', '2021-01-02 20:21:27', null, '2');

-- ----------------------------
-- Table structure for `tb_jobcollect`
-- ----------------------------
DROP TABLE IF EXISTS `tb_jobcollect`;
CREATE TABLE `tb_jobcollect` (
  `COMPANY_ID` int DEFAULT NULL,
  `COLLECT_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `COLLECT_ID` int NOT NULL AUTO_INCREMENT,
  `APPLICANT_ID` int NOT NULL,
  `JOB_ID` int NOT NULL,
  PRIMARY KEY (`COLLECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_jobcollect
-- ----------------------------
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 10:52:46', '31', '19', '3');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 18:29:01', '34', '4', '3');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 18:39:29', '35', '4', '4');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:08', '36', '20', '3');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:10', '37', '20', '4');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:11', '38', '20', '7');
INSERT INTO `tb_jobcollect` VALUES ('9', '2021-01-02 20:21:11', '39', '20', '18');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:12', '40', '20', '20');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:12', '41', '20', '21');
INSERT INTO `tb_jobcollect` VALUES ('2', '2021-01-02 20:21:22', '43', '20', '22');

-- ----------------------------
-- Table structure for `tb_jobinvitation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_jobinvitation`;
CREATE TABLE `tb_jobinvitation` (
  `INVITATION_ID` int NOT NULL AUTO_INCREMENT,
  `INVITATION_STATE` int DEFAULT NULL,
  `APPLICANT_ID` int NOT NULL,
  `JOB_ID` int NOT NULL,
  `INVITATION_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `COMPANY_ID` int NOT NULL,
  PRIMARY KEY (`INVITATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_jobinvitation
-- ----------------------------
INSERT INTO `tb_jobinvitation` VALUES ('13', null, '4', '3', '2021-01-02 18:19:12', '2');

-- ----------------------------
-- Table structure for `tb_resume_basicinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_resume_basicinfo`;
CREATE TABLE `tb_resume_basicinfo` (
  `BASICINFO_ID` int NOT NULL AUTO_INCREMENT,
  `APPLICANT_ID` int NOT NULL,
  `REALNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GENDER` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `CURRENT_LOC` varchar(255) DEFAULT NULL,
  `RESIDENT_LOC` varchar(255) DEFAULT NULL,
  `TELEPHONE` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EMAIL` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOB_INTENSION` varchar(50) DEFAULT NULL,
  `JOB_EXPERIENCE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HEAD_SHOT` varchar(255) DEFAULT NULL,
  `STATE` int DEFAULT NULL,
  PRIMARY KEY (`BASICINFO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_resume_basicinfo
-- ----------------------------
INSERT INTO `tb_resume_basicinfo` VALUES ('4', '4', '彭明源', '男', '20', null, null, '01438617535', 'applicant@qq.com', '老板', '吉首大学应届生', '57480974670_avatar.png', '1');
INSERT INTO `tb_resume_basicinfo` VALUES ('5', '19', '向波', '男', '20', null, null, '18173471615', '1438617155@qq.com', '股东', '毕业生', '31bd6cf209a31967.jpg', '1');
INSERT INTO `tb_resume_basicinfo` VALUES ('6', '20', '顾飞', '男', '20', null, null, '18173165115', 'test@qq.com', '前端', '应届毕业生', '54d70659742dd3cf.jpg', '1');
