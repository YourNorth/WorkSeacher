pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /home/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Ptest clean package'
                }
            }
        }
        stage('Test') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -Ptest test' 
                }
            }
            post {
                always {
                    junit 'work_sercher/target/surefire-reports/*.xml' 
                }
            }
        }
	stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh '/home/jenkins/scripts/deliver.sh' 
                }
            }
        }	
    }
}
