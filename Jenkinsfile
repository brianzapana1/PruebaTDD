pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Verificar Código') {
            steps {
                echo 'Código clonado correctamente por Jenkins SCM'
            }
        }


        stage('Compilar') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy a Tomcat') {
        steps {
            bat 'copy target\\tresenraeya-1.0-SNAPSHOT.war C:\\apache-tomcat-11.0.7\\webapps\\tresenraya.war'
        }
        }

    }
}
