

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste BuscasTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class BuscasTest
{
    /**
     * Construtor default para a classe de teste BuscasTest
     */
    public BuscasTest()
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
    public void testeBuscaSeq() {
        int v1[] = {0,5,10};
        int v2[] = {10,20,30,40,50,60,70,80,90,100,110};
        int v3[] = {2,4,6,8,10,12,14,16,18,20,22};
        int v4[] = {1,2,3,4,5,6,7,8,9,10,11};
        int v5[] = {10,11,12,13,14,15,16,17,18,19,10}; //Com erro
        
        assertEquals("Número não existe", -1, Buscas.buscaSeq(v1, 4));
        assertEquals("Número não existe", 6, Buscas.buscaSeq(v2, 70));
        assertEquals("Número não existe", 0, Buscas.buscaSeq(v3, 2));
        assertEquals("Número não existe", 10, Buscas.buscaSeq(v4, 11));
        assertEquals("Número não existe", 0, Buscas.buscaSeq(v5, 10));
    }
    
    @Test
    public void testeBuscaBin() {
        int v1[] = {0,5,10};
        int v2[] = {10,20,30,40,50,60,70,80,90,100,110};
        int v3[] = {2,4,6,8,10,12,14,16,18,20,22};
        int v4[] = {1,2,3,4,5,6,7,8,9,10,11};
        int v5[] = {10,11,12,13,14,15,16,17,18,19,10}; //Com erro
        
        assertEquals("Número não existe", -1, Buscas.buscaSeq(v1, 4));
        assertEquals("Número não existe", 6, Buscas.buscaSeq(v2, 70));
        assertEquals("Número não existe", 0, Buscas.buscaSeq(v3, 2));
        assertEquals("Número não existe", 10, Buscas.buscaSeq(v4, 11));
        assertEquals("Número não existe", 0, Buscas.buscaSeq(v5, 10));
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
