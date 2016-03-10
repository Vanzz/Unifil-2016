#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int palindromo (char* palavra) {
    int t = strlen(palavra);
    char a[t];
    int j = 0;
    for (int i = 0; i < t; i++) {
        if(palavra[i] == ' ')
            continue;
        else{
            a[j] = palavra[i];
            j++;
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

int verificaPalin(char* palavra) {
    if(palindromo(palavra) == 1){
        printf("%d NOPE\n", palindromo(palavra));
        return 1;
    }else{
        printf("Palíndromo\n");
        return 0;
    }
}

int main(int argc, char* argv[]) {
//    Exercício 3 - parâmetro passado ao executar ex: ./ex01 "String"
    
    char * str = argv[1];
    verificaPalin(str);
}