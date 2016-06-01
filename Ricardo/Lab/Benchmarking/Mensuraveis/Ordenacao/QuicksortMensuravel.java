package Mensuraveis.Ordenacao;

/**
 * Write a description of class QuicksortMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuicksortMensuravel extends OrdenacaoMensuravel
{
    @Override
    public void ordenar(int[] arranjo){
        sort(arranjo, 0, arranjo.length - 1);
    }

    private void sort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            sort(vetor, inicio, posicaoPivo - 1);
            sort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            }else if (pivo < vetor[f]) {
                f--;
            }else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
