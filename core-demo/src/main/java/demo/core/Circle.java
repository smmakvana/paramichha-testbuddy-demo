package demo.core;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

/**
 * A circle in a core library, with no validation provider on the classpath.
 *
 * <p>The annotations on the fields describe the rules. The constructor enforces them, so a value
 * outside a rule throws {@link IllegalArgumentException}, which is what the generated tests expect.
 */
public class Circle {

    @Min(0) @Max(1000) private final int x;
    @Min(0) @Max(1000) private final int y;
    @Positive private final double radius;

    public Circle(int x, int y, double radius) {
        if (x < 0 || x > 1000) throw new IllegalArgumentException("x must be between 0 and 1000, was " + x);
        if (y < 0 || y > 1000) throw new IllegalArgumentException("y must be between 0 and 1000, was " + y);
        if (radius <= 0) throw new IllegalArgumentException("radius must be positive, was " + radius);
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
