package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double lendth, double width, double height) {
        setLength(lendth);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (length > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

    }

    private void setHeight(double height) {
        if (length > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }

    }

    public double calculateSurfaceArea() {
        return ((2 * (this.length * this.width)) + (2 * (this.width * this.height)) + (2 * (this.length * this.height)));
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
