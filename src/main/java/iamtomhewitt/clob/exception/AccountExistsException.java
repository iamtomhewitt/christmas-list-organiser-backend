package iamtomhewitt.clob.exception;

public class AccountExistsException extends Exception {
    public AccountExistsException(String email) {
        super("Account with email '" + email + "' already exists");
    }
}
