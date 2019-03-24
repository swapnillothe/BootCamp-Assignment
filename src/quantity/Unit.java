package quantity;

import java.math.BigDecimal;

abstract class Unit {
    protected BigDecimal ratio;
    private Object type;

    Unit(BigDecimal ratio, Object type) {
        this.ratio = ratio;
        this.type = type;
    }

    public abstract BigDecimal getStandardRatio();

    boolean isOfSameType(Unit unit) {
        return this.type.equals(unit.type);
    }

    BigDecimal toBaseValue(BigDecimal value) {
        return value.multiply(this.ratio);
    }

    BigDecimal toStandardUnit(BigDecimal value) {
        return value.divide(this.getStandardRatio());
    }

    abstract Unit getStandardUnit();
}
