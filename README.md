1-To start this project just simply run docker-compose up under src/main/docker
(I assume you have docker running in your machine)

2-To access the api go to localhost:8080 to access Swagger-OpenAPI GUI
        You can switch between groups in your up right corner (Patient<->Doctor)
3- For the security I chose something simple, and the credentials you should use to use the endpoints are 
        User: cloudmobility
        password: awesome

Things to take into account when analysing code:

1- I did not go very deep in terms of Validation, Unit Testing(only made Integrated Testing),
data model (only built the basic, so that I could have some persistence layer)
2-I'm aware that performance wise, as well data mode structure this could be very much improved
3- I did log the application at method level, but nothing very specific
4- I don't have any Exception Managing system created
5-Unavailable period is somewhat rudimentary, only stores one period at time, 
but i think it serves the purpose of the exercise
6-I know my tests are not "time proof" meaning day only last as they are until the end of april

