-- SELECT * FROM AGENDA;

-- INSERT INTO agenda (dt_agenda,funcionario,servico,cliente,obs) values( '1998-10-25','TESTE','DAVID','JOAO','teste Obs 3');

-- SELECT * FROM AGENDA A
-- INNER JOIN USERS U ON A.id_funcionario = U.id
-- inner JOIN SERVICO S ON A.ID_SERVICO = S.ID
-- WHERE
-- DT_AGENDA BETWEEN '1998-10-25 00:00:00' AND '1998-10-25 00:00:00'
-- AND S.NOME LIKE '%serv1';

-- DROP TABLE users;
select servico.nome from servico where servico.id = 1;

SELECT users.nome FROM users where isFunc = 0;

CREATE TABLE servico (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) not null,
  valor INTEGER,
  descricao VARCHAR(500),
  obs VARCHAR(500),
  isProd BOOLEAN,
  quantidade int
);




CREATE TABLE users (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) not null,
  email  VARCHAR(50),
  telefone  VARCHAR(50),
  celular  VARCHAR(50),
  address VARCHAR(255),
  passwd VARCHAR(20),
  isFunc BOOLEAN,
  sexo VARCHAR(1),
  cidade VARCHAR(10),
  dtNasct date,
  obs VARCHAR(500)
);



CREATE TABLE agenda (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dt_agenda DATE,
  hora_agenda time,
  id_funcionario int unique not null,
  foreign key (id_funcionario) references users(id),
  id_servico int unique not null,
  foreign key (id_servico) references servico(id),
  id_cliente int unique not null,
  foreign key (id_cliente) references users(id),
  obs VARCHAR(500)
);


INSERT INTO users (nome, email, telefone, celular,address) VALUES ('mkyong', 'mkyong@gmail.com','12312312','12312312', 'Spring MVC, GWT');
INSERT INTO users (nome, email, telefone, celular,address) VALUES ('alex', 'alex@yahoo.com','12312312','12312312', 'Spring MVC, PLAY');
INSERT INTO users (nome, email, telefone, celular,address) VALUES ('joel', 'joel@gmail.com','12312312','12312312', 'Spring MVC, JSF 2');

INSERT INTO servico (nome, valor, descricao, obs) 
values('serv1',11,'desc teste1','obs teste1');

INSERT INTO servico (nome, valor, descricao, obs) 
values('serv2',12,'desc teste2','obs teste2');

INSERT INTO servico (nome, valor, descricao, obs) 
values('serv3',13,'desc teste3','obs teste3');

-- insert into def (col1, col2,col3) select 'hardcoded value',scol2, scol3 from abc;
INSERT INTO agenda (dt_agenda,hora_agenda,obs, id_funcionario,id_servico,id_cliente) 
values ( '1998-10-25','12:00','teste Obs 1',1,1,1);

INSERT INTO agenda (dt_agenda,hora_agenda,id_funcionario,id_servico,id_cliente,obs) 
values( '1998-11-25','13:00',2,2,2,'teste Obs 2');

INSERT INTO agenda (dt_agenda,hora_agenda,id_funcionario,id_servico,id_cliente,obs) 
values( '1998-12-25','14:00',3,3,3,'teste Obs 3');
