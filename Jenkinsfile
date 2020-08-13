node {
   def mvn = tool (name: 'maven-3', type: 'maven') + '/bin/mvn'
   
   stage('Github Checkout') {
	git branch: 'master',
	url: 'https://github.com/Abhik87/starapp'
   
   }
   stage('Maven Package') {
	   sh "${mvn} clean package"
   }
   stage('Build Docker Image') {
       sh 'docker build -t abhik87/starapp:1.0.0 .'
   }
   stage('Push Docker Image to Dockerhub') {
       withCredentials([string(credentialsId: 'docker-pwd', variable: 'DockerHubPwd')]) {
           sh "docker login -u abhik87 -p ${DockerHubPwd}"
       }
       sh "docker push abhik87/starapp:1.0.0"
   }
   stage('Run Container on Server') {
       def dockerRun = 'docker run -p 8081:8081 -d --name starapp abhik87/starapp:1.0.0'
       sshagent(['app-server']) {
          sh "ssh -o StrictHostKeyChecking=no ec2-user@172.31.13.145 ${dockerRun}"
       }
   }
}