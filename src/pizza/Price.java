package pizza;

import java.math.BigDecimal;
import java.util.Objects;

class Price {

    private BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }

    BigDecimal getValue() {
        return value;
    }

    Price add(Price toppingsPrice) {
        return new Price(this.value.add(toppingsPrice.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return Objects.equals(getValue(), price.getValue());
    }
}
