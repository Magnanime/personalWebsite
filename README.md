# PersonalWebsite

PersonalWebsite is the back-end part of a blog-ish web application (you can find the front-end part [here](https://github.com/Magnanime/personalWebsiteFrontend)). The main goal of the back-end is to expose an API which can be used to read articles, post them (for logged in users), log in (for registered users), and request the rights to contribute to the blog.  

## Installation

Before installing the application make sure you use JDK 11 and Maven installed. You will also need to create a database (PostgreSQL is preferable, but so long you are able to configure it right, anything goes) and set the "spring.jpa.hibernate.ddl-auto" variable to "create" on the first run. The project comes with a embedded Tomcat server, so no further software is needed to access the API. After you make sure you meet the prerequisites execute the following statement in the directory root directory of the project:

```bash
mvn clean install
```
This will create an .jar file which you can execute with:

```bash
java -jar /target/JAR_NAME.jar
```

## Usage

Currently we have the following API endpoints:

- /api/auth/signup - for signing up new users (functionality has to be changed in the near future),
- /api/auth/login - for login,
- /api/posts/ - /all - returns all articles,
- /api/posts/ - /get/{id} - returns article with given id