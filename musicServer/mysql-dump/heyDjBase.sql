-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le :  mar. 10 sep. 2019 à 11:18
-- Version du serveur :  5.7.27
-- Version de PHP :  7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `heyDjBase`
--

-- --------------------------------------------------------

--
-- Structure de la table `bars`
--
create DATABASE heyDjBase ; 

CREATE TABLE `bars` (
  `id` int(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `address` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bars`
--

INSERT INTO `bars` (`id`, `name`, `address`) VALUES
(1, 'Le cristal', '28, rue vignon, 75008 Paris'),
(2, 'Le Paris Madere', '28 rue de caumartin');

-- --------------------------------------------------------

--
-- Structure de la table `songs`
--

CREATE TABLE `songs` (
  `id` int(11) NOT NULL,
  `uri` varchar(48) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idBar` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `songs`
--

INSERT INTO `songs` (`id`, `uri`, `date`, `idBar`) VALUES
(1, 'Fy1xQSiLx8U', '2019-09-10 11:17:47', 1),
(2, 'm3YX8zlR4BU', '2019-09-10 11:17:47', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bars`
--
ALTER TABLE `bars`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bars`
--
ALTER TABLE `bars`
  MODIFY `id` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `songs`
--
ALTER TABLE `songs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
