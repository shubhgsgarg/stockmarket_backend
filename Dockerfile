FROM openjdk:8                   
EXPOSE 8080                   
ENTRYPOINT ["/bin/sh","/app/app.sh"]
