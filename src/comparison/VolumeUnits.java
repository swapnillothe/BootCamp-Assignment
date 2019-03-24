package comparison;

import java.math.BigDecimal;

class VolumeUnits extends Unit {

    static final Object VOLUME = new Object();

    static final Unit ML = new VolumeUnits(new BigDecimal(1), VOLUME);
    static final Unit LITRE = new VolumeUnits(new BigDecimal(1000), VOLUME);
    static final Unit GALLON = new VolumeUnits(new BigDecimal(3780), VOLUME);

    private BigDecimal ratio;

    private VolumeUnits(BigDecimal ratio, Object type) {
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
