create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on TestDB.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database

CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);
