package micro.prometheus

import com.toddcostella.mn.microPrometheus.MetricGenerator
import io.micrometer.core.instrument.MeterRegistry
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/generateMetricData")
class GenerateMetricDataControllerController {

    private MeterRegistry meterRegistry;

    public GenerateMetricDataControllerController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }


    @Get(uri="/", produces="text/plain")
    String index() {
        MetricGenerator mc = new MetricGenerator(meterRegistry)
        mc.generateRandomMetrics()
        "Done"
    }
}