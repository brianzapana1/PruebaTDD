pipeline {
    agent any

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
                bat 'copy target\\tresenraeya-1.0-SNAPSHOT.jar C:\\apache-tomcat-9.0.XX\\webapps\\tresenraya\\WEB-INF\\lib\\'
            }
        }
    }
}
