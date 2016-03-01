import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Text timerText = new Text();
    Carro player = new Carro();
    ParkingSlot slot = new ParkingSlot();
    CarroEstacionado esq = new CarroEstacionado(); 
    CarroEstacionado dir = new CarroEstacionado();
    CarroEstacionado doido = new CarroEstacionado();
    private int timer = 3600;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        player.Awake();
        // Adiciona o player e os carrosObstaculos

        addObject(esq, 231, 209);
        addObject(dir, 408, 209);
        addObject(slot, 319, 209);
        addObject(player, 75, 100);
        // Texto do tempo
        addObject(timerText, 503, 364); 
        timerText.setText("Time left: " + (timer/60));
    }
    int x = 0;
    boolean free = false;
    public void act()
    {
        Text derrota = new Text();
        timer--;
        if (timer%60 == 0) timerText.setText("Time left: " + (timer/60));
        if (timer == 0) {
            Greenfoot.stop();

            addObject(derrota, 297, 104);
            
            derrota.setText("DERROTA");
        }
        if(timer == 2400)
        {
            addObject(doido, x, 50);
            free = true;
        }
        if(free){
            x++;doido.setLocation(x,50);}
        
        ganhou();
        System.out.println(player.getX()+" : "+player.getY());
    }

    /**
     * Carro (75, 100)
     * PS (319, 209)
     */
    public void ganhou()
    {
        Text win = new Text();

        if(slot.getX() - 5 < player.getX() && player.getX() <= slot.getX() + 5 && 
        slot.getY() - 5 < player.getY() && player.getY() <= slot.getY() + 5 &&
        slot.getRotation() - 5 < player.getRotation() && player.getRotation() <= slot.getRotation() + 5)
        {
            Greenfoot.stop();
            addObject(win, 297, 104);
            win.setText("VITÓRIA");
        }
    }
}
