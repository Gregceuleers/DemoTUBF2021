package be.bxlformation.tu;

public class Calculation {

    private int C;
    private int B;
    private int A;

    public int addition(int a, int b) {
        return a + b;
    }

    public int divide(int i, int i1) {
        return i / i1;
    }

    public Calculation setA(int a) {
        A = a;
        return this;
    }

    public int getA() {
        return A;
    }

    public Calculation setB(int i) {
        B = i;
        return this;
    }

    public int getB() {
        return B;
    }

    public Calculation setC(int i) {
        C = i;
        return this;
    }

    public int getC() {
        return C;
    }

    public void createTriangle(int a, int b, int c) throws TriangleException {
    }
}
