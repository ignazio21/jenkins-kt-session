node {

    stage("checkout") {
        checkout scm
    }

    stage("init") {
        sh 'terraform init'
    }

    stage("plan") {
        sh 'terraform plan -out=tfplan'
    }

    stage("apply") {
        sh 'terraform apply tfplan'
    }

}
