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
        stage('Test & Jacoco Static Analysis') {
            junit 'target/surefire-reports/**/*.xml'
            jacoco()
        }
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sq1') {
                    bat 'mvn sonar:sonar -Dsonar.login=squ_6dda5afe868603b5cbccdff17da2eae9484cb58a -Dsonar.host.url=http://localhost:9000'
                }
            }
        }
    }
}
