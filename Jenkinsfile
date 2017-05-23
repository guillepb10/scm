pipeline {

    node('ecs-slave'){
        stage 'Checkout'
        sh 'git clone https://github.com/guillepb10/confi-server.git'

        stage 'Build'
        sh 'mvn clean install'

        stage 'Package'
        sh '$(aws ecr get-login --region eu-west-1) && mvn package docker:build -pl docker'

        stage 'Deploy'
        sh 'mvn package docker:push -pl docker'
    }
}