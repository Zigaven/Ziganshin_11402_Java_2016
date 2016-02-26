package Task002;

/**
 * Created by ruslanzigansin on 25.02.16.
 */
public class Matrix2x2 {
    private double[][] m;

    public Matrix2x2() {
        m = new double[2][2];
    }

    public Matrix2x2(double s) {
        this();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = s;
            }
        }
    }

    public Matrix2x2(double[][] matrix) {
        m = matrix;
    }

    public Matrix2x2(double a, double b, double c, double d) {
        m = new double[][]{{a, b}, {c, d}};
    }

    public double[][] getMatrix() {
        return m;

    }

    public Matrix2x2 add(Matrix2x2 matrix) {
        double[][] arr = matrix.getMatrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] += m[i][j];
            }
        }
        return new Matrix2x2(arr);
    }

    public void add2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] += matrix.getMatrix()[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 matrix) {
        double[][] arr = m;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] -= matrix.getMatrix()[i][j];
            }
        }
        return new Matrix2x2(arr);
    }

    public void sub2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] -= matrix.getMatrix()[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double k) {
        double[][] arr = m;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] *= k;
            }
        }
        return new Matrix2x2(arr);
    }

    public void multNumber2(double k) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] *= k;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 matrix) {
       double[][] arr = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] += m[i][k] * matrix.m[k][j];
                }
            }
        }
        return new Matrix2x2(arr);

    }

    public void mult2(Matrix2x2 matrix) {
        Matrix2x2 res = mult(matrix);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = res.m[i][j];
            }
        }
    }

    public double det() {
        double matrix = (this.m[0][0] * this.m[1][1] - this.m[0][1] * this.m[1][0]);
        return matrix;
    }

    public void transpon() {
        double u = m[1][1];
        m[1][1] = m[0][1];
        m[0][1] = m[0][0];
        m[0][0] = m[1][0];
        m[1][0] = u;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 matrix = new Matrix2x2();
        double q = det();
        if (q != 0) {
            matrix.m[0][0] = m[1][1];
            matrix.m[0][1] = -m[1][0];
            matrix.m[1][0] = -m[1][0];
            matrix.m[1][1] = m[0][0];
            matrix.multNumber(1 / q);
            transpon();
        }
        return matrix;
    }

    public Matrix2x2 equivalentDiagonal() {
        this.m[1][0]-=this.m[1][0]*this.m[0][0];
        this.m[0][1]-=this.m[0][1]*this.m[1][1];


        return this;
    }


}
