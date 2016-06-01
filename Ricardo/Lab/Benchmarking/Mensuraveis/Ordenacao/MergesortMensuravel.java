package Mensuraveis.Ordenacao;

import java.util.Arrays;
/**
 * Write a description of class MergesortMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergesortMensuravel extends OrdenacaoMensuravel
{
    /** 
     * Ordena e intercala dois arranjos de números inteiros, usando laços de repetição para intercalar e ordenar ao mesmo tempo.
     *
     *@param int[] A - Arranjo de números inteiros
     *@param int[] B - Arranjo de números inteiros
     *
     *@return int[] sorted - Arranjo resultante da interlação ordenada dos arranjos A e B.
     */
    public int[] mergeArranjos(int[] A, int[] B) {
        int[] sorted = new int[A.length + B.length];

        int aIndex = 0;
        int bIndex = 0;
        int sIndex = 0;

        while(sIndex < sorted.length){
            if(aIndex<A.length && bIndex<B.length)
            {
                if(A[aIndex] <= B[bIndex])
                {
                    sorted[sIndex++] = A[aIndex++];                    
                }else{
                    sorted[sIndex++] = B[bIndex++];                    
                }
            }else{
                if(aIndex >= A.length){
                    while(sIndex < sorted.length){
                        sorted[sIndex++] = B[bIndex++];
                    }
                }else{
                    while(sIndex < sorted.length){
                        sorted[sIndex++] = A[aIndex++];
                    }
                }
            }

        }
        return sorted;
    }

    /** Intercala e ordena 2 sub-arranjos em sequência já ordenados de um arranjo.
     *
     *@param int[] arranjo - O arranjo qual está contido os trechos a serem intercalados e ordenados.
     *@param int p - Posição inicial do primeiro arranjo.
     *@param int q - Posição final do primeiro e inicial do segundo arranjo.
     *@param int r - Posição final do segundo arranjo (exclusive). 
     */
    public void merge(int[] arranjo, int p, int q, int r) {
        int[] a = Arrays.copyOfRange(arranjo,p,q);
        int[] b = Arrays.copyOfRange(arranjo,q,r);
        int index = p;
        int ai = 0;
        int bi = 0;
        while(index<r){
            if(ai < a.length && bi < b.length){
                if(a[ai] <= b[bi]){
                    arranjo[index++] = a[ai++];
                }else{
                    arranjo[index++] = b[bi++];
                }
            }else{
                if(ai >= a.length){
                    while(index < r){
                        arranjo[index++] = b[bi++];
                    }
                }else{
                    while(index < r){
                        arranjo[index++] = a[ai++];
                    }
                }
            }
        }
    }

    /**
     * Ordena um trecho de um arranjo utilizando o método de intercalação, usando a recursividade como meio de obter os sub-arranjos já ordenados.
     * 
     *@param int[] arranjo - Arranjo a ser ordenado
     *@param int p - inicio do trecho
     *@param int r - fim do trecho ( exclusive)
     */
    public void mergesort(int[] arranjo, int p, int r){
        if(p<r-1){
            int meio = (p + r)/2;
            mergesort(arranjo, p, meio);
            mergesort(arranjo, meio, r);
            merge(arranjo,p,meio,r);
        }
    } 

    @Override
    public void ordenar(int[] arranjo) {
        mergesort(arranjo,0,arranjo.length);
    }
}
