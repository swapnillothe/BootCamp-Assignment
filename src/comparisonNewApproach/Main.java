package comparisonNewApproach;

public class Main {
    public static void main(String[] args) {
        Length twoInch = new Length(2.0, LengthUnits.INCH);
        Length twoPointFiveCm = new Length(2.5, LengthUnits.CM);

        Length actualOutput = twoInch.addTo(twoPointFiveCm, LengthUnits.INCH);
        Length expectedOutput = new Length(3.0, LengthUnits.INCH);
        System.out.println(actualOutput + "   " + expectedOutput);
    }
}
