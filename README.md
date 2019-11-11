v application.properties nastavit db:

atomikos.spartial.url=TODO
atomikos.spartial.user=TODO
atomikos.spartial.password=TODO


v repository mat oracle driver:

        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>12.2.0.1</version>
        </dependency>

kompilace a pusteni

mvn clean install spring-boot:run

vytvoreni db:

CREATE TABLE cola_markets (
  mkt_id NUMBER PRIMARY KEY,
  name VARCHAR2(32),
  shape SDO_GEOMETRY);
  
  create sequence SEQ_cola_markets start with 10;   

vlozeni/seznam zaznamu v db

http GET http://localhost:8080/spartial/vloz
http GET http://localhost:8080/spartial/list
 