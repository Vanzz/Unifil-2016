import java.util.Arrays;
/**
 * Escreva a descrição da classe Ordenar aqui.
 * 
 * @author Matheus Fávaro, Tiago Vansan Ketzer de Souza
 * @version (número de versão ou data)
 */
public class Ordenacoes{
    public void ordenarPorSelecao(int [] a){
        mostrar(a);
        for(int i = 0; i < a.length - 1; i++){
            int menor = i;
            for(int j = i; j < a.length; j++){
                if(a[j] < a[menor]){
                    menor = j;
                    mostrar(a);
                }
            }

            trocar(a, i, menor);
        }
        mostrar(a);
    }

    public void ordenarPorBolha(int [] a){
        mostrar(a);
        boolean troca = true;
        int j = 0;
        while(troca){
            troca = false;
            j++;
            for(int i = 0; i < a.length - j; i++){
                if(a[i] > a[i+1]){
                    trocar(a, i, i+1);
                    mostrar(a);
                    troca = true;
                }
            }
        }
        mostrar(a);
    }

    public int[] ordenarPorInsercaoCom2Arranjos(int[] monteComprado){
        int [] mao = new int[monteComprado.length];
        int cont = 0;
        for(int i = 0; i < monteComprado.length; i++){
            int j = i;
            mao[i] = monteComprado[i];
            cont++;
            while(j > 0 && monteComprado[i] < mao[j-1]){
                trocar(mao, j-1, j);
                j--;
                cont++;
            }
        }
        System.out.println("Ascending order : "
        + Arrays.toString(mao));
        System.out.println(cont);
        return mao;
    }
    
    public int[] ordenarPorInsercao(int[] monteComprado){
        for(int i = 1; i < monteComprado.length; i++){
            int aux = monteComprado[i];
            int j = i;
            for(; j > 0 && monteComprado[j - 1] > aux; j--){
                monteComprado[j] = monteComprado[j - 1];
            }
            monteComprado[j] = aux;
        }
        System.out.println("Ascending order : "
        + Arrays.toString(monteComprado));
        return monteComprado;
    }
    
    //     public int[] mergeArranjos(int[] A, int[] B){
    //         int [] merged = new int[A.length + B.length];
    //         for(int i = 0; i < A.length; i++){
    //             if(A[i] < B[i]){
    //                 merged[ = A[i];
    //                 merged = 
    //             }
    //         }
    //     }

    public void mostrar(int [] a) {
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public void trocar(int[] a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
