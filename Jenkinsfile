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
stage('Build & Test in Docker') {
    steps {
        script {
            docker.image('maven:3.8.7-eclipse-temurin-17').inside {
                sh 'mvn clean package'
            }
        }
    }
}

// ✅ Place Deploy stage outside
stage('Deploy') {
    steps {
        echo 'Deploying the application...'
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
