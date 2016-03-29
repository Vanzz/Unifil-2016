CC = gcc
CFLAGS = -Wall -Werror
NAME = forca
SOURCES = main.c forca.c lista_palavras.c
OBJECTS = main.o forca.o lista_palavras.o

all: $(OBJECTS)
	$(CC) $(CFLAGS) -o $(NAME) $(SOURCES) 

main.o: main.c forca.h lista_palavras.h
	$(CC) $(CFLAGS) -c main.c

forca.o: forca.c forca.h
	$(CC) $(CFLAGS) -c forca.c

lista_palavras.o: lista_palavras.c lista_palavras.h
	$(CC) $(CFLAGS) -c lista_palavras.c

clean:
	rm -rf *.o forca
