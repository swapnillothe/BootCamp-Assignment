package comparisonNewApproach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthTest {

    @Test
    void shouldAddTwoLengths() {
        Length twoInch = new Length(2.0, LengthUnits.INCH);
        Length twoPointFiveCm = new Length(2.5, LengthUnits.CM);

        Length actualOutput = twoInch.addTo(twoPointFiveCm, LengthUnits.INCH);
        Length expectedOutput = new Length(3.0, LengthUnits.INCH);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldConvertOneLengthQuantityToAnother() {
        Length length = new Length(2.0, LengthUnits.INCH);
        Length actualOutput = length.convertTo(LengthUnits.CM);
        Length expectedOutput = new Length(5.0, LengthUnits.CM);

        assertEquals(expectedOutput, actualOutput);
    }
}
