package pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Pizza {

    private Price totalPrice;

    private List<String> description;

    private Toppings toppings;

    Pizza() {
        this.totalPrice = new Price(new BigDecimal("50"));
        this.description = new ArrayList<>();
        this.description.add("Pizza with ");
        this.toppings = new Toppings();
    }

    void addTopping(Topping topping) {
        this.toppings.addTopping(topping);
    }

    Price getTotalPrice() {
        Price toppingsPrice = this.toppings.getToppingsPrice();
        return this.totalPrice.add(toppingsPrice);
    }

    String getDescription() {
        this.description.addAll(this.toppings.getDescription());
        return this.description.toString();
    }
}
