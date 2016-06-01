package Mensuraveis.Ordenacao;


/**
 * Write a description of class BolhaMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BolhaMensuravel extends OrdenacaoMensuravel
{
    @Override
    public void ordenar(int[] arranjo) {
        boolean troca = true;
        int j = 0;
        while(troca){
            troca = false;
            j++;
            for(int i = 0; i < arranjo.length - j; i++){
                if(arranjo[i] > arranjo[i+1]){
                    trocar(arranjo, i, i+1);
                    troca = true;
                }
            }
        }
    }
    
    public void trocar(int[] a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
