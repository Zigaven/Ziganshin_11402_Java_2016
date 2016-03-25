package Task009;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ComplexMatrix2x2Test {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("cm");
    ComplexNumber cn = (ComplexNumber) ac.getBean("cn");


    @Test
    public void defaultConstructorShouldBeNullMatrix() {
        ComplexMatrix2x2 m = (ComplexMatrix2x2) ac.getBean("test1");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertTrue(m.getMatrix()[i][j].equals(cn));
            }
        }
    }

    @Test
    public void operationAddShouldWorkCorrect() {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("test1");
        cm.add(this.cm);
        Assert.assertTrue(cm.equals(this.cm));
    }

    @Test
    public void operationMultShouldWorkCorrect() {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("test1");
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
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) ac.getBean("test1");
        Assert.assertTrue(cm.det().equals(cn));

    }

}

