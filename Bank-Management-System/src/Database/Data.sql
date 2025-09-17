create database bankSystem;
use bankSystem;
create table signup(
form_no varchar(30), 
name varchar(30),
father_name varchar(30),
DOB varchar(30),
email varchar(60),
marital_status varchar(30),
address varchar(60),
city varchar(30),
pincode varchar(30),
state varchar(50));

ALTER TABLE signup ADD gender varchar(10) AFTER DOB;

create table signuptwo(
form_no varchar(30), 
 religion varchar(30),
 category varchar(30),
income varchar(30),
education varchar(60),
occupation  varchar(30),
pan varchar(60),
adhar varchar(30),
seniorcitizen varchar(30),
 existing_account varchar(50));
 

 
 create table signupthree (
 form_no varchar(30),
 account_Type varchar(40),
 card_number varchar(30),
 pin varchar(30),
 facility varchar(200));
 
 
 
 create table login(
 form_no varchar(30),
 card_number varchar(50),
 pin varchar(30));
 

 
 create table bank(
 pin varchar(10),
 date varchar(50),
 type varchar(20),
 amount varchar(20));
 

SET SQL_SAFE_UPDATES = 0;

DELETE FROM signupthree WHERE LENGTH(pin) > 4;
DELETE FROM login WHERE LENGTH(pin) > 4;

ALTER TABLE signupthree MODIFY pin VARCHAR(4);
ALTER TABLE login MODIFY pin VARCHAR(4);

TRUNCATE TABLE signup;
TRUNCATE TABLE signuptwo;
TRUNCATE TABLE signupthree;
TRUNCATE TABLE login;
TRUNCATE TABLE bank;



use bankSystem;
select * from signup;
select * from signuptwo;
select * from signupthree;
select * from login;
select * from bank;






 
 
 


 


