package XOView.model;

public class User {
    private static Point point;

    public static void setPoint(Point point) {
        User.point = point;
    }

    public Point getShootPoint() {
        return point;
    }
}
