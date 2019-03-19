package shapes;

public class Rectangle implements Shapes {
    private final Dimension length;
    private final Dimension breadth;

    Rectangle(Dimension length, Dimension breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public Double calculateArea() {
        return this.length.getValue() * this.breadth.getValue();
    }

    public Double calculatePerimeter(){
        return 2*(this.length.getValue()+this.breadth.getValue());
    }
}
