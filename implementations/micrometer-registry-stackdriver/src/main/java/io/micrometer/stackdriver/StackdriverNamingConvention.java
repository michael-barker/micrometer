package io.micrometer.stackdriver;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.NamingConvention;

public class StackdriverNamingConvention implements NamingConvention {

    private final NamingConvention delegate;

    public StackdriverNamingConvention() {
        // FIXME What is the default?
        this(NamingConvention.snakeCase);
    }

    public StackdriverNamingConvention(NamingConvention delegate) {
        this.delegate = delegate;
    }

    @Override
    public String name(String name, Meter.Type type, String baseUnit) {
        // FIXME Implement
        return delegate.name(name, type, baseUnit);
    }

    @Override
    public String tagKey(String key) {
        // FIXME Implement
        return null;
    }
}
