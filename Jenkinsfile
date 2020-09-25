pipeline {
        agent any
        tools {
            maven 'Maven'
        }        

                stages {
                        stage('Checkout for other browser (Edge)') {
                                steps {
                                        bat 'mkdir Edge'                                        
                                        dir ('Edge') {                                                
                                                git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java' 
                                        }
                                }                                
                        }
                        stage('Build Chrome') {
                                steps {                                        
                                        bat 'mvn clean -f Chrome/pom.xml'
                                        bat 'mvn compile -f Chrome/pom.xml' 
                                        
                                }
                        }
                        stage('Build Edge') {
                                steps {                                         
                                        bat 'mvn clean -f Edge/pom.xml'
                                        bat 'mvn compile -f Edge/pom.xml' 
                                        
                                }
                        }
                        stage('Chrome Test') {
                                steps {
                                        bat 'echo BROWSER_TYPE=chrome >> Chrome/src/main/resources/.env'   
                                        bat 'mvn test -f Chrome/pom.xml' 
                                        
                                }
                                post {
                                        always {
                                                junit 'target/surefire-reports/**/*.xml' 
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
                                                junit 'target/surefire-reports/**/*.xml' 
                                        }                                        
                                }               
                        }
                }
}
