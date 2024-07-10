package br.com.emerlopes.bffecommerce.domain.shared;

public class RequestParametersStore {
    private static final ThreadLocal<String> threadLocalAuthorization = new ThreadLocal<>();

    public static void setAuthorization(
            final String value
    ) {
        threadLocalAuthorization.set(value);
    }

    public static String getAuthorization() {
        return threadLocalAuthorization.get();
    }

    public static void removeAuthorization() {
        threadLocalAuthorization.remove();
    }
}
