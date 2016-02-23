import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrincipalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FibonnaciTest
{
    /**
     * Default constructor for test class PrincipalTest
     */
    public void FibonacciTest()
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
    public void fibTest()
    {
        assertEquals("Erro no fib(0)", 0, Fibonacci.fib(0));
        assertEquals("Erro no fib(1)", 1, Fibonacci.fib(1));
        assertEquals("Erro no fib(2)", 1, Fibonacci.fib(2));
        assertEquals("Erro no fib(3)", 2, Fibonacci.fib(3));
        assertEquals("Erro no fib(4)", 3, Fibonacci.fib(4));
        assertEquals("Erro no fib(5)", 5, Fibonacci.fib(5));
        assertEquals("Erro no fib(6)", 8, Fibonacci.fib(6));
        assertEquals("Erro no fib(24)", 46368, Fibonacci.fib(24));
    }
    
    @Test
    public void palinTest()
    {
        Principal p = new Principal();
        
        assertEquals(true, p.isPalindromo("OTO COME DOCE SECO DE MOCOTO"));
        assertEquals(true, p.isPalindromo("IRENE RI"));
        assertEquals(true, p.isPalindromo("RITA, ATIR ,"));
        assertEquals(true, p.isPalindromo("OMISSISSIMO!"));
        assertEquals(true, p.isPalindromo("AMORE, ROMA"));
        assertEquals(true, p.isPalindromo("Are we not pure? 'No, sir!' Panama's moody Noriega brags. 'It is garbage!' Irony dooms a man - a prisoner up to new era."));
        assertEquals(true, p.isPalindromo("Taco cat"));
        assertEquals(true, p.isPalindromo("Was it a car or a cat I saw"));
        assertEquals(true, p.isPalindromo("Murder for a jar of red rum."));
        assertEquals(true, p.isPalindromo("DA1001!?.,- AD"));
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
