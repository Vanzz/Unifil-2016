 

import java.util.Arrays;
/**
 * Write a description of class MergesortMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergesortMensuravel{
    /** 
     * Ordena e intercala dois arranjos de n??meros inteiros, usando la??os de repeti????o para intercalar e ordenar ao mesmo tempo.
     *
     *@param int[] A - Arranjo de n??meros inteiros
     *@param int[] B - Arranjo de n??meros inteiros
     *
     *@return int[] sorted - Arranjo resultante da interla????o ordenada dos arranjos A e B.
     */
    public int[] mergeArranjos(int[] A, int[] B) {
        int[] sorted = new int[A.length + B.length];

        int aIndex = 0;
        int bIndex = 0;
        int sIndex = 0;

        while(sIndex < sorted.length)
        {
            if(aIndex<A.length && bIndex<B.length)
            {
                if(A[aIndex] <= B[bIndex])
                {
                    sorted[sIndex++] = A[aIndex++];                    
                }else
                {
                    sorted[sIndex++] = B[bIndex++];                    
                }
            }
            else
            {
                if(aIndex >= A.length)
                {
                    while(sIndex < sorted.length)
                    {
                        sorted[sIndex++] = B[bIndex++];
                    }
                }
                else
                {
                    while(sIndex < sorted.length)
                    {
                        sorted[sIndex++] = A[aIndex++];
                    }
                }
            }
        }
        return sorted;
    }

    /** Intercala e ordena 2 sub-arranjos em sequ??ncia j?? ordenados de um arranjo.
     *
     *@param int[] arranjo - O arranjo qual est?? contido os trechos a serem intercalados e ordenados.
     *@param int p - Posi????o inicial do primeiro arranjo.
     *@param int q - Posi????o final do primeiro e inicial do segundo arranjo.
     *@param int r - Posi????o final do segundo arranjo (exclusive). 
     */
    public void merge(int[] arranjo, int p, int q, int r) {
        int[] a = Arrays.copyOfRange(arranjo,p,q);
        int[] b = Arrays.copyOfRange(arranjo,q,r);
        int index = p;
        int ai = 0;
        int bi = 0;
        while(index < r){
            if(ai < a.length && bi < b.length)
            {
                if(a[ai] <= b[bi])
                {
                    arranjo[index++] = a[ai++];
                }
                else
                {
                    arranjo[index++] = b[bi++];
                }
            }
            else
            {
                if(ai >= a.length)
                {
                    while(index < r)
                    {
                        arranjo[index++] = b[bi++];
                    }
                }
                else
                {
                    while(index < r)
                    {
                        arranjo[index++] = a[ai++];
                    }
                }
            }
        }
    }

    /**
     * Ordena um trecho de um arranjo utilizando o m??todo de intercala????o, usando a recursividade como meio de obter os sub-arranjos j?? ordenados.
     * 
     *@param int[] arranjo - Arranjo a ser ordenado
     *@param int p - inicio do trecho
     *@param int r - fim do trecho ( exclusive)
     */
    public void mergesort(int[] arranjo, int p, int r){
        if(p < r-1){
            int meio = (p + r)/2;
            mergesort(arranjo, p, meio);
            mergesort(arranjo, meio, r);
            merge(arranjo,p,meio,r);
        }
    } 

    public void ordenar(int[] arranjo) {
        mergesort(arranjo,0,arranjo.length);
    }
}
