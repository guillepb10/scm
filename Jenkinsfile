pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps{
                deleteDir()
                sh 'git clone https://github.com/guillepb10/confi-server.git'
            }
        }

        stage('Build') {
            steps {
                dir('confi-server'){
                    echo 'Building..'
                    sh 'mvn clean install'
                }
            }
        }
        stage('Package') {
            steps {
                dir('confi-server'){
                    echo 'Packaging..'
                    sh 'mvn package docker:build -pl docker'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Testing..'
            }
        }
    }
}