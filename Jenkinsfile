pipeline {
        agent any
        tools {
            maven 'Maven'
        }        

                stages {
                        stage('Checkout') {
                                steps {
                                        
                                        bat 'dir'
                                }
                                steps {
                                        
                                        bat 'dir'
                                }
                        }
                        stage('Build') {
                                steps {
                                        bat 'dir'                                        
                                        bat 'echo BROWSER_TYPE=chrome >> src/main/resources/.env'   
                                        bat 'echo BROWSER_TYPE=edge >> Edge/src/main/resources/.env' 
                                        
                                        bat 'cd chrome'
                                        bat 'mvn clean'
                                        bat 'mvn compile'
                                        
                                        bat 'cd ..'
                                        bat 'cd Edge'
                                        bat 'mvn clean'
                                        bat 'mvn compile'
                                        
                                }
                        }
                        stage('Chrome Test') {
                                steps {
                                        bat 'echo BROWSER_TYPE=chrome >> src/main/resources/.env'   
                                        bat 'mvn test' 
                                        
                                }
                                post {
                                        always {
                                                junit 'target/surefire-reports/**/*.xml' 
                                        }                                        
                                }               
                        }
                        stage('Edge Test') {
                                steps {
                                        bat 'echo BROWSER_TYPE=edge >> src/main/resources/.env'   
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
