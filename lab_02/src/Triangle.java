public class Triangle {
    private MyPoint vertex1;
    private MyPoint vertex2;
    private MyPoint vertex3;

    public Triangle(MyPoint vertex1, MyPoint vertex2, MyPoint vertex3) {
        // Перевірка на виродженість трикутника
        if (areVerticesCollinear(vertex1, vertex2, vertex3)) {
            throw new IllegalArgumentException("Трикутник не може бути виродженим.");
        }

        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    public double area() {
        // Використовуємо формулу Герона для обчислення площі трикутника
        double side1 = vertex1.distanceTo(vertex2);
        double side2 = vertex2.distanceTo(vertex3);
        double side3 = vertex3.distanceTo(vertex1);
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public MyPoint centroid() {
        // Обчислення координат центроїда
        double centroidX = (vertex1.getX() + vertex2.getX() + vertex3.getX()) / 3;
        double centroidY = (vertex1.getY() + vertex2.getY() + vertex3.getY()) / 3;
        return new MyPoint(centroidX, centroidY);
    }

    private boolean areVerticesCollinear(MyPoint p1, MyPoint p2, MyPoint p3) {
        // Перевірка, чи точки є колінеарними (лежать на одній прямій)
        return Math.abs((p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) -
                (p3.getY() - p2.getY()) * (p2.getX() - p1.getX())) < 1e-6;
    }

    public static void main(String[] args) {
        MyPoint vertex1 = new MyPoint(0, 0);
        MyPoint vertex2 = new MyPoint(10, 0);
        MyPoint vertex3 = new MyPoint(2, 3);
        Triangle triangle = new Triangle(vertex1, vertex2, vertex3);

        System.out.println("Площа трикутника: " + triangle.area());
        System.out.println("Центроїд трикутника: " + triangle.centroid());
    }
}

class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(MyPoint other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
