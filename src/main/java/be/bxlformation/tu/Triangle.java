package be.bxlformation.tu;

public class Triangle {

    private int A;

    private int B;

    private int C;

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public void createTriangle(int a, int b, int c) throws TriangleException {
        if (a == 0 || b == 0 || c == 0) throw new TriangleException("Un des côtés vaut 0");
        if (a < 0 || b < 0 || c < 0) throw new TriangleException("Un des côté à une longueur négative");
        if (sommeDeDeuxCotesVautLeTroisieme()) throw new TriangleException("La somme de 2 côtés vaut le troisième côté");
        if (sommeDeDeuxCotesEstInferieurAuTroisieme()) throw new TriangleException("La somme de 2 côtés est inférieure au troisième côté");
    }

    private boolean sommeDeDeuxCotesEstInferieurAuTroisieme() {
        return A + B < C || A + C < B || B + C < A;
    }

    private boolean sommeDeDeuxCotesVautLeTroisieme() {
        return A + B == C || A + C == B || B + C == A;
    }
}
