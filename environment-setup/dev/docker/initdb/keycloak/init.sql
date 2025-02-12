CREATE DATABASE :keycloak_db;
CREATE USER :keycloak_user WITH PASSWORD :keycloak_password ;
ALTER DATABASE :keycloak_db OWNER TO :keycloak_user;