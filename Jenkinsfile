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
            sh 'service docker start'
            sh 'docker run hashicorp/terraform:light plan nginx.tf'
      }
    }
    
    stage('init') {
      steps {
            sh 'docker run hashicorp/terraform:light init'
      }
    }

    stage('plan') {
      steps {
            sh 'docker run hashicorp/terraform:light plan nginx.tf'
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
