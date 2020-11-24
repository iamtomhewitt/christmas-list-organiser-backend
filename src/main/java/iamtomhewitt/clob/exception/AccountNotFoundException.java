package iamtomhewitt.clob.exception;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String email) {
        super("Could not find account with '" + email + "'");
    }
}
