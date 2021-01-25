pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				bat 'gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				bat 'gradlew test'
            }
        }
		
		stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "local-artifactory",
                    url: "http://localhost:8081/artifactory",
                    username: 'admin',
					password: 'Admin123'
                )                
            }
        }


        stage('Deploy') {
            steps {
                echo 'Deploying....'
				echo "build number is ${env.BUILD_NUMBER}"
				echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} build num is ${env.BUILD_NUMBER}"
				
				rtUpload (
					serverId: 'local-artifactory',
					spec: '''{
						  "files": [
							{
							  "pattern": "build/libs/*.jar",
							  "target": "test-repo/example-pipeline/jar/${BUILD_NUMBER}/"
							}
						 ]
					}'''				 
				)
            }
        }
    }
}