# File Reader

### About

This is a utility application for holding various file parsers.

##### Features

###### Parse VCF
1. Loads a text file containing Variant Call Format genome data and strips out a subset of the data.


### Run Locally

##### Run Combined Application

```
mvn clean install
```
This will build the frontend module, copy the frontend output into the backend module, and builds the backend - that now represents the entire application.

You may need to comment out the modules first time to install the parent pom, which the modules look for, and won't be there the first time.

```
mvn --projects backend spring-boot:run  

or 

java -jar filereader.jar

```
Runs the application that includes the compiled front and backend code as built by the maven install.

Changes in the backend code may be picked up courtesy of Spring Dev Tools. Changes to front end won't be picked up until you run maven install again. (Unless you are running the frontend via the npm server that is).

You can then access the application at localhost:8081.

##### Run Backend Separately

You can build/run the backend as a normal maven project; i.e mvn clean, mvn package, or run MarcApplication class as Spring boot fom IDE.

Note though that you may need to do more mvn clean and mvn packages than usual to pick up new code changes. Also be aware that the backend will have the latest frontend code packaged prior to the latest mvn clean, so if you go to 8080 you will potentially see old backend code.

##### Run Frontend Separately

```bash
cd frontend
npm run serve
```

This starts the front end, useful when you want instant feedback on frontend only changes. It will be running on port 8080 unless the backend is already running in which case the frontend automatically switches up to 8081.

##### Run both independently

I normally run the backend separately and then the frontend while I am developing as the two can still communicate even though the app hasn't been packaged into one jar.

### Tech Stack

 - Spring - Boot
 - Java 8
 - Maven
 - VueJS
 - Vuetify
 - JUnit 4
 - Lombok
 
 Lombok provides annotations to remove boiler plate code, specifically getters and setters, equals, hashCode and toString. Any of these can be manually overwritten if required. Note that Lombok requires annotation processing to be turned on in your IDE. For Intellij this can be done by:
 
 ```
 Install the lombok plugin
 Turn annotation processing on
    - Preferences -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable annotation processing
 Make this your default for new projects with
    - File -> Other Settings -> Preferences For New Projects -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable annotation processing

```

We are using the Single-File Components (.vue) approach with VueJS 2.

#### Testing

##### Manual

You can post suitably formatted input data to:
```text
http://localhost:8080/download/txt
```
Headers:
```text
Content-type    multipart/form-data
```
Body:
```text
Parameter name      Content         Type
file                filename.txt    File
```

Or you can run the application locally.
