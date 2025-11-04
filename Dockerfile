FROM amazoncorretto:latest
WORKDIR /app
COPY src/ /app/
RUN javac *.java
CMD ["java", "Main"]
