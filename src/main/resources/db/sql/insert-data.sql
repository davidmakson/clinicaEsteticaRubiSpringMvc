INSERT INTO users (name, email, framework) VALUES ('mkyong', 'mkyong@gmail.com', 'Spring MVC, GWT');
INSERT INTO users (name, email, framework) VALUES ('alex', 'alex@yahoo.com', 'Spring MVC, PLAY');
INSERT INTO users (name, email, framework) VALUES ('joel', 'joel@gmail.com', 'Spring MVC, JSF 2');

INSERT INTO servico (name, valor, descricao, obs) values('serv1',11,'desc teste1','obs teste1');
INSERT INTO servico (name, valor, descricao, obs) values('serv2',12,'desc teste2','obs teste2');
INSERT INTO servico (name, valor, descricao, obs) values('serv3',13,'desc teste3','obs teste3');

INSERT INTO funcionario (name, email) values('alex', 'alex@yahoo.com');
INSERT INTO funcionario (name, email) values('david', 'david@yahoo.com');
INSERT INTO funcionario (name, email) values('thiago', 'thiago@yahoo.com');

INSERT INTO agenda (dt_agenda,funcionario,servico,cliente,obs) values( '1998-10-25','funcionario1','servico1','cliente1','teste Obs 1');
INSERT INTO agenda (dt_agenda,funcionario,servico,cliente,obs) values( '1998-11-25','funcionario2','servico2','cliente2','teste Obs 2');
INSERT INTO agenda (dt_agenda,funcionario,servico,cliente,obs) values( '1998-12-25','funcionario3','servico3','cliente3','teste Obs 3');
