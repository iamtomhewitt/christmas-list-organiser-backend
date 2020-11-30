package iamtomhewitt.clob.exception;

public class GroupNotFoundException extends Exception {
    public GroupNotFoundException(String name) {
        super("Could not find group with '" + name + "'");
    }
}
