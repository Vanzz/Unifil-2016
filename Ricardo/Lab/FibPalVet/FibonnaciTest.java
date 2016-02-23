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
        
        p.isPalindromo("OTO COME DOCE SECO DE MOCOTO");
        p.isPalindromo("IRENE RI");
        p.isPalindromo("RITA, ATIR ,");
        p.isPalindromo("OMISSISSIMO!");
        p.isPalindromo("AMORE, ROMA");
        p.isPalindromo("Are we not pure? 'No, sir!' Panama's moody Noriega brags. 'It is garbage!' Irony dooms a man - a prisoner up to new era.");
        p.isPalindromo("Taco cat");
        p.isPalindromo("Was it a car or a cat I saw");
        p.isPalindromo("Murder for a jar of red rum.");
        p.isPalindromo("DA1001!?.,- AD");
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
