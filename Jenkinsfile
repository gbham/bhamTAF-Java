pipeline {
        agent any
        tools {
            maven 'Maven'
        }        

                stages {
                        stage('Checkout') {
                                steps {
                                        bat 'mkdir Chrome'  
                                        bat 'mkdir Edge'
                                        
                                        bat 'cd Chrome'
                                        git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java'
                                        
                                        bat 'cd ..'
                                        bat 'cd Edge'
                                        git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java'                                       
                                        
                                }
                        }
                        stage('Build') {
                                steps {
                                        bat 'dir'                                        
                                        bat 'echo BROWSER_TYPE=chrome >> Chrome/src/main/resources/.env'   
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
                        stage('Test') {
                                steps {
                                        bat 'cd chrome'
                                        bat 'mvn test'
                                        
                                        bat 'cd ..'
                                        bat 'cd edge'
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
