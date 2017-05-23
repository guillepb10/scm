pipeline {

    node('ecs-slave'){
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
                    sh '$(aws ecr get-login --region eu-west-1) && mvn package docker:build -pl docker'
                }
            }
        }
        stage('Deploy') {
            steps {
                dir('confi-server'){
                    sh 'mvn package docker:push -pl docker'

                }
            }
        }
    }
}