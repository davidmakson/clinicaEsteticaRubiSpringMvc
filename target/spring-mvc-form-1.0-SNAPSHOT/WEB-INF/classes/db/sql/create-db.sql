--DROP TABLE users IF EXISTS;

CREATE TABLE servico (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(50),
  valor INTEGER,
  descricao VARCHAR(500),
  obs VARCHAR(500)
);

CREATE TABLE funcionario (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(50),
  email  VARCHAR(50),
  address VARCHAR(255),
  password VARCHAR(20),
  sex VARCHAR(1),
  NUMBER INTEGER,
  COUNTRY VARCHAR(10),
  SKILL VARCHAR(500)
);

CREATE TABLE users (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(50),
  email  VARCHAR(50),
  address VARCHAR(255),
  password VARCHAR(20),
  newsletter BOOLEAN,
  framework VARCHAR(500),
  sex VARCHAR(1),
  NUMBER INTEGER,
  COUNTRY VARCHAR(10),
  SKILL VARCHAR(500)
);

CREATE TABLE agenda (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  dt_agenda DATE, 
  funcionario VARCHAR(50),
  idFunc INTEGER,
  servico VARCHAR(50),
  idServ INTEGER,
  cliente VARCHAR(50),
  idCli INTEGER,
  obs VARCHAR(500)
);

ALTER TABLE agenda ADD CONSTRAINT fk_funcionario FOREIGN KEY(idFunc) REFERENCES funcionario(id);
ALTER TABLE agenda ADD CONSTRAINT fk_users FOREIGN KEY(idServ) REFERENCES users(id);
ALTER TABLE agenda ADD CONSTRAINT fk_servico FOREIGN KEY(idCli) REFERENCES servico(id);