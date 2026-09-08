package repository;

import exceptions.StudentNotFoundException;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class InMemoryStudentRepositoryTest {

    private InMemoryStudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryStudentRepository();
    }
    ArrayList<Student> students = new ArrayList<>();
    @Test
    void addStudent_validStudent_studentAdded() throws Exception {
        Student student = new Student(1, "Shakti", 19, "IT");

        repository.addStudent(student);

        assertEquals(1, repository.size());
        assertTrue(repository.studentExists(1));
    }
    @Test
    void searchStudent_existingId_returnsStudent() throws Exception {
        Student student = new Student(1, "Shakti", 19, "IT");
        repository.addStudent(student);

        Student result = repository.searchStudent(1);

        assertEquals(student, result);
    }
    @Test
    void searchStudent_nonExistingId_throwsException() throws Exception {
        assertThrows(
                StudentNotFoundException.class,
                () -> repository.searchStudent(999)
        );
    }
    @Test
    void deleteStudent_existingId_studentDeleted() throws Exception {
        Student student = new Student(1, "Shakti", 19, "IT");
        repository.addStudent(student);

        repository.deleteStudent(1);

        assertEquals(0, repository.size());
        assertFalse(repository.studentExists(1));
    }
    @Test
    void deleteStudent_nonExistingId_throwsException() {
        assertThrows(
                StudentNotFoundException.class,
                () -> repository.deleteStudent(999)
        );
    }
    @Test
    void studentExists_existingId_returnsTrue() throws Exception {
        repository.addStudent(
                new Student(1, "Shakti", 19, "IT")
        );

        assertTrue(repository.studentExists(1));
    }
    @Test
    void studentExists_nonExistingId_returnsFalse() {
        assertFalse(repository.studentExists(999));
    }
    @Test
    void isStudentsEmpty_newRepository_returnsTrue() {
        assertTrue(repository.isStudentsEmpty());
    }
    @Test
    void isStudentsEmpty_afterAddingStudent_returnsFalse() throws Exception {
        repository.addStudent(
                new Student(1, "Shakti", 19, "IT")
        );

        assertFalse(repository.isStudentsEmpty());
    }
    @Test
    void size_afterAddingStudents_returnsCorrectSize() throws Exception {
        repository.addStudent(
                new Student(1, "Shakti", 19, "IT")
        );

        repository.addStudent(
                new Student(2, "Arun", 20, "CSE")
        );

        assertEquals(2, repository.size());
    }
    @Test
    void get_validIndex_returnsStudent() throws Exception {
        Student student = new Student(1, "Shakti", 19, "IT");
        repository.addStudent(student);

        Student result = repository.get(0);

        assertEquals(student, result);
    }
    @Test
    void set_validIndex_replacesStudent() throws Exception {
        Student firstStudent = new Student(1, "Shakti", 19, "IT");
        Student replacement = new Student(2, "Arun", 20, "CSE");

        repository.addStudent(firstStudent);

        repository.set(0, replacement);

        assertEquals(replacement, repository.get(0));
    }
    @Test
    void swap_twoIndexes_studentsAreSwapped() throws Exception {
        Student first = new Student(1, "Shakti", 19, "IT");
        Student second = new Student(2, "Arun", 20, "CSE");

        repository.addStudent(first);
        repository.addStudent(second);

        repository.swap(0, 1);

        assertEquals(2, repository.get(0).getId());
        assertEquals(1, repository.get(1).getId());
    }
    @Test
    void getStudents_returnsStudentList() throws Exception {
        Student student = new Student(1, "Shakti", 19, "IT");
        repository.addStudent(student);

        assertEquals(1, repository.getStudents().size());
        assertEquals(student, repository.getStudents().get(0));
    }
    @Test
    void setStudents_replacesStudentList() {
        var students = new java.util.ArrayList<Student>();

        students.add(
                new Student(1, "Shakti", 19, "IT")
        );
        students.add(
                new Student(2, "Arun", 20, "CSE")
        );

        repository.setStudents(students);

        assertEquals(2, repository.size());
        assertEquals(1, repository.get(0).getId());
        assertEquals(2, repository.get(1).getId());
    }
}