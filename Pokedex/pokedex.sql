CREATE DATABASE  IF NOT EXISTS `pokedex` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokedex`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokedex
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `pokemons`
--

DROP TABLE IF EXISTS `pokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(500) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `evolvesTo` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `isFavorite` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons`
--

LOCK TABLES `pokemons` WRITE;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` VALUES (16,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\bulbasaur.png','Bulbasaur',6.9,0.7,'Grass','Ivysaur','A seed Pokemon with a bulb on its back. The bulb grows as Bulbasaur gains experience.',0),(17,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\caterpie.png','Caterpie',2.2,0.3,'Bug',NULL,'The first form of a butterfly Pokemon. It feeds constantly to store energy for evolution.',1),(18,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\charizard.png','Charizard',90,1.7,'Fire','','A powerful flying lizard Pokemon. Charizards fire grows hotter as it battles.',0),(19,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\charmander.png','Charmander',8.5,0.6,'Fire','Charmeleon','The first evolution of a fire-breathing lizard Pokemon. The flame on its tail is an indicator of its health.',0),(20,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\charmeleon.png','Charmeleon',56,1.1,'Fire','Charizard','The middle evolution of a fire-breathing lizard Pokemon. Charmeleons fire burns hotter and fiercer than Charmander.',1),(21,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\eevee.png','Eevee',6.5,0.3,'Normal',NULL,'A fox-like Pokemon with the potential to evolve into various forms depending on external stimuli.',0),(22,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\ivysaur.png','Ivysaur',13,1,'Grass','Venusaur','The evolved form of Bulbasaur. The bulb on its back has grown larger and sprouted a flower.',0),(23,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\jigglypuff.png','Jigglypuff',9.5,0.5,'Normal',NULL,'A pink puffball Pokemon known for its singing voice. Jigglypuff sings to make people sleep, then draws on their nightmares.',0),(24,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\meowth.png','Meowth',4.2,0.4,'Normal',NULL,'A cat Pokemon known for its fondness for coins. Meowth can stand upright and walk on two legs.',0),(25,'C:\\\\Users\\\\Rafid\\\\IdeaProjects\\\\Pokedex\\\\src\\\\main\\\\resources\\\\com\\\\example\\\\pokedex\\\\images\\\\mew.png','Mew',4,0.4,'Psychic',NULL,'A rare and mysterious Psychic-type Pokemon said to be the ancestor of all Pokemon.',0),(31,NULL,'Pikachu',6,0.4,'Electric',NULL,'An iconic electric mouse Pokemon. Pikachu stores electricity in its cheeks and can unleash powerful electric attacks.',0),(32,NULL,'Psyduck',19.6,0.8,'Water',NULL,'A duck Pokemon with strong psychic powers. Psyduck is constantly confused by its own abilities.',0),(33,NULL,'Squirtle',9,0.5,'Water',NULL,'A small turtle Pokemon that can withdraw into its shell for protection. Squirtle can also fire water jets from its mouth.',0),(34,NULL,'Venusaur',100,2,'Grass',NULL,'The final evolution of Bulbasaur. The bulb on its back has blossomed into a large flower with a sweet aroma.',1),(35,NULL,'Blastoise',85.5,1.6,'Water',NULL,'The final evolution of Squirtle. Blastoise has powerful water cannons mounted on its back that can fire jets of water with incredible force.',1);
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-22 22:54:12
