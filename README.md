# urlshortener
This is the question that pops up in my mind when seeing the challenge:
1- What is the length of the URL which is shortened?
2- IS the system a single instance or should be scaled it?
3-Which Db is needed? NoSQL DB or relational DB
4-What hash code is fit for this problem?
I have assumptions for solving the challenge:
for the answer first question, I use the long as the user can get it,
for the answer number 2, I think is the single instance because it's a code challenge problem for hiring me,
for choosing DB type, we need to think that how much data is persisted it.

-----------------------------------------------------------------------
Tech Test
-----------------------------------------------------------------------


## Deliverables:
# Setup
## App Requirements
- JVM running on your local machine
- Maven
- An IDE of your choice

### Running the app
To run the app you can use the following maven commands
./mvnw spring-boot:run

##api
Please create an application that exposes at least two http endpoints to manage a Url entity (Object Schema and examples provided below).

POST 
http://localhost:8080/generate
{
"url": "https://www.baeldung.com/kotlin/concatenate-strings"
}

GET
http://localhost:8080/{shortulr}