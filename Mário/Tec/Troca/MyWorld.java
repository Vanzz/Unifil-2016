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
    Banana banana = new Banana();
    int bXAnt, bYAnt, mXAnt, mYAnt;

    List<Actor> todos = getObjects(null);
    boolean cMaca = false;
    boolean cBanana = false;
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
    }

    public void act()
    {
        bXAnt = banana.getX();
        bYAnt = banana.getY();
        mXAnt = maca.getX();
        mYAnt = maca.getY();
        
        todos = getObjects(null);
        mostraObjects();
        if(cMaca && cBanana && !changed)
        {
            maca.setLocation(bXAnt, bYAnt);
            banana.setLocation(mXAnt, mYAnt);
            changed = true;
        }

        if(changed)
        {
            changed = false;
            cMaca = false;
            cBanana = false;
        }

        if(Greenfoot.mouseClicked(maca))
        {
            cMaca = true;
            changed = false;
        }

        if(Greenfoot.mouseClicked(banana))
        {
            cBanana = true;
            changed = false;
        }
    }
    
    public void mostraObjects()
    {
        for(int i = 0; i< todos.size(); i++)
        {       
            if(todos.get(i) != null)
            {
                System.out.println(todos.get(i));
            }        
        }
    }
    
}
