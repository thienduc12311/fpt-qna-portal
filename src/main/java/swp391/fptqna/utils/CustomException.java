package swp391.fptqna.utils;

public class CustomException extends Exception {

    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}