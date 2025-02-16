package br.com.horadoponto.infraestructure.entities.enums;

public enum EmployeeStatus {
    WORKING,
    AWAY,
    ANNUAL_LEAVE

    /*private int code;

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
    }*/
}
