#!/bin/bash
set -e  # Exit script if any command fails

echo "Waiting for PostgreSQL to be ready..."

# Loop until PostgreSQL is available
until pg_isready -h postgres -p 5432 -U postgres; do
  echo "Postgres is unavailable - waiting..."
  sleep 2
done

echo "Postgres is up - starting Spring Boot app..."
exec java -jar /app.jar
