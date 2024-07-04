package uk.tw.energy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PricePlanServiceTest {

    private PricePlanService pricePlanService;

    @MockBean
    private MeterReadingService meterReadingService;

    @BeforeEach
    public void setUp() {
        pricePlanService = new PricePlanService(null, meterReadingService);
    }

    @Test
    public void givenMeterIdThatDoesNotExistShouldReturnNull() {
        when(meterReadingService.getReadings("")).thenReturn(Optional.empty());

        Optional<Map<String, BigDecimal>> actual = pricePlanService.getConsumptionCostOfElectricityReadingsForEachPricePlan("");

        int i = 0;
    }
}
