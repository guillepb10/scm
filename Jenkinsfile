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
                echo 'Building..'
                sh 'mvn clean install -f confi-server/pom.xml'
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