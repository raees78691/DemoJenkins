pipeline {
    agent any

    tools {
        maven 'Maven-3.9'   // Name of Maven configured in Jenkins
        jdk 'jdk-17'        // Name of JDK configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/raees78691/demoJenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy step here (Docker build / copy JAR to server / AWS etc.)'
            }
        }
    }
}