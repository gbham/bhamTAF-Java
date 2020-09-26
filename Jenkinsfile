pipeline {
        agent any
        tools {
                maven 'Maven'
        }       
        environment {
                TEST_VAR = "1"
        }

                stages {
                        stage('Clone Repository (Edge)') {
                                steps { 
                                        bat 'mkdir Edge'
                                        bat 'Xcopy /E "Chrome" "Edge\"'
                                        
                                        bat 'echo TEST_VAR = ${TEST_VAR}'
                                }                                
                        }
                        stage('Build') {
                                steps {                                        
                                        bat 'mvn clean -f Chrome/pom.xml'
                                        bat 'mvn compile -f Chrome/pom.xml'
                                        
                                        bat 'mvn clean -f Edge/pom.xml'
                                        bat 'mvn compile -f Edge/pom.xml' 
                                }
                        }
                        stage('Run Tests') {        
                                parallel {
                                        stage('Chrome Test') {
                                                steps {
                                                        bat 'echo BROWSER_TYPE=chrome >> Chrome/src/main/resources/.env'   
                                                        bat 'mvn test -f Chrome/pom.xml'                                         
                                                }
                                                post {
                                                        always {
                                                                junit 'Chrome/target/surefire-reports/**/*.xml' 
                                                        }
                                                }
                                        }
                                        stage('Edge Test') {
                                                steps {
                                                        bat 'echo BROWSER_TYPE=edge >> Edge/src/main/resources/.env'   
                                                        bat 'mvn test -f Edge/pom.xml' 
                                                }
                                                post {
                                                        always {
                                                                junit 'Edge/target/surefire-reports/**/*.xml' 
                                                        }                                        
                                                }               
                                        } 
                                }
                        }
                }
                post {
                        always {                                
                                deleteDir()
                        }
                }
                
}
