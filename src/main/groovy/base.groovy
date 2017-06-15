#!groovy
stage( 'Checkout' ) {
    steps {
        sh 'git clone https://github.com/guillepb10/confi-server.git'
    }
}

stage( 'Build' ) {
    steps {
        dir ('confi-server') {
            sh 'mvn clean install'
        }
    }
}
stage( 'Package' ) {
    steps {
        dir ('confi-server') {
            sh '$(aws ecr get-login --region eu-west-1) && mvn package docker:build -pl docker'
        }
    }
}
stage( 'Deploy' ) {
    steps {
        dir ('confi-server') {
            sh '$(aws ecr get-login --region eu-west-1) &&  mvn package docker:push -pl docker'
        }
    }
}
