#!/usr/bin/env bash

pushd /docker-entrypoint-initdb.d/application || exit

psql -U ${POSTGRES_USER}  -v "application_db=${APPLICATION_DB}" \
                          -v "application_user=${APPLICATION_USER}" \
                          -v "application_password='${APPLICATION_PASSWORD}'" \
< init.sql
