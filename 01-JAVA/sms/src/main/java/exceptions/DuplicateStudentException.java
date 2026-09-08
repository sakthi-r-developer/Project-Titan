package exceptions;

public class DuplicateStudentException extends InvalidStudentException {
    public DuplicateStudentException(String message) {
        super(message);
    }
}
