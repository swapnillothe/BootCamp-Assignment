package quantity;

import java.math.BigDecimal;

class VolumeUnit extends Unit {

    private static final Object VOLUME = new Object();
    static final Unit LITER = new VolumeUnit(new BigDecimal(1000.0), VOLUME);
    static final Unit GALON = new VolumeUnit(new BigDecimal(3780.0), VOLUME);
    static final Unit ML = new VolumeUnit(new BigDecimal(1.0), VOLUME);

    private VolumeUnit(BigDecimal ratio, Object type) {
        super(ratio, type);
    }

    @Override
    public BigDecimal getStandardRatio() {
        return ML.ratio;
    }

    @Override
    Unit getStandardUnit() {
        return VolumeUnit.LITER;
    }
}
