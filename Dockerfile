FROM amazoncorretto:21
WORKDIR /app
COPY First/src/ /app/
RUN javac *.java
CMD ["java", "HelloWorld"]