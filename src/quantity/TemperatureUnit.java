package quantity;

import java.math.BigDecimal;

class TemperatureUnit extends Unit {

    private static final Object TEMPERATURE = new Object();
    static final Unit CELSIUS = new TemperatureUnit(new BigDecimal(1.8), new BigDecimal(32), TEMPERATURE);
    static final Unit FAHRENHEIT = new TemperatureUnit(new BigDecimal(1), new BigDecimal(0.0), TEMPERATURE);
    private BigDecimal scale;

    private TemperatureUnit(BigDecimal ratio, BigDecimal scale, Object type) {
        super(ratio, type);
        this.scale = scale;
    }

    @Override
    BigDecimal toBaseValue(BigDecimal value) {
        return value.multiply(this.ratio).add(this.scale);
    }

    @Override
    public BigDecimal getStandardRatio() {
        return FAHRENHEIT.ratio;
    }

    @Override
    BigDecimal toStandardUnit(BigDecimal value) {
        return value.subtract(this.scale).divide(this.getStandardRatio());
    }


    @Override
    Unit getStandardUnit() {
        return TemperatureUnit.FAHRENHEIT;
    }
}
