import java.io.IOException;

// update the class
class BadRequestException extends IOException {

    // constructor
    public BadRequestException(String message) {
        super(message);
    }

}