pipeline {
        agent any         
        tools {
                maven 'Maven'
        }
                stages {
                        //stage('Clone Repository (Edge)') {
                        //        steps { 
                        //                bat "mkdir Edge"
                        //                bat 'Xcopy /E "Chrome" "Edge\"' 
                        //        }                                
                        //}
                        //stage('Start Selenium Grid & Test App (Docker)') {
                        //        steps {
                        //                bat "docker-compose -f Chrome/docker-env-setup.yaml up -d"
                        //        }
                        //}
                        stage('Create .env files') {
                                steps {
                                        bat "echo BASE_URL=${BASE_URL} >> Chrome/src/main/resources/.env"                                        
                                        bat "echo SELENIUM_GRID=${SELENIUM_GRID} >> Chrome/src/main/resources/.env"
                                        bat "echo SELENIUM_HUB_URL=${SELENIUM_HUB_URL} >> Chrome/src/main/resources/.env"
                                        bat "echo BROWSER_TYPE=chrome >> Chrome/src/main/resources/.env"
                                        
                                        //bat "echo BASE_URL=${BASE_URL} >> Edge/src/main/resources/.env"                                        
                                        //bat "echo SELENIUM_GRID=${SELENIUM_GRID} >> Edge/src/main/resources/.env"
                                        //bat "echo SELENIUM_HUB_URL=${SELENIUM_HUB_URL} >> Edge/src/main/resources/.env"
                                        //bat "echo BROWSER_TYPE=edge >> Edge/src/main/resources/.env"
                                }
                        }  
                        stage('Build') {
                                steps {                                        
                                        bat "mvn clean -f Chrome/pom.xml"
                                        bat "mvn compile -f Chrome/pom.xml"
                                        
                                        //bat "mvn clean -f Edge/pom.xml"
                                        //bat "mvn compile -f Edge/pom.xml"
                                }
                        }
                        //stage('Run Tests') {        
                                //parallel {
                                        stage('Chrome Test') {
                                                steps {                                                          
                                                        bat "mvn test -f Chrome/pom.xml"                                         
                                                }
                                                post {
                                                        always {
                                                                junit "Chrome/target/surefire-reports/**/*.xml" 
                                                        }
                                                }
                                        }
                                        //stage('Edge Test') {
                                        //        steps {                                                           
                                        //                bat "mvn test -f Edge/pom.xml" 
                                        //        }
                                        //        post {
                                        //                always {
                                        //                        junit "Edge/target/surefire-reports/**/*.xml"
                                        //                }                                        
                                        //        }               
                                        //} 
                                //}
                        //}
                }
                post {
                        always { 
                                bat "dir"
                                //Attempt to copy artifacts from docker container                                
                                bat "docker cp a52a09a9e333:/tmp/srcFileTest.txt C:/Dev "
                                //bat "docker-compose -f Chrome/docker-env-setup.yaml down"
                                //deleteDir()
                        }
                }
                
}
