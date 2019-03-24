package comparisonNewApproach;

import java.math.BigDecimal;

class Unit {

    private BigDecimal ratio;

    Unit(BigDecimal ratio) {
        this.ratio = ratio;
    }

    BigDecimal toBaseValue(BigDecimal value) {
        return this.ratio.multiply(value);
    }
}
