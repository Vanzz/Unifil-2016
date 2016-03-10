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
    
    for (int i = 0; i < sizeof(a); i++)
    {
        if( a[i] != a[sizeof(a) - i -1])// (-1)pq o ultimo caracter e espaco
        {
            return 1;
        }
    }
    return 0;
}

int verificaPalin(char* palavra) {
    
    if(palindromo(palavra) == 1){
        return 1;
    }else{
        printf("\n%s Palíndromo\n",palavra);
        return 0;
    }
}

int main(int argc, char* argv[]) {
    char str[10];
    int i;
    for(i = 0; i<10001;i++) {
        
        sprintf(str,"%d",i);
        verificaPalin(str);
    }
}