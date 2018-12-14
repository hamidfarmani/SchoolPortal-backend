package schoolPortal.util;

public enum Status {
    OK(1, "OK"),
    CONFLICT(-1, "CONFLICT"),
    NOT_FOUND(-2, "NOT FOUND"),

    PASS_LENGTH(-40,"PASSWORD LENGTH ERROR"),
    PASS_UPPER_LOWER_SIGN_NUMBER(-41,"PASSWORD UPPER LOWER SIGN NUMBER ERROR"),
    PASS_USED_BEFORE(-42,"PASSWORD HAS BEEN USED BEFORE"),
    PASS_WRONG(-43, "OLD PASSWORD IS WRONG"),
    PASS_MISMATCH(-44,"PASS AND REPASS NOT EQUAL"),


    BAD_REQUEST(-400, "BAD REQUEST"),
    UNAUTHORIZED(-401, "UNAUTHORIZED"),
    TOKEN_EXPIRED(-402, "TOKEN EXPIRED"),
    ACCESS_DENIED(-403, "ACCESS DENIED"),
    RESOURCE_NOT_FOUND(-404,"RESOURCE NOT FOUND"),
    METHOD_NOT_ALLOWED(-405,"REQUESTED METHOD NOT SUPPORTED"),
    UNSUPPORTED_MEDIA_TYPE(-415,"UNSUPPORTED MEDIA TYPE"),

    UNKNOWN_ERROR(-500, "INTERNAL SERVER ERROR AT BACKEND");



    private int statusCode;
    private String statusDesc;

    Status(int statusCode, String status) {
        this.statusCode = statusCode;
        this.statusDesc = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }
}
