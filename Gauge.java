import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Gauge here.
 * 
 * @author sophie
 * @version 1.0
 */
public class Gauge extends Actor
{
    private int value;
    private Color myColor;
    public Gauge(int startValue, Color c)
    {
        value = startValue;
        myColor= c;
        
        GreenfootImage img = new GreenfootImage(102,22);
        
        
        setImage(img);
        updateImage();
        
    }
    public int getValue() 
    {
        return value;
    }    
    public void changeValueBy(int HowMuch)
    {
        
        if(isValueValid(HowMuch) ) {
           value = value + HowMuch; 
        updateImage();
    }
    }
    
   private void updateImage()
   {
       GreenfootImage img = getImage();
       img.clear();
       
       img.setColor(Color.BLUE);
        img.drawRect( 0,0, 101, 21);
        
        img.setColor( myColor);
        img.fillRect(1, 1, value, 20);
    }
    
    private boolean isValueValid(int valid)
    {
        return (value+valid)>-10 && (value+valid)<=100;
    }
}
