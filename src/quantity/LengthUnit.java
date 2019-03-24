package quantity;

import java.math.BigDecimal;

class LengthUnit extends Unit {

    private static Object LENGTH = new Object();
    static final Unit MM = new LengthUnit(new BigDecimal(1.0), LENGTH);
    static final Unit CM = new LengthUnit(new BigDecimal(10.0), LENGTH);
    static final Unit FEET = new LengthUnit(new BigDecimal(300.0), LENGTH);
    static final Unit INCHES = new LengthUnit(new BigDecimal(25.0), LENGTH);

    private LengthUnit(BigDecimal ratio, Object type) {
        super(ratio, type);
    }

    @Override
    public BigDecimal getStandardRatio() {
        return INCHES.ratio;
    }

    @Override
    Unit getStandardUnit() {
        return LengthUnit.INCHES;
    }
}
