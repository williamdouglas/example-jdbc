DROP DATABASE digital_innovation_one;

SHOW DATABASES;

CREATE DATABASE digital_innovation_one;

USE digital_innovation_one;

SHOW TABLES;

CREATE TABLE aluno (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    idade INTEGER NOT NULL,
    estado CHARACTER(2) NOT NULL
);

INSERT INTO aluno (nome, idade, estado) VALUES ('Pedro', 20, 'RJ');
INSERT INTO aluno (nome, idade, estado) VALUES ('Maria', 35, 'AC');
INSERT INTO aluno (nome, idade, estado) VALUES ('João', 10, 'SC');
INSERT INTO aluno (nome, idade, estado) VALUES ('Ana', 51, 'GO');

DELETE FROM aluno WHERE ID > 4;

SELECT * FROM aluno;