package iamtomhewitt.clob.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String itemName) {
        super("'" + itemName + "' not found");
    }
}
