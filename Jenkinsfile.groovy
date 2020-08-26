pipeline {  
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
        sh 'terraform plan -out=tfplan'
      }
    }
 
    stage('apply') {
      steps {
        sh 'terraform apply tfplan'
      }
    }
  }
}
