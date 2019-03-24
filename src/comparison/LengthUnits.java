package comparison;

import java.math.BigDecimal;

class LengthUnits extends Unit {

    static final Object LENGTH = new Object();

    static final Unit FEET = new LengthUnits(new BigDecimal(300), LENGTH);
    static final Unit INCHES = new LengthUnits(new BigDecimal(25), LENGTH);
    static final Unit CM = new LengthUnits(new BigDecimal(10), LENGTH);
    static final Unit MM = new LengthUnits(new BigDecimal(1), LENGTH);

    private BigDecimal ratio;

    private LengthUnits(BigDecimal ratio, Object type) {
        super(ratio, type);
        this.ratio = ratio;
    }

    public BigDecimal toBaseValue(BigDecimal value) {
        return this.ratio.multiply(value);
    }

    @Override
    public BigDecimal addUnits(BigDecimal value, Unit unit) {
        BigDecimal baseValue1 = this.toBaseValue(value);
        BigDecimal baseValue2 = unit.toBaseValue(value);
        BigDecimal sum = baseValue1.add(baseValue2);
        return this.toRequiredUnit(sum, unit);
    }
}
