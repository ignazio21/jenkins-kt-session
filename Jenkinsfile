pipeline {   
  stages {
    stage('checkout') {
      steps {
        checkout scm
      }
    }

    stage('init') {
      steps {
          container('terraform') {
            sh 'terraform init'
          }
      }
    }

    stage('plan') {
      steps {
          container('terraform') {
            sh 'terraform plan -out=tfplan'
          }
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
          container('terraform') {
            sh 'terraform apply tfplan'
          }
      }
    }
  }
}
