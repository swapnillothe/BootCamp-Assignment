package comparison;

import java.math.BigDecimal;

abstract class Unit {

    private BigDecimal ratio;
    private Object type;

    Unit(BigDecimal ratio, Object type) {
        this.ratio = ratio;
        this.type = type;
    }

    BigDecimal toRequiredUnit(BigDecimal value, Unit unit) {
        return value.divide(unit.ratio);
    }

    boolean isOfSameType(Unit unit) {
        return this.type.equals(unit.type);
    }

    public abstract BigDecimal toBaseValue(BigDecimal value);

    public abstract BigDecimal addUnits(BigDecimal value, Unit unit);
}


