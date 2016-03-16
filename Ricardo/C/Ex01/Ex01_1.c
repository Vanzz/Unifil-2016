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


int main (int argc, char * argv[]) {
    
        //Exercício 1 - Fibonacci
        int valorFib;
        printf("Exercício 1\n");
        printf("Digite o valor de fibonacci: ");
        scanf("%d", &valorFib);
    
        printf("Fibonnacci de %d é: %d\n",valorFib, fibonacci(valorFib));
}
