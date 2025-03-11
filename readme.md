create local jenkins docker and aon every push start a new job

docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v ~/jenkins_home:/var/jenkins_home --user root jenkins/jenkins:lts

docker run -d --name jenkins --user root -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins:lts

Di 11.03.
dockerrize
kubenetize
