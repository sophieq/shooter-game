import greenfoot.*;

/**
 * Write a description of class Boat here.
 * 
 * @author Sophie
 * @version 1.0
 */
public class Boat extends Actor
{
    private GreenfootImage imgRight = new GreenfootImage("boat1.png");
    private GreenfootImage imgLeft = new GreenfootImage("boat2.png");
    private int life= 9;
    private boolean shoot= false;
    private Gauge bullet;

    public Boat (Gauge b)
    {
        bullet = b;
    }

    public void act() 
    {
        movement();
        checkLives();

        if(Greenfoot.isKeyDown("space") && !shoot) {
            if(bullet.getValue()>0) {
                firing();
            }
        }
        if(!Greenfoot.isKeyDown("space")) {
            shoot = false;

        }

    }    

    public void firing()
    {
        getWorld().addObject(new Bullet(getRotation()), getX(),getY() );
        bullet.changeValueBy(-2);
        shoot = true;
    }

    public void movement()
    {
        if( Greenfoot.isKeyDown("up")) {
            move(4);
            setImage(imgRight);
        }
        if(Greenfoot.isKeyDown("down")){
            move(-4);
            setImage(imgLeft);
        }
        if ( Greenfoot.isKeyDown("left") ) {
            turn(-4);
        }
        if ( Greenfoot.isKeyDown("right") ) {
            turn(4);
        }  

        getTreasure();

    }

    public void checkLives() {
        Actor collided;
        collided = getOneIntersectingObject(Fin.class);
        if(collided!=null) {
            loseLife();
            if(life == 0) {
                Greenfoot.stop();
                Ocean blueOcean = (Ocean)getWorld();
                blueOcean.gameOver();
            }
        }
    }

    public void loseLife() {
        life = life - 1;
        Ocean world = (Ocean)getWorld();
        if(world.anyLivesLeft() ) {
            world.changeLivesCounterBy(-11);
        }
        setLocation(400,300);

    }
    public void getTreasure()
    {
        Actor money = getOneIntersectingObject(Treasure.class);
        if(money !=null) {
            Ocean theOcean = (Ocean)getWorld();
            theOcean.changeScore(1);
            getWorld().removeObject(money);
        }
    }

}
