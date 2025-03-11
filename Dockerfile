# Use an official OpenJDK image
FROM eclipse-temurin:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application port (same as in application.properties)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
