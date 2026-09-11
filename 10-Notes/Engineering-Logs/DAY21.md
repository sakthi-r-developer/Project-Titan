# Day 21 — Maven & JUnit 5 Testing

## Today's Goal

Introduce Maven and JUnit 5 into the Student Management System and start automated testing.

## What I Did

- Converted the project to a Maven project
- Created and configured `pom.xml`
- Added JUnit 5 dependency
- Set Java source and target to Java 25
- Followed the standard Maven project structure
- Created `src/main/java`
- Created `src/main/resources`
- Created `src/test/java`
- Created `StudentServiceTest`
- Created `InMemoryStudentRepositoryTest`
- Tested service and repository behavior
- Learned Arrange–Act–Assert
- Learned common JUnit assertions
- Tested exceptions using `assertThrows()`
- Used `@BeforeEach` for test setup
- Ran the complete test suite using Maven

## Maven

The project now uses Maven for dependency management and build automation.

### Maven Coordinates

- Group ID: `com.sms`
- Artifact ID: `sms`
- Version: `1.0-SNAPSHOT`

### Java Version

- Source: Java 25
- Target: Java 25

### JUnit Dependency

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.13.4</version>
    <scope>test</scope>
</dependency>