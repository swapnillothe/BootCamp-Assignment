package shapes;

public class Dimension {
    private Double value;

    Dimension(Double value) throws Exception {
        this.setValue(value);
    }

    Double getValue() {
        return value;
    }

    private void setValue(Double value) throws Exception {
        if (value < 0) {
            throw new InvalidDimensionException("Invalid dimension");
        }
        this.value = value;
    }
}
