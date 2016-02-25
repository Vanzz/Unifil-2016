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
    CarroEstacionado esq = new CarroEstacionado(); 
    CarroEstacionado dir = new CarroEstacionado();
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
        addObject(player, 75, 100);
        addObject(esq, 231, 209);
        addObject(dir, 408, 209);
        
        // Texto do tempo
        addObject(timerText, 503, 364); 
        timerText.setText("Time left: " + (timer/60));
    }
    
    public void act()
    {
        Text derrota = new Text();
        timer--;
        if (timer%60 == 0) timerText.setText("Time left: " + (timer/60));
        if (timer == 0) {
            Greenfoot.stop();
            
            addObject(derrota, 300, 200);
            derrota.setText("DERROTA");
        }
    }
}
