package com.toddcostella.mn.microPrometheus

import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.time.Duration
import java.time.temporal.ChronoUnit

/**
 * Generate a couple of metric entries. One for simple method count and a timer that collects duration events
 * for the
 */
class MetricGenerator {
    static Logger log = LoggerFactory.getLogger(MetricGenerator.class)
    private MeterRegistry meterRegistry

    //todo: Likely there is a way inject the registry directly via Micronaut.
    MetricGenerator(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry
    }

    void generateRandomMetrics() {
        meterRegistry.counter("metricGenerator.generateRandomMetrics").increment()
        Random random = new Random()
        def range = random.nextInt(15)
        (1..range).each {
            def start = System.nanoTime()
            method1()
            def end = System.nanoTime()
            Duration duration = Duration.of(end - start, ChronoUnit.NANOS)
            meterRegistry.timer("metricGenerator.methodTimer").record(duration)
        }
    }

    static void method1() {
        Random random = new Random()
        def sleep = random.nextInt(1000) as long
        log.debug("Sleeping for {} milliseconds", sleep)
        Thread.sleep(sleep)
    }

}