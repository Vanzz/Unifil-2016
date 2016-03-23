
/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci
{
    public static int fib(int g) {
        int anterior = 0;
        int atual = 1;
        
        g--;
        while(g >= 0) {
            int prox = anterior + atual;
            anterior = atual;
            atual = prox;
            g--;
        }
        
        return anterior;
    }
    
    public static int rec_fib(int g) {
        // Casos base
        if (g == 0) {
            return 0;
        }
        else if (g == 1) {
            return 1;
        }
        
        // Definição recursiva
        return rec_fib(g-1) + rec_fib(g-2);
    }
    
    /***
     * Busca um elemento em um arranjo
     * @param arr Arranjo a ser buscado.
     * @param val valor buscado no arranjo.
     * @return Índice de val em arr, ou -1 caso não encontre
     */
    public static int buscaPos(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        
        return -1;
    }
    
    /***
     * Busca, recursivamente, um elemento em um arranjo
     * @param arr Arranjo a ser buscado.
     * @param val valor buscado no arranjo.
     * @return Índice de val em arr, ou -1 caso não encontre
     */
    public static int buscaPos_rec(int[] arr, int val) {
        return buscaPos_recHelper(arr, val, 0);
    }
    
    private static int buscaPos_recHelper(int[] arr, int val, int i) {
        // Casos base
        // 1º caso: já procurei o arranjo inteiro e não achei
        if (i == arr.length) {
            return -1;
        }
        // 2º caso: encontrei val no índice "x"
        else if (arr[i] == val) {
            return i;
        }
        
        // Definição de subdivisão (recursiva)
        return buscaPos_recHelper(arr, val, i+1);
    }
    
    /**
     * Encontra o maior elemento no arranjo.
     * @param arr Arranjo onde se dará a busca.
     * @return Maior elemento encontrado.
     */
    public static int buscaMax_rec(int[] arr) {
        // Casos base
        
        // Definição recursiva
        return 0;
    }
    
    /**
     * Encontra o menor elemento no arranjo.
     * @param arr Arranjo onde se dará a busca.
     * @return Menor elemento encontrado.
     */
    public static int buscaMin_rec(int[] arr) {
        // Casos base
        
        // Definição recursiva
        return 0;
    }
}
