CREATE DATABASE plataformacursos;

CREATE TABLE curso (idcurso BIGINT AUTO_INCREMENT,
					nome VARCHAR(70) NOT NULL,
					ch INT,
					preco DECIMAL (12,2) NOT NULL,
					linguagem VARCHAR(50) NOT NULL,
					CONSTRAINT cursopk PRIMARY KEY (idcurso));
				
CREATE TABLE disciplina (iddisciplina BIGINT AUTO_INCREMENT,
						nome VARCHAR(70) NOT NULL,
						creditos INT,
						CONSTRAINT disciplinapk PRIMARY KEY (iddisciplina));
						
CREATE TABLE professor (idprofessor BIGINT AUTO_INCREMENT,
						nome VARCHAR(150) NOT NULL,
						cpf CHAR(11) NOT NULL,
						email VARCHAR(40) NOT NULL,
						senha VARCHAR (200) NOT NULL,
						salario DECIMAL(12,2) NOT NULL,
						CONSTRAINT professorpk PRIMARY KEY (idprofessor));