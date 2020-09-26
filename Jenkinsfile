pipeline {
        agent any
        tools {
            maven 'Maven'
        }        

                stages {
                        stage('Checkout for other browser (Edge)') {
                                steps {
                                        bat 'mkdir Edge'
                                        bat 'Xcopy /E \chrome \Edge\'
                                        //dir ('Edge') {                                                
                                        //        git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java' 
                                        //}
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
                                bat 'RMDIR /Q /S Edge'    
                                bat 'RMDIR /Q /S Chrome'  
                                
                        }
                }
                
}
