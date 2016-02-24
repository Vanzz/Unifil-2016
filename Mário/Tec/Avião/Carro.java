import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aviao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro extends Actor
{
    /**
     * Act - do whatever the Aviao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        float time = 0;
        move(0);

            if(Greenfoot.isKeyDown("up"))
            {
                move(1);
                if(Greenfoot.isKeyDown("right"))
                {
                    turn(1);
                }else if(Greenfoot.isKeyDown("left"))
                {
                    turn(-1);
                }
    
            }else if(Greenfoot.isKeyDown("down"))
            {
                move(-1);
                if(Greenfoot.isKeyDown("right"))
                {
                    turn(-1);
                }else if(Greenfoot.isKeyDown("left"))
                {
                    turn(1);
                }
                
            }
            time -= 0.15;
        } 
    }   
}
