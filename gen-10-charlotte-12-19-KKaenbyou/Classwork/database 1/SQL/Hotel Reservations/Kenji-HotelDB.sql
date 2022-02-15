DROP DATABASE IF EXISTS HotelDB;
CREATE DATABASE HotelDB;
USE HotelDB;

create table roomtype (
	typeid int primary key not null,
    rtype varchar(50) not null);
    
create table amenities (
	amenid int primary key not null,
    rtype varchar(50) not null);

CREATE TABLE Rooms (
    Room INT PRIMARY KEY,
    `Type` int NOT NULL,
    Amenities int NOT NULL,
    ADA VARCHAR(3) NOT NULL,
    SOccupancy INT NOT NULL,
    MOccupancy INT NOT NULL,
    BasePrice VARCHAR(10) NOT NULL,
    ExtraPerson CHAR(3) NULL);
        
create table mmroomtype (
	typeid int not null,
    room int not null,
	PRIMARY KEY pk_mm (typeid, room),
    FOREIGN KEY fk_mmid (room)
        REFERENCES rooms(room),
    FOREIGN KEY fk_mmtype (typeid)
        REFERENCES roomtype(typeid));
        
create table mmamenities (
	amenid int not null,
    room int not null,
	PRIMARY KEY pk_mm2 (amenid, room),
    FOREIGN KEY fk_mmid2 (room)
        REFERENCES rooms(room),
    FOREIGN KEY fk_mmtype2 (amenid)
        REFERENCES amenities(amenid));
    
CREATE TABLE Guests (
    -- GuestID INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) primary key NOT NULL,
    Address VARCHAR(50) NOT NULL,
    City VARCHAR(50) NOT NULL,
    State CHAR(2) NOT NULL,
    ZIP INT NOT NULL,
    Phone CHAR(14) NOT NULL);
    
CREATE TABLE Reservations (
    ResID INT PRIMARY KEY AUTO_INCREMENT,
	Room CHAR(3) REFERENCES Rooms(Room),
    `Name` VARCHAR(50) NOT NULL,
    Adults INT NOT NULL,
    Kids INT NOT NULL,
    StartDate VARCHAR(10) NOT NULL,
    EndDate VARCHAR(10) NOT NULL,
    TotalCost VARCHAR(10) NOT NULL,
    foreign key fk_rguest (`name`)
		REFERENCES guests(`name`));
        
create table resroom (
	resid int not null,
    room int not null,
	PRIMARY KEY pk_mm (resid, room),
    FOREIGN KEY fk_mmid3 (room)
        REFERENCES rooms(room),
    FOREIGN KEY fk_mmtype3 (resid)
        REFERENCES reservations(resid));