create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on TestDB.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database

# CREATE TABLE `user` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `email` varchar(255) NOT NULL,
#   `name` varchar(255) NOT NULL,
#   `password` varchar(255) NOT NULL,
#   PRIMARY KEY (`id`)
# );
#
# CREATE TABLE `task` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `description` varchar(255) DEFAULT NULL,
#   `user_id` int(11) NOT NULL ,
#   PRIMARY KEY (`id`),
#   CONSTRAINT FK_TaskUser FOREIGN KEY (id) REFERENCES user(id)
# );