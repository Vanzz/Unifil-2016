#include <stdio.h>
#include <stdlib.h>
#include <string.h>
    
    int size(char *string) {
        int length = 0;
        while(*string){
            ++length;
            ++string;
        }
        return length;
    }
    
    int palindromo (char* palavra) {
        int t = size(palavra);
        char a[t];
        int j = 0;
        for (int i = 0; i < t; i++) {
            if(palavra[i] == ' ' || palavra[i] == '?' || palavra[i] == '!')
                continue;
            else{
                a[j] = palavra[i];
                j++;
            }
            if(t % 2 != 0 ) {
                a[i] = '\0';
            }else if(i+1 == t)
            {
                a[i+1] = '\0';
            }
        };
        for (int i = 0; i < size(a); i++)
        {
            if( a[i] != a[size(a) - i-1])// (-1)pq o ultimo caracter e espaco
            {
                return 1;
            }
        }
        return 0;
    }
    
    
    
int verificaPalin(char* palavra) {
        if(palindromo(palavra) == 1){
            printf("NOPE\n");
            return 1;
        }else{
            printf("Palíndromo\n");
            return 0;
        }
    }
    
    int main(int argc, char* argv[]) {
        //    Exercício 4 - Array de palíndromo
        char *palavras[8] = {"joseesoj","odraciricardo", "omississimo", "nada", "1331","1311", "roma me tem amor", "irene ri"};
        
        for(int i = 0;i<8;i++) {
            printf("A palavra %s é ", palavras[i]);
            verificaPalin(palavras[i]);
        }
        

    }