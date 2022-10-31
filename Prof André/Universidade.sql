USE Universidade;

CREATE TABLE aluno 
( 
 Matricula INT PRIMARY KEY,  
 Nome VARCHAR(50),  
 DataNascimento DATE,  
 Curso VARCHAR(50)  
); 

CREATE TABLE disciplina 
( 
 idOferta INT,  
 Disciplina VARCHAR(50) PRIMARY KEY,  
 Nome VARCHAR(50),  
 Horas INT  
); 

CREATE TABLE professor 
( 
 iddisciplina INT,  
 CPF INT PRIMARY KEY,  
 Nome INT,  
 Salario FLOAT  
); 

CREATE TABLE Oferta 
( 
 Codigo INT PRIMARY KEY,  
 Nome VARCHAR(50),  
 Semestre INT,  
 Ano INT,  
 Nota FLOAT,  
 Frequencia VARCHAR(50),  
 Aluno INT,  
 Professor INT  
); 

CREATE TABLE Prerequisito 
( 
 idOferta INT,  
 CodigoDisciplina VARCHAR(50) PRIMARY KEY,  
); 

CREATE TABLE possui 
( 
 idaluno INT PRIMARY KEY,  
 iddisciplina INT PRIMARY KEY  
); 

ALTER TABLE disciplina ADD FOREIGN KEY(idOferta) REFERENCES Oferta (idOferta);
ALTER TABLE professor ADD FOREIGN KEY(iddisciplina) REFERENCES disciplina (iddisciplina);
ALTER TABLE Prerequisito ADD FOREIGN KEY(idOferta) REFERENCES Oferta (idOferta);
ALTER TABLE possui ADD FOREIGN KEY(idaluno) REFERENCES aluno (idaluno);
ALTER TABLE possui ADD FOREIGN KEY(iddisciplina) REFERENCES disciplina (iddisciplina);
