/*SCRIPT TO EXECUTE TO CREATE ALL TABLES NEEDED FOR IOTBAY DATABASE*/
CREATE TABLE USERTABLE(
    userID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    emailAddress varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    PRIMARY KEY (userID)
);
CREATE TABLE CUSTOMERTABLE(
    customerID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    userID int NOT NULL, 
    dob date NOT NULL,
    streetNumber int,
    streetName varchar(20),
    postCode int NOT NULL,
    registered boolean,
    PRIMARY KEY (customerID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);
CREATE TABLE STAFFTABLE(
    staffID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    userID int NOT NULL, 
    PRIMARY KEY (staffID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);
CREATE TABLE APPLICATIONLOGTABLE(
    LogID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    userID int,
    staffID int,
    accessed varchar(50) NOT NULL,
    accesstype varchar(25) NOT NULL, 
    PRIMARY KEY (LogID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID),
    FOREIGN KEY (staffID) REFERENCES STAFFTABLE(staffID)
);

CREATE TABLE ORDERTABLE(
    orderID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    customerID int NOT NULL,
    dateOrdered date NOT NULL,
    orderTotal float NOT NULL,
    PRIMARY KEY (orderID),
    FOREIGN KEY (customerID) REFERENCES CUSTOMERTABLE(customerID)
);

CREATE TABLE PRODUCTTABLE(
    productID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    productName varchar(50) NOT NULL,
    productDescription varchar(50) NOT NULL,
    productCategory varchar(30) NOT NULL,
    productPrice float NOT NULL,
    productStock int,
    PRIMARY KEY (productID)
);

CREATE TABLE ORDERLINETABLE(
    orderID int NOT NULL, 
    productID int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY (orderID,productID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID),
    FOREIGN KEY (productID) REFERENCES PRODUCTTABLE(productID)
);

CREATE TABLE INVOICETABLE(
    customerID int NOT NULL, 
    orderID int NOT NULL,
    productName varchar(50) NOT NULL,
    productQuantity int NOT NULL,
    dateOrdered date NOT NULL,
    orderTotal float NOT NULL,
    billingAddress varchar(100) NOT NULL,
    PRIMARY KEY (customerID, orderID),
    FOREIGN KEY (customerID) REFERENCES CUSTOMERTABLE(customerID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

CREATE TABLE PAYMENTTABLE(
    paymentID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    orderID int NOT NULL,
    paymentType int NOT NULL, /*1 is credit card, 2 is paypal*/
    paymentdate date,
    PRIMARY KEY (paymentID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

CREATE TABLE CREDITCARDTABLE(
    paymentID int NOT NULL,
    CardID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    cardNumber varchar(40) NOT NULL,
    expiryDate date NOT NULL,
    holderName varchar(50) NOT NULL,
    CVV varchar(30) NOT NULL,
    PRIMARY KEY (CardID),
    FOREIGN KEY (paymentID) REFERENCES PAYMENTTABLE(paymentID)
);

CREATE TABLE PAYPALTABLE(
    paypalID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    paymentID int NOT NULL,
    paypalusername varchar(50),
    paypalpassword varchar(50),
    PRIMARY KEY (paypalID),
    FOREIGN KEY (paymentID) REFERENCES PAYMENTTABLE(paymentID)
);

CREATE TABLE SHIPPINGTABLE(
    shipmentID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    orderID int NOT NULL,
    shippingToken varchar(1000) NOT NULL,
    PRIMARY KEY (shipmentID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

INSERT INTO USERTABLE(FIRSTNAME, LASTNAME, EMAILADDRESS,PASSWORD, PHONENUMBER)
VALUES 
('Alex','Law','al@gmail.com','1234','0483920184'),
('Nicholas','Kent','nkent@gmail.com','qTwa95Fy','0483920182'),
('Khadeejah','Blake','kblake@gmail.com','tzJFFhsN','0439203948'),
('Maja','Chung','mchung@gmail.com','zmHk8x3n','0489403829'),
('Ajwa','Daly','adaly@gmail.com','VLC6LFDV','0425463524'),
('Amaan','Akhtar','aakhtar@gmail.com','LXfucv8G','0453628394'),
('Isabella','Ramsey','iramsey@gmail.com','PrXRs64P','0467893029'),
('Aiden','Pace','apace@gmail.com','PemJLabM','0478291028'),
('Mitchell','Cook','mcook@gmail.com','2p49tcnA','0483920574'),
('Clarice','Rosa','crosa@gmail.com','f3GFAFCZ','0490749302'),
('Azaan','Hatfield','ahatfield@gmail.com','BBNS5vBA','0463537281'),
('Sharna','Peacock','speacock@gmail.com','xnMu3Rtn','0489473829'),
('Tarun','Reese','treese@gmail.com','bWjxcy5p','0489098746'),
('Markus','Benitez','mbenitz@gmail.com','qum8DVSa','0465649209'),
('Mai','Whittle','mwhittle@gmail.com','qVV3YThS','0412341526'),
('Mateusz','Klien','mklien@gmail.com','dKquQyt5','0483928192'),
('Rebeca','Whitmore','rwhitmore@gmail.com','vPhNj3a8','0483920191'),
('Xena','Brady','xbrady@gmail.com','4vzj5W6u','0420219301'),
('Muhamed','Blundell','mblundell@gmail.com','scXYLJXL','0483920192'),
('Sarah','Becker','sbecker@gmail.com','1234','0483920191');

INSERT INTO CUSTOMERTABLE(USERID, DOB, STREETNUMBER, STREETNAME, POSTCODE, REGISTERED)
VALUES
(1,'01/28/2001',25,'Clara Street',2000,'True'),
(2,'05/12/2001',10,'Sega Street',2000,'True'),
(3,'06/21/2001',2,'Keys Street',2102,'True'),
(4,'04/11/2001',20,'Prophet Street',2039,'True'),
(5,'12/01/2001',99,'Whale Street',2020,'True'),
(6,'10/06/2001',404,'Fx Street',2019,'True'),
(7,'07/11/2001',101,'Sesame Street',2839,'True'),
(8,'10/09/2001',573,'Konami Street',2019,'True'),
(9,'04/11/2001',13,'Kyuu Street',1029,'True'),
(10,'06/11/2001',21,'Satisfaction Street',1902,'True');

INSERT INTO STAFFTABLE(USERID)
VALUES (11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20);

INSERT INTO PRODUCTTABLE(PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCTSTOCK)
VALUES
('Outdoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Indoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Canon 50D', 'A nice camera', 'Cameras', 600.50, 50),
('Satellite Dish', 'something Dish-y', 'Entertainment', 9050.43, 3),
('Outdoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Indoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Canon 50D', 'A nice camera', 'Cameras', 600.50, 50),
('Satellite Dish', 'something Dish-y', 'Entertainment', 9050.43, 3),
('Outdoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Indoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Canon 50D', 'A nice camera', 'Cameras', 600.50, 50),
('Satellite Dish', 'something Dish-y', 'Entertainment', 9050.43, 3),
('Outdoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Indoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Canon 50D', 'A nice camera', 'Cameras', 600.50, 50),
('Satellite Dish', 'something Dish-y', 'Entertainment', 9050.43, 3),
('Outdoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Indoor Camera', 'something useful', 'surveillance', 550.99, 50),
('Canon 50D', 'A nice camera', 'Cameras', 600.50, 50),
('Satellite Dish', 'something Dish-y', 'Entertainment', 9050.43, 3);

INSERT INTO ORDERTABLE (CUSTOMERID, DATEORDERED, ORDERTOTAL)
VALUES
(1, '2021-06-02', 100.00),
(2, '2021-06-12', 150.00),
(3, '2021-03-12', 3650.00),
(4, '2022-12-12', 450.00),
(5, '2023-06-18', 2800.00),
(6, '2020-04-22', 1500.00),
(7, '2021-05-28', 200.00),
(8, '2022-06-09', 190.00),
(9, '2023-07-10', 180.00),
(10, '2021-08-12', 150.00);

INSERT INTO PAYMENTTABLE (ORDERID, PAYMENTTYPE)
VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 1),
(5, 1),
(6, 2),
(7, 1),
(8, 2),
(9, 1);

INSERT INTO CREDITCARDTABLE (PAYMENTID, CARDNUMBER, EXPIRYDATE, HOLDERNAME, CVV)
VALUES
(2, '1234567', '2023-06-02', 'John Smith', '123'),
(3, '7654321', '2023-06-12', 'Ashley Hunter', '321');

INSERT INTO PAYPALTABLE (PAYMENTID, PAYPALUSERNAME, PAYPALPASSWORD)
VALUES
(1, 'paypaluser1', '738387'),
(2, 'paypaluser2', '7258'),
(3, 'paypaluser3', '73273852'),
(4, 'paypaluser4', '325478'),
(5, 'paypaluser5', '35757'),
(6, 'paypaluser6', '783753'),
(7, 'paypaluser7', '73873'),
(8, 'paypaluser8', '78637832'),
(9, 'paypaluser9', '3787836');
