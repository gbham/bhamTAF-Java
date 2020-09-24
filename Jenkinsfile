pipeline {
        agent any
        tools {
            maven 'Maven'
        }        

                stages {
                        stage('Checkout') {
                                steps {
                                        git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java'
                                }
                        }
                        stage('Build') {
                                steps {
                                        bat 'mvn clean'
                                        bat 'mvn compile'
                                }
                        }
                        stage('Test') {
                                steps {
                                        bat 'mvn test'
                                }
                                post {
                                        always {
                                                junit 'target/surefire-reports/**/*.xml' 
                                        }
                                        failure {
                                                mail to: 'gregbanham@hotmail.com',
                                                        subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                                                        body: "Something is wrong with ${env.BUILD_URL}"
                                }
                                        }               
                        }
                }
}
