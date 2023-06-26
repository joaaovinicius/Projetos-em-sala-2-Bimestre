CREATE TABLE pessoa(
idPessoa INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
email VARCHAR(100)
);

CREATE TABLE veiculo(
idVeiculo INT PRIMARY KEY AUTO_INCREMENT,
numeroChassi VARCHAR(100),
placa VARCHAR(10),
modelo VARCHAR(100),
marca VARCHAR(100),
valor DOUBLE
);
