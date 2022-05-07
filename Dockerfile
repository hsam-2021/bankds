FROM maven:3.6.0-jdk-8
VOLUME /tmp
EXPOSE 8080
ADD target/bankds.jar bankds.jar
ENTRYPOINT ["java","-jar","bankds.jar",""]