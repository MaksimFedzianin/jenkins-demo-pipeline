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
        stage('Deploy') {
            steps {
                echo 'Deploying....'
				echo 'build number is ${env.BUILD_NUMBER}'
				echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
            }
        }
    }
}