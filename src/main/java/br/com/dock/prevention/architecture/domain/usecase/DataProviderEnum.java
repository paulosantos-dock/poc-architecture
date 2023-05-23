package br.com.dock.prevention.architecture.domain.usecase;

public enum DataProviderEnum {
    DATABASE,
    PIER,
    DOCK_ONE;

    public static DataProviderEnum fromValue(final String value) {
        for (DataProviderEnum provider : DataProviderEnum.values()) {
            if (String.valueOf(provider).toLowerCase().equals(value)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("Value invalid");
    }
}
