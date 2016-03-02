import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Maca maca = new Maca();
    Maca2 maca1 = new Maca2();
    Banana banana = new Banana();
    Cereja cereja = new Cereja();
    Uva uva = new Uva();
    
    int bXAnt, bYAnt, aXAnt, aYAnt;
    Actor a, b;
    List<Actor> todos = getObjects(null);

    boolean secondActor = false;
    boolean firstActor = false;
    boolean changed = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(maca, 150, 200);
        addObject(banana, 450, 200);
        addObject(maca1, 300, 200);
        addObject(cereja, 300, 100);
        addObject(uva, 300, 300);
    }

    public void act()
    {   
        todos = getObjects(null);

        if(changed)
        {
            changed = false;
            firstActor = false;
            secondActor = false;
            a = null;
            b = null;
        }

        if(Greenfoot.mouseClicked(null))
        {
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                if(!firstActor)
                {
                    a = mostraObjects(Greenfoot.getMouseInfo());
                    firstActor = true;
                } else if (firstActor && !secondActor) 
                {
                    b = mostraObjects(Greenfoot.getMouseInfo());
                    if(!a.equals(b)){
                        secondActor = true;
                        setLocationAnterior(a,b);
                        trocar(a,b);
                    }
                }
            }
        }
    }

    public Actor mostraObjects(MouseInfo m)
    {
        for(int i = 0; i < todos.size(); i++)
        {       
            if(todos.get(i) != null)
            {                
                if(todos.get(i).equals(m.getActor()))
                {
                    return todos.get(i);
                }
            }        
        }
        return null;
    }

    public void setLocationAnterior(Actor a, Actor b)
    {
        bXAnt = b.getX();
        bYAnt = b.getY();
        aXAnt = a.getX();
        aYAnt = a.getY();
    }

    public void trocar(Actor a, Actor b)
    {
        a.setLocation(bXAnt, bYAnt);
        b.setLocation(aXAnt, aYAnt);
        changed = true;
    }
}
