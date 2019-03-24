package shapes;

class Square implements Shapes {

    private final Rectangle rectangle;

    Square(Dimension side) {
        rectangle = new Rectangle(side, side);
    }

    public Double calculateArea() {
        return rectangle.calculateArea();
    }

    public Double calculatePerimeter() {
        return rectangle.calculatePerimeter();
    }
}
