package iamtomhewitt.clob.exception;

public class InvalidAccountException extends Exception {
    public InvalidAccountException(String email) {
        super("Incorrect password for '" + email + "'");
    }
}
