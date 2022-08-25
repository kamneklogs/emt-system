CREATE TABLE `user` (
  id         varchar(255) NOT NULL, 
  password   varchar(255), 
  last_login timestamp DEFAULT '1970-01-01 00:00:01' NULL, 
  PRIMARY KEY (id));
CREATE TABLE role (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  name        varchar(45), 
  description varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE user_role (
  userusername varchar(255) NOT NULL, 
  roleid       int(10) NOT NULL, 
  PRIMARY KEY (userusername, 
  roleid));
CREATE TABLE personalinformation (
  id           varchar(255) NOT NULL, 
  first_name   int(10), 
  last_name    int(10), 
  email        int(10), 
  dob          int(10), 
  gender       int(10), 
  civil_status int(10), 
  phone_number int(10), 
  address      varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE clinical_history_format (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  name        int(10), 
  description int(10), 
  disable     int(10), 
  created_at  int(10), 
  PRIMARY KEY (id));
CREATE TABLE field (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  name        int(10), 
  description int(10), 
  type        int(10), 
  PRIMARY KEY (id));
CREATE TABLE option_item (
  id      int(10), 
  content int(10));
CREATE TABLE pacient (
  id varchar(255) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE user_role ADD CONSTRAINT FKuser_role211266 FOREIGN KEY (userusername) REFERENCES `user` (id);
ALTER TABLE user_role ADD CONSTRAINT FKuser_role432826 FOREIGN KEY (roleid) REFERENCES role (id);
ALTER TABLE personalinformation ADD CONSTRAINT FKpersonalin432238 FOREIGN KEY (id) REFERENCES `user` (id);
ALTER TABLE personalinformation ADD CONSTRAINT FKpersonalin150320 FOREIGN KEY (id) REFERENCES pacient (id);
