import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.awt.Color;
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
    Buscar buscarButton;
    IconBuscar icbscButton;
    OrdenarAsc ordAscButton;
    OrdenarDesc ordDescButton;

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
        buscarButton = new Buscar();
        icbscButton = new IconBuscar();
        ordAscButton = new OrdenarAsc();
        ordDescButton = new OrdenarDesc();

        this.addObject(addButton, LARGURA-addButton.getImage().getWidth(), ALTURA-2*addButton.getImage().getHeight());
        this.addObject(removeButton, LARGURA-removeButton.getImage().getWidth(), ALTURA-removeButton.getImage().getHeight());
        this.addObject(buscarButton, LARGURA-buscarButton.getImage().getWidth(), ALTURA-3*buscarButton.getImage().getHeight());
        this.addObject(ordAscButton, LARGURA-buscarButton.getImage().getWidth(), ALTURA-4*buscarButton.getImage().getHeight());
        this.addObject(ordDescButton, LARGURA-buscarButton.getImage().getWidth(), ALTURA-5*buscarButton.getImage().getHeight());

        Pessoa p = new Pessoa();
        Label l1 = new Label("Kleber", 15);
        Label l2 = new Label("33", 15);
        Node n = new Node(p, l1, l2);
        lista.inserirFinal(n);

        this.addObject(p, LARGURA/4, ALTURA/2);
        this.addObject(l1, LARGURA/4, ALTURA/2-30);
        this.addObject(l2, LARGURA/4, ALTURA/2+30);

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

                this.removeObject(lista.getLast().getPessoa());   
                this.removeObject(lista.getLast().getNome());
                this.removeObject(lista.getLast().getIdade());
                lista.remover(lista.getSize());
                NEXT-= 50;
            }                
        }

        if(Greenfoot.mouseClicked(buscarButton)){
            if(Greenfoot.getMouseInfo() != null) 
            {
                IconBuscar iB = new IconBuscar();

                String comp = Greenfoot.ask("Digite o nome da pessoa:");
                for(int i = 1; i <= lista.getSize(); i++) {
                    addObject(iB, lista.getNode(i).getPessoa().getX(), ALTURA/2 + 60);
                    Greenfoot.delay(120);
                    if(comp.equals(lista.getNode(i).getNome().getValue())){
                        removeObject(iB);

                        Label l = new Label("Achou", 15);

                        addObject(l, lista.getNode(i).getPessoa().getX(), ALTURA/2 - 60);
                        Greenfoot.delay(280);
                        removeObject(l);
                        break;
                    }

                    removeObject(iB);
                }
            }
        }

        if(Greenfoot.mouseClicked(ordAscButton)){
            if(Greenfoot.getMouseInfo() != null) 
            {
                lista.bubblesortAsc();
            }
        }

        if(Greenfoot.isKeyDown("p") && !jafui)
        {
            lista.listAllNodes();
            jafui = true;
            j++;
            System.out.println(j);
        }
        //Se quiser remover de uma posição qualquer aperte 'R'
        if(Greenfoot.isKeyDown("r") && !jafui)
        {
            jafui = true;
            int a = Integer.parseInt(JOptionPane.showInputDialog("Qual remover: "));
            this.removeObject(lista.getNode(a).getPessoa());   
            this.removeObject(lista.getNode(a).getNome());
            this.removeObject(lista.getNode(a).getIdade());
            lista.remover(a);
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
