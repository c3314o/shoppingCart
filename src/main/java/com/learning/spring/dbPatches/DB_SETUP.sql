
------------------------------------- CREATE USER --------------------------------------
-- USERNAME : CONNECT SYSTEM; PASSWORD : system
CREATE USER SHOPCART IDENTIFIED BY SHOPCART;
GRANT CONNECT TO SHOPCART;
GRANT ALL PRIVILAGES TO SHOPCART IDENTIFIED BY SHOPCART;

------------------------------------ CREATE SEQUENCE FOR USER DETAILS TABLE --------------------------------------
CREATE SEQUENCE user_detail_seq
 START WITH     100
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

------------------------------------- CREATE USER DETAILS TABLE --------------------------------------
CREATE TABLE USER_DETAILS
  (
    USER_ID       INT PRIMARY KEY,
    FIRSTNAME     VARCHAR2(100),
    LASTNAME      VARCHAR2(100),
    USERNAME      VARCHAR2(100),
    USER_PASSWORD VARCHAR2(10),
    CREATED_BY    VARCHAR2(20),
    CREATED_ON    DATE,
    UPDATED_BY    VARCHAR2(50),
    UPDATED_ON    DATE
  );

------------------------------------ CREATE SEQUENCE FOR ADDRESS TABLE --------------------------------------

CREATE SEQUENCE ADDRESS_SEQ
 START WITH     200
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

------------------------------------- CREATE ADDRESS TABLE --------------------------------------
CREATE TABLE ADDRESS (
         ADDRESS_ID      INT NOT NULL PRIMARY KEY,
         ADDRESS_LINE1    VARCHAR2(255) NOT NULL,
         ADDRESS_LINE2    VARCHAR2(255),
         CITY             VARCHAR2(100),
         STATE_CODE       VARCHAR2(100),
         ZIP_CODE         INT,
         CREATED_BY       VARCHAR2(20),
         CREATED_ON       DATE,
         UPDATED_BY       VARCHAR2(50),
         UPDATED_ON       DATE,
         USER_ID          INT
         );

------------------------------------- MAP USER_DETAILS TO ADDRESS TABLE --------------------------------------		 
ALTER TABLE ADDRESS ADD CONSTRAINT FK_USER_ADDRESS FOREIGN KEY (USER_ID) references USER_DETAILS(USER_ID);

------------------------------------ CREATE SEQUENCE FOR INVENTORY TABLE --------------------------------------
CREATE SEQUENCE inventory_seq
 START WITH     300
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

------------------------------------- CREATE INVENTORY TABLE --------------------------------------
CREATE TABLE INVENTORY
  (
    INVENTORY_ID INT PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(250),
    CATAGORY     VARCHAR2(100),
    COLOR        VARCHAR2(30),
    BRAND        VARCHAR2(50),
    STATUS       VARCHAR2(10),
    PRICE        DECIMAL (18, 2),
    IS_IN_CART   VARCHAR2(3),
    ACTIVE       VARCHAR2(100),
    MODEL_NUMBER VARCHAR2(20),
    CREATED_BY   VARCHAR2(100),
    CREATED_ON   DATE,
    UPDATED_BY   VARCHAR2(100),
    UPDATED_ON   DATE
  );

  COMMIT;