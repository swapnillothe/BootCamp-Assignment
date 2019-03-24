package comparison;

class Inches {
    private Double value;

    Inches(Double value) {
        this.value = value;
    }

    Inches toFeet() {
        return new Inches(value / 12);
    }


    boolean compare(Inches inches) {
        return inches.value.equals(this.value);
    }

    boolean compare(Feet feet) {
        return feet.toInches().equals(this.value);
    }
}
