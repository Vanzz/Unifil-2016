#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int somatoria (int tamanhoVetor, int * v) {
    int somaVetor = 0;
    
    for( int i = 0; i < tamanhoVetor; i++)
    {
        somaVetor = somaVetor + v[i];
    }
    
    return somaVetor;
}

int main(int argc, char* argv[]) {
    
//    Exercício 2 - Soma dos vetores
    
        int vetor[100];
        int n;
        int m;
    
        printf("Exercício 2\n");
        printf("Digite o tamanho do vetor: ");
        scanf("%d", &n);
    
        m = n;
    
        for(int i = 0; i < n; i++)
        {
            printf("Digite o(s) %d valor(es): ", m);
            scanf("%d", &vetor[i]);
            m--;
        }
        
        printf("A soma do vetor é: %d\n",somatoria(n, vetor));
    
}