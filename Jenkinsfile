pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh "./mvnw clean package -DskipTests"
            }
        }

        stage('Test') {
            steps {
                sh "./mvnw test"
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage("Check Coverage") {
            steps {
                sh "./mvnw jacoco:report-aggregate"
            }
            post {
                always {
                    // Requires HTMLPublisher plugin in Jenkins instance.
                    publishHTML(target: [
                            reportDir  : '**/target/site/jacoco-aggregate',
                            reportFiles: 'index.html',
                            reportName : 'Coverage Report - Unit Tests'
                    ])
                }
            }
        }
    }
}
