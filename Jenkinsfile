node
{
  def mavenHome=tool name: "maven3.6.2"

 stage('Checkout')
 {
 	git branch: 'krishna', credentialsId: 'dda4164d-b839-423d-9d4e-ebf5676b26a9', url: 'https://github.com/frameworksselenium/live-execution-dashboard.git'

 }
 stage('Build')
 {
    sh  "${mavenHome}/bin/mvn clean package"
 }

 stage('ExecuteSoanrQubeReport')
 {
    sh  "${mavenHome}/bin/mvn sonar:sonar"
 }

 stage('UploadArtifactintoNexus')
 {
    sh  "${mavenHome}/bin/mvn deploy"
 }

 stage('DeployAppintoTomcat')
 {
    sshagent(['ed833a5b-4248-40cd-b77a-1c4699baaedd']) {
        sh "scp -o StrictHostKeyChecking=no target/maven-web-application.war ec2-user@54.167.87.65:/opt/apache-tomcat-9.0.64/webapps/"
    }
 }

 stage('SendEmailNotification')
 {
    emailext body: '''Deployment Done...
    Krishna''', subject: 'Deployment Done', to: 'devopsgithub100@gmail.com'
 }

}