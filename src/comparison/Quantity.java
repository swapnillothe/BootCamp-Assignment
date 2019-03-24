package comparison;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(Double value, Unit unit) {
        this.value = new BigDecimal(value);
        this.unit = unit;
    }

    Quantity addQuantity(Quantity quantity) throws Exception {
        if (!(this.unit.isOfSameType(quantity.unit))) {
            throw new Exception("Mismatching Quantity Types");
        }
        double sum = quantity.unit.addUnits(this.value, this.unit).doubleValue();
        return new Quantity(sum, this.unit);
    }

    @Override
    public boolean equals(Object quantity2) {
        if (!(quantity2 instanceof Quantity)) return false;
        if (!(this.unit.isOfSameType(((Quantity) quantity2).unit))) return false;
        Quantity quantity = (Quantity) quantity2;
        BigDecimal quantity1BaseValue = this.unit.toBaseValue(value);
        BigDecimal quantity2BaseValue = quantity.unit.toBaseValue(quantity.value);
        System.out.println(quantity1BaseValue + "  " + quantity2BaseValue);
        return quantity1BaseValue.equals(quantity2BaseValue);
    }
}
