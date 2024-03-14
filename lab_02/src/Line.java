public class Line {
    private double k;
    private double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line otherLine) {
        // Обчислення координат точки перетину
        double x = (otherLine.b - this.b) / (this.k - otherLine.k);
        double y = this.k * x + this.b;

        // Перевірка, чи лінії збігаються
        if (Double.isInfinite(x) || Double.isNaN(x) || Double.isInfinite(y) || Double.isNaN(y)) {
            return null;
        }

        // Перевірка, чи лінії паралельні (тобто не мають точок перетину)
        if (this.k == otherLine.k && this.b != otherLine.b) {
            return null;
        }

        // Повернення точки перетину
        return new Point(x, y);
    }

    public static void main(String[] args) {
        Line line1 = new Line(1, 1);
        Line line2 = new Line(-1, 3);

        Point intersectionPoint = line1.intersection(line2);
        if (intersectionPoint != null) {
            System.out.println("(" + intersectionPoint.getX() + ";" + intersectionPoint.getY() + ")");
        } else {
            System.out.println("Лінії збігаються або перетинаються.");
        }
    }
}

class Point1 {
    private double x;
    private double y;

    public Point1(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
