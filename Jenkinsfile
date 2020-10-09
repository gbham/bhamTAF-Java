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
                        //stage('Run Parallel Tests') {
                                //parallel {
                                        stage('Chrome Parallel Tests') {
                                                steps {
                                                        bat "mvn test -f Chrome/pom.xml -DthreadCount=4 -Dgroups=ChromeParallel"
                                                }
                                                post {
                                                        always {
                                                                junit "Chrome/target/surefire-reports/**/*.xml"
                                                        }
                                                }
                                        }
                                        //stage('Edge Parallel Tests') {
                                        //        steps {
                                        //                bat "mvn test -f Edge/pom.xml -D threadCount=4 "
                                        //        }
                                        //        post {
                                        //                always {
                                        //                        junit "Edge/target/surefire-reports/**/*.xml"
                                        //                }
                                        //        }
                                        //}
                                //}
                        //}
                        stage('Chrome Single Tests') {
                                steps {
                                        bat "mvn test -f Chrome/pom.xml -Dgroups=ChromeSingle"
                                }
                                post {
                                        always {
                                                junit "Chrome/target/surefire-reports/**/*.xml"
                                        }
                                }
                        }
                        //stage('Edge Single Tests') {
                        //        steps {
                        //                bat "mvn test -f Edge/pom.xml"
                        //        }
                        //        post {
                        //                always {
                        //                        junit "Edge/target/surefire-reports/**/*.xml"
                        //                }
                        //        }
                        //}

                }
                post {
                        always {
                                dir('C:/TestResults/') {
                                        archiveArtifacts artifacts: "VideoRecordings/**/*.mp4, allowEmptyArchive: true"
                                        sleep 4
                                        bat "del VideoRecordings\\*.mp4 /f/s/q "       
                                }

                                archiveArtifacts artifacts: "Chrome/TestResults/**/*.*, allowEmptyArchive: true"                                
                                //archiveArtifacts artifacts: "Chrome/target/surefire-reports/**/*.xml"
                                //archiveArtifacts artifacts: 'Edge/TestResults/**/*.*'
                                //bat "docker-compose -f Chrome/docker-env-setup.yaml down"
                                sh "docker container kill \$(docker ps -q)"
                                deleteDir()
                        }
                }
}
