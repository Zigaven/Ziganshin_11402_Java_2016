package Task003;

import Task002.Matrix2x2Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ComplexMatrix2x2Test {
    ComplexNumber cn;
    ComplexMatrix2x2 cm;

    @Before
    public void createNullComplexNumber() {
        cn = mock(ComplexNumber.class);
        when(cn.getIm()).thenReturn(0.0);
        when(cn.getReal()).thenReturn(0.0);
        when(cn.add(cn)).thenReturn(cn);
        when(cn.sub(cn)).thenReturn(cn);
        when(cn.mult(cn)).thenReturn(cn);
        cm = mock(ComplexMatrix2x2.class);
        when(cm.getMatrix()).thenReturn(new ComplexNumber[][]{{cn, cn}, {cn, cn}});
    }

    @Test
    public void defaultConstructorShouldBeNullMatrix() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertTrue(m.getMatrix()[i][j].equals(cn));
            }
        }
    }

    @Test
    public void operationAddShouldWorkCorrect() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        cm.add(this.cm);
        Assert.assertTrue(cm.equals(this.cm));
    }

    @Test
    public void operationMultShouldWorkCorrect() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        cm.mult(this.cm);
        Assert.assertTrue(cm.equals(this.cm));
    }

    @Test
    public void operationDetShouldWorkCorrect() {
        ComplexNumber n1 = mock(ComplexNumber.class);
        when(n1.getIm()).thenReturn(0.0);
        when(n1.getReal()).thenReturn(1.0);
        when(n1.add(cn)).thenReturn(n1);
        when(n1.sub(cn)).thenReturn(n1);
        when(n1.mult(cn)).thenReturn(cn);
        when(n1.mult(n1)).thenReturn(n1);


    }

}
