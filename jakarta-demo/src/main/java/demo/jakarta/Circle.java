package demo.jakarta;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

/**
 * A circle in a Jakarta project. The annotations on the fields are the rules; a validator reports
 * violations, so the constructor accepts any value and does not throw.
 */
public class Circle {

    @Min(0) @Max(1000) private final int x;
    @Min(0) @Max(1000) private final int y;
    @Positive private final double radius;

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public double getRadius() { return radius; }

    public double area() { return Math.PI * radius * radius; }

    public double perimeter() { return 2 * Math.PI * radius; }

    public double diameter() { return 2 * radius; }

    public boolean contains(int px, int py) {
        double dx = px - x;
        double dy = py - y;
        return Math.sqrt(dx * dx + dy * dy) <= radius;
    }
}
