import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author Sophie Qin
 * @version 1.0
 */
public class Bullet extends Actor
{
    public Bullet(int angle)
    {
        setRotation(angle);
    }
    public void act() 
    {
        move(7);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            Actor shark = getOneIntersectingObject(Fin.class);
            if(shark !=null) {
                
                getWorld().removeObject(shark);
                getWorld().removeObject(this);
            }
        }
    }    
}
