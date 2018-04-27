import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Ocean here.
 * 
 * @author Sophie
 * @version 1.0
 */
public class Ocean extends World
{
    private Counter score;
    private Gauge lives;
    private Gauge bullets;

    public Ocean()
    {    

        super(800, 600, 1); 

        lives = new Gauge (100, Color.RED);
        addObject(lives, 65, 575);
        addObject(new Label ("Lives", 25), 65, 575);

        bullets = new Gauge (100, Color.BLUE);
        addObject( bullets, 65, 545);
        addObject(new Label ("Bullets", 25), 65, 545);

        addObject(new Boat(bullets), 70,300);
        addObject(new Whirlpool(), 400,300);
        score = new Counter ("Score: ");
        addObject(score, 730,30);
        addTreasure();
        startSharks();
    }

    public void addTreasure() 
    {
        for(int p=0; p<6; p=p+1) {
            int x= Greenfoot.getRandomNumber ( getWidth() );
            int y= Greenfoot.getRandomNumber (getHeight());
            addObject(new Treasure(), x,y);
        }

    }

    public void startSharks()
    {
        for( int s=0; s<5; s=s+1){
            addObject( new Fin(), 50,50);
        }
    }

    public void addShark()
    {
        if(Greenfoot.getRandomNumber(1000) < 3) {
            addObject( new Fin(), 50, 50);
        }
    }

    public void act()
    {
        if(Greenfoot.getRandomNumber(100) < 0.1 ) {
            addObject( new Treasure(), Greenfoot.getRandomNumber( getWidth() ), Greenfoot.getRandomNumber( getHeight()));
        }
        addShark();
    }

    public void changeScore (int change)
    {
        score.add(change);
    }

    public void gameOver ()
    {
        Label endGame = new Label("Game Over \n Your Score is " + score.getValue(), 40);
        Greenfoot.playSound("gameover.wav");
        addObject( endGame, getWidth()/2, getHeight()/2);
    }

    public void changeLivesCounterBy( int HowMuch)
    {
        lives.changeValueBy( HowMuch); 
    }

    public boolean anyLivesLeft()
    {
        return lives.getValue()>0;
    }
}

