-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinebankingg
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accno` bigint NOT NULL,
  `balance` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,391491820101,1800,'johndoe',1),(2,391491820102,2500,'alicesmith',2),(3,391491820103,500,'bobjohnson',3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chequebook_requests`
--

DROP TABLE IF EXISTS `chequebook_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chequebook_requests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_number` bigint NOT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `request_status` tinyint(1) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `number_of_pages` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chequebook_requests`
--

LOCK TABLES `chequebook_requests` WRITE;
/*!40000 ALTER TABLE `chequebook_requests` DISABLE KEYS */;
INSERT INTO `chequebook_requests` VALUES (1,391491820101,'Primary',1,'2023-09-05',20),(2,9876543210,'Savings',0,'2023-09-06',10),(3,391491820102,'Primary',1,'2023-09-07',15),(4,391491820101,'Primary',1,'2023-09-05',20),(5,1234567890,'Savings',0,'2023-09-06',10),(6,391491820103,'Primary',1,'2023-09-07',15);
/*!40000 ALTER TABLE `chequebook_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `annual_Income` varchar(255) DEFAULT NULL,
  `loan_Used_For` varchar(255) DEFAULT NULL,
  `loan_Status` varchar(10) DEFAULT 'Pending',
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (1,5000,'45000','Home Improvement','Approved',1),(2,3000,'35000','Education','Pending',2),(3,10000,'60000','Car Purchase','Rejected',3);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saccount`
--

DROP TABLE IF EXISTS `saccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saccount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accno` bigint NOT NULL,
  `balance` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `saccount_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saccount`
--

LOCK TABLES `saccount` WRITE;
/*!40000 ALTER TABLE `saccount` DISABLE KEYS */;
INSERT INTO `saccount` VALUES (1,9876543210,1500,'johndoe',1),(2,1234567890,3000,'alicesmith',2),(3,7894561230,5800,'bobjohnson',3);
/*!40000 ALTER TABLE `saccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `saccount` bigint NOT NULL,
  `raccount` bigint NOT NULL,
  `amount` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer`
--

LOCK TABLES `transfer` WRITE;
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` VALUES (1,123456789,9876543210,200,'2023-09-05'),(2,391491820101,7894561230,150,'2023-09-06'),(3,456789123,391491820102,300,'2023-09-07'),(4,391491820103,7894561230,500,'2023-09-09');
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `identity_type` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `authorization_status` tinyint(1) DEFAULT '0',
  `feature_status` int DEFAULT '3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John','Doe',391491820101,'123 Main St','john.doe@example.com','johndoe','password123','1990-01-15','SSN','123-45-6789',0,1,3),(2,'Alice','Smith',391491820102,'456 Elm St','alice.smith@example.com','alicesmith','securepass','1985-03-20','Driver License','DL123456',0,1,3),(3,'Bob','Johnson',391491820103,'789 Oak St','bob.johnson@example.com','bobjohnson','p@ssw0rd','1995-07-10','Passport','P1234567',0,1,3),(4,'ck','yC',567667890,'122 Main St, City','ck@example.com','ck','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','1990-01-01','Passport','AB1234567',0,0,3),(5,'kathir','C',967667890,'1256 Main St, City','kathir@example.com','Kathir','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','1990-01-01','Passport','AB1234567',0,0,3),(6,'Dharani','Ck',8997667890,'128956 Main St, City','dharani@example.com','dharani','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','1990-01-01','Passport','AB1234567',0,0,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_display`
--

DROP TABLE IF EXISTS `user_display`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_display` (
  `username` varchar(255) NOT NULL,
  `primaryAccno` bigint DEFAULT NULL,
  `primaryBalance` int DEFAULT NULL,
  `savingsAccno` bigint DEFAULT NULL,
  `savingsBalance` int DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_display`
--

LOCK TABLES `user_display` WRITE;
/*!40000 ALTER TABLE `user_display` DISABLE KEYS */;
INSERT INTO `user_display` VALUES ('alicesmith',391491820102,2500,1234567890,1000),('bobjohnson',391491820103,500,7894561230,1500),('johndoe',391491820101,1000,9876543210,2500);
/*!40000 ALTER TABLE `user_display` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` bigint DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_history`
--

LOCK TABLES `user_history` WRITE;
/*!40000 ALTER TABLE `user_history` DISABLE KEYS */;
INSERT INTO `user_history` VALUES (1,1234567890,100,'Deposit','2023-09-05'),(2,391491820103,500,'Withdraw','2023-09-06'),(3,391491820101,200,'Deposit','2023-09-07'),(4,7894561230,800,'deposit','2023-09-12'),(5,391491820101,800,'credit','2023-09-12');
/*!40000 ALTER TABLE `user_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-12 20:47:03
