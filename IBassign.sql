create table customer(
 custID INT primary key,
 custName Varchar(20) not null
 );
 drop table customer;
 drop table orders;
 create table orders(
 custID INT ,
 orderID INT primary key,
 orderDate date,
 orderQty Int,
 foreign key(custID) REFERENCES customer(custID)
 )

insert into customer(custID,custName) Values(101,'Cat'); 
insert into customer(custID,custName) Values(102,'Dog');
insert into customer(custID,custName) Values(103,'Fish');
insert into customer(custID,custName) Values(104,'Rat');
insert into customer(custID,custName) Values(105,'Tiger');
insert into customer(custID,custName) Values(106,'Lion');
insert into customer(custID,custName) Values(107,'Elephant');

insert into orders(custID,orderID,orderDate,orderQty) Values(101,10,'2020-01-01',15);
insert into orders(custID,orderID,orderDate,orderQty) Values(101,11,'2020-01-01',17);
insert into orders(custID,orderID,orderDate,orderQty) Values(101,12,'2020-01-01',20);
insert into orders(custID,orderID,orderDate,orderQty) Values(101,13,'2020-01-01',08);
insert into orders(custID,orderID,orderDate,orderQty) Values(102,15,'2020-01-01',08);
insert into orders(custID,orderID,orderDate,orderQty) Values(102,16,'2020-01-01',13);
insert into orders(custID,orderID,orderDate,orderQty) Values(103,17,'2020-01-02',15);
insert into orders(custID,orderID,orderDate,orderQty) Values(103,18,'2020-01-02',63);
insert into orders(custID,orderID,orderDate,orderQty) Values(104,19,'2020-01-02',22);
insert into orders(custID,orderID,orderDate,orderQty) Values(105,20,'2020-01-02',22);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,21,'2020-01-02',14);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,22,'2020-01-03',12);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,23,'2020-01-03',03);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,24,'2020-01-03',26);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,25,'2020-01-03',14);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,26,'2020-01-03',16);
insert into orders(custID,orderID,orderDate,orderQty) Values(107,27,'2020-01-03',23);

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertIntoCust`(IN custId INT,IN custNAME varchar(10))
BEGIN
	Insert into customer(custID,custName) Values(custId,custNAME);
END

USE `mydb`;
DROP procedure IF EXISTS `insertIntoOrders`;

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `insertIntoOrders` (
	IN vcustID INT,
    IN vorderID INT,
    IN vorderDate date,
    IN vorderQty INT)
BEGIN
	insert into orders(custID,orderID,orderDate,orderQty) Values(vcustID,vorderID,vorderDate,vorderQty);
END$$

DELIMITER ;
CALL insertIntoCust(108,'Hello')
CALL insertIntoOrders(108,28,'2020-01-03',25)
select * from orders;
select customer.custName,customer.custID,orders.orderDate,sum(orders.orderQty) from customer inner join orders on customer.custID=orders.custID group by customer.custID,orders.orderDate having sum(orders.orderQty)>50
