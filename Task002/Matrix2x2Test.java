package Task002;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 25.02.16.
 */
public class Matrix2x2Test {
    public static final double EPS = 10e-6;

    @Test
    public void constructorShouldBeNullMatrix() {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(0, m.getMatrix()[i][j], EPS);

            }
        }
    }

    @Test
    public void constructorShouldBeWithSomeNumber() {
        Matrix2x2 m = new Matrix2x2(6);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(6, m.getMatrix()[i][j], EPS);

            }
        }
    }

    @Test
    public void constructorShouldBeMatrixFromArray() {
        double[][] arr = {{2, 3}, {4, 5}};
        Matrix2x2 m = new Matrix2x2(arr);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 2 + j + 2, m.getMatrix()[i][j], EPS);
            }

        }
    }

    @Test
    public void constuctorShoudBeMatrixFromNubmers() {
        Matrix2x2 m = new Matrix2x2(2, 3, 4, 5);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 2 + j + 2, m.getMatrix()[i][j], EPS);
            }

        }
    }

    @Test
    public void firstMatrixShouldAddSecondMatrix() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(4, 3, 2, 1);
        Matrix2x2 sum = m.add(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(5, sum.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void fristMatrixShouldAdd2SecondMatrix() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        m.add2(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 4 + j * 2 + 3, m.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void firstMatrixShouldSubSecondMatrix() {
        Matrix2x2 m = new Matrix2x2(4, 3, 2, 1);
        Matrix2x2 m2 = new Matrix2x2(1, 1, 1, 1);
        Matrix2x2 sub = m.sub(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * (-2) + j * (-1) + 3, sub.getMatrix()[i][j], EPS);
            }
        }
    }

    public void firstMatrixShouldSub2SecondMatrix() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        m.sub2(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 4 + j * 2 + 3, m.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void matrixShouldMultOnSomeNumber() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        int a = 5;
        Matrix2x2 multNumber = m.multNumber(a);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals((i * 2 + j + 1) * 5, multNumber.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void matrixShouldMult2OnSomeNumber() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        int a = 2;
        m.multNumber2(a);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals((i * 2 + j + 1) * 2, m.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void firstMatrixShouldMultOnTheSecondMatrix() {
        Matrix2x2 m = new Matrix2x2(2, 2, 2, 2);
        Matrix2x2 m2 = new Matrix2x2(3, 3, 3, 3);
        Matrix2x2 mult = m.mult(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Assert.assertEquals(12, mult.getMatrix()[i][j], EPS);
                }
            }
        }
    }

    @Test
    public void firstMatrixShouldMult2OnTheSecondMatrix() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        m.mult2(m2);
        Assert.assertEquals(10, m.getMatrix()[0][0], EPS);
        Assert.assertEquals(13, m.getMatrix()[0][1], EPS);
        Assert.assertEquals(22, m.getMatrix()[1][0], EPS);
        Assert.assertEquals(29, m.getMatrix()[1][1], EPS);

    }

    @Test
    public void detShouldReturnCorrectDeterminant() {
        Matrix2x2 m = new Matrix2x2(0, 1, 2, 3);
        Assert.assertEquals(-2, m.det(), EPS);
    }


    @Test
    public void transShouldTransportMatrixCorrect() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        m1.transpon();
        Assert.assertEquals(2, m1.getMatrix()[0][0], EPS);
        Assert.assertEquals(0, m1.getMatrix()[0][1], EPS);
        Assert.assertEquals(3, m1.getMatrix()[1][0], EPS);
        Assert.assertEquals(1, m1.getMatrix()[1][1], EPS);
    }


    @Test
    public void inverseMatrixShouldBeCountCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 2, 3);
        Matrix2x2 res = m1.inverseMatrix();
        Assert.assertEquals(-3, res.getMatrix()[0][0], EPS);
        Assert.assertEquals(2, res.getMatrix()[0][1], EPS);
        Assert.assertEquals(2, res.getMatrix()[1][0], EPS);
        Assert.assertEquals(-1, res.getMatrix()[1][1], EPS);


    }

    @Test
    public void inverseMatrixShouldReturnNullMatrixWhenDetIsNull() {
        Matrix2x2 matrix = new Matrix2x2(0, 0, 0, 1);
        Matrix2x2 result = matrix.inverseMatrix();
        Assert.assertEquals(0, result.getMatrix()[0][0], EPS);
        Assert.assertEquals(0, result.getMatrix()[0][1], EPS);
        Assert.assertEquals(0, result.getMatrix()[1][0], EPS);
        Assert.assertEquals(0, result.getMatrix()[1][1], EPS);


    }


    @Test
    public void diagonalMatrixShouldBeCountCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 0, 0, 1);
        Matrix2x2 res = m1.equivalentDiagonal();
        Assert.assertEquals(1, res.getMatrix()[0][0], EPS);
        Assert.assertEquals(0, res.getMatrix()[0][1], EPS);
        Assert.assertEquals(0, res.getMatrix()[1][0], EPS);
        Assert.assertEquals(1, res.getMatrix()[1][1], EPS);
    }

}
