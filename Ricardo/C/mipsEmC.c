#include <stdlib.h>
#include <stdio.h>

int main () {
    int CARTEIRA = 0;
    int mesesCalculo = 12;
    int valorSalario = 1000;
    int impostoMB = 437;
    
    do{
    CARTEIRA += valorSalario;
    CARTEIRA -= impostoMB;
    mesesCalculo--;
    }while (mesesCalculo != 1);
    
    printf("O sálario calculado foi de: %d\n", CARTEIRA);
    return CARTEIRA;
}