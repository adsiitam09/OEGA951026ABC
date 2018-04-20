package mx.com.itam.adsi.ejercicio;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPrincipal {
    private final static Logger LOG = Logger.getLogger(TestPrincipal.class);
    
    
    private Solucion s = new Solucion();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    public void isCorrectCalcTest() {
        String val="";
        LOG.info("Ejecutando la prueba");
        
        val="A-->B-->C";
	Solucion.Node a = new Node("A");
	Solucion.Node b = new Node("B");
	Solucion.Node c = new Node("C");
	a.next = b;
	b.next = c;
        assertTrue("Calculo para '"+val+"':", calc(a));
    }
    
    private boolean calc(String resp, Node a) {
        String calc = a.prnt();
        System.out.println(calc);
        return resp==calc;
    }

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
