package de.fabiexe.byebyebuttons.config;

import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

public final class ConfigPart<T> implements Supplier<T> {
    private final String name;
    private final T defaultValue;
    private @Nullable T value = null;

    public ConfigPart(String name, T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public @Nullable T getValue() {
        return value;
    }

    public T get() {
        return Objects.requireNonNullElse(value, defaultValue);
    }

    public void set(T value) {
        if (Objects.equals(value, defaultValue)) {
            this.value = null;
        } else {
            this.value = value;
        }
    }
}