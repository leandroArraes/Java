# lojaAutomoveis

Projeto de uma loja de automoveis feito para a aula de programação do curso de ADS. <br>
Foi utilizado java para backend, swing para telas e mysql para o banco de dados

 ## Membros do grupo:
Victor Miguel Rocha<br>
Pedro sartori<br>
Lucas Oliveira<br>
Leandro Arraes

## Tabelas SQL
```sql
CREATE DATABASE AutoVendas;
USING AutoVendas;
--
-- Estrutura da tabela `automovel`
--

CREATE TABLE `automovel` (
  `Codigo` int(11) NOT NULL,
  `Fabricante` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `preco` double NOT NULL,
  `statusVenda` int(11) NOT NULL DEFAULT 0
);

--
-- Extraindo dados da tabela `automovel`
--

INSERT INTO `automovel` (`Codigo`, `Fabricante`, `modelo`, `preco`, `statusVenda`) VALUES
(10, 'Chevrolet', 'Zafira', 36000, 0),
(12, 'Chevrolet', 'Zafira', 38000, 0),
(13, 'Chevrolet', 'Zafira', 75000, 0),
(14, 'Chevrolet', 'Vectra', 45000, 0),
(15, 'Chevrolet', 'Vectra', 50000, 0),
(16, 'Chevrolet', 'Astra ', 35000, 0),
(17, 'Chevrolet', 'Astra ', 47000, 0),
(18, 'Chevrolet', 'Astra ', 52010, 0),
(20, 'Fiat', 'Uno', 20100, 0);

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `CPF` char(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Estado` varchar(30) NOT NULL
);

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`CPF`, `Nome`, `Cidade`, `Estado`) VALUES
('01', 'john Oats', 'São Paulo', 'SP'),
('02', 'Daryl Hall', 'Rio de Janeiro', 'RJ'),
('03', 'DC Sunshine Band', 'Brasilia', 'DF'),
('04', 'Donna Summer', 'Brasilia', 'DF'),
('05', 'Air Supply', 'Brasilia', 'DF'),
('06', 'Mackenzie', 'São Paulo', 'SP');

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Nome` varchar(20) NOT NULL,
  `CPF` char(11) NOT NULL,
  `Matricula` char(8) NOT NULL,
  `cargo` varchar(30) NOT NULL
);

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Nome`, `CPF`, `Matricula`, `cargo`) VALUES
('David', '10', '0001', 'Gerente'),
('joão', '11', '0002', 'supervisor'),
('maria', '12', '0003', 'vendedor'),
('Matheus', '13', '0004', 'vendedor');

--
-- Estrutura da tabela `negocio`
--

CREATE TABLE `negocio` (
  `CPF` char(11) DEFAULT NULL,
  `Matricula` char(8) DEFAULT NULL,
  `Codigo` int(11) DEFAULT NULL,
  `DataCompra` varchar(11) DEFAULT NULL,
  `PrecoPago` float DEFAULT NULL
);

--
-- Índices para tabela `automovel`
--
ALTER TABLE `automovel`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CPF`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Matricula`),
  ADD UNIQUE KEY `CPF` (`CPF`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

--
-- Índices para tabela `negocio`
--
ALTER TABLE `negocio`
  ADD KEY `FK01` (`Matricula`),
  ADD KEY `FK02` (`CPF`),
  ADD KEY `FK03` (`Codigo`);

--
-- Limitadores para a tabela `negocio`
--
ALTER TABLE `negocio`
  ADD CONSTRAINT `FK01` FOREIGN KEY (`Matricula`) REFERENCES `funcionario` (`Matricula`),
  ADD CONSTRAINT `FK02` FOREIGN KEY (`CPF`) REFERENCES `cliente` (`CPF`),
  ADD CONSTRAINT `FK03` FOREIGN KEY (`Codigo`) REFERENCES `automovel` (`Codigo`);
COMMIT;

```