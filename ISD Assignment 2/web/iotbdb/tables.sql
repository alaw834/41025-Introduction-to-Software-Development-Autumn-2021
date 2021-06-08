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

