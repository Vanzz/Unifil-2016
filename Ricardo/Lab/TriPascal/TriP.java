
/**
 * Escreva a descrição da classe TriP aqui.
 * 
 * @author Tiago Vansan Ketzer de Souza
 */
public class TriP
{
    
    /**
     * Método que resolve o binômio de Newton
     * @param n - primeiro número do binomio; k - segundo número do binomio
     * @return resultado da equação
     */
    public static int resolverBinomio (int n, int k) {
        if(n == k) return 1;
        if(k == 0) return 1;
        
        return fatorial(n) / ((fatorial(k))*(fatorial(n - k)));
    }
    
    public static int resolverBinomioPascal (int n, int k) {
        if(n == k) return 1;
        if(k == 0) return 1;
        
        return resolverBinomio(n - 1, k -1) + resolverBinomio(n - 1, k);
    }
    
    /**
     * Método que resolve fatorial
     * @param nP - número a ser fatorado
     * @return o resultado da fatoração
     */
    public static int fatorial(int nP) {
        int n = nP;
        int resultado = 1;
        while(n > 0)
        {
            resultado *= n;
            n--;
        }
        return resultado;
    }
}
