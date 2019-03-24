package pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Toppings {
    private List<Topping> toppings;
    private Price toppingsPrice;
    private List<String> description;

    Toppings() {
        this.toppings = new ArrayList<>();
        this.toppingsPrice = new Price(new BigDecimal("0"));
        this.description = new ArrayList<>();
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
        this.toppingsPrice = this.toppingsPrice.add(topping.getPrice());
        this.description.add(topping.name());
    }

    Price getToppingsPrice() {
        return this.toppingsPrice;
    }

    List<String> getDescription() {
        return this.description;
    }
}
