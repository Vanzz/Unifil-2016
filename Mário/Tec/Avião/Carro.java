import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aviao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro extends Actor
{
    boolean up,down;

    public void Awake()
    {
        up = true;
        down = true;
        System.out.println("Acordei");
    }
    
    /**
     * Act - do whatever the Aviao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(!isAtEdge()) {
            move(0);

            if(Greenfoot.isKeyDown("up") && up)
            {
                move(1);
                
                if(Greenfoot.isKeyDown("right"))
                {
                    turn(1);
                }else if(Greenfoot.isKeyDown("left"))
                {
                    turn(-1);
                }

                if(isCollider())
                {
                    System.out.println("Sou collider");
                    up = false;
                    down = true;
                } else {
                    down = true;
                }
                
            }else if(Greenfoot.isKeyDown("down") && down)
            {
                move(-1);

                if(Greenfoot.isKeyDown("right"))
                {
                    turn(-1);
                }else if(Greenfoot.isKeyDown("left"))
                {
                    turn(1);
                }

                if(isCollider())
                {
                    System.out.println("Sou collider");
                    up = true;
                    down = false;
                } else {
                    up = true;
                }
                
            }
            
            System.out.println(up+" : "+down+" -> "+isCollider());
        } else {
            move(0);
        }
        
    } 
    
    public boolean isCollider()
    {
        return isTouching(CarroEstacionado.class);
    }
}   




























