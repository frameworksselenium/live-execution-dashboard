FROM openjdk:8
ADD target/live-execution-dashboard.jar live-execution-dashboard.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","live-execution-dashboard.jar"]