-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2018 at 08:40 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ucenje`
--

-- --------------------------------------------------------

--
-- Table structure for table `lekcija`
--

CREATE TABLE `lekcija` (
  `id` int(11) NOT NULL,
  `naslov` varchar(150) NOT NULL,
  `trajanje` varchar(150) NOT NULL,
  `tezina` varchar(150) NOT NULL,
  `autor` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lekcija`
--

INSERT INTO `lekcija` (`id`, `naslov`, `trajanje`, `tezina`, `autor`) VALUES
(207, 'Test', 'Test', 'Lagano', 'Admin'),
(209, 'b', 'b', 'Napredno', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE `osoba` (
  `id` int(11) NOT NULL,
  `ime` varchar(150) NOT NULL,
  `prezime` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `lozinka` varchar(150) NOT NULL,
  `indeks` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `osoba`
--

INSERT INTO `osoba` (`id`, `ime`, `prezime`, `email`, `lozinka`, `indeks`) VALUES
(2, 'admin', 'admin', 'admin', 'admin', 'admin'),
(4, 'b', 'b', 'b', 'b', 'b');

-- --------------------------------------------------------

--
-- Table structure for table `stranica`
--

CREATE TABLE `stranica` (
  `id` int(11) NOT NULL,
  `naslov` varchar(50) NOT NULL,
  `podnaslov` varchar(50) NOT NULL,
  `sadrzaj` text NOT NULL,
  `broj` int(10) NOT NULL,
  `fk_lekcija` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stranica`
--

INSERT INTO `stranica` (`id`, `naslov`, `podnaslov`, `sadrzaj`, `broj`, `fk_lekcija`) VALUES
(107, 'b', 'b', 'b', 1, 209),
(108, 'b', 'b', 'bb', 2, 209);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lekcija`
--
ALTER TABLE `lekcija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_autor` (`autor`);

--
-- Indexes for table `osoba`
--
ALTER TABLE `osoba`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stranica`
--
ALTER TABLE `stranica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lekcija` (`fk_lekcija`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lekcija`
--
ALTER TABLE `lekcija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=210;

--
-- AUTO_INCREMENT for table `osoba`
--
ALTER TABLE `osoba`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `stranica`
--
ALTER TABLE `stranica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `stranica`
--
ALTER TABLE `stranica`
  ADD CONSTRAINT `stranica_ibfk_1` FOREIGN KEY (`fk_lekcija`) REFERENCES `lekcija` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
