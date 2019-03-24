package comparison;

import java.math.BigDecimal;

class TemperatureUnits extends Unit {
    static final Object TEMPERATURE = new Object();

    static final Unit CELSIUS = new TemperatureUnits(new BigDecimal(1.0), new BigDecimal(0.0), TEMPERATURE);
    static final Unit FAHRENHEIT = new TemperatureUnits(new BigDecimal(1.8), new BigDecimal(32.0), TEMPERATURE);
    static final Unit KELVIN = new TemperatureUnits(new BigDecimal(1.0), new BigDecimal(273.0), TEMPERATURE);

    private final BigDecimal scale;
    private final BigDecimal ratio;

    private TemperatureUnits(BigDecimal ratio, BigDecimal scale, Object type) {
        super(ratio, type);
        this.scale = scale;
        this.ratio = ratio;
    }

    @Override
    public BigDecimal toBaseValue(BigDecimal value) {
        return this.ratio.multiply(value).add(this.scale);
    }

    public BigDecimal toRequiredUnit(BigDecimal sum, Unit unit) {
        return null;
    }

    @Override
    public BigDecimal addUnits(BigDecimal value, Unit unit) {
        System.out.println("TEMPERATURES CAN NOT BE ADDED");
        return null;
    }
}
