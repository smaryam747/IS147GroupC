# PLAYPAL 

MEMBER: Elijah,           ROLE: Project Manager\
MEMBER: Biruk,            ROLE: Tester\
MEMBER: Sunila,           ROLE: Business analyst\
MEMBER: Thomas,           ROLE: Tester\
MEMBER: Khalil,           ROLE: Coder\
MEMBER: Amari,            ROLE: Coder

Project Description: 
Our web based project will solve the common problem of interaction fatigue, decision-making stalls during casual games like Truth or Dare, Would You Rather, Trivia, and similar party or conversation-style games, and just straight up boredom. People often run out of creative ideas, struggle to keep the game flowing, or simply lack someone to play with. Our bot addresses these issues by not only acting as a game host that provides prompts and questions, but also can be an active participant that plays alongside users or suggests interesting moves and ideas. This helps maintain engagement, reduce awkwardness, and ensure that anyone can have a good gaming experience.

# Password Validator:

step 1: Use scanner to take the password input from the user

step 2: Password MUST be 8 characters long, MUST contain at least one digi(0-9), and MUST contain one special charcter(!@#$%^&*()_+-=[]{};:'"\|,.<>?/)

step 3: Password will have the following output\
  a.) Strong Password\
  b.) Password is weak and does not meet required conditions(No special character)\
  c.) Password is weak and does not meet required conditions (Too short)

# Docker and Java: 

step 1: Install Docker 

step 2: Write a simple Java program\
  a.) Create a file names Helloworld.java\
  b.) Have the following content:
  
  public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Docker and Java!");
    }
}

step 3: Build project\
  a.) Click on build -> build project to create folder on project directory-> will generate main.class file\

step 4: Create a Dockerfile\
  a.) create a file names "Dockerfile" in the same directory as your java program with the following content:\
       # Use the OpenJDK 23 image as the base image\
                FROM openjdk:23
                
                # Create a new app directory for my application files
                RUN mkdir /app
                
                # Copy the app files from host machine to image filesystem
                COPY out/production/HelloWorldDocker/ /app
                
                # Set the directory for executing future commands
                WORKDIR /app
                
                # Run the Main class
                CMD java Main

Step 5: Build the docker image\
  a.) Open a terminal or command promt and navigate to the prompt containing the Dockerfile and Helloworld.class\ 
  b.) Build the docker image\
              docker build -t hello-java .\
            
      -t hello-java: Tags the image with the name hello-java.
      -.: Specifies the current directory as the build context.

Step 6: Run the docker containor\
  a.) Once built run it as a containor\
       docker run hello-java\
     output:\
       Hello, Docker and Java!

Step 7: Automate Compilation in Docker\

Step 8: Key concepts\
    a.) Dockerfile: A script that defines how to build a Docker image.\
    b.) Base Image: The starting point for building a Docker image (e.g., openjdk:11-jre-slim).\
    c.) Layers: Each instruction in the Dockerfile creates a new layer in the image.\
    d.) Multi-Stage Builds: Used to reduce the size of the final image by separating the build environment from the runtime environment.\
    e.) Docker Commands:\
              docker build: Builds an image from a Dockerfile.\
              docker run: Runs a container from an image.\
              docker images: Lists all images on the system.\
              docker ps: Lists running containers.\
              
Step 9: Pratice Exercise\
   a.) Modify the HelloWorld.java program to print your name.\
   b.) Update the Dockerfile to use a different base image (e.g., openjdk:17-jre-slim).\
   c.) Build and run the updated Docker image
   
Step 10: Additional resources\
   a.)Docker Documentation: https://docs.docker.com/ \
   b.)Java Documentation: https://docs.oracle.com/en/java/ \
   c.)Docker Hub: https://hub.docker.com/ (to find base images) \
   d.)Tutorial: https://www.youtube.com/ 

Step 11: If you see the following error\
--> Error: LinkageError occurred while loading main class Main java.lang.UnsupportedClassVersionError: Main has been compiled by a more recent version of the Java Runtime (class file version 67.0); this version of the Java Runtime only recognizes class file versions up to 65.0.\

   a.)Check your SDK version: Click on the hamburger icon => go to File => Project Structure => SDK to check which version of JDK is currently used by your project.\
   b.)Update your Dockerfile: If the SDK version is 22 or 23, update the `FROM` statement in your Dockerfile to match the version (e.g., `FROM openjdk:22` or `FROM openjdk:23`). Ensure the SDK version matches the Dockerfile.\
   c.)Delete the old "out" folder: Remove the "out" folder from your project and rebuild it.\
   d.)Repeat the step from step 3: Repeat the step from step 3.




