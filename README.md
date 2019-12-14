

### PROFILES
How to run with different profiles

Development (default)
mvn spring-boot:run

Test
mvn spring-boot:run -Dspring.profiles.active=test

Production
mvn spring-boot:run -Dspring.profiles.active=production

### PUSH TO HEROKU
mvn clean
git add .
git commit -m"pushing to heroku"
git push heroku master


