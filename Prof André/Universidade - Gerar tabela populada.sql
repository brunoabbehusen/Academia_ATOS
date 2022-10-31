-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Out-2022 às 02:07
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `universidade2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `Matricula` int(15) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `DataNascimento` date NOT NULL,
  `Curso` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`Matricula`, `Nome`, `DataNascimento`, `Curso`) VALUES
(1828201, 'Pedro Santos', '2000-09-02', 'COM'),
(1918023, 'Camila Braga', '1999-03-12', 'COM'),
(1918142, 'João Lage', '2001-11-20', 'PRO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `Codigo` varchar(15) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Horas` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`Codigo`, `Nome`, `Horas`) VALUES
('CSI030', 'Programação de Computadores I', 60),
('CSI160', 'Cálculo Diferencial e Integral I', 60),
('CSI440', 'Banco de Dados I', 60),
('CSI443', 'Matemática Discreta', 60),
('CSI488', 'Algoritimos e Estrutura de Dados I', 60);

-- --------------------------------------------------------

--
-- Estrutura da tabela `oferta`
--

CREATE TABLE `oferta` (
  `Codigo` int(11) NOT NULL,
  `CodigoDisciplina` varchar(15) DEFAULT NULL,
  `Semestre` int(10) DEFAULT NULL,
  `Ano` int(4) DEFAULT NULL,
  `Nota` float DEFAULT NULL,
  `Frequencia` decimal(3,0) DEFAULT NULL,
  `Aluno` int(15) DEFAULT NULL,
  `professor` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `oferta`
--

INSERT INTO `oferta` (`Codigo`, `CodigoDisciplina`, `Semestre`, `Ano`, `Nota`, `Frequencia`, `Aluno`, `professor`) VALUES
(1, 'CSI030', 1, 2019, 8.6, '90', 1918023, 2147483647),
(2, 'CSI030', 1, 2019, 7.4, '95', 191842, 2147483647),
(3, 'CSI030', 1, 2019, 2.5, '50', 1828201, 2147483647),
(4, 'CSI040', 1, 2019, 4.7, '75', 1918142, 2147483647),
(5, 'CSI160', 1, 2019, 9.5, '100', 1828201, 2147483647),
(6, 'CSI443', 1, 2019, 7.7, '82', 1918023, 2147483647),
(7, 'CSI030', 2, 2019, 6, '90', 1828201, 2147483647),
(8, 'CSI440', 2, 2019, 6.7, '85', 1918142, 2147483647),
(9, 'CSI160', 2, 2019, 8.2, '92', 1918023, 1050930210),
(10, 'CSI443', 2, 2019, 9, '100', 1828201, 2147483647);

-- --------------------------------------------------------

--
-- Estrutura da tabela `prerequisito`
--

CREATE TABLE `prerequisito` (
  `CodigoDisciplina` varchar(15) NOT NULL,
  `CodigoPrerequisito` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `prerequisito`
--

INSERT INTO `prerequisito` (`CodigoDisciplina`, `CodigoPrerequisito`) VALUES
('CSI448', 'CSI030'),
('CSI440', 'CSI443'),
('CSI440', 'CSI448');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `CPF` varchar(15) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`CPF`, `Nome`, `Salario`) VALUES
('10010220470', 'Elton Cardoso', 6500),
('10120214450', 'Lucas Menezes', 5420),
('10190267390', 'Rafael Silva', 2500),
('10432029020', 'Fernando Vaz', 3880),
('10560930210', 'Marcos Lima', 7150),
('11040540330', 'Bruno Santos', 4200);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`Matricula`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `prerequisito`
--
ALTER TABLE `prerequisito`
  ADD PRIMARY KEY (`CodigoPrerequisito`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`CPF`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `oferta`
--
ALTER TABLE `oferta`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;