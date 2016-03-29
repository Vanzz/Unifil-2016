//
//  forca.c
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 23/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#include "forca.h"

/*
 * Método que verifica se a letra foi tentada ou não.
 */
enum tentado {
    TENTADO,
    NAO_TENTADO
};

const int MAX_TENTATIVAS = 5;
const int LETRAS_ALFABETO = 26;

//Declaração das variáveis do struct dados_forca
struct dados_forca {
    char * oculta;
    unsigned long qtde_letras;
    int acertos;
    int tentativas_restantes;
    enum tentado letras_tentadas[LETRAS_ALFABETO];
};

/*Metodo que determina quantas tentativas resta, e quais ja foram usadas
 *@param struct dados_forca * dados
 */
void
informa_dados(struct dados_forca * dados) {
    printf("Voce tem %d tentativas. Letras ja tentadas:", dados->tentativas_restantes);
    for (int i = 0; i < LETRAS_ALFABETO; i++) {
        if (dados->letras_tentadas[i] == TENTADO) {
            printf(" %c ", 'a' + i);
        }
    }
    putchar('\n');
    
    printf("Letras descobertas:");
    for (int i = 0; i < dados->qtde_letras; i++) {
        printf(" %c", dados->oculta[i]);
    }
    putchar('\n');
}

/*Metodo que inicializa os dados
 *@param struct dados_forca * dados, char const * palavra
 */
void
inicializar_dados(struct dados_forca * dados, char const * palavra) {
    dados->qtde_letras = strlen(palavra);
    dados->oculta = (char *) calloc(dados->qtde_letras + 1, sizeof(char));
    memset(dados->oculta, '_', dados->qtde_letras);
    dados->oculta[dados->qtde_letras+1] = '\0';
    
    dados->acertos = 0;
    dados->tentativas_restantes = MAX_TENTATIVAS;
    memset(dados->letras_tentadas, NAO_TENTADO, sizeof(dados->letras_tentadas));
}

/*Metodo do jogo, aonde acontece a magica das letras e palavras =)
 *@param char const * palavra
 */
void
jogar_forca(char const * palavra) {
    struct dados_forca dados;
    inicializar_dados(&dados, palavra);
    int tamanho = strlen(palavra);
    int i = 0;
    
    //Esse while, faz com que ' ', ja inicie de primeira, sendo que o jogador não precisa adivinhar o ' '.
    //Exer. 4
    while(i < tamanho){
        if (palavra[i] == ' ') {
            dados.acertos += 1;
            dados.oculta[i] = ' ';
        }
        i++;
    }
    while (dados.tentativas_restantes > 0 && dados.acertos < dados.qtde_letras) {
        informa_dados(&dados);
        
        printf("Digite uma letra: ");
        char tentativa = getchar();
        while (getchar() != '\n');
        
        if (!isalpha(tentativa)) {
            printf("Caractere digitado inválido!\n");
            continue;
        }
        tentativa = tolower(tentativa);
        
        // Verificar se tentativa ja foi feita
        int idx_letra = tentativa - 'a';
        if (dados.letras_tentadas[idx_letra] == TENTADO) {
            printf("Letra escolhida já havia sido tentada anteriormente.\n");
            continue;
        }
        dados.letras_tentadas[idx_letra] = TENTADO;
        
        // Verificar se a tentativa existe na palavra
        if (strchr(palavra, tentativa) != NULL) {
            for (int i = 0; palavra[i] != '\0' && dados.oculta[i] != '\0'; i++) {
                if (palavra[i] == tentativa) {
                    dados.oculta[i] = tentativa;
                    dados.acertos++;
                }
            }
        } else {
            dados.tentativas_restantes--;
        }
    }
    
    // Fim de jogo
    if (dados.tentativas_restantes > 0) {
        printf("Parabens, voce descobriu a palavra \"%s\"!\n", palavra);
    } else {
        printf("Infelizmente você perdeu... A palavra era \"%s\".\n", palavra);
    }
}
