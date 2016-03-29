//
//  lista_palavras.c
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 22/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "lista_palavras.h"

/*
 Metodo cria uma lista nova, e cria um vetor de char. E lê o arquivo.txt, e aloca dentro do vetor.
 @param unsigned int capacidade
 @return nova
 */
struct lista_palavras *
nova_lista(unsigned int capacidade) {
    struct lista_palavras * nova = (struct lista_palavras *) malloc(sizeof(struct lista_palavras));
    if (nova == NULL) {
        printf("Falta de memoria para alocar nova lista.\n");
        exit(!0);
    }
    
    nova->contador = 0;
    nova->capacidade = capacidade;
    nova->palavras = (char**) calloc(capacidade, sizeof(char*));
    if (nova->palavras == NULL) {
        printf("Falta de memoria para alocar palavras.\n");
        exit(!0);
    }
    
    return nova;
}

/*
 Metodo que pega a palavra
 @param struct lista_palavras * lista, unsigned int num.
 @return lista->palavras[num]
 */
char *
get_palavra(struct lista_palavras * lista, unsigned int num) {
    return lista->palavras[num];
}

/*
 Metodo que pega o tamanho da palavra, contador.
 @param struct lista_palavras * lista
 @return lista->contador
 */
int
get_num_palavras(struct lista_palavras * lista) {
    return lista->contador;
}

/*
 Metodo que que insere uma palavra dentro da lista_palavras
 @param struct lista_palavras * lista, char palavra[]
 */
void
inserir_palavra(struct lista_palavras * lista, char palavra[]) {
    if (lista->contador == lista->capacidade) {
        printf("Lista de palavras esta cheia.\n");
        exit(!0);
    }
    
    unsigned long tam_string = strlen(palavra)+1;
    lista->palavras[lista->contador] = (char *) calloc(tam_string, sizeof(char));
    if (lista->palavras[lista->contador] == NULL) {
        printf("Falta de memória para inserir palavra.\n");
        exit(!0);
    }
    strcpy(lista->palavras[lista->contador], palavra);
    lista->contador++;
}

/*
 Metodo que libera lista de palavras, apaga.
 @param struct lista_palavras * lista
 */
void
liberar_lista_palavras(struct lista_palavras * lista) {
    for (int i = 0; i < lista->contador; i++) {
        free(lista->palavras[i]);
    }
    free(lista->palavras);
    free(lista);
}
