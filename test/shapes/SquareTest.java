package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void calculateAreaShouldReturnTheSquareOfSide() throws Exception {
        Square square = new Square(new Dimension(5D));
        Double actualOutput =  square.calculateArea();
        Double expectedOutput = 25D;
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void calculatePerimeterShouldReturnPerimeter() throws Exception {
        Square square = new Square(new Dimension(5D));
        Double actualOutput =  square.calculatePerimeter();
        Double expectedOutput = 20D;
        assertEquals(expectedOutput,actualOutput);
    }
}