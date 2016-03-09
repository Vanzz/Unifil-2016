import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
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
    }

    public void started()
    {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Número de frutas: "));
        if(n > 1){
            for(int i = 0; i < n; i++)
            {
                addObject(escolha(), range(20, 580),range(20, 380));
            }
        }else{
            started();
        }
    }

    public Actor escolha() {
        int n = range(1, 5);

        Maca maca = new Maca();
        Maca2 maca2 = new Maca2();
        Banana banana = new Banana();
        Cereja cereja = new Cereja();
        Uva uva = new Uva();

        if(n == 1)
            return maca;
        if(n == 2)
            return maca2;
        if(n == 3)
            return banana;
        if(n == 4)
            return cereja;
        if(n == 5)
            return uva;

        return null;
    }

    public int range(int min, int max)
    {
        int range = Math.abs(max - min) + 1;     
        return (int)(Math.random() * range) + (min <= max ? min : max);
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
