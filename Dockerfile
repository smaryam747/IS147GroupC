FROM openjdk:23
WORKDIR /app
COPY First/src/ /app/
RUN javac *.java
CMD ["java", "Main"]
