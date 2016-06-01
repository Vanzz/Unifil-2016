package Mensuraveis.Ordenacao;


/**
 * Write a description of class InsercaoMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsercaoMensuravel extends OrdenacaoMensuravel
{
    public int[] ordenarCom2Arranjos(int[] monteComprado) {
        int [] mao = new int[monteComprado.length];
        for(int i = 0; i < monteComprado.length; i++){
            int j = i;
            mao[i] = monteComprado[i];
            while(j > 0 && monteComprado[i] < mao[j-1]){
                trocar(mao, j-1, j);
                j--;
            }
        }
        return mao;
    }
    
    public void trocar(int[] a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
    
    @Override
    public void ordenar(int[] arranjo) {
        for(int i = 1; i < arranjo.length; i++){
            int aux = arranjo[i];
            int j = i;
            for(; j > 0 && arranjo[j - 1] > aux; j--){
                arranjo[j] = arranjo[j - 1];
            }
            arranjo[j] = aux;
        }
    }
}
