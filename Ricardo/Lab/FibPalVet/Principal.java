/**
 * Primeira aula de Lab. II
 * Coleção de soluções para o Exercício 0.
 * 
 * @author Tiago Vansan Ketzer de Souza
 * @version 23/02/2016
 */
public class Principal
{
    /**
     * Calcula a somatória de um vetor dado.
     * 
     * @param valores vetor dado.
     * @return a soma dos números do vetor.
     */
    public static int somatoria(int v[])
    {
        int somaVetor = 0;

        for( int i = 0; i < v.length; i++)
        {
            somaVetor += v[i];
        }

        System.out.println("A soma dos elementos do vetor é: "+ somaVetor);

        return somaVetor;
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

    /**
     * Verifica se a palavra dada é um palíndromo
     * 
     * @param palavra1 palavra a verificar
     * @return se é ou não palíndromo
     */
    public static boolean isPalindromo(String palavra1)
    {
        String resultado = ""; 

        String palavra = limparString(palavra1);

        for(int x = palavra.length() - 1; x >= 0; x--)
        {
            resultado += palavra.charAt(x);
        }
        if(resultado.equals(palavra))
        {
            System.out.println("A palavra "+palavra1+ " é um palíndromo.");
            return true;
        }
        else
        {
            System.out.println("A palavra "+palavra1+ " não é um palíndromo.");
            return false;
        }
    }
    
    /**
     * Verifica se a palavra é um palíndromo
     * 
     * @param palavra1 palavra a ser verificada
     * @return se é ou não palíndromo
     */
    public static boolean verificaPalindromo(String palavra1)
    {
        String resultado = ""; 

        String palavra = limparString(palavra1);

        for(int x = palavra.length() - 1; x >= 0; x--)
        {
            resultado += palavra.charAt(x);
        }
        
        if(resultado.equals(palavra)) return true;
        
        return false;
    }
    
    /**
     * Método que imprime se a palvrar for um palíndromo
     * faz sua verificação através do metódo {@link #verificaPalindromo(String) verificaPalindromo}
     * 
     * @param palavra1 palavra a ser impressa
     * @return retorna se é um palíndromo
     */
    public static boolean printaPalindromo(String palavra1)
    {
        if(verificaPalindromo(palavra1)) 
            System.out.println("A palavra "+palavra1+ " é um palíndromo.");
        return verificaPalindromo(palavra1);
    }
    
    /**
     * Verifica um vetor as palavras que são palíndromos
     * passando para outro método {@link #printaPalindromo(String) printaPalindromo}
     * para fazer a sua verificação.
     * 
     * @param vetorString um array de strings
     * @return um vetor de boolean com os resultados dos teste
     */
    public static boolean [] isPalindromoVetor(String [] vetorString)
    {
        boolean [] result = new boolean [vetorString.length];
        for (int i = 0; i <= vetorString.length - 1; i++)
        {
            result[i] = printaPalindromo(vetorString[i]);
        }
        return result;
    }

    /**
     * Classe responsável por limpar a String
     * 
     * @param palavra1 palavra a ser limpa
     * @return a palavra limpa e minúscula (padrão)
     */
    public static String limparString(String palavra1)
    {
        //         String palavra = palavra1.replaceAll("\\s", "");
        //         palavra = palavra.replaceAll("!","");
        //         palavra = palavra.replaceAll("'","");
        //         palavra = palavra.replaceAll("-","");
        //         palavra = palavra.replaceAll(",","");
        //         palavra = palavra.replaceAll("\\.","");
        //         palavra = palavra.replaceAll("\\?","");
        String palavra = palavra1.replaceAll("\\W","");
        return palavra.toLowerCase();
    }

    /**
     * Verifica quais números são palíndromos até 10k
     */
    public static void dezMil()
    {
        int n = 1;

        while (n < 10001) 
        {
            String palindromo= "";

            if ((n%2) == 0)
            {
                String p = Integer.toString(n);  

                for(int i = p.length() -1; i >= 0; i--) 
                {
                    palindromo += p.charAt(i);
                }

                if(palindromo.equals(p))
                {
                    System.out.println(p);
                }
            }

            n += 1;
        }
    }
}

