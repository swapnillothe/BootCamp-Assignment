package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DimensionTest {
    @Test
    void getValue() throws Exception {
        Dimension dimension = new Dimension(2.0D);
        Double actualOutput = dimension.getValue();
        Double expectedOutput = 2.0D;
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getValueShouldThrowExceptionForNegativeValues() throws Exception {
        assertThrows(InvalidDimensionException.class, () -> {
            Dimension dimension = new Dimension(-1.0D);
        });
    }

}