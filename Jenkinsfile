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
                        stage('Maven Build') {
                                steps {
                                        sh 'mvn -Dmaven.test.failure.ignore=true install'
                                
                        }
                }
}
