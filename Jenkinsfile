pipeline {
    agent any
    triggers {
        pollSCM '*/3 * * * *'
    }
    tools {
        jdk 'java-11'
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
    }
}