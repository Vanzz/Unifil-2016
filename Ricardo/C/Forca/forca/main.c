//
//  main.c
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 21/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#include "lista_palavras.h"
#include "forca.h"

//Metodo que sorteia
//@param int inferior, int superior
//@return rand() % superior + inferior
int sortear_entre(int inferior, int superior) {
    srand((unsigned int) time(NULL));
    return rand() % superior + inferior;
}

/*
 Metodo que lê o arquivo .txt, para assim usar no jogo.
 @param char const * nome_arq
 @return lista
 */
struct lista_palavras *
carregar_palavras(char const * nome_arq) {
    // Abre um arquivo para leitura
    FILE * arq = fopen(nome_arq, "r");
    if (arq == NULL) {
        printf("O arquivo indicado não pode ser aberto.\n");
        exit(!0);
    }
    
    // Le quantas palavras há no arquivo aberto
    unsigned int num_palavras;
    if (fscanf(arq, "%u\n", &num_palavras) == 0) {
        printf("Erro ao ler quantidade de palavras no arquivo.\n");
        exit(!0);
    }
    
    // Cria uma nova lista de palavras
    struct lista_palavras * lista = nova_lista(num_palavras);
    
    for (int i = 0; i < num_palavras && feof(arq) == 0; i++) {
        const int tam_max_palavra = 100;
        char palavra[tam_max_palavra];
        
        /*if(fscanf(arq, "%s\n", palavra) == 0) {
            printf("Erro ao ler a proxima palavra do arquivo.\n");
            liberar_lista_palavras(lista);
            exit(!0);
        }*/
        
        char * str;
        //Em vez de usar o fscanf de ler char por char, usei o fgets para pegar a linha(100).
        str = fgets(palavra, tam_max_palavra, arq);
        str[strlen(palavra) - 1] = '\0';
        
        inserir_palavra(lista, palavra);
    }
    
    return lista;
}

//Esse método sorteia a palavra pra aparecer no jogo
int
main(int argc, const char * argv[]) {
    if (argc < 2) {
        printf("Modo de uso: forca <arquivo_palavras>\n");
        exit(!0);
    }
    char const * nome_arq = argv[1];
    
    struct lista_palavras * palavras;
    palavras = carregar_palavras(nome_arq);
    
    int sorteada = sortear_entre(0, get_num_palavras(palavras));
    char * palavra = get_palavra(palavras, sorteada);
    
    jogar_forca(palavra);
    
    liberar_lista_palavras(palavras);
    return 0;
}
