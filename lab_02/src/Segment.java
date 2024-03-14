public class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        // Перевірка на виродженість відрізка
        if (start.equals(end)) {
            throw new IllegalArgumentException("Початок та кінець відрізка не можуть бути однаковими точками.");
        }

        this.start = start;
        this.end = end;
    }

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    public Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        // Перевірка на паралельність відрізків
        if (denominator == 0) {
            return null;
        }

        double intersectionX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double intersectionY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        // Перевірка, чи точка перетину знаходиться на відрізках
        if (intersectionX < Math.min(x1, x2) || intersectionX > Math.max(x1, x2) ||
                intersectionX < Math.min(x3, x4) || intersectionX > Math.max(x3, x4) ||
                intersectionY < Math.min(y1, y2) || intersectionY > Math.max(y1, y2) ||
                intersectionY < Math.min(y3, y4) || intersectionY > Math.max(y3, y4)) {
            return null;
        }

        return new Point(intersectionX, intersectionY);
    }

    public static void main(String[] args) {
        Point startPoint1 = new Point(3, 5);
        Point endPoint1 = new Point(3, 0);
        Segment segment1 = new Segment(startPoint1, endPoint1);

        Point startPoint2 = new Point(0, 10);
        Point endPoint2 = new Point(10, 20);
        Segment segment2 = new Segment(startPoint2, endPoint2);

        System.out.println("Довжина відрізка: " + segment1.length());
        System.out.println("Середня точка відрізка: " + segment1.middle());
        Point intersectionPoint = segment1.intersection(segment2);
        if (intersectionPoint != null) {
            System.out.println("Точка перетину: " + intersectionPoint);
        } else {
            System.out.println("Відрізки не перетинаються.");
        }
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
