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
            when { branch 'main' }
  steps {
                bat 'docker build -t springboot-app:%BUILD_NUMBER% .'
    bat 'docker rm -f springboot-app || exit /b 0'
    bat 'docker run -d --name springboot-app -p 8050:8050 springboot-app:%BUILD_NUMBER%'
  }
}

  }

  post {
        always { echo "Done at ${new Date()}" }
  }
}