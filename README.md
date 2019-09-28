### About the project
The main goal of this project is to help us learn the theoretical curriculum for Codecool.

In this project, we could practice what we learned about **Java Enterprise**:
- Spring and Spring Boot
- JPA with Hibernate
- Spring Security

We also used **Lombok** annotations to avoid boilerplate code.

[Link to front-end](https://github.com/Crepkey/workbook_front_end)


### Install & config
With importing this project to IntelliJ as a **Maven project**, IntelliJ can auto-install the dependencies based on the pom.xml

We use PostgreSQL to store data. We need to **create a new database** called 'workbook' under the role of 'postgres'. After that, we need to add the necessary data into the application.properties file (for that file, there is a skeleton in the following folder: src/main/resources, we have to copy that and call it application.properties):
- spring.datasource.url=jdbc:postgresql://localhost:5432/workbook  --> we have to check, if the url is correct
- spring.datasource.username=postgres  --> we don't have to change that if we created our database under the 'postgres' role
- **spring.datasource.password**  --> we have to add our password

We have to set our **run configurations**, the Main class will be: com.codecool.workbook.WorkbookApplication.

After the first running of the application, the DataInitializer will automatically create the database tables and fill it up with some data.

### Available features
Registration in only available on backend, so to log in please use one of these accounts:

```User / password``` or ```Admin / password```

The above mentioned accounts have **different roles**:
- User can only access **'Learning mode'**, where random questions make him/her practice the theoretical material, he/she can even mark them as known, so that they won't come up anymore.
- Admin can also access **'Question management'**, where he/she can add new questions and edit the existing ones.

**Other features we planned:**

Just to mention some: Quiz mode, Filtering and search, Answer rating, Summarizing page