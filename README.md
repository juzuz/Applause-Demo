# Applause-Demo
A major feature of the Applause platform is our tester-matching algorithm. We are able to drill-down from a community of over 300k Testers each with multiple Devices, to a sub-set of Testers that best meet a Customer’s needs. As you can imagine, this is a complicated process that takes multiple dimensions into account.
Your goal is to write a simpler matching system, this can even be a class, a module, a service, etc., whatever you think is needed for this exercise, that takes two matching Criteria (Country and Device) and presents a sorted list of results (more on this below).

# Setup
For this project, I used Spring Boot, JPA, Hibernate, and MySQL as the backend server. And I used react JS for the front-end.

1. Create a schema and name it "applause" or [Your Name of choice]


To run this code, you will need an IDE that has a spring boot workspace. For example, IntelliJ or VS Code with the spring boot dashboard extension.

We will first need a schema for the database.
In my case, the schema is named "applause".
This can be changed in the application.properties file at "backend\src\main\resources\"

![appProps](./assets/appProps.PNG)

2. Change the port number and schema name in the spring.datasource.url to match your configuration

Change the URL to whichever port your MySQL server is running on and the "applause" in the URL to whatever name you have chosen.

3. Change the user and password to allow access


Change the username and password and the database will be all set!

Find the "database.sql" file in the folder "/backend/database.sql"
and run the code in your MySQL CLI or Workbench

4. Run the database.sql code in the backend folder in your mysql CLI or Workbench


Run the backend server with your IDE and now let's start the front-end server!

You will need to enter the "frontend/applause_demo" folder and run 
    
5. Run the following commands in the frontend/applause-demo folder

    yarn install
    
    yarn start

to begin the front-end server.


# Results
Once everything is running, you will be welcomed with the front page.

![home](/assets/home.PNG)

There are two options in the navbar. For any meaningful results, we must first upload the required files.

Once everything is uploaded, we can begin our search.

![search](/assets/search.PNG)

Click on the filter type dropdown button and choose between filtering a country or a device.

Once selected, a new dropdown will appear and you will need to specify the country or device to add to our filter.

Once both are selected, click on the + button to add the filter.

Keep adding filters according to your needs.

Once you have set up your list of filters, click on the search button to get the list of testers that fit the criteria.

If you leave the country or device empty, it will be counted as ALL countries or ALL devices.

![list](./assets/list.PNG)

Here is our result for all countries and all devices.

