pipeline {
    agent any
    stages {
        stage('Preparing for build') {
            steps {
                script {
                    def isContainerExists = sh(script: "docker ps -q -f name='halushka_pampushka_bot:latest'", returnStdout: true) != ""
                    def isImageExists = sh(script: "docker images -q halushka_pampushka_bot:latest", returnStdout: true) != ""

                    echo "${isContainerExists}"

                    sh 'docker ps -a'

                    sh 'docker ps'

                    echo "${isImageExists}"

                    if (isContainerExists) {
                        sh 'docker stop -t 0 halushka_pampushka_bot:latest'
                        sh 'docker rm halushka_pampushka_bot:latest'
                    }

                    if (isImageExists) {
                        sh 'docker rmi -f halushka_pampushka_bot:latest'
                    }
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