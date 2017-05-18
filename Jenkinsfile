pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps{
                deleteDir()
                sh 'git clone https://github.com/guillepb10/confi-server.git'
            }
        }

        dir('confi-server'){
            stage('Build') {
                steps {
                    echo 'Building..'
                    sh 'mvn clean install'
                }
            }
            stage('Package') {
                steps {
                    echo 'Packaging..'
                    sh 'mvn package docker:build -pl docker'
                }
            }
            stage('Deploy') {
                steps {
                    echo 'Testing..'
                }
            }
        }
    }
}