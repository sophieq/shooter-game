import greenfoot.*;

/**
 * 
 * @author Sophie
 * @version 1.0
 */
public class Fin extends Actor
{

    public void act() 
    { move(2);
        if(isAtEdge()) {
         turn(12);   
        }
        if(Greenfoot.getRandomNumber(100) < 45) {
            if(Greenfoot.getRandomNumber(2) == 0) {
                turn(-3);
            } else {
                turn(3);
            }
        }
        
        Actor pool = getOneIntersectingObject(Whirlpool.class);
            if(pool !=null) {
                getWorld().removeObject(this);
            }
    }
}    
