package comparisonNewApproach;

enum LengthUnits {
    MM(1.0),
    CM(10.0),
    INCH(25.0),
    FEET(300.0),
    METER(1000.0);

    private final Double ratio;

    LengthUnits(Double ratio) {
        this.ratio = ratio;
    }

    public Double getRatio() {
        return ratio;
    }
}
