-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2018 at 02:31 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sg_voting`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'studentgovernmentadmin', 'bsusc2018');

-- --------------------------------------------------------

--
-- Table structure for table `archivecandidates`
--

CREATE TABLE IF NOT EXISTS `archivecandidates` (
  `id_number` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `partylist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `archivecandidates`
--

INSERT INTO `archivecandidates` (`id_number`, `lastname`, `firstname`, `position`, `partylist`) VALUES
('', '', '', 'President', 'BulSUOne'),
('2015-501937', 'Somido', 'Guava', 'Vice Governor', 'STANDBulSU'),
('2016-500-150', 'Rodrigo', 'Asdasd', 'President', 'BulSUOne'),
('2016-500100', 'Reyes', 'Sheena', 'President', 'STANDBulSU'),
('2016-500103', 'Tampipi', 'Lyka', 'Governor', 'BulSUOne'),
('2016-500144', 'delacruz', 'shane', 'BEED BM', 'STANDBulSU'),
('2016-600101', 'Wong', 'Jay', 'BIT BM', 'STANDBulSU'),
('2018-500002', 'Smith', 'Sam', 'BSHM BM', 'STANDBulSU'),
('2018-600121', 'Ponce', 'Bryan', 'BSIT/ACT BM', 'BulSUOne'),
('2018-600125', 'Baldomar', 'Abby', 'BSIT/ACT BM', 'STANDBulSU');

-- --------------------------------------------------------

--
-- Table structure for table `archivestudents`
--

CREATE TABLE IF NOT EXISTS `archivestudents` (
  `ID` int(255) NOT NULL,
  `id_number` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `yearandsection` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `archivestudents`
--

INSERT INTO `archivestudents` (`ID`, `id_number`, `lastname`, `firstname`, `yearandsection`, `course`, `status`) VALUES
(1, '2016500028', 'orias123', 'lindsay', 'a1', 'BSBA', 'Not Voted Yet'),
(2, '2016500121', 'orias', 'buklat', 'espiritu', 'BIT', 'Not Voted Yet'),
(3, '2016500123', 'jepoy', 'jepoy', '3a1', 'BSIT', 'Not Voted Yet'),
(4, '2015502356', 'mislang', 'ailee', '3a1', 'BSIT', 'Not Voted Yet'),
(5, '2016-500-150', 'Rodrigo', 'Nikkie', '2A', 'BEED', 'Not Voted Yet'),
(6, '2016-500-150', 'Rodrigo', 'Nikkie', '2A', 'BEED', 'Not Voted Yet'),
(7, '2016-500-150', 'Rodrigo', 'Nikkie', '2A', 'BEED', 'Not Voted Yet'),
(8, '2016-500100', 'Reyes', 'Sheena', '2A', 'BSBA', 'Not Voted Yet'),
(9, '2016-500103', 'Tampipi', 'Lyka', '1B', 'BSBA', 'Not Voted Yet'),
(10, '2016-500100', 'Reyes', 'Sheena', '2A', 'BSBA', 'Not Voted Yet'),
(11, '2016-500100', 'Reyes', 'Sheena', '2A', 'BSBA', 'Not Voted Yet'),
(12, '2016-500-150', 'Rodrigo', 'Nikkie', '2A', 'BEED', 'Not Voted Yet'),
(13, '2016-500-150', 'Rodrigo', 'Nikkie', '2A', 'BEED', 'Not Voted Yet');

-- --------------------------------------------------------

--
-- Table structure for table `candidates`
--

CREATE TABLE IF NOT EXISTS `candidates` (
  `candidate_id` int(50) NOT NULL,
  `id_number` varchar(255) NOT NULL,
  `position_id` int(11) NOT NULL,
  `partylist` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidates`
--

INSERT INTO `candidates` (`candidate_id`, `id_number`, `position_id`, `partylist`) VALUES
(2, '2016-500100', 1, 'STANDBulSU'),
(3, '2016-500101', 2, 'BulSUOne'),
(4, '2016-500102', 2, 'STANDBulSU'),
(7, '2016-500105', 4, 'BulSUOne'),
(8, '2016-500106', 4, 'STANDBulSU'),
(9, '2016-500107', 8, 'BulSUOne'),
(10, '2016-500108', 8, 'STANDBulSU'),
(11, '2016-500143', 6, 'BulSUOne'),
(13, '2016-600100', 10, 'BulSUOne'),
(15, '2017-500101', 7, 'BulSUOne'),
(16, '2017-500102', 7, 'STANDBulSU'),
(17, '2018-500001', 9, 'BulSUOne'),
(21, '2018-500008', 1, 'BulSUOne'),
(24, '2015-501937', 3, 'STANDBulSU'),
(26, '2018-600123', 5, 'STANDBulSU'),
(27, '2018-600125', 5, 'BulSUOne'),
(28, '2016-500148', 3, 'BulSUOne'),
(29, '2016-600107', 3, 'STANDBulSU'),
(30, '2016-500149', 6, 'STANDBulSU'),
(31, '2016-600108', 10, 'STANDBulSU'),
(32, '2018-500006', 9, 'STANDBulSU');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `course_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_name`) VALUES
('BEED'),
('BIT'),
('BSBA'),
('BSED'),
('BSHM'),
('BSIT');

-- --------------------------------------------------------

--
-- Table structure for table `partylist`
--

CREATE TABLE IF NOT EXISTS `partylist` (
  `partylist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partylist`
--

INSERT INTO `partylist` (`partylist`) VALUES
('BulSUOne'),
('STANDBulSU');

-- --------------------------------------------------------

--
-- Table structure for table `positions`
--

CREATE TABLE IF NOT EXISTS `positions` (
  `position_id` int(11) NOT NULL,
  `position` varchar(255) NOT NULL,
  `position_type` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `positions`
--

INSERT INTO `positions` (`position_id`, `position`, `position_type`) VALUES
(1, 'President', 'Non-BM'),
(2, 'Vice President', 'Non-BM'),
(3, 'Governor', 'Non-BM'),
(4, 'Vice Governor', 'Non-BM'),
(5, 'BSIT/ACT BM', 'BM'),
(6, 'BEED BM', 'BM'),
(7, 'BSED BM', 'BM'),
(8, 'BSBA BM', 'BM'),
(9, 'BSHM BM', 'BM'),
(10, 'BIT BM', 'BM');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id_number` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `yearAndSection` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id_number`, `lastname`, `firstname`, `yearAndSection`, `course`, `gender`, `status`) VALUES
('2016-500-150', 'Rodrigo', 'Asdasd', '2f', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500100', 'Reyes', 'Sheena', '2A', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-500101', 'Gonzales', 'Chele', '2A', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-500102', 'Rs', 'Santos', '3A', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-500103', 'Tampipi', 'Lyka', '1B', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-500104', 'Galapong', 'Josh', '2B', 'BSBA', 'Male', 'Not Voted Yet'),
('2016-500105', 'Valdez', 'Ramir', '1B', 'BSBA', 'Male', 'Not Voted Yet'),
('2016-500106', 'Delosreyes', 'Shaina', '2B', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-500107', 'Guzman', 'Ville', '2B', 'BIT', 'Male', 'Not Voted Yet'),
('2016-500108', 'Daroy', 'Trixia', '4A', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500109', 'Santos', 'Mark', '3B', 'BSBA', 'Male', 'Not Voted Yet'),
('2016-500143', 'ganhinhin', 'trina', '3A', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500144', 'delacruz', 'shane', '4b', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500145', 'cruz', 'domingo', '1B', 'BEED', 'Male', 'Not Voted Yet'),
('2016-500146', 'ramirez', 'james', '2A', 'BEED', 'Male', 'Not Voted Yet'),
('2016-500147', 'quirino', 'elpidio', '2C', 'BEED', 'Male', 'Not Voted Yet'),
('2016-500148', 'magsaysay', 'ramon', '3C', 'BEED', 'Male', 'Not Voted Yet'),
('2016-500149', 'arroyi', 'trinidad', '2D', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500151', 'Manawis', 'Monica', '3A', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500152', 'San Martin', 'Mimay', '4A', 'BEED', 'Female', 'Not Voted Yet'),
('2016-500250', 'padua', 'reynald', '3a1', 'BSIT', 'Male', 'Not Voted Yet'),
('2016-600100', 'Alcantara', 'Angelu', '4C', 'BSBA', 'Female', 'Not Voted Yet'),
('2016-600101', 'Wong', 'Jay', '3B', 'BIT', 'Male', 'Not Voted Yet'),
('2016-600102', 'Fabia', 'Shyla', '3D', 'BIT', 'Female', 'Not Voted Yet'),
('2016-600103', 'Garcia', 'Aries', '3A', 'BIT', 'Male', 'Not Voted Yet'),
('2016-600104', 'Somido', 'Jayrold', '3A', 'BIT', 'Male', 'Not Voted Yet'),
('2016-600105', 'Mislang', 'Ailee', '2C', 'BIT', 'Female', 'Not Voted Yet'),
('2016-600106', 'Calajate', 'Buklat', '3A', 'BIT', 'Male', 'Not Voted Yet'),
('2016-600107', 'Manaois', 'Divine', '4A', 'BIT', 'Female', 'Not Voted Yet'),
('2016-600108', 'Apurillo', 'Chikay', '4a', 'BIT', 'Male', 'Not Voted Yet'),
('2016-600109', 'Aytona', 'She', '4C', 'BIT', 'Female', 'Not Voted Yet'),
('2016500218', 'pacia', 'roer', '3a1', 'BSIT', 'Male', 'Not Voted Yet'),
('2017-500101', 'Guma', 'Jerome', '4A', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500102', 'Klein', 'Calvin', '2B', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500103', 'Gomez', 'Angelito', '4A', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500104', 'Marchan', 'Sheng', '2A', 'BSED', 'Female', 'Not Voted Yet'),
('2017-500105', 'Paloma', 'Mego', '2B', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500106', 'Deguzman', 'Jenard', '3B', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500107', 'Pascual', 'Kyle', '2B', 'BSED', 'Female', 'Not Voted Yet'),
('2017-500108', 'Celis', 'Joy', '3B', 'BSED', 'Female', 'Not Voted Yet'),
('2017-500109', 'Avendano', 'Joel', '4C', 'BSED', 'Male', 'Not Voted Yet'),
('2017-500110', 'Cruz', 'Boyet', '3C', 'BSED', 'Male', 'Not Voted Yet'),
('2018-500001', 'Vincent', 'Joseph', '3B', 'BSHM', 'Male', 'Not Voted Yet'),
('2018-500002', 'Smith', 'Sam', '2B', 'BSHM', 'Male', 'Not Voted Yet'),
('2018-500003', 'Berdin', 'Janine', '3A', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500004', 'Gonzaga', 'Ariane', '1B', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500005', 'DelosReyes', 'Ivy', '1B', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500006', 'Carreon', 'Jane', '1B', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500007', 'Genovate', 'Cyril', '1A', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500008', 'Alcazar', 'Perla', '4B', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500009', 'Austria', 'Princes', '1B', 'BSHM', 'Female', 'Not Voted Yet'),
('2018-500010', 'Arcan', 'Levi', '3A', 'BSHM', 'Male', 'Not Voted Yet'),
('2018-600121', 'Ponce', 'Bryan', '2B', 'BSIT', 'Male', 'Not Voted Yet'),
('2018-600122', 'Angeles', 'Rome', '2A', 'BSIT', 'Male', 'Not Voted Yet'),
('2018-600123', 'Felomino', 'Roseanne', '3B', 'BSIT', 'Female', 'Not Voted Yet'),
('2018-600124', 'Cruz', 'Faith', '2C', 'BSIT', 'Female', 'Not Voted Yet'),
('2018-600125', 'Baldomar', 'Abby', '3A', 'BSIT', 'Female', 'Not Voted Yet'),
('2018-600126', 'Brigino', 'Joshua', '3A', 'BSIT', 'Male', 'Not Voted Yet'),
('2018-600127', 'Pecson', 'Mark', '3B', 'BSIT', 'Male', 'Not Voted Yet'),
('2018-600128', 'Lopez', 'Juliet', '2A', 'BSIT', 'Female', 'Not Voted Yet'),
('2018-600129', 'Gonzales', 'Anthony', '1B', 'BSIT', 'Female', 'Not Voted Yet'),
('2018-600130', 'Pacia', 'Roer', '3A', 'BSIT', 'Male', 'Not Voted Yet');

-- --------------------------------------------------------

--
-- Table structure for table `voting_tally`
--

CREATE TABLE IF NOT EXISTS `voting_tally` (
  `id` int(11) NOT NULL,
  `id_number` varchar(255) NOT NULL,
  `candidate_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `archivecandidates`
--
ALTER TABLE `archivecandidates`
  ADD PRIMARY KEY (`id_number`);

--
-- Indexes for table `archivestudents`
--
ALTER TABLE `archivestudents`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `candidates`
--
ALTER TABLE `candidates`
  ADD PRIMARY KEY (`candidate_id`),
  ADD KEY `id_number` (`id_number`),
  ADD KEY `position_id` (`position_id`),
  ADD KEY `partylist` (`partylist`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_name`);

--
-- Indexes for table `partylist`
--
ALTER TABLE `partylist`
  ADD PRIMARY KEY (`partylist`);

--
-- Indexes for table `positions`
--
ALTER TABLE `positions`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id_number`),
  ADD KEY `course` (`course`);

--
-- Indexes for table `voting_tally`
--
ALTER TABLE `voting_tally`
  ADD PRIMARY KEY (`id`),
  ADD KEY `candidate_id` (`candidate_id`),
  ADD KEY `id_number` (`id_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `archivestudents`
--
ALTER TABLE `archivestudents`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `candidates`
--
ALTER TABLE `candidates`
  MODIFY `candidate_id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `positions`
--
ALTER TABLE `positions`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `voting_tally`
--
ALTER TABLE `voting_tally`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=161;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `candidates`
--
ALTER TABLE `candidates`
  ADD CONSTRAINT `candidates_ibfk_1` FOREIGN KEY (`id_number`) REFERENCES `students` (`id_number`),
  ADD CONSTRAINT `candidates_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`),
  ADD CONSTRAINT `candidates_ibfk_3` FOREIGN KEY (`partylist`) REFERENCES `partylist` (`partylist`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`course`) REFERENCES `courses` (`course_name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
