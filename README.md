## Integration architecture: Managing Performance Records

### Brief Introduction
Managing Performance Records is a software which can be used to manage the CRUD Operation related to a Salesman and his performance records as an academical project in the university Bonn-Rhein-Sieg of applied science.

### Requirements
- MongoDB: running with default setting (if not possible the values of the following attributes can be overridden in the file application.yml)
    - Host: 127.0.0.1
    - Port: 27017
- Java JDK version 17

### Running the application
In order to run the application, you need to execute the following commands:
- `./gradlew build`
- `cd .\build\libs\`
- `java -jar .\HighPerformance-0.0.1-SNAPSHOT.jar`

At The end a shell command line should be started. If this happened, it means you did right and everything works fine :)

### Using the shell command line for accessing the tool

If you started the shell command, you can:
- get general information about the tool by executing the command
  - `help`
- get more information about a specific command, like get command
  - `help get`
- execute a command like init
  - `init` 
- execute commands by creating a file containing a set of commands:
  - `script <file-name>`

  ### Swagger API
- To access the swagger-ui you simply type the following URL int your browser:
  - `http://localhost:8080/swagger-ui.html`
- From there you can try out all available HTTP methods

