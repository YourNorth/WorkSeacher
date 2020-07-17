pipeline {
    agent {
        dockerfile {
            filename '/home/maven-image/Dockerfile'
            args '-u root -v /home/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/host-docker.sock -v /var/jenkins_home/:/var/jenkins_home/  --network jenkins'
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
                sh 'DOCKER_HOST=unix:///var/run/host-docker.sock docker stop work_finder || true'
                sh 'DOCKER_HOST=unix:///var/run/host-docker.sock docker rm -f work_finder || true'
            }
        }
        stage('Deliver') { 
            steps {
                dir( 'work_sercher'){
                    sh 'mvn -B -DskipTests -Prelease package'
                    sh 'DOCKER_HOST=unix:///var/run/host-docker.sock docker rmi -f springio/gs-spring-boot-docker || true'
                    sh 'DOCKER_HOST=unix:///var/run/host-docker.sock mvn spring-boot:build-image -DskipTests -Prelease -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker'   
                }
            }
        }	
        stage('Start server'){
            steps{
                //sh 'echo test'
                sh 'DOCKER_HOST=unix:///var/run/host-docker.sock docker run --restart unless-stopped --name work_finder --detach --volume /home/keys/keystore.p12:/home/keys/keystore.p12 --network host -p 443:443  -u root -t springio/gs-spring-boot-docker'
            }
        }
    }
}
