pipeline {
        agent any
        tools {
            maven 'Maven 3.6.3'
        }        

                stages {
                        stage('Checkout') {
                                steps {
                                        git credentialsId: 'github', url: 'https://github.com/gbham/bhamTAF-Java'
                                }
                        }
                        stage('Maven Build') {

                        }
                }
}
