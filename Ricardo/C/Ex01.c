#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int fibonacci (int n) {
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fibonacci(n-2) + fibonacci(n-1);
}

int somatoria (int tamanhoVetor, int * v) {
    int somaVetor = 0;
    
    for( int i = 0; i < tamanhoVetor; i++)
    {
        somaVetor = somaVetor + v[i];
    }
    
    return somaVetor;
}

int palindromo (char* palavra) {
    char a[100];
    int j = 0;
    for (int i = 0; i < strlen(palavra); i++) {
        if(palavra[i] == ' ')
            continue;
        else{
            a[j] = palavra[i];
            j++;
            
            printf("%s\n", a);
        }
    }

    
    for (int i = 0; i < strlen(a); i++)
    {
       if( a[i] != a[strlen(a) - i-1])// (-1)pq o ultimo caracter e espaco
       {
           return 1;
       }
    }
    return 0;
}

void verificaPalin(char* palavra) {
    printf("\n%s\n", palavra);
    if(palindromo(palavra) == 1){
        printf("\n%d NOPE\n", palindromo(palavra));
    }else{
        printf("\nPalíndromo\n");
    }
}

int main (int argc, char * argv[]) {
    
//    //Exercício 1 - Fibonacci
//    int valorFib;
//    printf("Exercício 1\n");
//    printf("Digite o valor de fibonacci: ");
//    scanf("%d", &valorFib);
//    
//    printf("Fibonnacci de %d é: %d\n",valorFib, fibonacci(valorFib));
//    
//    //Exercício 2 - Soma dos vetores
//    
//    int vetor[100];
//    int n;
//    int m;
//    
//    printf("Exercício 2\n");
//    printf("Digite o tamanho do vetor: ");
//    scanf("%d", &n);
//    
//    m = n;
//    
//    for(int i = 0; i < n; i++)
//    {
//        printf("Digite o(s) %d valor(es): ", m);
//        scanf("%d", &vetor[i]);
//        m--;
//    }
//    
//    printf("A soma do vetor é: %d\n",somatoria(n, vetor));
//
    
//    Exercício 3 - parâmetro passado ao executar ex: ./ex01 "String"
    
//    if(palindromo(argv[1]) == 1){
//        printf("\nNOPE\n");
//    }else{
//        printf("\nPalíndromo\n");
//    }
//    verificaPalin(argv[1]);
    
//    Exercício 4 - Array de strings
    
//    Exercício 5 - números palíndromos até 10000
    
//    for(int i = 0; i < 10001; i++)
//    {
//        char str[5];
//        sprintf(str, "%d", i);
//        puts(str);
//        if(palindromo(str) != 1)
//            printf("%d é palíndromo.", i);
//    }
   
}
