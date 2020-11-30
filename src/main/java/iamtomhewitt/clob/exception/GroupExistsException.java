package iamtomhewitt.clob.exception;

public class GroupExistsException extends Exception {
    public GroupExistsException(String name) {
        super("Group with name '" + name + "' already exists");
    }
}
