package me.lolico.sms.lang;

/**
 * @author lolico
 */
public class InvalidActionException extends RuntimeException {
    private final String invalidAction;

    public InvalidActionException(String invalidAction) {
        super("Unexpected action value '" + invalidAction + "'");
        this.invalidAction = invalidAction;
    }

    public String getInvalidAction() {
        return invalidAction;
    }
}
