package be.bxlformation.tu.exercices;

public class TriangleBF {

    private int C;
    private int B;
    private int A;

    public void setA(int a) {
        this.A = a;
    }

    public void setB(int b) {
        this.B = b;
    }

    public void setC(int c) {
        this.C = c;
    }

    public int getC() {
        return C;
    }

    public int getB() {
        return B;
    }

    public int getA() {
        return A;
    }

    public String checkValidity(int a, int b, int c) throws TriangleBFException {
        if (a == 0 || b == 0 || c == 0) throw new TriangleBFException("Un des 3 côtés vaut 0");
        if (a < 0 || b < 0 || c < 0) throw new TriangleBFException("Un des côtés est négatif");
        if (a + b < c || a + c < b || b + c < a) throw new TriangleBFException("La somme de deux côtés est inférieure au troisième");
        if (a + b == c || a + c == b || b + c == a) throw new TriangleBFException("La somme de deux côtés vaut le troisième");
        if (a == c && c == b) return "équilatéral";
        if (a == b || a == c || b == c) return  "isocèle";
        return "scalène";
    }

    public static void main(String[] args) {
        TriangleBF triangleBF = new TriangleBF();
        triangleBF.setA(5);
        triangleBF.setB(5);
        triangleBF.setC(9);
        try {
            System.out.println(triangleBF.checkValidity(triangleBF.getA(), triangleBF.getB(),triangleBF.getC()));
        } catch (TriangleBFException e) {
            e.printStackTrace();
        }
    }
}
