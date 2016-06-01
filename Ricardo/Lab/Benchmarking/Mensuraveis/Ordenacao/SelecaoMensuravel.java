package Mensuraveis.Ordenacao;


/**
 * Write a description of class Selecao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelecaoMensuravel extends OrdenacaoMensuravel
{
    /**
     * Este método ordena o arranjo utilizando o algoritmo de selecao.
     * 
     * @param arranjo Arranjo a ser ordenado.
     */
    @Override
    public void ordenar(int[] arranjo) {
        for(int i = 0; i < arranjo.length - 1; i++){
            int menor = i;
            for(int j = i; j < arranjo.length; j++){
                if(arranjo[j] < arranjo[menor]){
                    menor = j;
                }
            }

            trocar(arranjo, i, menor);
        }
    }
    
    public void trocar(int[] a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
