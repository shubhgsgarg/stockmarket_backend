FROM openjdk:8-jdk-alpine
# WORKDIR /var/lib/jenkins/workspace/mavennew/companydetails
ADD target/companyDetails-0.0.1-SNAPSHOT.jar companyDetails.jar
EXPOSE 8080                   
ENTRYPOINT ["java", "-jar", "companyDetails.jar"]
