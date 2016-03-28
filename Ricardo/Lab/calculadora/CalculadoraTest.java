

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalculadoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest
{
    /**
     * Default constructor for test class CalculadoraTest
     */
    public CalculadoraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void calcularTest() {
        assertEquals("Erro no conta0.txt", Calculadora.calcular("conta0.txt"), 0);
        assertEquals("Erro no conta1.txt", Calculadora.calcular("conta1.txt"), 25);
        assertEquals("Erro no conta2.txt", Calculadora.calcular("conta2.txt"), 5);
        assertEquals("Erro no conta3.txt", Calculadora.calcular("conta3.txt"), -5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
