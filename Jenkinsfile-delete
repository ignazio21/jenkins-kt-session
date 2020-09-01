pipeline {   
  
  agent any
  
  stages {
    stage('checkout') {
      steps {
        checkout scm
      }
    }
    
    stage('init') {
      steps {
            sh 'terraform init'
      }
    }

    stage('plan') {
      steps {
            sh 'terraform plan -destroy'
      }
    }

    stage('destroy') {
      steps {
            sh 'terraform destroy -force'
      }
    }
  }
}
