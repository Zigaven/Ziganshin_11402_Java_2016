package Task009;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ComplexMatrix2x2 {
    private ComplexNumber[][] cn = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber cn) {
        this(cn, cn, cn, cn);
    }

    public ComplexNumber[][] getMatrix() {
        return cn;
    }

    public ComplexMatrix2x2(ComplexNumber z, ComplexNumber x, ComplexNumber c, ComplexNumber v) {
        this.cn[0][0] = z;
        this.cn[0][1] = x;
        this.cn[1][0] = c;
        this.cn[1][1] = v;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 cm) {
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                cm2.cn[i][j] = this.cn[i][j].add(cm.getMatrix()[i][j]);
            }
        }
        return cm2;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 cm) {
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    cm2.cn[i][j] = cm2.cn[i][j].add(this.cn[i][j].mult(cm.getMatrix()[i][j]));
                }
            }
        }
        return cm2;
    }

    public ComplexNumber det() {
        return (this.cn[0][0].mult(this.cn[1][1])).sub(this.cn[0][1].mult(this.cn[1][0]));
    }

    public boolean equals(ComplexMatrix2x2 matrix) {
        if (matrix == null)
            return false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!cn[i][j].equals(matrix.getMatrix()[i][j]))
                    return false;
            }
        }
        return true;
    }


}
