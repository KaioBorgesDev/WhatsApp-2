# WhatsApp-2
WhatsApp 2: Java, JavaFX e MySQL. Um novo aplicativo de mensagens em desenvolvimento feito por mim!


Database Schema
usuario Table
id (int): Unique user ID.
nome (varchar(150)): User's name.
email (varchar(200)): User's email.
senha (varchar(8)): User's password.
conversas Table
id (int): Unique conversation ID.
id_usuario (int): ID of the first user in the conversation.
id_usuario_2 (int): ID of the second user in the conversation.
mensagem Table
id (int): Unique message ID.
conversa_id (int): ID of the conversation to which the message belongs.
remetente_id (int): ID of the message sender.
conteudo (text): Message content.
data_envio (datetime): Date and time of message sending.
SQL Code
sql




Copy code
CREATE DATABASE `whatsapp`;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `conversas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_usuario_2` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_usuario_2` (`id_usuario_2`),
  CONSTRAINT `conversas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `conversas_ibfk_2` FOREIGN KEY (`id_usuario_2`) REFERENCES `usuario` (`id`)
);

CREATE TABLE `mensagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `conversa_id` int DEFAULT NULL,
  `remetente_id` int DEFAULT NULL,
  `conteudo` text,
  `data_envio` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `conversa_id` (`conversa_id`),
  KEY `remetente_id` (`remetente_id`),
  CONSTRAINT `mensagem_ibfk_1` FOREIGN KEY (`conversa_id`) REFERENCES `conversas` (`id`),
  CONSTRAINT `mensagem_ibfk_2` FOREIGN KEY (`remetente_id`) REFERENCES `usuario` (`id`)
);


How to Use
Create a MySQL database named whatsapp using your MySQL client or command line.

Run the provided SQL code in your MySQL client or by executing SQL files.

You can now interact with the database to manage users, conversations, and messages as needed for your messaging application.

Feel free to customize this database schema and SQL code according to your specific requirements. If you have any questions or need further assistance, please don't hesitate to ask.

This README provides a basic guide on how to use the database and includes the corrected SQL code for your WhatsApp-like messaging application. You can adjust the README and the database schema as necessary to meet your project's needs. If you have any additional questions or require further assistance, please let me know.






Regen


