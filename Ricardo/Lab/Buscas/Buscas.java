public class Buscas
{
    /**
     * Método de busca sequencial
     * @param a - arranjo a ser buscado; n - número a ser encontrado
     * @return posição do n
     */
    public static int buscaSeq(int a[], int n){
        for(int i = 0; i < a.length; i++) {
            if(a[i] == n) return i;
        }
        return -1;
    }
    
    /**
     * Método de busca binário
     * @param a - arranjo a ser buscado; n - número a ser encontrado
     * @return posição do n
     */
    public static int buscaBin(int a[], int n){
        int esq = 0; int dir = a.length;
        do{
            int meio = (dir + esq)/2;
            if(a[meio] == n) return meio;
            else if (a[meio] < n) esq = meio + 1;
            else dir = meio;
        }while(dir - esq > 0);
        return -1;
    }
}