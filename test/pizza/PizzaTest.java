package pizza;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {

    @Test
    @DisplayName("should give the price of basic pizza")
    void basicPizzaPrice() {
        Pizza pizza = new Pizza();
        Price actual = pizza.getTotalPrice();
        assertEquals(new Price(new BigDecimal("50")), actual);
    }

    @Test
    @DisplayName("should give the description of basic pizza")
    void basicPizzaDescription() {
        Pizza pizza = new Pizza();
        String actual = pizza.getDescription();
        assertEquals("[Pizza with ]", actual);
    }

    @Test
    @DisplayName("should give the price of chicken pizza")
    void chickenPizzaPrice() {
        Pizza pizza = new Pizza();
        pizza.addTopping(Topping.CHICKEN);
        Price actual = pizza.getTotalPrice();
        assertEquals(new Price(new BigDecimal("80.0")), actual);
    }

    @Test
    @DisplayName("should give the description of chicken pizza")
    void chickenPizzaDescription() {
        Pizza pizza = new Pizza();
        pizza.addTopping(Topping.CHICKEN);
        String actual = pizza.getDescription();
        assertEquals("[Pizza with , CHICKEN]", actual);
    }
}