pipeline {
    agent any
    triggers {
        pollSCM '*/3 * * * *'
    }
    stages {
        stage('Build'){
            steps {
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Test'){
            steps{
                bat "mvn test"
            }
        }
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sq1') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
    }
}
