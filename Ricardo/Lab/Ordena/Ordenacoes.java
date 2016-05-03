
/**
 * Escreva a descrição da classe Ordenar aqui.
 * 
 * @author Matheus Fávaro, Tiago Vansan Ketzer de Souza
 * @version (número de versão ou data)
 */
public class Ordenacoes
{
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
        int cont = 0;
        while(troca){
            troca = false;
            j++;
            cont++;
            for(int i = 0; i < a.length - j; i++){
                if(a[i] > a[i+1]){
                    trocar(a, i, i+1);
                    mostrar(a);
                    troca = true;
                    cont++;
                }
            }
        }
        mostrar(a);
        
        System.out.println(cont);
    }

    public void mostrar(int [] a) {
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public void trocar(int[] a, int i, int j)
    {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
