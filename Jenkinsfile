pipeline {   
  
  agent any
  
  stages {
    stage('checkout') {
      steps {
        checkout scm
      }
    }

    stage('check terraform installation') {
      steps {
            sh 'ls -la'
            sh 'which terraform'
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

    stage('approval') {
        steps {
            script {
                def userInput = input(id: 'confirm', message: 'Apply Terraform?', parameters: [ [$class: 'BooleanParameterDefinition', defaultValue: false, description: 'Apply terraform', name: 'confirm'] ])
            }
        }
    }  

    stage('apply') {
      steps {
            sh 'terraform apply tfplan'
      }
    }
  }
}
