pipeline {
    agent {
        dockerfile {
            filename '/home/maven-image/Dockerfile'
            args '-v /home/.m2:/root/.m2 -v /home/maven-image/id_rsa:/root/.ssh/id_rsa -v /var/run/docker.sock:/var/run/docker.sock -v /var/jenkins_home/:/var/jenkins_home/ -v /certs/client:/certs/client --network host'
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
                sh 'DOCKER_CERT_PATH=/certs/client DOCKER_TLS_VERIFY=1 DOCKER_HOST=tcp://172.18.0.3:2376 docker stop work_finder || true'
                sh 'DOCKER_CERT_PATH=/certs/client DOCKER_TLS_VERIFY=1 DOCKER_HOST=tcp://172.18.0.3:2376 docker rm -f work_finder || true'
            }
        }
        stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh 'DOCKER_CERT_PATH=/certs/client DOCKER_TLS_VERIFY=1 DOCKER_HOST=tcp://172.18.0.3:2376 docker rmi -f springio/gs-spring-boot-docker || true'
                    sh 'DOCKER_CERT_PATH=/certs/client DOCKER_TLS_VERIFY=1 DOCKER_HOST=tcp://172.18.0.3:2376 mvn spring-boot:build-image -DskipTests -Prelease -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker'   
                }
            }
        }	
        stage('Start server'){
            steps{
                //sh 'echo test'
                sh 'DOCKER_CERT_PATH=/certs/client DOCKER_TLS_VERIFY=1 DOCKER_HOST=tcp://172.18.0.3:2376 docker run --restart unless-stopped --name work_finder --detach --volume /home/keys/keystore.p12:/home/keys/keystore.p12 --network host -p 443:443  -u root -t springio/gs-spring-boot-docker'
            }
        }
    }
}
