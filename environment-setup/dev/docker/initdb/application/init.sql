CREATE DATABASE :application_db ;
CREATE USER :application_user WITH PASSWORD :application_password;
ALTER DATABASE :application_db OWNER TO :application_user;