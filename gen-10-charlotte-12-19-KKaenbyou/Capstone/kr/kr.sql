DROP DATABASE IF EXISTS kr;
CREATE DATABASE kr;

USE kr;

CREATE TABLE `user`(
    username VARCHAR(20) PRIMARY KEY,
    realname VARCHAR(20),
    `password` VARCHAR(50) NOT NULL,    
    points int default 0
);

CREATE TABLE food(
    foodname varchar(20) PRIMARY KEY,
    price int NOT NULL,
    `description` VARCHAR(100)
);

CREATE TABLE `order`(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) references `user`(username),
    total int,
    constraint fk_username FOREIGN KEY (username) REFERENCES `user`(username)
);

CREATE TABLE feedback(
    id INT PRIMARY KEY AUTO_INCREMENT,
    userfeedback VARCHAR(50)
);


CREATE TABLE foodOrderBridge(
    foodname varchar(20) NOT NULL,
    id int NOT NULL,
    constraint fk_foodname FOREIGN KEY (foodname) REFERENCES food(foodName), 
    constraint fk_id FOREIGN KEY (id) REFERENCES `order`(id)
);

insert into `user`(username, realname, `password`, points) values
	('kk', 'Kenji Kaenbyou', 'password', '0'),
	('Guest', 'FirstLast', 'password', '0');

insert into food(foodname, price, `description`) values
	('Chicken', '10', 'Chicks served on a bed of rice with vegetables'),
	('Beef', '11', 'Beef served on a bed of rice with vegetables'),
    ('Chicken 2', '10', '2 Chicks served on a bed of rice with vegetables'),
	('Pork', '12', 'Pork served on a bed of rice with vegetables');

insert into `order`(id, username, total) values
	(1, 'Guest', '420');