package lesson7.homework;

import java.util.Arrays;

public enum EStorageType {
    COOKIES(CookiesHandler.getInstance()),
    SESSION(SessionHandler.getInstance());

    private IStorageHandler handler;

    EStorageType(IStorageHandler handler) {
        this.handler = handler;
    }

    public IStorageHandler getHandler() {
        return this.handler;
    }

    public static EStorageType valueOfIgnoreCase(String storageType) {
        return Arrays.stream(values()).filter(o -> o.name().equalsIgnoreCase(storageType)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
