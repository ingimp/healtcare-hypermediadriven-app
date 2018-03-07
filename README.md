# healtcare-hypermediadriven-app
Example of microservice developed to way the HATEOAS constraint in healtcare app.

# Building the Docker Images
To build the code examples as a docker image, open a command-line window change to the directory where you have downloaded source code.

Run the following maven command.  This command will execute the [Spotify docker plugin](https://github.com/spotify/docker-maven-plugin) defined in the pom.xml file.  

   **mvn clean package docker:build**

If everything builds successfully you should see a message indicating that the build was successful.

# Running the Application
Now we are going to use docker-compose to start the actual image.  To start the docker image,
change to the docker-compose directory in your source code.  Issue the following docker-compose command:

   **docker-compose -f docker/common/docker-compose.yml up**

If everything starts correctly you should see a bunch of spring boot information fly by on standard out.  At this point all of the services needed for the chapter code examples will be running.

# Test the service
Now that the service is up, visit:  	**http://localhost:8080/healtcare/hypermediadriven/api/v1/**

# Swagger

For swagger ui: http://localhost:8080/swagger-ui.html

# TIP
After launching the "docker-compose -f docker/common/docker-compose.yml up" command if you have the following error:

Starting common_patientservice_1 ...
Starting common_patientservice_1 ... done
Attaching to common_patientservice_1
patientservice_1  | /bin/sh: ./run.sh: not found
common_patientservice_1 exited with code 127

then you have to change the file format of patient-service/src/main/docker/run.sh from WINDOWS to UNIX and repeat the build.
