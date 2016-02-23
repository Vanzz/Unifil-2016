/**
 * Primeira aula de Lab. II
 * Coleção de soluções para o Exercício 0.
 * 
 * @author Tiago Vansan Ketzer de Souza
 * @version 23/02/2016
 */
public class Aquecimento
{
    /**
     * Calcula a somatória de um vetor dado.
     * 
     * @param valores vetor dado.
     * @return a soma dos números do vetor.
     */
    public static int somatoria (int [] valores)
    {
        int soma = 0;
        
        for(int i = 0; i <= valores.length - 1; i++)
        {
            soma += valores[i];
        }
        
        System.out.println(soma);
        
        return soma;
    }
    
    /**
     * Calcula a enésima geração de fibonacci;
     * 
     * @param valor a geração de fibonacci
     * @return quantidade de membros na determinada geração
     */
    public static int fibonacci (int valor)
    {
        if (valor == 0)
            return 0;
        if (valor == 1)
            return 1;
            
        return fibonacci(valor - 1) + fibonacci(valor - 2);
    }
}
