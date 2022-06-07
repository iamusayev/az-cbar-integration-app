Task introduction
-


Create a web service for collecting and searching for official exchange rates of the Azerbaijani manat in relation to foreign currencies.

----


Detailed description
-




The Central Bank of the Republic of Azerbaijan publicly publishes the official exchange rates
of foreign currencies and banking metals against the Azerbaijani manat on a selected date.
This information is available at the following link:
https://www.cbar.az/currencies/25.05.2022.xml



---

**Requirements**

- Collection of information on official exchange rates
   - Maintaining the exchange rates for the selected date in the database downloaded
   from the exchange bulletin of the Central Bank of the Republic of Azerbaijan;
   - If the rates for the selected date already exist in the database, then no change occurs
   and the appropriate response is returned.
    - Deleting saved rates for the selected date;

 
 - Obtaining information on AZN rates
     - Obtaining the exchange rate of the Azerbaijani manat on the selected date and
   against the selected currency;
    - Acquisition of the exchange rate of the Azerbaijani manat against all foreign
    currencies on the selected date;
    - Obtaining the exchange rate of the Azerbaijani manat against the selected foreign
    currency on all dates.

-----

                                                    Database diagram

[![newdb.png](https://i.postimg.cc/ncDGNkNz/newdb.png)](https://postimg.cc/ppPjFDWb)


----

- users table

[![users-table.png](https://i.postimg.cc/8cnqbh7v/users-table.png)](https://postimg.cc/BPHYSPcZ)

----- 

- roles table 

[![admin-table.png](https://i.postimg.cc/h4wyp4CV/admin-table.png)](https://postimg.cc/jCH4jTYj)

-----
- users_roles table

![link](https://i.postimg.cc/MGvtyhy9/users-roles-2.png)

-----

To call HTTP methods POST and DELETE you need to authorize. For obtaining authorization information you need to call URL
- 

- POST 
        
      localhost:8088/v1/auth/login?username=admin&password=admin1234
   
example:

[![acess-and-refresh.png](https://i.postimg.cc/wvsVrZT0/acess-and-refresh.png)](https://postimg.cc/zb8Kbdhg)

After the URL is called "access" and "refresh" tokens will be generated.
You need to send the "access" token in the request's header by calling POST and DELETE methods of HTTP.




 "access" token expires in 10 minutes. To refresh it you need to navigate to 

 - GET
    
       localhost:8088/v1/auth/token/refresh

and in the request's header send "refresh token".

example:

[![Inkedrefresh-ttt-LI.jpg](https://i.postimg.cc/154p7bC6/Inkedrefresh-ttt-LI.jpg)](https://postimg.cc/hfWzfZqP)

**Save information to database** 

Local date parameter example: (year-month-day)

  - POST
  
        localhost:8088/v1/rates?date=2022-06-03

example:

[![postik.png](https://i.postimg.cc/g2XKSrc3/postik.png)](https://postimg.cc/jDTNCx7j)

**Delete information**
  - DELETE
  
        localhost:8088/v1/rates?date=2022-06-03

example: 

[![delete-2nd.png](https://i.postimg.cc/m23X3PDk/delete-2nd.png)](https://postimg.cc/ZCRx4K6z)

-----

No authorization needed for the following methods
- 

 **Get by date and currency**

  - GET
  
        localhost:8088/v1/rates?date=2022-06-03&currency=USD&count=10&page=0


**Get by date**
          
  - GET
  
        localhost:8088/v1/rates?date=2022-06-03&count=10&page=0


**Get by currency**
     
- GET

      localhost:8088/v1/rates?currency=USD&count=10&page=0


example:


![link](https://i.postimg.cc/25QfhcnL/example-get-methods.png)


Docker compose file is attached. You can easily run the application on your device.
- 
