alchemytec Demo App
==========================
The alchemytec Demo App provides a way of demoing the AngularJs client with Spring4 REST server. Angular web based user interface and REST API to allow interact request/response operations.

Installation
------------
The app server can be started using the following commands:
1. Run the create-db.sql Db script which located in sql folder
2. Build the project 
	mvn clean install 
3. Run the project
	mvn2 tomcat:run or mvn -Dmaven.tomcat.port=8084 tomcat:run
4. To access the demo app webapp, point a browser to the following url:
	localhost:8084/alchemytec/#/expenses
