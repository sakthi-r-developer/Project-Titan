package exceptions;

public class InvalidAgeException extends InvalidStudentException{
    public InvalidAgeException(String message) {
        super(message);
    }
}
