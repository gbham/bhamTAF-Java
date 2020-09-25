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
                                        bat 'dir'                                        
                                        bat 'echo BROWSER_TYPE=chrome >> src/main/resources/.env'                                       
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
                                }               
                        }
                }
}
