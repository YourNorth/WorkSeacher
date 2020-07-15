pipeline {
    agent {
        dockerfile {
            filename '/home/developer/maven-image/Dockerfile'
            dir 'build'
            args '-v /home/:/root/ -v /home/.m2:/root/.m2 -v /root/.ssh/:/root/.ssh -v /var/run/docker.sock:/var/run/docker.sock'
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
        stage('Stop server'){
            steps{
                sh 'ssh developer@172.17.0.1  -p 12 "docker stop work_finder";'
            }
        }
        stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh 'DOCKER_HOST=/var/run/docker.sock mvn spring-boot:build-image -DskipTests -Prelease -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker'   
                }
            }
        }	
        stage('Start server'){
            steps{
                sh 'ssh developer@172.17.0.1  -p 12 "docker run --name work_finder --detach --volume /home/developer/keys/keystore.p12:/home/keys/keystore.p12 --network jenkins -p 443:443  -u root -t springio/gs-spring-boot-docker";'
            }
        }
    }
}
