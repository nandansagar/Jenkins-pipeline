@Library('my-shared-library') _  // Load the shared library

pipeline {
    agent any  // This specifies that the pipeline can run on any available agent
    
    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
    }
    
    post {
        success {
            echo 'Build was successful!'
            Success()  // Calls Success() from the shared library
        }
        
        failure {
            echo 'Build failed!'
            Failure()  // Calls Failure() from the shared library
        }
        
        always {
            echo 'This will always run, regardless of success or failure.'
            cleanWs()
        }
    }
}
