import greenfoot.*;

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node 
{
    Pessoa pessoa;
    Label nome;
    Label idade;
    Node node;
    Node ant;
    
    public Node()
    {
        
    }
    
    public Node(Pessoa p)
    {
        this(p,new Label("Kleber",20));
    }
    
    public Node(Pessoa p, Label n)
    {
        this(p,n,new Label(0,20));
    }
    
    /**
     * Constructor for objects of class Node
     */
    public Node(Pessoa p, Label n, Label i)
    {
        this.pessoa = p;
        this.nome = n;
        this.idade = i;
    }
    
    public Pessoa getPessoa() 
    {
        return pessoa;
    }
    
    public Label getNome() 
    {
        return nome;
    }
    
    public Label getIdade() 
    {
        return idade;
    }
    
    public String toString()
    {
        return "[P]"+pessoa+"\n[N]"+nome+"\n[I]"+idade;
    }
    
    public Node getNode() 
    {
        return this;
    }
    
    public void setProximo(Node _node) 
    {
        this.node = _node;
    }
    
    public Node getProximo() 
    {
        return node;
    }
    
    public void setAnterior(Node _node)
    {
        this.ant = _node;
    }
    
    public Node getAnterior()
    {
        return ant;
    }
}
