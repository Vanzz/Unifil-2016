import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste AquecimentoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class AquecimentoTest
{
    /**
     * Construtor default para a classe de teste AquecimentoTest
     */
    public AquecimentoTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
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
        
        assertEquals("umZero ERRO", 0, Aquecimento.somatoria(umZero));
        assertEquals("doisZero ERRO", 0, Aquecimento.somatoria(doisZeros));
        assertEquals("variosZero ERRO", 0, Aquecimento.somatoria(variosZeros));
        assertEquals("teste1 ERRO", 6, Aquecimento.somatoria(teste2));
        assertEquals("teste2 ERRO", 1000, Aquecimento.somatoria(teste1));
        assertEquals("teste3 ERRO", -3, Aquecimento.somatoria(teste3));
    }
    
    @Test
    public void fibonacciTest ()
    {
        assertEquals(0 , Aquecimento.fibonacci(0));
        assertEquals(1 , Aquecimento.fibonacci(1));
        assertEquals(1 , Aquecimento.fibonacci(2));
        assertEquals(2 , Aquecimento.fibonacci(3));
        assertEquals(3 , Aquecimento.fibonacci(4));
        assertEquals(5 , Aquecimento.fibonacci(5));
        assertEquals(8 , Aquecimento.fibonacci(6));
        assertEquals(13 , Aquecimento.fibonacci(7));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Teste()
    {
    }
}

