

### PROFILES
How to run with different profiles

Development (default)
mvn spring-boot:run

Test
mvn spring-boot:run -Dspring.profiles.active=test

Production
mvn spring-boot:run -Dspring.profiles.active=prod
