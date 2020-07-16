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
                sh 'DOCKER_HOST=/var/run/docker.sock docker stop work_finder || true'
                sh 'DOCKER_HOST=/var/run/docker.sock docker rm -f work_finder || true'
            }
        }
        stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh 'DOCKER_HOST=/var/run/docker.sock docker rmi -f springio/gs-spring-boot-docker || true'
                    sh 'DOCKER_HOST=/var/run/docker.sock mvn spring-boot:build-image -DskipTests -Prelease -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker'   
                }
            }
        }	
        stage('Start server'){
            steps{
                //sh 'echo test'
                sh 'DOCKER_HOST=/var/run/docker.sock docker run --name work_finder --detach --volume /home/developer/keys/keystore.p12:/home/keys/keystore.p12 --network jenkins -p 443:443  -u root -t docker.io/springio/gs-spring-boot-docker'
            }
        }
    }
}
