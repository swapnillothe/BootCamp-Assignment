package quantity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityTest {

    @Test
    void shouldReturnTrueForTwoOneCmAndOneCm() {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), LengthUnit.CM);
        Quantity quantity2 = new Quantity(new BigDecimal(1.0), LengthUnit.CM);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForTwoDifferentQuantitiesButSameValue() {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), LengthUnit.INCHES);
        Quantity quantity2 = new Quantity(new BigDecimal(25.0), LengthUnit.MM);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForTwoDifferentQuantitiesButSameValueVolume() {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), VolumeUnit.LITER);
        Quantity quantity2 = new Quantity(new BigDecimal(1000.0), VolumeUnit.ML);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForTwoDifferentQuantitiesButSameValueVolumes() {
        Quantity quantity1 = new Quantity(new BigDecimal(3780.0), VolumeUnit.ML);
        Quantity quantity2 = new Quantity(new BigDecimal(1.0), VolumeUnit.GALON);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForTwoDifferentQuantitiesButSameValueTemperature() {
        Quantity quantity1 = new Quantity(new BigDecimal(100.0), TemperatureUnit.CELSIUS);
        Quantity quantity2 = new Quantity(new BigDecimal(212.0), TemperatureUnit.FAHRENHEIT);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldThrowExceptionForDifferentTypesOfQuantities() throws Exception {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), LengthUnit.INCHES);
        Quantity quantity2 = new Quantity(new BigDecimal(1.0), VolumeUnit.ML);
        assertThrows(Exception.class, () -> quantity1.addQuantity(quantity2));
    }

    @Test
    void shouldAddTwoSameTypesOfQuantities() throws Exception {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), LengthUnit.INCHES);
        Quantity quantity2 = new Quantity(new BigDecimal(1.0), LengthUnit.INCHES);
        Quantity expectedOutput = new Quantity(new BigDecimal(2.0), LengthUnit.INCHES);
        assertEquals(expectedOutput, quantity1.addQuantity(quantity2));
    }

    @Test
    void shouldAddTwoSameTypesOfQuantitiesLength() throws Exception {
        Quantity quantity1 = new Quantity(new BigDecimal(1.0), LengthUnit.FEET);
        Quantity quantity2 = new Quantity(new BigDecimal(1.0), LengthUnit.INCHES);
        Quantity expectedOutput = new Quantity(new BigDecimal(13.0), LengthUnit.INCHES);
        assertEquals(expectedOutput, quantity1.addQuantity(quantity2));
    }
}