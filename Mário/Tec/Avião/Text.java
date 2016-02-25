import greenfoot.*;
import java.awt.Color;
 
public class Text extends Actor
{
    public Text()
    {
        this("");
    }
 
    public Text(String text)
    {
        setText(text);
    }
 
    public void setText(String text)
    {
        setImage(new GreenfootImage(text, 24, Color.black, new Color(0, 0, 0, 0)));
    } 
}