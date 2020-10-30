FROM centos
RUN mkdir /opt/tomcat/
WORKDIR /opt/tomcat

RUN curl -O https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz
RUN tar xvfz apache*.tar.gz
RUN yum -y install java
RUN java -version

WORKDIR /opt/tomcat/apache-tomcat-9.0.35/webapps
COPY ./target/sap.war /opt/tomcat/apache-tomcat-9.0.35/webapps/

ENV CATALINA_HOME=/opt/tomcat/apache-tomcat-9.0.35
ENV CATALINA_OPTS="-Xms2048M -Xmx4096M"
ENV JAVA_OPTS="-Xms2048M -Xmx4096M"

ENV apiFootball.url=https://apiv2.apifootball.com/
ENV apiFootball.getApiKey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978

EXPOSE 8080

ENTRYPOINT ["/opt/tomcat/apache-tomcat-9.0.35/bin/catalina.sh", "run"]