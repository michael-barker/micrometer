package io.micrometer.stackdriver;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import io.micrometer.core.lang.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class StackdriverMeterRegistry extends StepMeterRegistry {

    private final Logger logger = LoggerFactory.getLogger(StackdriverMeterRegistry.class);

    private final StackdriverConfig config;

    public StackdriverMeterRegistry(StackdriverConfig config, Clock clock) {
        this(config, clock, Executors.defaultThreadFactory());
    }

    private StackdriverMeterRegistry(
        StackdriverConfig config,
        Clock clock,
        ThreadFactory threadFactory
    ) {
        super(config, clock);
        this.config().namingConvention(new StackdriverNamingConvention());
        this.config = config;
        start(threadFactory);
    }

    @Override
    protected void publish() {
        // TODO
    }

    @Override
    @NonNull
    protected TimeUnit getBaseTimeUnit() {
        return TimeUnit.MILLISECONDS;
    }
}
