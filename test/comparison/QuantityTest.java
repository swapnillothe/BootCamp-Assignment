package comparison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void ShouldReturnTrueForTwoEqualQuantities() {
        Quantity quantity1 = new Quantity(1.0, LengthUnits.FEET);
        Quantity quantity2 = new Quantity(12.0, LengthUnits.INCHES);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnFalseForTwoUnequalQuantitiesInches() {
        Quantity quantity1 = new Quantity(1.0, LengthUnits.FEET);
        Quantity quantity2 = new Quantity(13.0, LengthUnits.INCHES);
        assertNotEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueForTwoUnequalQuantities() {
        Quantity quantity1 = new Quantity(2.0, LengthUnits.INCHES);
        Quantity quantity2 = new Quantity(5.0, LengthUnits.CM);
        assertEquals(quantity1, quantity2);

    }

    @Test
    void ShouldReturnFalseForTwoUnequalQuantitiesCm() {
        Quantity quantity1 = new Quantity(15.0, LengthUnits.INCHES);
        Quantity quantity2 = new Quantity(40.0, LengthUnits.CM);
        assertNotEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueForTwoUnequalQuantitiesMM() {
        Quantity quantity1 = new Quantity(2.0, LengthUnits.CM);
        Quantity quantity2 = new Quantity(20.0, LengthUnits.MM);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueForEqualGallonAndML() {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.GALLON);
        Quantity quantity2 = new Quantity(3780.0, VolumeUnits.ML);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueForEqualLitreAndML() {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.LITRE);
        Quantity quantity2 = new Quantity(1000.0, VolumeUnits.ML);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueForEqualLitreAndGallon() {
        Quantity quantity1 = new Quantity(100.0, VolumeUnits.GALLON);
        Quantity quantity2 = new Quantity(378.0, VolumeUnits.LITRE);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnFalseForDifferentTypes() {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.ML);
        Quantity quantity2 = new Quantity(1.0, LengthUnits.MM);
        assertNotEquals(quantity1, quantity2);
    }

    @Test
    void ShouldReturnTrueSameTypes() {
        Quantity quantity1 = new Quantity(1.0, LengthUnits.MM);
        Quantity quantity2 = new Quantity(1.0, LengthUnits.MM);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTheSumOfSameTypeQuantities() throws Exception {
        Quantity quantity1 = new Quantity(1.0, LengthUnits.INCHES);
        Quantity quantity2 = new Quantity(1.0, LengthUnits.INCHES);

        Quantity expectedQuantity = new Quantity(2.0, LengthUnits.INCHES);
        assertEquals(expectedQuantity, quantity1.addQuantity(quantity2));
    }

    @Test
    void shouldThrowErrorForDifferentTypeQuantities() throws Exception {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.ML);
        Quantity quantity2 = new Quantity(1.0, LengthUnits.INCHES);

        assertThrows(Exception.class, () -> quantity1.addQuantity(quantity2));
    }

    @Test
    void shouldAddTwoSameTypeOfQuantitiesForLength() throws Exception {
        Quantity quantity1 = new Quantity(2.0, LengthUnits.INCHES);
        Quantity quantity2 = new Quantity(2.5, LengthUnits.CM);

        Quantity expectedQuantity = new Quantity(3.0, LengthUnits.INCHES);
        assertEquals(expectedQuantity, quantity1.addQuantity(quantity2));

    }


    @Test
    void shouldAddTwoSameTypeOfQuantitiesForVolume() throws Exception {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.LITRE);
        Quantity quantity2 = new Quantity(1.0, VolumeUnits.GALLON);

        Quantity expectedQuantity = new Quantity(4.78, VolumeUnits.LITRE);
        assertEquals(expectedQuantity, quantity1.addQuantity(quantity2));
    }

    @Test
    void ShouldReturnFalseForDifferentTypesOfTemperatureAndVolume() {
        Quantity quantity1 = new Quantity(1.0, VolumeUnits.LITRE);
        Quantity quantity2 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        assertNotEquals(quantity1, quantity2);
    }

    @Test
    void shouldAddTwoSameTypeOfQuantitiesForTemperature() throws Exception {
        Quantity quantity1 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        Quantity quantity2 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        assertNull(quantity1.addQuantity(quantity2));
    }

    @Test
    void shouldCompareTwoTemperatureUnits() {
        Quantity quantity1 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        Quantity quantity2 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        assertEquals(quantity1, quantity2);

    }

    @Test
    void shouldCompareTwoDifferentTemperatureUnits() throws Exception {
        Quantity quantity1 = new Quantity(1.0, TemperatureUnits.CELSIUS);
        Quantity quantity2 = new Quantity(273.0, TemperatureUnits.KELVIN);
        assertEquals(quantity1, quantity2);

    }

}
