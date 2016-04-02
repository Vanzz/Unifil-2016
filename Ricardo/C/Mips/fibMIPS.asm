.text
main:
# Prompt escolhe um número
	la $a0,prompt   
	li $v0,4
	syscall
#Lê o número(n)
	li $v0,5    
	syscall
#Move n para $t2
	move $t2,$v0    

# Chama a função de fibonacci #n
	move $a0,$t2
	move $v0,$t2
 #Chama o fib (n)
	jal fib    
#Resultado está no $t3
	move $t3,$v0    

#Mensagens de saída
#Printa o Fibonacci de
	la $a0,result   
	li $v0,4
	syscall
#Printa o n
	move $a0,$t2    
	li $v0,1
	syscall
#Printa o é
	la $a0,result2  
	li $v0,4
	syscall
#Printa a resposta
	move $a0,$t3    
	li $v0,1
	syscall
#Pula linha \n
	la $a0,endl 
	li $v0,4
	syscall

# Fecha programa
	li $v0,10
	syscall

fib:
# Verifica os números de fibonacci
	beqz $a0,zero   #if (n==0) return 0;
	beq $a0,1,one   #if (n==1) return 1;

#Calling fib(n-1)
#Alimenta a variável de retorno
	sub $sp,$sp,4   
	sw $ra,0($sp)
#n-1
	sub $a0,$a0,1   
#fib(n-1)
	jal fib     
	add $a0,$a0,1
#Restore a variável de returno para 0
	lw $ra,0($sp)   
	add $sp,$sp,4

#Coloca o valor de retorno de volta na pilha
	sub $sp,$sp,4   
	sw $v0,0($sp)

#Calling fib(n-2)
#Alimenta a variável de retorno
	sub $sp,$sp,4   
	sw $ra,0($sp)
#n-2
	sub $a0,$a0,2   
#fib(n-2)
	jal fib     
	add $a0,$a0,2
#Restore a variável de retorno para 0
	lw $ra,0($sp)   
	add $sp,$sp,4
#Retorna o valor da pilha
	lw $s7,0($sp)
	add $sp,$sp,4
# f(n - 2)+fib(n-1)
	add $v0,$v0,$s7 
# próximo da pilha
	jr $ra 

zero:
	li $v0,0
	jr $ra
one:
	li $v0,1
	jr $ra

.data
	prompt:  .asciiz "Insira um número que deseja saber o fibonacci: "
	result:  .asciiz "Fibonacci de "
	result2: .asciiz " é "
	endl:    .asciiz "\n"