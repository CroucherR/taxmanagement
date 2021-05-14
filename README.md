# UWTSD- TAX MANAGEMENT REST SERVICE
                                 

----
   How to Run this project in docker (without keycloak):
----
----
   

1. First navigate into the taxmanagmentrest directory and type: mvn clean package -DskipTests
    

2. Within the same directory enter: docker compose up


3. This will boot up the docker container and start the web service.

------------------------------------------------------------------------------------------------------------------------------------------------
----
   How to Run this project with keycloak:
----
----

I have been unable to dockerise this project with the keycloak server so I have exported 3 types of my realm. Please import one of these realms and launch the keycloak server.
To run this there are a few things you need to change in the repo to 'turn on' keycloak : (NOTE: Changing this will make tests fail due to authorisation)
   

1. First navigate into the application.properties and uncomment the second hald and comment the first half.
    

2. Navigate into the TaxManagementServiceConfig file and follow the intrustions to enable keycloak.


3. Run the aplication locally and the keycloak server should connect and provide the security.

------------------------------------------------------------------------------------------------------------------------------------------------
