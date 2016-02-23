
/**
 * Classe com os métodos que resolvem os exercicios propostos pela
 * Lista de Atividades
 * @author Gabriel Praxedes 
 * @version 24022015
 */
public class Fibonacci
{
    // Padrão do código, forma de criá-lo

    /**
     * Constructor for objects of class Principal
     */
    public Fibonacci()
    {
        // initialise instance variables
       
    }

    /**
     * Calcula o numero de fibonacci
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int fib(int n)
    {
        if(n ==0)
        {
            return 0;
        }
        else if(n ==1)
        {
            return 1;
        }
        
        int anterior = 0;
        int atual = 1;
        
        for(int i=1;i < n; i++)
        {
            int novo = anterior + atual;
            anterior = atual;
            atual = novo;
        }
        return atual;
    }
        
}
