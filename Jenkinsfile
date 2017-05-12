pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps{
                sh 'git clone https://github.com/guillepb10/confi-server.git'
                cd config-server
            }
        }

        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging..'
                sh 'mvn docker:build'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Testing..'
            }
        }
    }
}