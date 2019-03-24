package quantity;

import java.math.BigDecimal;

public class Quantity {

    private BigDecimal value;
    private Unit unit;

    Quantity(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    Quantity addQuantity(Quantity quantity) throws Exception {
        if (!(this.unit.isOfSameType(quantity.unit))) {
            throw new Exception("Mismatching Quantity Types");
        }
        BigDecimal quantity1BaseValue = this.unit.toBaseValue(value);
        BigDecimal quantity2BaseValue = quantity.unit.toBaseValue(quantity.value);

        BigDecimal sum = quantity1BaseValue.add(quantity2BaseValue);
        BigDecimal standardSum = this.unit.toStandardUnit(sum);

        return new Quantity(standardSum, this.unit.getStandardUnit());
    }

    @Override
    public boolean equals(Object quantity2) {
        if (!(quantity2 instanceof Quantity)) return false;
        if (!(this.unit.isOfSameType(((Quantity) quantity2).unit))) return false;
        Quantity quantity = (Quantity) quantity2;
        BigDecimal quantity1BaseValue = this.unit.toBaseValue(value);
        BigDecimal quantity2BaseValue = quantity.unit.toBaseValue(quantity.value);
        return quantity1BaseValue.intValue() == quantity2BaseValue.intValue();
    }
}
