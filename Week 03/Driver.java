class Point {
    int x, y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point p = (Point) obj;
        return x == p.x && y == p.y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Driver {
    public static void main(String[] args) {

        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4)
        };

        System.out.println("Points:");
        for (Point p : points) {
            System.out.println(p);
        }

        int distinct = 0;
        int repeats = 0;

        for (int i = 0; i < points.length; i++) {
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    found = true;
                    repeats++;
                    break;
                }
            }

            if (!found) {
                distinct++;
            }
        }

        System.out.println("Repeated points: " + repeats);
        System.out.println("Distinct: " + distinct);
    }
}