------------------------------------------ Creating database ------------------------------------
CREATE DATABASE RFDBMS

----------------------------------------------- Profile -----------------------------------------

------------- Admin -------------------
CREATE TABLE Admin (
	A_id int IDENTITY(1001,1) PRIMARY KEY,
	Name varchar(50) NOT NULL,
	UserName varchar(50) NOT NULL,
	Password varchar(200) NOT NULL,
	Phone nchar(11) NOT NULL,
	Email varchar(200) NOT NULL,
	Address varchar(200) NOT NULL,)

INSERT INTO Admin(Name, UserName,Password, Phone, Email, Address) 
VALUES ('Karim Hasan', 'Karim',HASHBYTES('MD5','Karim'),'01842345675', 'Karim@gmail.com', 'Gulshan'),
       ('Rahim Hasan', 'Rahim', HASHBYTES('MD5','Rahim'),'01812345675', 'Rahim@gmail.com', 'Malibag'),
	   ('Sadik Hasan', 'Sadik', HASHBYTES('MD5','Sadik'),'01812345675', 'Sadik@gmail.com', 'BaileyRoad'),
	   ('Mridul Hasan', 'Mridul', HASHBYTES('MD5','Mridul'),'01814345675', 'Mridul@gmail.com', 'BaileyRoad'),
	   ('Ovi Rahman', 'Ovi', HASHBYTES('MD5','Ovi'),'01712345675', 'Ovi@gmail.com', 'BaileyRoad')

SELECT * FROM Admin
DROP TABLE Admin
TRUNCATE TABLE Admin


------------- Employee -------------------
CREATE TABLE Employee(
	E_id int IDENTITY(2001,1) PRIMARY KEY,
	Name varchar(50) NOT NULL,
	UserName varchar(50) NOT NULL,
	Password varchar(200) NOT NULL,
	Phone nchar(11) NOT NULL,
	Email varchar(200) NOT NULL,
	Address varchar(200) NOT NULL,
	A_id int NOT NULL FOREIGN KEY REFERENCES Admin(A_id),)

INSERT INTO EMPLOYEE (Name, UserName,Password, Phone, Email, Address,A_id) 
VALUES ('Abul Hasan', 'Karim',HASHBYTES('MD5','Karim'),'01842345675', 'Karim@gmail.com', 'Gulshan',1001),
       ('Rahul Hasan', 'Rahim', HASHBYTES('MD5','Rahim'),'01812345675', 'Rahim@gmail.com', 'Malibag',1003),
	   ('Sadik Hasan', 'Sadik', HASHBYTES('MD5','Sadik'),'01812345675', 'Sadik@gmail.com', 'BaileyRoad',1004),
	   ('Mina Hasan', 'Mina', HASHBYTES('MD5','Mina'),'01712345675', 'Mina@gmail.com', 'Malibag',1003),
	   ('Sadiya Hasan', 'Sadiya', HASHBYTES('MD5','Sadik'),'01812345675', 'Sadiya@gmail.com', 'Banani',1004)
	  
SELECT * FROM Employee
DROP TABLE Employee
TRUNCATE TABLE Employee


-------------------------------------- Simple Table ------------------------------------------------

--------------- Items ---------------------
CREATE TABLE Items(
	I_id int IDENTITY(3001,1) PRIMARY KEY,
	Name varchar(50) NOT NULL,
	Price money NOT NULL,
	Quantity int NOT NULL,
	Status int default (0),)

INSERT INTO Items (Name,Price,Quantity,Status)
VALUES ('Chicken fry', 500, 4, 1),
       ('Fried rice', 300, 1, 1),
	   ('Burger', 200, 1, 0),
	   ('Pizza', 200, 1, 1)

SELECT * FROM Items
DROP TABLE Items
TRUNCATE TABLE Items


--------------- Package ---------------------
CREATE TABLE Package(
	P_id int IDENTITY(4001,1) PRIMARY KEY,
	Name varchar(50) NOT NULL,
	Price money NOT NULL,
	Description varchar(100) NOT NULL, 
	Status int default(0))

INSERT INTO Package (Name, Price, Description, Status)
VALUES ('Combo', 1000,'2*Fried Rice,  2*Cocacola',1),
		('Dhamaka_Offer', 900,'3*Fried Rice, 2*Cocacola, Vegetables',1),
		('Eid_Offer', 2000,'2*Fried Rice, Vegetables, 2*Chicken fry',0),
		('New_Year_Offer', 2000,'2*Fried Rice, 2*Cocacola, 2*Chicken fry',0)

SELECT * FROM Package
DROP TABLE Package
TRUNCATE TABLE Package


--------------- Customer ---------------------
CREATE TABLE Customer(
	C_id int NOT NULL IDENTITY(5001,1) PRIMARY KEY,
	Name varchar(50) NOT NULL,
	Phone nchar(50) NOT NULL,
	Email varchar(200),
	Address varchar(200) )

INSERT INTO Customer
(Name,Phone,Email,Address)
VALUES ('Mila','01719845679','mila@gmail.com','Tejgaon'),
       ('Shorna','01786230987','shorna@gmail.com','Gulshan'),
       ('Fatema','01672892789','fatema@gmail.com','Bonani'),
       ('Shweta','01713409785','shweta@gmail.com','Beliroad')

SELECT * FROM Customer
DROP TABLE Customer
TRUNCATE TABLE Customer


--------------- TableT ---------------------
CREATE TABLE TableT(
	T_id int IDENTITY(6001,1) PRIMARY KEY,
	TableType varchar(50) NOT NULL,
	Capacity int NOT NULL,
	Location varchar(50) NOT NULL, 
	Status int default(0))

INSERT INTO TableT (TableType, Capacity, Location, Status) 
VALUES ('Round', 5, 'Window_Side', 1),
		('Square', 6, 'Middle', 0),
		('Side', 2, 'Corner', 1)

SELECT * FROM TableT
DROP TABLE TableT
TRUNCATE TABLE TableT


--------------- Payment ---------------------
CREATE TABLE Payment(
	Pay_id int IDENTITY(7001,1) PRIMARY KEY,
	Total_price money NOT NULL,
	Method varchar(50) default ('Cash'),
	Paid money NOT NULL,
	Due money NOT NULL,
	P_date DATE DEFAULT CAST(GETDATE() AS DATE),
	P_time TIME DEFAULT CAST(GETDATE() AS TIME) )

INSERT INTO Payment (Total_price, Method, Paid, Due) 
VALUES (500, 'Bkash', 300, 100),
(400, 'Rocket', 300, 100),
(900, 'Bkash', 400, 100),
(600, 'Cash', 200, 100)


SELECT * FROM Payment
DROP TABLE Payment
TRUNCATE TABLE Payment


-------------------------------------- complex Table ------------------------------------------------


------------- Ordero ------------------
CREATE TABLE Ordero(
	O_id int IDENTITY(8001,1) PRIMARY KEY,
	C_id int NOT NULL FOREIGN KEY REFERENCES Customer(C_id),
	Pay_id int NOT NULL FOREIGN KEY REFERENCES Payment(Pay_id),
	E_id int NOT NULL FOREIGN KEY REFERENCES Employee(E_id) )

INSERT INTO Ordero (C_id, Pay_id, E_id) 
VALUES (5001, 7001, 2001),
		(5002, 7002, 2001),
		(5003, 7003, 2003),
		(5004, 7004, 2003)


SELECT * FROM Ordero
DROP TABLE Ordero
TRUNCATE TABLE Ordero


------------- OrderPacList ------------------
CREATE TABLE OrderPacList(
	O_id int NOT NULL FOREIGN KEY REFERENCES Ordero(O_id),
	P_id int FOREIGN KEY REFERENCES Package(P_id),
	Quantity int default(1) )

INSERT INTO OrderPacList (O_id, P_id, Quantity) 
VALUES (8001, 4001, 1),
		(8001, 4002, 2),
		(8002, 4001, 1),
		(8002, 4002, 1)


SELECT * FROM OrderPacList
DROP TABLE OrderPacList
TRUNCATE TABLE OrderPacList


------------- OrderItemList ------------------
CREATE TABLE OrderItemList(
	O_id int NOT NULL FOREIGN KEY REFERENCES Ordero(O_id),
	I_id int FOREIGN KEY REFERENCES Items(I_id),
	Quantity int default(1) )

INSERT INTO OrderItemList (O_id, I_id, Quantity) 
VALUES (8003, 3001, 1),
		(8003, 3002, 2),
		(8004, 3003, 2),
		(8004, 3001, 1)


SELECT * FROM OrderItemList
DROP TABLE OrderItemList
TRUNCATE TABLE OrderItemList


------------- OrderDetails ------------------
CREATE TABLE OrderDetails(
	O_id int NOT NULL FOREIGN KEY REFERENCES Ordero(O_id),
	O_date DATE DEFAULT CAST(GETDATE() AS DATE),
	O_time TIME DEFAULT CAST(GETDATE() AS TIME) )

INSERT INTO OrderDetails (O_id) 
VALUES (8001),
		(8002),
		(8003),
		(8004)


SELECT * FROM OrderDetails
DROP TABLE OrderDetails
TRUNCATE TABLE OrderDetails


------------- Reservation ------------------
CREATE TABLE Reservation(
	R_id int IDENTITY(9001,1) PRIMARY KEY,
	C_id int NOT NULL FOREIGN KEY REFERENCES Customer(C_id),
	Pay_id int NOT NULL FOREIGN KEY REFERENCES Payment(Pay_id),
	E_id int NOT NULL FOREIGN KEY REFERENCES Employee(E_id) )

INSERT INTO Reservation (C_id, Pay_id, E_id) 
VALUES (5001, 7001, 2001),
		(5002, 7002, 2001),
		(5003, 7003, 2003),
		(5004, 7004, 2003)


SELECT * FROM Reservation
DROP TABLE Reservation
TRUNCATE TABLE Reservation


------------- ReservationTable ------------------
CREATE TABLE ReservationTable(
	R_id int NOT NULL FOREIGN KEY REFERENCES Reservation(R_id),
	T_id int NOT NULL FOREIGN KEY REFERENCES TableT(T_id) )

INSERT INTO ReservationTable (R_id, T_id) 
VALUES (9001, 6001),
		(9002, 6002),
		(9003, 6003)

SELECT * FROM ReservationTable
DROP TABLE ReservationTable
TRUNCATE TABLE ReservationTable


------------- ReservationDetails ------------------
CREATE TABLE ReservationDetails(
	R_id int NOT NULL FOREIGN KEY REFERENCES Reservation(R_id),
	Num_of_People int not null,
	ReservDate DATE NOT NULL,
	ReservTime TIME DEFAULT('00:00:00'),
	R_date DATE DEFAULT CAST(GETDATE() AS DATE),
	R_time TIME DEFAULT CAST(GETDATE() AS TIME) )

INSERT INTO ReservationDetails (R_id, Num_of_People, ReservDate, ReservTime) 
VALUES (9001, 5, '2020-09-01', '10:00:00'),
		(9002, 6, '2020-09-01', '10:30:00'),
		(9003, 2, '2020-09-01', '11:00:00')

SELECT * FROM ReservationDetails
DROP TABLE ReservationDetails
TRUNCATE TABLE ReservationDetails