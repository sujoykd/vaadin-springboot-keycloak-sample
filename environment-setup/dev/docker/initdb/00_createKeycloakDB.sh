#!/usr/bin/env bash

pushd /docker-entrypoint-initdb.d/keycloak

psql -U ${POSTGRES_USER}  -v "keycloak_db=${KC_DB_NAME}" \
                          -v "keycloak_user=${KC_DB_USERNAME}" \
                          -v "keycloak_password='${KC_DB_PASSWORD}'" \
< init.sql
