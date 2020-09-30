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
                        stage('Start Selenium Grid (Docker)') {
                                steps {                                       
                                        bat "docker-compose -f Chrome/docker-SeleniumGrid.yaml up -d"                                        
                                }                                
                        }
                        stage('Start Application (Docker)') {
                                steps {                                       
                                        bat "git clone https://github.com/dockersamples/node-bulletin-board"
                                       
                                        dir('node-bulletin-board\\bulletin-board-app') {
                                                bat "docker build --tag bulletinboard:1.0 ."
                                                bat "docker run --publish 8000:8080 --detach --name bb bulletinboard:1.0"
                                        }
                                }                                
                        }                        
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
                                        
                                        bat "mvn clean -f Edge/pom.xml"
                                        bat "mvn compile -f Edge/pom.xml"
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
                                
                                bat "docker-compose -f Chrome/docker-SeleniumGrid.yaml down"
                                bat "docker rm --force bb"
                                //remember and close docker container for application being tested
                                deleteDir()                                                                
                        }
                }
                
}
