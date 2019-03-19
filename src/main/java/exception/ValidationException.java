package exception;

public class ValidationException extends Exception { // rzucanie wyjatkow

    public ValidationException (String message){
        super(message);
    }
    public ValidationException (String message, Throwable cause){
        super(message,cause);
    }
    public ValidationException (String fieldName, String value){
        this(String.format("Invalid hero, field: %s with value: %s ", fieldName,value));
    }


}
