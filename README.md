# Spring Boot BMI Calculator Project

This project is a simple BMI (Body Mass Index) calculator built with Spring Boot. It provides a REST API to calculate BMI based on user input (height and weight).

## Features
- Calculate BMI via REST endpoint
- Return BMI value and category (Underweight, Normal, Overweight, Obese)

## How to Run
1. Ensure you have Java 17+ and Maven installed.
2. Build and run the project using Maven:
   ```shell
   mvn spring-boot:run
   ```
3. Access the BMI API at `http://localhost:8080/api/bmi?height=170&weight=65`

## Project Structure
- `src/main/java/.../BmiCalculatorApplication.java`: Main Spring Boot application class
- `src/main/java/.../controller/BmiController.java`: REST controller for BMI calculation
- `src/main/resources/application.properties`: Configuration file

## API Example
```
GET /api/bmi?height=170&weight=65
Response: { "bmi": 22.49, "category": "Normal" }
```

---
Replace `...` with your package name as needed.
