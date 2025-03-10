pipeline {
     agent {
           docker {
               image 'maven:3.8.7-openjdk-17'  // Use a Maven image with Java 17
           }
       }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                git branch: 'develop', url: 'https://github.com/hamidsoleymani/atientInformationSystem.git'
            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (optional)
                echo 'Deploying the application...'
                // Add deployment steps here (e.g., copying the JAR to a server)
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
