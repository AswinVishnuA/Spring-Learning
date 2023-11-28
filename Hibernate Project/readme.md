# Hibernate Example Project

This Java project provides examples of Hibernate usage for Object-Relational Mapping (ORM), demonstrating various relationships like one-to-one, one-to-many, many-to-one, and many-to-many. The entities involved include User, Vehicle, UserProfile, and Brand.

## Technologies Used

- Java
- Hibernate 5.5.6.Final
- MySQL 8 (Database)

## Dependencies

The project uses Maven for dependency management. Ensure you have the following dependencies in the `pom.xml` file:

```xml
<dependencies>
    <!-- Hibernate -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.5.6.Final</version>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version>
    </dependency>
</dependencies>
```


## Configuration

### Database Configuration

1. **Database Setup:**
    - Make sure you have MySQL 8 installed and running.
    - Create a database named `hibernate_example`.

2. **Adjust Database Connection Properties:**
    - Open the `src/main/resources/hibernate.cfg.xml` file.
    - Update the following properties with your MySQL connection details:

      ```xml
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_example</property>
      <property name="hibernate.connection.username">your_mysql_username</property>
      <property name="hibernate.connection.password">your_mysql_password</property>
      ```

### Test Database Configuration

For testing purposes, a separate configuration is provided.

1. **Test Database Setup:**
    - Make sure you have MySQL 8 installed and running.
    - Create a database named `test_database`.

2. **Adjust Test Database Connection Properties:**
    - Open the `src/test/resources/hibernate-test.cfg.xml` file.
    - Update the following properties with your MySQL connection details:

      ```xml
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/test_database</property>
      <property name="hibernate.connection.username">your_mysql_username</property>
      <property name="hibernate.connection.password">your_mysql_password</property>
      ```

## How to Run

1. **Run the App Class:**
    - Open the `MainDemo` class in your IDE.
    - Run the `main` method.

## Notes

- The project uses Hibernate annotations for entity mappings.
- Be cautious when using `hibernate.hbm2ddl.auto` in a production environment, as it can result in data loss or schema modifications.
- Explore the code and adapt it to your specific use cases!