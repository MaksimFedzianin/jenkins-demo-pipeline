/*
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
				junit 'build/test-results/test/*.xml'
            }
        }
		
		stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "local-artifactory",
                    url: "http://localhost:8081/artifactory",
                    credentialsId: 'local-artifactory-credentials'
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
*/
node {
    echo "Fetching code..."
    scmVars = git "https://github.com/MaksimFedzianin/jenkins-demo-pipeline.git"
    echo "Code fetched..."
    def option = readFile "${env.WORKSPACE}/option.txt"
    echo "option is: |" + option + "|"
    echo 'Branch name is: ' + scmVars.GIT_BRANCH
    for (i=0; i<2; i++) {
        stage("Stage #" + i) {
           print 'Hello, world !'
        }
    }
    
    if(option != "skipTests") {
        stage("Run Tests"){
            echo 'Running tests'
        }
    }
    else {
        echo 'Testing skipped'
    }
}