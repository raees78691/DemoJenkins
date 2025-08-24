pipeline {
    agent any

  tools {
        maven 'Maven-3.9'   // must exist in Manage Jenkins → Tools
    jdk   'jdk-17'      // must exist in Manage Jenkins → Tools
  }

  options { timestamps() }

  stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
            url: 'https://github.com/raees78691/demoJenkins.git'
            // ,credentialsId: 'github-creds' // if repo is private
      }
    }

    stage('Build') {
            steps {
                bat 'where mvn'
        bat 'mvn -v'
        bat 'mvn -B clean verify'
      }
    }

    stage('Test') {
            steps {
                bat 'mvn -B test'
        junit 'target/surefire-reports/*.xml'
      }
    }

    stage('Package') {
            steps {
                bat 'mvn -B package -DskipTests'
        archiveArtifacts artifacts: 'target\\*.jar', fingerprint: true
      }
    }

    stage('Deploy') {
            when { branch 'main' } // only deploy from main
      steps {
                echo 'Deploy step here (Docker build / copy JAR to server / AWS etc.)'
        }
      }

  }

  post {
        always { echo "Done at ${new Date()}" }
  }
}