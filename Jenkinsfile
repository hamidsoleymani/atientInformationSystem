pipeline {
    agent {
        docker { image 'maven:3.8.7-eclipse-temurin-17' }  // ✅ Use a valid Maven image
    }

    stages {
        stage('Checkout') {
            steps {
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

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add deployment steps here
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
