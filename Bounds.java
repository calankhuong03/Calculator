// This class will define two x bounds for a f(x) equation
public class Bounds {
    private int x1;
    private int x2;

    public Bounds() {
        this.x1 = 0;
        this.x2 = 0;
    }
    public Bounds(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    // Mutators ----- some of these aren't used in the MyClassClient
    public void changeX1(int x1) {
        this.x1 = x1;
    }
    public void changeX2(int x2) {
        this.x2 = x2;
    }
    public void changeBounds(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    public void shiftBounds(int shift) {
        this.x1 += shift;
        this.x2 += shift;
    }
    // Access
    public String toString() {
        return "(" + this.x1 + ", " + this.x2 + ")";
    }
    public int getx1() {
        return x1;
    }
    public int getx2() {
        return x2;
    }

}