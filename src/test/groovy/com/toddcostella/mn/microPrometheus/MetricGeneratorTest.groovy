package com.toddcostella.mn.microPrometheus

import io.micrometer.core.instrument.MeterRegistry
import io.micronaut.context.ApplicationContext
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest(rebuildContext = true)
class MetricGeneratorTest extends Specification {
    @Inject
    private MeterRegistry meterRegistry

    void testGenerateRandomMetrics() {
        given:
        ApplicationContext context = ApplicationContext.run()
        def mc = new MetricGenerator(meterRegistry)
        mc.generateRandomMetrics()
        expect:
        1 == 1
    }
}
