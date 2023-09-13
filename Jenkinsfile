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
        stage('Jacoco Static Analysis') {
            steps {
                bat "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Pcoverage-per-test"
            }
        }
        stage('Scan') {
            steps {
                bat 'mvn sonar:sonar -Dsonar.login=squ_6dda5afe868603b5cbccdff17da2eae9484cb58a -Dsonar.host.url=http://localhost:9000'
            }
        }
        stage ('Deploy on Tomcat Server') {
            deploy adapters: [tomcat9(credentialsId: 'TomcatCreds', path: '', url: 'http://localhost:8090')], contextPath: null, war: '**/*.war'
        }
    }
}
