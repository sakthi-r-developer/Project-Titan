package service;

import exceptions.DuplicateStudentException;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import searching.LinearSearchStrategy;
import sorting.BuiltInSortStrategy;
import sorting.SortingStrategy;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryStudentRepository();
        service = new StudentService(repository);
    }
    @Test
    void addStudent_validStudent_studentAdded()
            throws InvalidStudentException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");

        // Act
        service.addStudent(student);

        // Assert
        assertTrue(service.studentExists(1));
    }
    @Test
    void addStudent_duplicateId_throwsException()
            throws InvalidStudentException {

        // Arrange
        Student firstStudent =
                new Student(1, "Shakti", 19, "IT");

        Student duplicateStudent =
                new Student(1, "Arun", 20, "CSE");

        service.addStudent(firstStudent);

        // Act + Assert
        assertThrows(
                DuplicateStudentException.class,
                () -> service.addStudent(duplicateStudent)
        );
    }
    @Test
    void addStudent_invalidAge_throwsException() {

        // Arrange
        Student student =
                new Student(2, "Arun", 15, "CSE");

        // Act + Assert
        assertThrows(
                InvalidStudentException.class,
                () -> service.addStudent(student)
        );
    }
    @Test
    void deleteStudent_validStudent_studentDeleted() throws InvalidStudentException, StudentNotFoundException {
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);
        service.deleteStudent(student.getId());
        assertFalse(service.studentExists(1));
    }
    @Test
    void deleteStudent_invalidId_throwsException() {
        Student student = new Student(1, "Arun", 19, "IT");
        assertThrows(
                StudentNotFoundException.class,
                () -> service.deleteStudent(student.getId()));
    }
    @Test
    void searchStudent_validId_studentFound()
            throws InvalidStudentException, StudentNotFoundException {

        //Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        //Act
        Student foundStudent = service.searchStudent(new LinearSearchStrategy() , student.getId());

        //Assert
        assertEquals(student, foundStudent);
    }
    @Test
    void searchStudent_nonExistingId_throwsException()
            throws InvalidStudentException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act + Assert
        assertThrows(
                StudentNotFoundException.class,
                () -> service.searchStudent(
                        new LinearSearchStrategy(),
                        999
                )
        );
    }
    @Test
    void studentExists_validId_studentFound()
            throws InvalidStudentException {
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);
        assertTrue(service.studentExists(1));
    }
    @Test
    void studentExists_nonExistingId_returnsFalse()
            throws InvalidStudentException {
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);
        assertFalse(service.studentExists(10));
    }
    @Test
    void isStudentsEmpty_beforeAdd() {

        assertTrue(service.isStudentsEmpty());
    }
    @Test
    void isStudentsEmpty_afterAdd()
            throws InvalidStudentException {
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);
        assertFalse(service.isStudentsEmpty());
    }
    @Test
    void updateStudent_validId_nameUpdated()
            throws InvalidStudentException, StudentNotFoundException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act
        boolean result = service.updateStudent(1, 1, "Arun");

        // Assert
        assertTrue(result);
        assertEquals("Arun", student.getName());
    }
    @Test
    void updateStudent_validId_validAgeUpdated()
            throws InvalidStudentException, StudentNotFoundException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act
        boolean result = service.updateStudent(1, 2, "25");

        // Assert
        assertTrue(result);
        assertEquals(25, student.getAge());
    }
    @Test
    void updateStudent_validId_departmentUpdated()
            throws InvalidStudentException, StudentNotFoundException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act
        boolean result = service.updateStudent(1, 3, "CSE");

        // Assert
        assertTrue(result);
        assertEquals("CSE", student.getDepartment());
    }
    @Test
    void updateStudent_invalidAge_returnsFalse()
            throws InvalidStudentException, StudentNotFoundException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act
        boolean result = service.updateStudent(1, 2, "15");

        // Assert
        assertFalse(result);
        assertEquals(19, student.getAge());
    }
    @Test
    void updateStudent_nonExistingId_throwsException() {

        assertThrows(
                StudentNotFoundException.class,
                () -> service.updateStudent(999, 1, "Arun")
        );
    }
    @Test
    void updateStudent_invalidChoice_returnsFalse()
            throws InvalidStudentException, StudentNotFoundException {

        // Arrange
        Student student = new Student(1, "Shakti", 19, "IT");
        service.addStudent(student);

        // Act
        boolean result = service.updateStudent(1, 99, "Something");

        // Assert
        assertFalse(result);
    }
    @Test
    void sortStudents_sortsById()
            throws InvalidStudentException {

        // Arrange
        service.addStudent(new Student(3, "Vijay", 19, "ECE"));
        service.addStudent(new Student(1, "Shakti", 19, "IT"));
        service.addStudent(new Student(2, "Arun", 20, "CSE"));

        // Act
        service.sortStudents(new BuiltInSortStrategy());

        // Assert
        assertEquals(1, repository.getStudents().get(0).getId());
        assertEquals(2, repository.getStudents().get(1).getId());
        assertEquals(3, repository.getStudents().get(2).getId());
    }
    @Test
    void addDummyStudents_emptyRepository_addsTenStudents()
            throws InvalidStudentException {

        // Act
//        service.addDummyStudents();

        // Assert
        assertTrue(service.addDummyStudents());
    }
    @Test
    void addDummyStudents_studentsAlreadyExist_doesNotAddDuplicates()
            throws InvalidStudentException {

        // Arrange
        service.addStudent(
                new Student(1, "Shakti", 19, "IT")
        );

        // Act
//        service.addDummyStudents();

        // Assert
        assertFalse(service.addDummyStudents());
    }
}
