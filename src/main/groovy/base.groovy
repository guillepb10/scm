#!groovy

def run() {
    stage('Checkout') {
        sh 'git clone https://github.com/guillepb10/confi-server.git'
    }

    stage('Build') {
        dir('confi-server') {
            sh 'mvn clean install'
        }
    }
    stage('Package') {
        dir('confi-server') {
            sh '$(aws ecr get-login --region eu-west-1) && mvn package docker:build -pl docker'
        }
    }
    stage('Deploy') {
        dir('confi-server') {
            sh '$(aws ecr get-login --region eu-west-1) &&  mvn package docker:push -pl docker'
        }
    }
}