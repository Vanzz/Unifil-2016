import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static int ALTURA = 400;
    private static int LARGURA = 600;
    private int NEXT = 50;
    Add addButton;
    Remove removeButton;

    Lista lista = new Lista();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(LARGURA, ALTURA, 1);
    }

    public void started(){
        addButton = new Add();
        removeButton = new Remove();

        this.addObject(addButton, LARGURA-addButton.getImage().getWidth(), ALTURA-2*addButton.getImage().getHeight());
        this.addObject(removeButton, LARGURA-removeButton.getImage().getWidth(), ALTURA-removeButton.getImage().getHeight());

        Pessoa p = new Pessoa();
        Node n = new Node(p);
        lista.inserirFinal(n);

        this.addObject(p, LARGURA/4, ALTURA/2);

        Label label = new Label("Pessoinhas", 20);
        this.addObject(label, 150, 10);
    }
    int j = 0;
    boolean jafui = false;
    public void act() {
        Node node = new Node();

        if(Greenfoot.mouseClicked(addButton)){
            if(Greenfoot.getMouseInfo() != null)
            {
                Pessoa p = new Pessoa();
                Label l1 = new Label(nome(), 15);
                Label l2 = new Label(idade(), 15);
                //System.out.println(p+ "|"+ l1 + "|"+ l2);
                node = new Node(p,l1,l2);
                lista.inserirFinal(node);

                this.addObject(p, LARGURA/4+NEXT, ALTURA/2);
                this.addObject(l1, LARGURA/4+NEXT, ALTURA/2-30);
                this.addObject(l2, LARGURA/4+NEXT, ALTURA/2+30);
                NEXT+=50;
                jafui = false;
            }
        }

        if(Greenfoot.mouseClicked(removeButton)){
            if(Greenfoot.getMouseInfo() != null)
            {                
                jafui = false;
                //System.out.println("\t[REMOVER] | \n"+lista.getLast());
                this.removeObject(lista.getLast().getPessoa());   
                this.removeObject(lista.getLast().getNome());
                this.removeObject(lista.getLast().getIdade());
                lista.remover(lista.getSize());
                NEXT-= 50;
            }                
        }

        if(Greenfoot.isKeyDown("p") && !jafui)
        {
            lista.listAllNodes();
            jafui = true;
            j++;
            System.out.println(j);
        }
    }

    public String nome() {
        String nome = "";
        nome = JOptionPane.showInputDialog("Nome: ");
        return nome;
    }

    public int idade() {
        Integer idade = null;
        try {
            idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
            return idade;
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
