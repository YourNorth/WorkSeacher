pipeline {
    agent {
        dockerfile {
            filename '/home/maven-image/Dockerfile'
            args '-v /home/.m2:/root/.m2 -v /home/maven-image/id_rsa:/root/.ssh/id_rsa -v /var/run/docker.sock:/var/run/docker.sock -v /var/jenkins_home/:/var/jenkins_home/ --network host'
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
                sh 'sshpass -p "SidikovCrasavaqwert007" ssh developer@172.18.0.1 -o StrictHostKeyChecking=no -p 12 docker stop work_finder || true'
                sh 'sshpass -p "SidikovCrasavaqwert007" ssh developer@172.18.0.1 -o StrictHostKeyChecking=no -p 12 docker rm -f work_finder || true'
            }
        }
        stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh 'sshpass -p "SidikovCrasavaqwert007" ssh developer@172.18.0.1 -o StrictHostKeyChecking=no -p 12 docker rmi -f springio/gs-spring-boot-docker || true'
                    sh 'DOCKER_HOST=/var/run/docker.sock mvn spring-boot:build-image -DskipTests -Prelease -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker'   
                }
            }
        }	
        stage('Start server'){
            steps{
                sh 'sshpass -p "SidikovCrasavaqwert007" ssh developer@172.18.0.1 -o StrictHostKeyChecking=no -p 12 docker run --name work_finder --detach --volume /home/developer/keys/keystore.p12:/home/keys/keystore.p12 --network jenkins -p 443:443  -u root -t springio/gs-spring-boot-docker'
            }
        }
    }
}
