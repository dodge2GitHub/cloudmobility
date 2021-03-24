Hi,
Link to github Repository -> https://github.com/dodge2GitHub/cloudmobility

1-To start this project access cmd line on \cloud-mobility-private-hospital:
        -mvn clean install to run tests and generate latest jar
        -from cmd line access \cloud-mobility-private-hospital\src\main\docker
        -run docker-compose up
        -go to http://localhost:8080 to access swagger-openapi-gui
                You can switch between groups in your up right corner (Patient<->Doctor)
        - you can access database (postgresql) on localhost:5432

Tips for using the api->
I populated the database with 2 doctors "Dr. Jeniffer" and "Dr. Paul" 
both working from 09:00 to 19:00. For patients i have "Carol" and "John".
DateTime, date or time are in ISO forma ex:2021-03-26 14:00:00

2- For the security I chose something simple, and the credentials you should use to use the endpoints are 
        User: cloudmobility
        password: awesome

Things to take into account when analysing code:

1- I did not go very deep in terms of validation logic, unit testing(only made Integrated Testing),
data model (only built the basic, so that I could have some persistence layer)
2-I'm aware that performance wise, as well data mode structure this could be very much improved
3- I did log the application at method level, but nothing very specific
4- I don't have any Exception Managing system created
5-Unavailable period is somewhat rudimentary, only stores one period at time, 
but i think it serves the purpose of the exercise
6-I know my tests are not "time proof" meaning they only last not failing, until the end of april
7-There could potentially be some bugs in the app undiscovered
