package comparisonNewApproach;

import java.math.BigDecimal;

class Length {
    private BigDecimal value;
    private Unit unit;
    private LengthUnits lengthUnit;

    Length(Double value, LengthUnits unit) {
        this.lengthUnit = unit;
        this.unit = new Unit(new BigDecimal(unit.getRatio()));
        this.value = new BigDecimal(value);
    }

    Length convertTo(LengthUnits unit) {
        Double a = this.unit.toBaseValue(this.value).doubleValue();
        return new Length(a / unit.getRatio(), unit);
    }

    Length addTo(Length length, LengthUnits unit) {
        BigDecimal length1 = this.unit.toBaseValue(this.value);
        BigDecimal length2 = length.unit.toBaseValue(length.value);

        Double addition = length1.add(length2).doubleValue();
        return new Length(addition, LengthUnits.MM).convertTo(unit);
    }

    @Override
    public boolean equals(Object length2) {
        if (!(length2 instanceof Length)) return false;
        Length quantity = (Length) length2;
        BigDecimal quantity1BaseValue = this.unit.toBaseValue(value);
        BigDecimal quantity2BaseValue = quantity.unit.toBaseValue(quantity.value);
        return quantity1BaseValue.equals(quantity2BaseValue);
    }
}
