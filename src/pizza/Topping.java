package pizza;

import java.math.BigDecimal;

public enum Topping {

    CHICKEN(new Price(new BigDecimal("30.0"))),
    EXTRACHEESE(new Price(new BigDecimal("25.0"))),
    JALAPENO(new Price(new BigDecimal("40.0"))),
    MOZZARELLA(new Price(new BigDecimal("10.0"))),
    TOMATOSAUCE(new Price(new BigDecimal("5.0"))),
    VEGETABLE(new Price(new BigDecimal("20.0")));

    private Price price;

    Topping(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return this.price;
    }
}
