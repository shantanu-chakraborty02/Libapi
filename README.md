# Libapi
 Data Uploading API

Project Discussion:

The project aims to develop a RESTful API using Spring Boot to upload data from an Excel sheet to a MySQL database and retrieve the data using a GET API. The project consists of several files and follows specific specifications.

1. `libapiapplication`: This is the main file of the Spring Boot application.
2. `EmployeeController`: This controller file contains the necessary annotations for handling HTTP requests. It includes the `@RestController` annotation for creating RESTful APIs, `@CrossOrigin("*")` for enabling cross-origin resource sharing, `@Autowired` for dependency injection, and `@PostMapping("/Employee/upload")` and `@GetMapping("/Employee")` annotations for defining the POST and GET APIs, respectively.
3. `Employee` Entity: This file represents the Employee entity and includes the necessary annotations such as `@Entity` and `@Id`. It also contains getter and setter methods for accessing the entity attributes.
4. `Helper` file: This file provides a helper method `checkExcelFormat` for validating the format of the uploaded Excel file. It checks the content type of the file and returns `true` if it's in the expected format (`application/vnd.openxmlformats-officedocument.spreadsheetml.sheet`).
5. `EmployeeRepo`: This repository interface extends `JpaRepository` and provides methods for database operations related to the `Employee` entity.
6. `EmployeeService`: This service class handles the business logic for saving the data from the Excel sheet to the database and retrieving all employees. It is annotated with `@Service` for dependency injection. The `save` method takes a `MultipartFile` as input, converts the Excel data to a list of `Employee` objects using the `convertExcelToListOfEmployee` method from the `Helper` class, and saves the list to the database using the `EmployeeRepo`. The `getAllEmployees` method retrieves all employees from the database using the `EmployeeRepo`.

The project follows the specified requirements of using Spring Boot, MySQL Workbench as the database, and the creation of POST and GET APIs. The uploaded data is not required to be manually entered but is instead provided via the POST API. The implementation ensures that the uploaded Excel file is in the correct format before processing it.

Overall, the project provides a structured and scalable solution for uploading data from an Excel sheet to a MySQL database and retrieving it using RESTful APIs.
