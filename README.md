# Log-Http-Requests-and-Responses

A spring boot application which logs all http requests and responses into mongoDB collection.

*   You can customize the logging for your requirements,

     Example : Log only /users path
     
*   This can done by adding path patterns in the following file

     /src/main/java/com/jothibasu/learning/configurations/Config.java
     
*   Change your database configuration in the following file

     /src/main/resources/application.yml
