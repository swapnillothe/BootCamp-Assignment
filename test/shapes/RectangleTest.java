package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void getAreaShouldGiveMultiplicationOfLengthAndBreadth() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(3D), new Dimension(5D));
        Double actualOutput = rectangle.calculateArea();
        Double expectedOutput = 15D;
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getAreaShouldReturnZeroIfAnyOfDimensionIsZero() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(0D), new Dimension(5D));

        Double actualOutput = rectangle.calculateArea();
        Double expectedOutput = 0D;
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void calculatePerimeterShouldReturnPerimeterOfRectangle() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(3D), new Dimension(5D));
        Double actualOutput = rectangle.calculatePerimeter();
        Double expectedOutput = 16D;
        assertEquals(expectedOutput, actualOutput);
    }
}