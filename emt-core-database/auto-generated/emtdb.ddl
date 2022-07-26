CREATE TABLE emt.`user` (
  username   varchar(255) NOT NULL, 
  password   varchar(255) NOT NULL, 
  last_login timestamp DEFAULT '1970-01-01 00:00:01' NOT NULL, 
  PRIMARY KEY (username));
CREATE TABLE emt.role (
  id          int(11) NOT NULL AUTO_INCREMENT, 
  name        varchar(255) NOT NULL, 
  description varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE emt.user_role (
  userusername varchar(255) NOT NULL, 
  roleid       int(11) NOT NULL, 
  PRIMARY KEY (userusername, 
  roleid));
ALTER TABLE emt.user_role ADD CONSTRAINT FKuser_role928336 FOREIGN KEY (userusername) REFERENCES emt.`user` (username);
ALTER TABLE emt.user_role ADD CONSTRAINT FKuser_role432826 FOREIGN KEY (roleid) REFERENCES emt.role (id);
