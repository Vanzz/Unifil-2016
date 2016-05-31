 

/**
 * Write a description of class QuicksortMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuicksortMensuravel 
{
    public void ordenar(int[] arranjo) 
    {
        quickSort(arranjo,0,arranjo.length);
    }

    public void quickSort(int[] arranjo, int inicio, int fim) {
        if (inicio < fim) {
            int pivot = separar(arranjo, inicio, fim);
            quickSort(arranjo, inicio, pivot-1);
            quickSort(arranjo, pivot+1, fim);
        }
    }

    public int separar(int[] arranjo, int inicio, int fim) {
        int pivot = arranjo[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (arranjo[i] <= pivot)
                i++;
            else if (pivot < arranjo[f])
                f--;
            else {
                int aux = arranjo[i];
                arranjo[i] = arranjo[f];
                arranjo[f] = aux;
                i++;
                f--;
            }
        }
        arranjo[inicio] = arranjo[f];
        arranjo[f] = pivot;
        return f;
    }
}
