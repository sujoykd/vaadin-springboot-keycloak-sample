# Sample project for Vaadin Spring Boot with Keycloak and PostgreSQL in Docker

This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

## Clone the repository

To clone the repository use:

```
git clone --recursive <url>
```

## Running the application in development

The project is a standard Maven project.

Run the docker container.

```
cd environment-setup/dev/docker/
docker compose up -d --wait
```

Run the application in your IDE by running the `Application.java`

Go to `http://localhost:8081/`

Users setup for dev environment:

```
username: admin
password: admin
```

## Running the application in production

Build the application with 
```
mvn clean package -Pproduction
```

Start the application with
```
java -jar target\vaadin-springboot-keycloak-sample-<version>.jar
```
You can override the application configuration by providing an `application-prod.yml` file in the same location as the jar file when starting the application.

## Troubleshooting


### Too many redirect error when logging in to the application

Turn on log level to trace for org.springframework `logging.level.org.springframework = trace`
in `application-dev.properties`\
If you see the following stack trace then check the WSL2 data time.\
`Caused by: org.springframework.security.oauth2.jwt.JwtValidationException: An error occurred while attempting to decode the Jwt: Jwt expired at ...`

In WSL2 the clock drifts from the host system resulting
in [clock skew issues.](https://github.com/microsoft/WSL/issues/10006)
Easiest fix is to either set the hardware clock in wsl by running `sudo hwclock -s` or go into windows command prompt
and restart WSL2.

```
# shutdown WSL
wsl --shutdown

# start it again
wsl
```

