-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 04-Nov-2014 às 19:44
-- Versão do servidor: 5.6.12-log
-- versão do PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `tcc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fator_complexidade`
--

CREATE TABLE IF NOT EXISTS `fator_complexidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  `data_exclusao` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=50 ;

--
-- Extraindo dados da tabela `fator_complexidade`
--

INSERT INTO `fator_complexidade` (`nome`, `valor`, `tipo`, `data_exclusao`) VALUES
('Sistema Distribuído', '2.00', 'T', NULL),
('Desempenho da Aplicação', '1.00', 'T', NULL),
('Eficiencia do Usuário', '1.00', 'T', NULL),
('Processamento Interno Complexo', '1.00', 'T', NULL),
('Reusabilidade de Código', '1.00', 'T', NULL),
('Facilidade de Instalação', '0.50', 'T', NULL),
('Usabilidade', '0.50', 'T', NULL),
('Portabilidade', '2.00', 'T', NULL),
('Manutenibilidade', '1.00', 'T', NULL),
('Concorrencia', '1.00', 'T', NULL),
('Caracteristicas especiais de segurança', '1.00', 'T', NULL),
('Acesso Direto para Terceiros', '1.00', 'T', NULL),
('Facilidade especiais de Treinamento', '1.00', 'T', NULL),
('Familiaridade com o processo de desenvolvimen', '1.50', 'A', NULL),
('Experiência na aplicação', '0.50', 'A', NULL),
('Experiência com OO, na linguagem e na técnica', '1.00', 'A', NULL),
('Capacidade do Líder de análise', '0.50', 'A', NULL),
('Motivação', '1.00', 'A', NULL),
('Requisitos estáveis', '2.00', 'A', NULL),
('Trabalhadores comd edicação parcial', '-1.00', 'A', NULL),
('Dificuldade na linguagem de programação', '-1.00', 'A', NULL),
('Familiaridade com o processo de desenvolvimen', '1.50', 'A', NULL),
('Experiência na aplicação', '0.50', 'A', NULL),
('Experiência com OO, na linguagem e na técnica', '1.00', 'A', NULL),
('Capacidade do Líder de análise', '0.50', 'A', NULL),
('Motivação', '1.00', 'A', NULL),
('Requisitos estáveis', '2.00', 'A', NULL),
('Trabalhadores comd edicação parcial', '-1.00', 'A', NULL),
('Dificuldade na linguagem de programação', '-1.00', 'A', NULL),
('Experiência na aplicação', '0.50', 'A', NULL),
('Experiência com OO, na linguagem e na técnica', '1.00', 'A', NULL),
('Capacidade do Líder de análise', '0.50', 'A', NULL),
('Motivação', '1.00', 'A', NULL),
('Requisitos estáveis', '2.00', 'A', NULL),
('Trabalhadores comd edicação parcial', '-1.00', 'A', NULL),
('Dificuldade na linguagem de programação', '-1.00', 'A', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
