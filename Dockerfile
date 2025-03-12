# Use an official OpenJDK image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application port (same as in application.properties)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]
#  docker logs  patient_information_system
