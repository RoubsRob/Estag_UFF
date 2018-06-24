USE Sistag_UFF;    
GO    
DROP TABLE AREA

CREATE TABLE Area (
	id INT NOT NULL PRIMARY KEY,
	nome VarChar(30) NOT NULL
);

CREATE TABLE Vaga(
	id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	publicada BIT NOT NULL,
	area int FOREIGN KEY (area)
			REFERENCES Area (id)
	ON DELETE CASCADE    
    ON UPDATE CASCADE    
)

CREATE TABLE Disciplina(
	id INT NOT NULL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	ementa VARCHAR(500)
	)

CREATE TABLE Empresa(
	id INT NOT NULL PRIMARY KEY,
	login VarChar(30) NOT NULL,
	senha VarChar(30) NOT NULL,
	nome VarChar(30) NOT NULL,
	cnpj INT NOT NULL,
	vaga INT FOREIGN KEY (vaga)
			REFERENCES Vaga(id),
	validada BIT NOT NULL,
	areasAtuacao int FOREIGN KEY (areasAtuacao)
				REFERENCES Vaga(id)
	ON DELETE CASCADE    
    ON UPDATE CASCADE    
)



CREATE TABLE Aluno(
	id INT NOT NULL PRIMARY KEY,
	login VarChar(30) NOT NULL,
	senha VarChar(30) NOT NULL,
	nome VarChar(30) NOT NULL,
	cargaHoraria INT NOT NULL,
	disciplinas INT FOREIGN KEY (disciplinas)
			REFERENCES Disciplina(id),
	perfil VarChar(500),
	validado BIT NOT NULL,
	competencias int FOREIGN KEY (competencias)
				REFERENCES Area(id)
	ON DELETE CASCADE    
    ON UPDATE CASCADE    
)

CREATE TABLE Coordenador(
	id INT NOT NULL PRIMARY KEY,
	login VarChar(30) NOT NULL,
	senha VarChar(30) NOT NULL,
	nome VarChar(30) NOT NULL    
)


CREATE TABLE Contrato(
	id INT NOT NULL PRIMARY KEY,
	vaga INT FOREIGN KEY (vaga)
			REFERENCES Vaga(id),
	aprovado BIT,
	aluno int FOREIGN KEY (aluno)
				REFERENCES Aluno(id),
	responsavel int FOREIGN KEY (responsavel)
				REFERENCES Coordenador(id)
	
	ON DELETE CASCADE    
    ON UPDATE CASCADE    
)
; GO

