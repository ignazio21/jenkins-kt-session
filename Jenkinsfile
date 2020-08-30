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
            sh 'set TERRAFORM_VERSION=0.12.7'
            sh 'apk --update --no-cache add libc6-compat git openssh-client python py-pip python3 && pip install awscli'
            sh 'cd /usr/local/bin && \
                curl https://releases.hashicorp.com/terraform/${TERRAFORM_VERSION}/terraform_${TERRAFORM_VERSION}_linux_amd64.zip -o terraform_${TERRAFORM_VERSION}_linux_amd64.zip && \
                unzip terraform_${TERRAFORM_VERSION}_linux_amd64.zip && \
                rm terraform_${TERRAFORM_VERSION}_linux_amd64.zip'
            sh 'terraform -version'
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
