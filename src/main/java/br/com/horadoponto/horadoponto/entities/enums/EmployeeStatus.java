package br.com.horadoponto.horadoponto.entities.enums;

public enum EmployeeStatus {
    WORKING(1),
    AWAY(2),
    ANNUAL_LEAVE(3);

    private int code;

    private EmployeeStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EmployeeStatus valueOf(int code){
        for (EmployeeStatus value : EmployeeStatus.values()) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus code");
    }
}
