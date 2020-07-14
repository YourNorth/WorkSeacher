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
                sh 'mvn -B -DskipTests -f ./work_sercher -Ptest clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn -f ./work_sercher  -Ptest test' 
            }
            post {
                always {
                    junit 'work_sercher/target/surefire-reports/*.xml' 
                }
            }
        }
	stage('Deliver') { 
            steps {
                sh 'mvn -B -DskipTests -f ./work_sercher -Prelease package'
                sh '/home/jenkins/scripts/deliver.sh' 
            }
        }	
    }
}
