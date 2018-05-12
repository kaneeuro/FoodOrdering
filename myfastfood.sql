-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  sam. 28 avr. 2018 à 14:12
-- Version du serveur :  5.6.35
-- Version de PHP :  7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `myfastfood`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id_article` bigint(20) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `id_categorie` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `designation`, `prix`, `id_categorie`, `image_url`) VALUES
(1, 'Thiebou djeune', 1200, 1, 'http://10.0.2.2/FoodOrdering/images/uploads/platsdujour.png'),
(2, 'Yassa guinaar', 1500, 1, 'http://10.0.2.2/FoodOrdering/images/uploads/platsdujour.png'),
(3, 'Mafé', 1000, 1, 'http://10.0.2.2/FoodOrdering/images/uploads/platsdujour.png'),
(5, 'Pain au chocolat', 500, 2, 'http://10.0.2.2/FoodOrdering/images/uploads/patisserie.jpg'),
(6, 'Chausson aux pommes', 600, 2, 'http://10.0.2.2/FoodOrdering/images/uploads/patisserie.jpg'),
(7, 'Cake aux fruits', 1900, 2, 'http://10.0.2.2/FoodOrdering/images/uploads/patisserie.jpg'),
(8, 'Bûche Délice vanille', 7200, 12, 'http://10.0.2.2/FoodOrdering/images/uploads/placeholder.jpg'),
(9, 'Salade de fruits', 2500, 10, 'http://10.0.2.2/FoodOrdering/images/uploads/fruits.jpg'),
(10, 'Formule Brunch', 5000, 2, 'http://10.0.2.2/FoodOrdering/images/uploads/patisserie.jpg'),
(11, 'Crêpe au sucre', 1500, 10, 'http://10.0.2.2/FoodOrdering/images/uploads/fruits.jpg'),
(12, 'Gâteau vanille chocolat', 10000, 2, 'http://10.0.2.2/FoodOrdering/images/uploads/patisserie.jpg'),
(13, 'Hamburger simple', 1400, 6, 'http://10.0.2.2/FoodOrdering/images/uploads/hamburger-french-fries.jpg'),
(16, 'Hamburger complet', 1600, 6, 'http://10.0.2.2/FoodOrdering/images/uploads/hamburger-french-fries.jpg'),
(17, 'Chawarma', 1300, 6, 'http://10.0.2.2/FoodOrdering/images/uploads/hamburger-french-fries.jpg'),
(18, 'Crêpe au chocolat', 950, 10, 'http://10.0.2.2/FoodOrdering/images/uploads/fruits.jpg'),
(19, 'Bûche moka Danish', 6000, 12, 'http://10.0.2.2/FoodOrdering/images/uploads/placeholder.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

CREATE TABLE `catalogue` (
  `id_catalogue` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_resto` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`id_catalogue`, `nom`, `id_resto`, `image_url`) VALUES
(1, 'Catalogue 1', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_catalogue` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom`, `id_catalogue`, `image_url`) VALUES
(1, 'Plats du jour', 1, 'http://10.0.2.2/FoodOrdering/images/uploads/meal.png'),
(2, 'Viennoiseries', 1, 'http://10.0.2.2/FoodOrdering/images/uploads/viennoiserie.png'),
(3, 'Salades et entrées', 1, NULL),
(4, 'Assiettes', 1, NULL),
(5, 'Plats cuisinés', 1, NULL),
(6, 'Fast-food', 1, 'http://10.0.2.2/FoodOrdering/images/uploads/5851279-fastfood.jpg'),
(7, 'Salés', 1, NULL),
(8, 'Pizzas', 1, NULL),
(9, 'Omelettes', 1, NULL),
(10, 'Desserts', 1, 'http://10.0.2.2/FoodOrdering/images/uploads/fruits.jpg'),
(11, 'Boissons', 1, NULL),
(12, 'Spécialités', 1, 'http://10.0.2.2/FoodOrdering/images/uploads/placeholder.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `numero` bigint(20) DEFAULT NULL,
  `statut` int(11) NOT NULL,
  `id_comptable` bigint(20) DEFAULT NULL,
  `id_cuisinier` bigint(20) DEFAULT NULL,
  `id_serveur` bigint(20) NOT NULL,
  `id_table` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `date`, `numero`, `statut`, `id_comptable`, `id_cuisinier`, `id_serveur`, `id_table`) VALUES
(1, '16-03-2018 14:00:39', 8647511570, 1, NULL, NULL, 1, 1),
(2, '17-03-2018 14:30:15', 7850746047, 3, 3, NULL, 1, 3),
(4, '17-03-2018 14:43:20', 5036827714, 2, NULL, NULL, 1, 2),
(5, '17-03-2018 15:01:30', 4394631844, 1, NULL, NULL, 1, 5),
(6, '17-03-2018 15:11:35', 7910286610, 1, NULL, NULL, 1, 1),
(7, '17-03-2018 15:20:30', 5208117932, 1, NULL, NULL, 1, 2),
(8, '17-03-2018 15:31:30', 6294040129, 1, NULL, NULL, 1, 6),
(9, '20-02-2018 14:30:00', 8188395549, 1, NULL, NULL, 1, 6),
(10, '20-02-2018 14:30:00', 7531891346, 1, NULL, NULL, 1, 2),
(11, '20-02-2018 14:30:00', 6551319688, 1, NULL, NULL, 1, 5),
(12, '20-02-2018 14:30:00', 7085426609, 1, NULL, NULL, 1, 7),
(13, '20-02-2018 14:30:00', 2463534575, 1, NULL, NULL, 1, 5),
(14, '20-02-2018 14:30:00', 5856893669, 1, NULL, NULL, 1, 8),
(15, '20-02-2018 14:30:00', 1061088634, 1, NULL, NULL, 1, 5),
(16, '20-02-2018 14:30:00', 6252591208, 1, NULL, NULL, 1, 9),
(17, '20-02-2018 14:30:00', 2660038617, 1, NULL, NULL, 1, 5),
(18, '20-02-2018 14:30:00', 5150237334, 1, NULL, NULL, 1, 10),
(19, '20-02-2018 14:30:00', 7444545435, 1, NULL, NULL, 1, 5),
(20, '20-02-2018 14:30:00', 7361510804, 1, NULL, NULL, 1, 11),
(21, '20-02-2018 14:30:00', 7265948030, 1, NULL, NULL, 1, 2),
(22, '20-02-2018 14:30:00', 2789229110, 1, NULL, NULL, 1, 1),
(23, '20-02-2018 14:30:00', 8032538969, 1, NULL, NULL, 1, 2),
(24, '20-02-2018 14:30:00', 2564503207, 1, NULL, NULL, 1, 9),
(25, '20-02-2018 14:30:00', 1648397014, 1, NULL, NULL, 1, 8),
(26, '20-02-2018 14:30:00', 8703934261, 1, NULL, NULL, 1, 12),
(27, '20-02-2018 14:30:00', 8000320697, 1, NULL, NULL, 1, 5),
(28, '20-02-2018 14:30:00', 6822730875, 1, NULL, NULL, 1, 2),
(29, '20-02-2018 14:30:00', 6035356481, 1, NULL, NULL, 1, 2),
(30, '20-02-2018 14:30:00', 2102914152, 1, NULL, NULL, 1, 1),
(31, '25-02-2018 18:43:32', 1501165461, 1, NULL, NULL, 1, 6),
(32, '24-03-2018 13:16:00', 3350254777, 1, NULL, NULL, 1, 13),
(33, '24-03-2018 18:42:22', 3915458354, 1, NULL, NULL, 1, 1),
(34, '24-03-2018 18:49:53', 1362729400, 1, NULL, NULL, 1, 9);

-- --------------------------------------------------------

--
-- Structure de la table `commande_article`
--

CREATE TABLE `commande_article` (
  `id_commande_article` bigint(20) NOT NULL,
  `prix_total` double NOT NULL,
  `prix_unitaire` double NOT NULL,
  `quantite` bigint(20) DEFAULT NULL,
  `id_article` bigint(20) NOT NULL,
  `id_commande` bigint(20) NOT NULL,
  `statut` int(11) NOT NULL DEFAULT '0',
  `id_cuisinier` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande_article`
--

INSERT INTO `commande_article` (`id_commande_article`, `prix_total`, `prix_unitaire`, `quantite`, `id_article`, `id_commande`, `statut`, `id_cuisinier`) VALUES
(1, 1200, 1200, 1, 1, 1, 1, 2),
(2, 1500, 1500, 1, 2, 2, 1, 2),
(4, 2000, 2000, 1, 3, 4, 1, 2),
(5, 1900, 1900, 1, 7, 4, 0, NULL),
(6, 5000, 5000, 1, 10, 5, 0, NULL),
(7, 10000, 10000, 1, 12, 5, 0, NULL),
(8, 1200, 1200, 1, 1, 6, 0, NULL),
(9, 1900, 1900, 1, 7, 6, 0, NULL),
(10, 10000, 10000, 1, 12, 6, 0, NULL),
(11, 1200, 1200, 1, 1, 7, 0, NULL),
(12, 1000, 1000, 1, 9, 7, 0, NULL),
(13, 1500, 1500, 1, 2, 7, 0, NULL),
(14, 400, 400, 1, 11, 7, 0, NULL),
(15, 1500, 1500, 1, 2, 8, 0, NULL),
(16, 10000, 10000, 1, 12, 9, 0, NULL),
(17, 5000, 5000, 1, 10, 9, 0, NULL),
(18, 1200, 1200, 1, 1, 10, 0, NULL),
(19, 1000, 1000, 1, 9, 10, 0, NULL),
(20, 10000, 10000, 1, 12, 11, 0, NULL),
(21, 4500, 1500, 3, 2, 12, 0, NULL),
(22, 1900, 1900, 1, 7, 12, 0, NULL),
(23, 2000, 1000, 2, 9, 12, 0, NULL),
(24, 6000, 1500, 4, 17, 13, 0, NULL),
(25, 4000, 2000, 2, 9, 13, 0, NULL),
(26, 950, 950, 1, 18, 13, 0, NULL),
(27, 2000, 2000, 1, 8, 14, 0, NULL),
(28, 1500, 1500, 1, 16, 14, 0, NULL),
(29, 1500, 1500, 1, 2, 14, 0, NULL),
(30, 1200, 1200, 1, 1, 15, 0, NULL),
(31, 500, 500, 1, 5, 15, 0, NULL),
(32, 1000, 1000, 1, 13, 15, 0, NULL),
(33, 4500, 1500, 3, 2, 16, 0, NULL),
(34, 3000, 1500, 2, 17, 17, 0, NULL),
(35, 4000, 2000, 2, 9, 17, 0, NULL),
(36, 2400, 1200, 2, 1, 18, 0, NULL),
(37, 3800, 1900, 2, 7, 18, 0, NULL),
(38, 2000, 2000, 1, 8, 18, 0, NULL),
(39, 4000, 2000, 2, 3, 19, 0, NULL),
(40, 400, 400, 1, 11, 19, 0, NULL),
(41, 2400, 1200, 2, 1, 20, 0, NULL),
(42, 2000, 2000, 1, 3, 20, 0, NULL),
(43, 2000, 2000, 1, 8, 20, 0, NULL),
(44, 1200, 1200, 1, 1, 21, 0, NULL),
(45, 1500, 1500, 1, 17, 22, 0, NULL),
(46, 950, 950, 1, 18, 22, 0, NULL),
(47, 1500, 1500, 1, 16, 23, 0, NULL),
(48, 4000, 2000, 2, 9, 23, 0, NULL),
(49, 1500, 1500, 1, 2, 24, 0, NULL),
(50, 1200, 1200, 1, 1, 25, 0, NULL),
(51, 2000, 2000, 1, 3, 25, 0, NULL),
(52, 4500, 1500, 3, 2, 26, 0, NULL),
(53, 10000, 10000, 1, 12, 26, 0, NULL),
(54, 1500, 1500, 1, 17, 26, 0, NULL),
(55, 2000, 2000, 1, 9, 26, 0, NULL),
(56, 2400, 1200, 2, 1, 27, 0, NULL),
(57, 3000, 1500, 2, 2, 28, 0, NULL),
(58, 1900, 1900, 1, 7, 28, 0, NULL),
(59, 5000, 2500, 2, 9, 28, 0, NULL),
(60, 3000, 1500, 2, 2, 29, 0, NULL),
(61, 1900, 1900, 1, 7, 29, 0, NULL),
(62, 7500, 2500, 3, 9, 29, 0, NULL),
(63, 2000, 1000, 2, 3, 30, 0, NULL),
(64, 10000, 5000, 2, 10, 31, 0, NULL),
(65, 3600, 1200, 3, 1, 32, 1, 2),
(66, 5000, 5000, 1, 10, 32, 1, 2),
(67, 6000, 6000, 1, 19, 32, 1, 2),
(68, 14400, 7200, 2, 8, 33, 1, 2),
(69, 20000, 10000, 2, 12, 34, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `commande_article_temporaire`
--

CREATE TABLE `commande_article_temporaire` (
  `id_commande_article_temporaire` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `id_article` bigint(20) DEFAULT NULL,
  `id_compte` bigint(20) DEFAULT NULL,
  `id_employe` bigint(20) DEFAULT NULL,
  `id_table` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` bigint(20) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `id_employe` bigint(20) NOT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `login`, `password`, `role`, `id_employe`, `token`) VALUES
(1, 'l', 'p', 'SERVEUR', 1, 'dxtvBQQ4TkM:APA91bHrOpKml6Sa5YSgvRbdJCtGU8d4fcW83ppoeiz9PRnT0BOVC_SqXiim7HXxq0bWcyCRssIoYBTyTM2tNI8Q9lUazhn860iwVTD4gmLVa9Bd65cHv_Z0dLbc8lQd-SKVdvO2gh-o'),
(2, 'll', 'pp', 'CUISINIER', 2, 'cleIFSkxzkI:APA91bF1YDaG3n2VBEAewioe0mvllr8g8D-htNtIb6-If9jLvA5mXgbYWlB6r4tJyX8aGAhNkWViIumFEAj72KiWoRhn7NuQ2sVV2pwceSPqk3OyF_-ixudj3vW1tH7JzqDi5D_GdSYw'),
(3, 'lll', 'ppp', 'COMPTABLE', 3, 'dxtvBQQ4TkM:APA91bHrOpKml6Sa5YSgvRbdJCtGU8d4fcW83ppoeiz9PRnT0BOVC_SqXiim7HXxq0bWcyCRssIoYBTyTM2tNI8Q9lUazhn860iwVTD4gmLVa9Bd65cHv_Z0dLbc8lQd-SKVdvO2gh-o');

-- --------------------------------------------------------

--
-- Structure de la table `cuisine`
--

CREATE TABLE `cuisine` (
  `id_cuisine` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_resto` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cuisine`
--

INSERT INTO `cuisine` (`id_cuisine`, `nom`, `type`, `id_resto`, `image_url`) VALUES
(1, 'Cuisine 1', 'Type 1', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `token` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `devices`
--

INSERT INTO `devices` (`id`, `email`, `token`) VALUES
(1, 'kaneeuro@gmail.com', 'deSrahJ8lDE:APA91bENcNMJ9CoMgKOuF6AbAPnNTgEwpOJaHL01vqwF3UulriQnP1KJTpRzcgj41d2vtg2SpVs-NQkFt5uPIyZKcvrBWFkw2zhBOLCd8DdQRUOj_85r9Q1r8szTICxbnh1gCd-2EPRV'),
(2, 'modykane@gmail.com', 'fUJKxDTKkHE:APA91bFxb5riBjZwy1O85m2j5kbfh365ab3JfIiS5vyVE4v7aU_Fnv72YpASzkvEOLByyrnTGn6rvpDkd0oTfDKRetiPxfCwBcpcPrtu5IxtZekm2mNpa5JRJBpujwXw4j7cUjkITEWb');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id_employe` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `matricule` varchar(255) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `id_cuisine` bigint(20) DEFAULT NULL,
  `id_resto` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id_employe`, `email`, `fonction`, `matricule`, `nom`, `prenom`, `telephone`, `id_cuisine`, `id_resto`, `image_url`) VALUES
(1, 'adamadiallo@gmail.com', 'Serveur', 'EMP0001', 'DIALLO', 'Adama', '771234567', 1, 1, 'http://10.0.2.2/FoodOrdering/images/uploads/user_female.png'),
(2, 'azizfall@gmail.com', 'Cuisinier', 'EMP0002', 'FALL', 'Aziz', '771234568', 1, 1, NULL),
(3, 'chaikhoutop@gmail.com', 'Comptable', 'EMP0003', 'TOP', 'Chaikhou', '771234569', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

CREATE TABLE `restaurant` (
  `id_resto` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `restaurant`
--

INSERT INTO `restaurant` (`id_resto`, `adresse`, `code`, `designation`, `email`, `telephone`, `image_url`) VALUES
(1, 'Almadies, Dakar', 'RESTO001', 'Food Ordering', 'myresto@gmail.com', '338601234', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tables`
--

CREATE TABLE `tables` (
  `id_table` bigint(20) NOT NULL,
  `nombre_place` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tables`
--

INSERT INTO `tables` (`id_table`, `nombre_place`, `numero`) VALUES
(1, 4, 1),
(2, 6, 2),
(3, 2, 18),
(5, 2, 3),
(6, 2, 7),
(7, 2, 19),
(8, 2, 6),
(9, 2, 5),
(10, 2, 9),
(11, 2, 8),
(12, 2, 100),
(13, 2, 10);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`),
  ADD KEY `FK5qbslk1ioudummgell60ha69j` (`id_categorie`);

--
-- Index pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id_catalogue`),
  ADD KEY `FKp4n67r10q2y3h1qaklicn4u3w` (`id_resto`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`),
  ADD KEY `FKd4nnux3bd6nv6etdk7wnm885o` (`id_catalogue`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `FKls4tu9udpkuu4ajncadt7iack` (`id_comptable`),
  ADD KEY `FK8sx2joni6ihxdkhqn6tujuqkj` (`id_cuisinier`),
  ADD KEY `FKdll5kq43j1etbnx1gdttpnvtv` (`id_serveur`),
  ADD KEY `FKfymbwwqaetnxrvu2ak1u0x296` (`id_table`);

--
-- Index pour la table `commande_article`
--
ALTER TABLE `commande_article`
  ADD PRIMARY KEY (`id_commande_article`),
  ADD KEY `FK1oj919k5kluteecator3cr33n` (`id_article`),
  ADD KEY `FKp7o0b8tl4dw3ipdwnbwq5ifvr` (`id_commande`),
  ADD KEY `FKepfr6njnymsrn9yodn10ptnwf` (`id_cuisinier`);

--
-- Index pour la table `commande_article_temporaire`
--
ALTER TABLE `commande_article_temporaire`
  ADD PRIMARY KEY (`id_commande_article_temporaire`),
  ADD KEY `FKnduy7bwqgihpfdlbrx8mtqqv3` (`id_article`),
  ADD KEY `FK1k3rs11lre3bkj73cqhdnyyep` (`id_compte`),
  ADD KEY `FKawj95q5vkbelwq3yxuye1ica9` (`id_employe`),
  ADD KEY `FKnai9871g9xt9iulbxxfjsb546` (`id_table`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`),
  ADD UNIQUE KEY `UK_a0jr9j935oikjgxinnvwiwirq` (`login`),
  ADD KEY `FK9g2yxidhplctl39r045vccwi9` (`id_employe`);

--
-- Index pour la table `cuisine`
--
ALTER TABLE `cuisine`
  ADD PRIMARY KEY (`id_cuisine`),
  ADD KEY `FKlyggj8oo49wbn6mx7a3krbtxi` (`id_resto`);

--
-- Index pour la table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id_employe`),
  ADD UNIQUE KEY `UK_sewfj92skjm3geoc0usfber43` (`matricule`),
  ADD KEY `FKsmpk8x2m3u86pb2sljxayv1j1` (`id_cuisine`),
  ADD KEY `FKesx2ng44mwxx0gmfskn70hdhi` (`id_resto`);

--
-- Index pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id_resto`);

--
-- Index pour la table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`id_table`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id_catalogue` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT pour la table `commande_article`
--
ALTER TABLE `commande_article`
  MODIFY `id_commande_article` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;
--
-- AUTO_INCREMENT pour la table `commande_article_temporaire`
--
ALTER TABLE `commande_article_temporaire`
  MODIFY `id_commande_article_temporaire` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id_compte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `cuisine`
--
ALTER TABLE `cuisine`
  MODIFY `id_cuisine` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id_employe` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id_resto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `tables`
--
ALTER TABLE `tables`
  MODIFY `id_table` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK5qbslk1ioudummgell60ha69j` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
-- Contraintes pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `FKp4n67r10q2y3h1qaklicn4u3w` FOREIGN KEY (`id_resto`) REFERENCES `restaurant` (`id_resto`);

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `FKd4nnux3bd6nv6etdk7wnm885o` FOREIGN KEY (`id_catalogue`) REFERENCES `catalogue` (`id_catalogue`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK8sx2joni6ihxdkhqn6tujuqkj` FOREIGN KEY (`id_cuisinier`) REFERENCES `employe` (`id_employe`),
  ADD CONSTRAINT `FKdll5kq43j1etbnx1gdttpnvtv` FOREIGN KEY (`id_serveur`) REFERENCES `employe` (`id_employe`),
  ADD CONSTRAINT `FKfymbwwqaetnxrvu2ak1u0x296` FOREIGN KEY (`id_table`) REFERENCES `tables` (`id_table`),
  ADD CONSTRAINT `FKls4tu9udpkuu4ajncadt7iack` FOREIGN KEY (`id_comptable`) REFERENCES `employe` (`id_employe`);

--
-- Contraintes pour la table `commande_article`
--
ALTER TABLE `commande_article`
  ADD CONSTRAINT `FK1oj919k5kluteecator3cr33n` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`),
  ADD CONSTRAINT `FKepfr6njnymsrn9yodn10ptnwf` FOREIGN KEY (`id_cuisinier`) REFERENCES `employe` (`id_employe`),
  ADD CONSTRAINT `FKp7o0b8tl4dw3ipdwnbwq5ifvr` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`);

--
-- Contraintes pour la table `commande_article_temporaire`
--
ALTER TABLE `commande_article_temporaire`
  ADD CONSTRAINT `FK1k3rs11lre3bkj73cqhdnyyep` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`),
  ADD CONSTRAINT `FKawj95q5vkbelwq3yxuye1ica9` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`),
  ADD CONSTRAINT `FKnai9871g9xt9iulbxxfjsb546` FOREIGN KEY (`id_table`) REFERENCES `tables` (`id_table`),
  ADD CONSTRAINT `FKnduy7bwqgihpfdlbrx8mtqqv3` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK9g2yxidhplctl39r045vccwi9` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`);

--
-- Contraintes pour la table `cuisine`
--
ALTER TABLE `cuisine`
  ADD CONSTRAINT `FKlyggj8oo49wbn6mx7a3krbtxi` FOREIGN KEY (`id_resto`) REFERENCES `restaurant` (`id_resto`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FKesx2ng44mwxx0gmfskn70hdhi` FOREIGN KEY (`id_resto`) REFERENCES `restaurant` (`id_resto`),
  ADD CONSTRAINT `FKsmpk8x2m3u86pb2sljxayv1j1` FOREIGN KEY (`id_cuisine`) REFERENCES `cuisine` (`id_cuisine`);
