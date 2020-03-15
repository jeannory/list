pipeline {

    agent any

    stages{
        stage('checkout') {
            steps {
                checkout scm
            }
        }

//        stage('stop app') {
//            steps {
//                sh 'echo "kill port 61616"'
//                sh 'fuser -n tcp -k 61616'
//            }
//        }

        stage('clean install') {
            steps {
                sh 'echo "kill mvn install"'
                sh 'mvn install -DskipTests'
            }
        }

        stage('start app') {
            steps {
                sh 'echo "start app"'
                sh 'java -jar /var/lib/jenkins/workspace/adneom/target/adneom-0.0.1-SNAPSHOT.jar'
            }
        }

    }

}
