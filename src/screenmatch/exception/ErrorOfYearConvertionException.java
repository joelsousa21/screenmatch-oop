package screenmatch.exception;

public class ErrorOfYearConvertionException extends RuntimeException {
    private String message;

    public ErrorOfYearConvertionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
