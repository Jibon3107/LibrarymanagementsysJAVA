-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2019 at 04:28 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Author` varchar(80) NOT NULL,
  `Publisher` varchar(50) NOT NULL,
  `Edition` varchar(80) NOT NULL,
  `CallNo` varchar(20) NOT NULL,
  `Rack` varchar(20) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `Name`, `Author`, `Publisher`, `Edition`, `CallNo`, `Rack`, `Quantity`) VALUES
(6, 'Advance Java', 'MD. EZAZUL ISLAM', 'Penguin Random House', '9th, 11th', '101', '2/4', 197),
(7, 'Operating System', 'Peter Baer Galvin', 'Brothers\' Publicatio', '5th, 7th', '102', '4/8', 150),
(8, 'Theory Of Computation', 'Michael Sipser', 'Cengage Learning', '3rd', '103', '3/6', 228),
(12, 'Computer Organization', 'Umme Marzia Haque ', 'Ananno Brothers', '3rd, 6th', '105', '3/8', 197),
(14, 'Advance Database', 'Sifat Rahman Ahona', 'Seba Publication', '3rd, 5th', '106', '4/8', 19),
(15, 'Compiler Design', 'Tohedul Islam', 'Penguin Random House', '7th, 11th', '107', '1/5', 280),
(16, 'Object Oriented Analysis', 'S. A. M. Manzur Hossain Khan', 'Cengage Learning', '11th', '108', '4/2', 200),
(17, 'Artificial Intelligence', 'Dr. Subir Nondi', 'Grim Publication', '5th, 7th', '109', '4/9', 180),
(18, 'Advance Datastructre ', 'Kaniz Fatema', 'Springer Nature', '2nd, 4th', '110', '8/12', 150),
(19, 'Comples And Z Transformation', 'Jenita Jahangir', 'Wiley (John Wiley & Sons)', '6th', '111', '11/5', 140);

-- --------------------------------------------------------

--
-- Table structure for table `current`
--

CREATE TABLE `current` (
  `ID` int(11) NOT NULL,
  `Name` int(11) NOT NULL,
  `CurrentTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `current`
--

INSERT INTO `current` (`ID`, `Name`, `CurrentTime`) VALUES
(1, 69, '2019-05-03 22:37:49');

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `ID` int(11) NOT NULL,
  `CallNo` varchar(20) NOT NULL,
  `UserName` varchar(20) NOT NULL,
  `IssueDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ReturnDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`ID`, `CallNo`, `UserName`, `IssueDate`, `ReturnDate`) VALUES
(2, '102', 'nurul1234', '2019-04-30 17:44:15', '2019-04-30 18:00:00'),
(4, '101', 'nurul1234', '2019-04-30 17:46:30', '2019-04-30 18:00:00'),
(5, '103', 'abir123', '2019-04-30 17:58:53', '2019-04-30 18:00:00'),
(6, '101', 'mustak123', '2019-04-30 18:41:47', '2019-04-30 18:00:00'),
(7, '101', 'mustak123', '2019-04-30 18:58:10', '2019-04-30 18:00:00'),
(10, '105', 'abir123', '2019-04-30 19:33:25', '2019-04-30 18:00:00'),
(11, '106', 'mustak123', '2019-05-01 03:59:42', '2019-04-30 18:00:00'),
(14, '106', 'hasan123', '2019-05-02 03:17:49', '2019-04-18 18:00:00'),
(15, '101', 'hasan123', '2019-05-02 11:02:01', '2019-04-18 18:00:00'),
(16, '101', 'mustak123', '2019-05-03 09:55:12', '2019-05-04 21:54:56'),
(17, '106', 'sabbir123', '2019-05-03 12:10:27', '2019-05-05 00:10:24'),
(18, '105', 'maruf123', '2019-05-03 12:11:49', '2019-05-05 00:11:39'),
(19, '102', 'maruf123', '2019-05-03 12:12:10', '2019-05-05 00:12:08'),
(20, '103', 'mustak123', '2019-05-03 13:46:27', '2019-05-05 01:46:23'),
(21, '105', 'mustak123', '2019-05-03 13:59:10', '2019-05-05 01:59:01'),
(22, '101', 'maruf123', '2019-05-03 22:37:19', '2019-05-05 22:37:06');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `EMail` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Contact` varchar(20) NOT NULL,
  `Status` varchar(1) NOT NULL,
  `Fine` varchar(20) NOT NULL,
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`ID`, `Name`, `EMail`, `Address`, `Contact`, `Status`, `Fine`, `UserName`, `Password`) VALUES
(1, 'Abir Hossain', 'abir@mail.com', 'Gabtoli, Dhaka', '0172453646', '0', '20', 'abir123', '12345'),
(2, 'Aysha Maliha', 'maliha@mail.com', 'Basundhara, Dhaka', '01763536377', '1', '0', 'maliha123', '12345'),
(5, 'Mustak Khaled', 'mustak@mail.com', 'Basundhara, Dhaka', '01763874873', '0', '0', 'mustak123', '12345'),
(10, 'Sabbir Ahamed', 'sabbir@mail.com', 'Baddha, Dhaka', '017263546', '0', '0', 'sabbir123', '12345'),
(11, 'Nurul Islam', 'nurul@gmail', 'Boshundhora', '0191077', '0', '0', 'nurul1234', '12345'),
(12, 'Maruf Ahamed', 'maruf@mail.com', 'Baddha, Dhaka', '023634783', '0', '0', 'maruf123', '12345'),
(13, 'Hasan Ali', 'hasan@mail.com', 'Mirpur, Dhaka', '0716353546', '0', '0', 'hasan123', '12345'),
(14, 'Subir Nondi', 'subir@mail.com', 'Farmgate, Dhaka', '0174536743', '1', '0', 'subir123', '12345'),
(15, 'Abdul Karim', 'karim@mail.com', 'Gulshan, Dhaka', '0173456745', '0', '0', 'karim123', '12345'),
(16, 'Mostofa Kabir', 'kabir@mail.com', 'Banani, Dhaka', '0172346576', '1', '0', 'kabir123', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CallNo` (`CallNo`);

--
-- Indexes for table `current`
--
ALTER TABLE `current`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UserName` (`UserName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `issuebook`
--
ALTER TABLE `issuebook`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
