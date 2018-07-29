# DojoMadnessTest
This is sample solution application which is responsible for fetching data by consuming REST API. The fetched data is stored in the database and served back as REST API.

## Technolgies

* I have implemented this solution using Spring Boot framework using Spring Web, Spring REST, Spring JPA and Spring Test libraries. It is a gradle based project, which 
can be directly importated into Eclipse IDE.

* This project uses integrated database(H2DB) that comes with Spring. The package com.kpaudel consists of startup program called Appication.java.

* After all libraries are downloaded, we can run this application by using the startup program "Applicaiton.java"

* After applications runs successfully, the application has the following endpoints:

http://localhost:8080/api/heros

http://localhost:8080/api/heros/{hero_id}

http://localhost:8080/api/abilities

http://localhost:8080/api/abilities/{ability_id}

http://localhost:8080/api/heros/{hero_id}/abilities
