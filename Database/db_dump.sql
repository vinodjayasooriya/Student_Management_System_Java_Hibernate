-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: courseregistrations
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic`
--

DROP TABLE IF EXISTS `academic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic` (
  `arstudentId` varchar(255) NOT NULL,
  `arstudentName` varchar(255) DEFAULT NULL,
  `arstudentprograme` varchar(255) DEFAULT NULL,
  `arstudentyear` varchar(255) DEFAULT NULL,
  `arstudentgpa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`arstudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic`
--

LOCK TABLES `academic` WRITE;
/*!40000 ALTER TABLE `academic` DISABLE KEYS */;
INSERT INTO `academic` VALUES ('S001','sadun','it','2020','3.5'),('S002','nimal','it','2020','2.8'),('S003','hansaka','it','2020','2.0'),('S004','kushan','it','2024','2.0'),('S005','raveen','engineering','2024','1.4'),('S006','sapumal','it','2020','3.8'),('S007','kamal','it','2020','1.7');
/*!40000 ALTER TABLE `academic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `CourseId` varchar(255) NOT NULL,
  `CourseName` varchar(255) DEFAULT NULL,
  `CreditHours` varchar(255) DEFAULT NULL,
  `MaximumCapacity` varchar(255) DEFAULT NULL,
  `prerequisites` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` tinytext,
  `prerequisite_id` int DEFAULT NULL,
  PRIMARY KEY (`CourseId`),
  KEY `FK8ie2bps8d86jok8am9rmv3qw7` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('C001','CMJD','12','110','Pass A/L','Software Engineering',NULL,0),('C002','Dep','11','110','Pass A/L','Software Engineering',NULL,NULL),('C003','Gdse','10','100','Pass O/L','Software Engineering',NULL,NULL),('C004','AI','20','12','Pass A/L','Software Engineering',NULL,NULL),('C005','HR','13','100','Pass A/L','Management',NULL,NULL),('C006','Electrical','16','60','Pass A/L','Engineering',NULL,NULL);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKjgekpgygvdlc7q47p4pr12bx7` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (3,'Engineering'),(1,'Information Technology'),(2,'Management');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gpa` float(5,2) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `semester_type` varchar(200) DEFAULT NULL,
  `status_type` varchar(50) DEFAULT NULL,
  `course_id` varchar(255) NOT NULL,
  `student_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKho8mcicp4196ebpltdn9wl6co` (`course_id`),
  KEY `FK8kf1u1857xgo56xbfmnif2c51` (`student_id`),
  CONSTRAINT `FK8kf1u1857xgo56xbfmnif2c51` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FKho8mcicp4196ebpltdn9wl6co` FOREIGN KEY (`course_id`) REFERENCES `courses` (`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_requisites`
--

DROP TABLE IF EXISTS `pre_requisites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_requisites` (
  `PreRequisiteId` int NOT NULL AUTO_INCREMENT,
  `requisiteName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PreRequisiteId`),
  UNIQUE KEY `UKaopfj3kkhivxyrpbblf0nc33s` (`requisiteName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_requisites`
--

LOCK TABLES `pre_requisites` WRITE;
/*!40000 ALTER TABLE `pre_requisites` DISABLE KEYS */;
INSERT INTO `pre_requisites` VALUES (1,'A/L'),(2,'B.sc Degree'),(3,'M.sc degree');
/*!40000 ALTER TABLE `pre_requisites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regstudent`
--

DROP TABLE IF EXISTS `regstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regstudent` (
  `rstudentid` varchar(255) NOT NULL,
  `rname` varchar(255) DEFAULT NULL,
  `remail` varchar(255) DEFAULT NULL,
  `rdepartment` varchar(255) DEFAULT NULL,
  `rdob` date DEFAULT NULL,
  `ryear` varchar(255) DEFAULT NULL,
  `rcontack` varchar(255) DEFAULT NULL,
  `rnid` varchar(255) DEFAULT NULL,
  `rhcontack` varchar(255) DEFAULT NULL,
  `rschool` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `ral` varchar(255) DEFAULT NULL,
  `rprograme` varchar(255) DEFAULT NULL,
  `raddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rstudentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regstudent`
--

LOCK TABLES `regstudent` WRITE;
/*!40000 ALTER TABLE `regstudent` DISABLE KEYS */;
INSERT INTO `regstudent` VALUES ('S001','kamal','kamal@gmail.com','Management','2025-02-05','2 Year','076123456y','962861329v','0412269209','Rahula colleage matara','A3, B3,C3 ','A3','CMJD','kamal,newstreet,matara.'),('S0011','kamal','kamal@gmail.com','Management','2025-02-05','4 Year','0761234567','962861329v','0412269209','Rahula colleage matara','A3, B3,C3 ','A3','GDSE','kamal,newstreet,matara.'),('S004','nimal','jtjtj','Software Engineering','2025-02-05','1 Year','tyjejjjj','yjetj','jteje','jetjy','ejtje','jtyejy','GDSE','jjtejetj');
/*!40000 ALTER TABLE `regstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKovpqau8r3lgfnmak7xyel2bt0` (`roleName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin'),(3,'Faculty'),(2,'Student');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StudentId` varchar(255) NOT NULL,
  `StudentName` varchar(255) DEFAULT NULL,
  `StudentProgram` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`StudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('001','hd','dd');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentregcourse`
--

DROP TABLE IF EXISTS `studentregcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentregcourse` (
  `rcstudentid` varchar(255) NOT NULL,
  `rccourseid1` varchar(255) DEFAULT NULL,
  `rccourseid2` varchar(255) DEFAULT NULL,
  `rccourseid3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rcstudentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentregcourse`
--

LOCK TABLES `studentregcourse` WRITE;
/*!40000 ALTER TABLE `studentregcourse` DISABLE KEYS */;
INSERT INTO `studentregcourse` VALUES ('S001','CMJD','DEP','AI');
/*!40000 ALTER TABLE `studentregcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` varchar(255) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `contact_number` int DEFAULT NULL,
  `program` varchar(255) DEFAULT NULL,
  `student_dob` date DEFAULT NULL,
  `year` int DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UKg4fwvutq09fjdlb4bb0byp7t` (`user_id`),
  CONSTRAINT `FKdt1cjx5ve5bdabmuuf3ibrwaq` FOREIGN KEY (`user_id`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('S001','Jehan kumara','jehan@gmail.com',66234567,'It programming','1996-02-14',2025,3),('S002','Lahiru Kumara','lahiru@gmail.com',552345678,'It Programming','2002-02-06',2025,4),('S003','nimal Fernando','kamal@gmail.com',22345678,'Artificial Intelligence','1995-04-12',2026,5),('S005','kamal','kamal34@gmail.com',987654321,'it','2025-02-04',2024,17),('S006','kasun','k@gmail.com',761234567,'It','2025-02-06',2020,25),('S007','sudesh','sudesh@gmail.com',987654321,'it','2025-01-29',2020,27);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UKoxhihch3cx8k0vufoqnlq3kpl` (`userEmail`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'$2a$12$geZkrIca4NsY0ikXP1hn3OoOtuIV.r5M5LCQVzuJAxCY9Mn7OWQGu','jehan@gmail.com','Jehan kumara',1),(4,'$2a$12$D5WcOf7Y2H8L5SFa7B3mJ.Y1CZ4mok7hZKPEYORnSPymObmI5pPHm','lahiru@gmail.com','Lahiru Kumara',2),(5,'$2a$12$R9yeye/fV76yJy4fh8WePOpUrgHHTMjd9uNQd.8wQNzwt5PGvrvMy','kamal@gmail.com','nimal Fernando',2),(6,'$2a$12$8.ZzbuGW5BaKITBLbANXL.z0ePVpMO7U3OUeCDHl8Tywj/II3rv0G','kumara@yopmail.com','Kumara Thirimadura',1),(7,'$2a$12$p5Sr641PXwWez.Z9XIiOgezakdIxrqqnsmEQaUIb.3o4ZQbf5EApO','sumal@gmail.com','Sumal jayanath',2),(17,'$2a$12$HS3Y3kZ/zWcIzdMWlxxf2.IVtE.wyoEDkbXxHBqqiuKpbVx.N4yPy','kamal34@gmail.com','kamal',2),(20,'$2a$12$DLrspeCOCO6/48aNbiZHDugY5mZ7D9YJoCTrN6Jazk/GMzaYXX4BK','tqwt','r3rt2t',2),(23,'$2a$12$wL2wJuxZWgxaUN7dLdbZY.sz0ZEfcmhD9x8aBjp8OUfKKXJV7kHYG','nuwan@gmail.com','nuwan',2),(24,'$2a$12$p939qUKuyk2MA.Tmi0kTjOoKxBAwYviro8UjnBBa5LOfpuPgdqYyy','ery','ter',2),(25,'$2a$12$Ar3zMjca/qGB0D1Z48G0x.QuCRLcdfIzCFmTsp2AUwyensNixqapi','k@gmail.com','kasun',2),(27,'$2a$12$ChCo4QGGxKJa8x..3NYDeuQaLpbvK5OLNj.NqRg2ejKTFqNIqyoXa','sudesh@gmail.com','sudesh',2),(28,'$2a$12$WVEpuiy8XyOQUZ4i31aDJukDDM5LmNNnMnCuqdIgCVnmKHJQ9Ye4e','lasith@gmail.com','lasith kumara',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'courseregistrations'
--

--
-- Dumping routines for database 'courseregistrations'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-27 20:52:10
