pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', 
                    url: 'https://github.com/Chiranth-VN/saucedemofirefox.git'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            // ✅ FIX: allow empty test results
            junit allowEmptyResults: true, 
                  testResults: '**/target/surefire-reports/*.xml'
        }

        success {
            echo 'Build and Firefox Selenium tests executed successfully!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
