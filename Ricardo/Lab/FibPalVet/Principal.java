
/**
 * Escreva a descrição da classe Principal aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Principal
{
    public static int vetor(int v[])
    {
        int somaVetor = 0;
        
        for( int i = 0; i < v.length; i++)
        {
            somaVetor += v[i];
        }
        
        System.out.println("A soma dos elementos do vetor é: "+ somaVetor);
        
        return somaVetor;
    }
    
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
    
    //Todos números palíndromos até 10k
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

