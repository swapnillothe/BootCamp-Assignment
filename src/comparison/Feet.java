package comparison;

class Feet {
    private Double value;

    Feet(Double value) {
        this.value = value;
    }


    Inches toInches() {
        return new Inches(value * 12);
    }

    boolean compare(Inches inches) {
        return inches.toFeet().equals(this.value);
    }

    boolean compare(Feet feet) {
        return feet.value.equals(this.value);
    }
}
