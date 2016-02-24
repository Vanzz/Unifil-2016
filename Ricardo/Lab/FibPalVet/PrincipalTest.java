import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * The test class PrincipalTest.
 *
 * @author  Tiago Vansan Ketzer de Souza
 * @version 24/02/2016
 */
public class PrincipalTest
{
    /**
     * Default constructor for test class PrincipalTest
     */
    public void principalTest()
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
    public void somatoriaVariadosTest ()
    {
        int umZero[] = {0};
        int doisZeros[] = {0,0};
        int variosZeros[] = {0,0,0,0};
        int teste1[] = {0,1000};
        int teste2[] = {1, 2, 3};
        int teste3[] = {0,-1,2,-3, 4, -5};
        
        assertEquals("umZero ERRO", 0, Principal.somatoria(umZero));
        assertEquals("doisZero ERRO", 0, Principal.somatoria(doisZeros));
        assertEquals("variosZero ERRO", 0, Principal.somatoria(variosZeros));
        assertEquals("teste1 ERRO", 6, Principal.somatoria(teste2));
        assertEquals("teste2 ERRO", 1000, Principal.somatoria(teste1));
        assertEquals("teste3 ERRO", -3, Principal.somatoria(teste3));
    }
    
    @Test
    public void fibTest()
    {
        assertEquals("Erro no fib(0)", 0, Principal.fibonacci(0));
        assertEquals("Erro no fib(1)", 1, Principal.fibonacci(1));
        assertEquals("Erro no fib(2)", 1, Principal.fibonacci(2));
        assertEquals("Erro no fib(3)", 2, Principal.fibonacci(3));
        assertEquals("Erro no fib(4)", 3, Principal.fibonacci(4));
        assertEquals("Erro no fib(5)", 5, Principal.fibonacci(5));
        assertEquals("Erro no fib(6)", 8, Principal.fibonacci(6));
        assertEquals("Erro no fib(24)", 46368, Principal.fibonacci(24));
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
    
    @Test
    public void vetorPalinTest()
    {
        String v1[] = {"OTO COME DOCE SECO DE MOCOTO", "IRENE RI" , 
            "Taco cat", "Are we not pure? 'No, sir!' Panama's moody Noriega brags. 'It is garbage!' Irony dooms a man - a prisoner up to new era.", 
            "OLAR", "COMO VAI VOSE"};
        boolean a1[] = {true, true, true, true, false, false};
        
        assertTrue(Arrays.equals(a1, Principal.isPalindromoVetor(v1)));
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
