package iamtomhewitt.clob.exception;

public class NoChristmasListException extends Exception {
    public NoChristmasListException(String email) {
        super("No Christmas list for '" + email + "'");
    }
}
