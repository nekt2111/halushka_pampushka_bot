pipeline {
    agent any
    stages {
        stage('Preparing for build') {
            steps {
                script {
                    sh 'docker rm halushka_pampushka_bot'

                    def isContainerExists = sh(script: "docker ps -q -f name='halushka_pampushka_bot'", returnStdout: true) != ""
                    def isImageExists = sh(script: "docker images -q halushka_pampushka_bot", returnStdout: true) != ""

                    echo "${isContainerExists}"

                    sh 'docker ps -a'

                    sh 'docker ps'

                    echo "${isImageExists}"

                    if (isContainerExists) {
                        sh 'docker stop -t 0 halushka_pampushka_bot'
                        sh 'docker rm halushka_pampushka_bot'
                    }

                    if (isImageExists) {
                        sh 'docker rmi -f halushka_pampushka_bot'
                    }
                }
            }
        }
        stage('Build Docker Image') {
        steps {
                sh 'docker build -t halushka_pampushka_bot .'
            }
        }
        stage ('Start Application in Docker') {
            steps {
                sh 'docker run -d --name halushka_pampushka_bot halushka_pampushka_bot'
            }
        }
    }
}