

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste TriPTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class TriPTest
{
    /**
     * Construtor default para a classe de teste TriPTest
     */
    public TriPTest()
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
    public void testeBinom() {
        TriP tP = new TriP();
        
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j <= i; j++) {
                tP.resolverBinomioPascal(i, j);
            }
        }
    }
    
    @Test
    public void testeFat() {
        TriP tP = new TriP();
        
        for (int i = 0; i < 1000; i++) {
            tP.fatorial(i);
        }
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
}
