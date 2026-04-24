
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run TestNG Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
``
