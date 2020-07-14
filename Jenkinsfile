pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests -f ./work_sercher/pom.xml -Pdev clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn -f ./work_sercher/pom.xml -Pdev test' 
            }
            post {
                always {
                    junit 'work_sercher/target/surefire-reports/*.xml' 
                }
            }
        }
	stage('Deliver') { 
            steps {
                sh '/home/jenkins/scripts/deliver.sh' 
            }
        }	
    }
}
