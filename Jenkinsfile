pipeline {
    agent any
    stages {
        stage('Preparing for Build') {
            steps {
                script {

                }
            }
        }
        stage('Build Docker Image') {
        steps {
                sh 'docker build -t halushka_pampushka_bot:latest .'
            }
        }
        stage ('Start Application in Docker') {
            steps {
                sh 'docker run -p 8083:8080 halushka_pampushka_bot:latest'
            }
        }
    }
}