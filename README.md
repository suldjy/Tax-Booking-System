# Tax-Booking-System
It's the application that manage the booking of tax

REQUIREMENT
-------------
1)IDE: Eclipse or STS(Spring Tool Suite)
2)DBMS : MySQL
3) Create database called taxbooking_db
4)Client Testing Tool for API (e.g: Postman)

CONFIGURATION
--------------
1) Change database configuration in application.properties file located in src>main>resources

- In case your MySQL is not running on default port (3306), you have to change the port in url
- change username and password to your MySQL username and password


RUN THE APPLICATION
----------------------
Once you've opened the application in the IDEA, right click on the project> Run As> Java Application.


Note: 
1) Make sure nothing is running on port 9999 on your computer, if so please do change the project port number in application.properties file to your desired port.
2)Initialise data into the DB in case you want to use the application with loaded data. Run the application and go to this url (http://localhost:9999/initialize) to initialise.

3) When you use postman or any client tool, make sure you provide token in the header for each request. 
The token key is : tbs_token, and token value is: TBS-today's date. e.g.:TBS10-10-2018

You are done.

Enjoy using the application.







