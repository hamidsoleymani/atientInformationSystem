pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'my-spring-app'
        DOCKER_CONTAINER = 'spring_app'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/hamidsoleymani/catalog-service.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t my-spring-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker stop $DOCKER_CONTAINER || true && docker rm $DOCKER_CONTAINER || true'
                sh 'docker run -d --name $DOCKER_CONTAINER -p 8080:8080 my-spring-app'
            }
        }
    }
}
