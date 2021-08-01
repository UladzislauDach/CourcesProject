package lesson1.homework.classesForMethodsExample;

import java.io.File;

/**
 * This DTO class for {@link lesson1.homework.MethodsExample#getMaintenanceMap(File)} class working
 *
 * @author uladz
 * @version 1.1
 */

public class MaintenanceDto {
    private String operationName;
    private int operationCode;
    private String description;
    private String parts;
    private int interval;

    /**
     * Default constructor for {@link Builder}
     */
    public MaintenanceDto() {
    }

    /**
     * All args constructor
     *
     * @param operationName name of operation as String
     * @param operationCode code of operation as integer
     * @param description   description of operation as String
     * @param parts         parts for operation as Strong
     * @param interval      interval for performance operation
     */
    public MaintenanceDto(String operationName, int operationCode, String description, String parts, int interval) {
        this.operationName = operationName;
        this.operationCode = operationCode;
        this.description = description;
        this.parts = parts;
        this.interval = interval;
    }

    /**
     * Getter
     *
     * @return name of operation
     */

    public String getOperationName() {
        return operationName;
    }

    /**
     * Getter
     *
     * @return code of operation
     */
    public int getOperationCode() {
        return operationCode;
    }

    /**
     * Getter
     *
     * @return description of operation
     */

    public String getDescription() {
        return description;
    }

    /**
     * Getter
     *
     * @return parts op operation
     */

    public String getParts() {
        return parts;
    }

    /**
     * Getter
     *
     * @return interval of operation
     */

    public int getInterval() {
        return interval;
    }

    /**
     * This simple builder for {@link MaintenanceDto} object
     */
    public static class Builder {
        private MaintenanceDto newMaintenanceDto;

        public Builder() {
            newMaintenanceDto = new MaintenanceDto();
        }

        public Builder setOperationName(String operationName) {
            newMaintenanceDto.operationName = operationName;
            return this;
        }

        public Builder setOperationCode(int operationCode) {
            newMaintenanceDto.operationCode = operationCode;
            return this;
        }

        public Builder setDescription(String description) {
            newMaintenanceDto.description = description;
            return this;
        }

        public Builder setParts(String parts) {
            newMaintenanceDto.parts = parts;
            return this;
        }

        public Builder setInterval(int interval) {
            newMaintenanceDto.interval = interval;
            return this;
        }

        public MaintenanceDto build() {
            return newMaintenanceDto;
        }
    }
}
