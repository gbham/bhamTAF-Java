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
                                        bat 'cd src/main/resources'
                                        bat 'echo BROWSER_TYPE=chrome >> .env'
                                        sh  'cat .env'
                                        bat 'mvn clean'
                                        bat 'mvn compile'
                                }
                        }
                        stage('Test') {
                                steps {
                                        bat 'mvn test -e -X'
                                }
                                post {
                                        always {
                                                junit 'target/surefire-reports/**/*.xml' 
                                        }                                        
                                }               
                        }
                }
}
