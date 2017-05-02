import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class TimeCounter extends ScoreBoard
{
    public static int timeBoard;
    public void act() 
    {
        for(int i = 30 ; i > 0; i--){
            setImage(new GreenfootImage(""+(timeBoard/2000), 22, Color.BLACK, new Color(0,0,0,0))); 
            timeBoard--;
        }
        if(timeBoard == 0){
            setImage(new GreenfootImage("0", 22, Color.BLACK, new Color(0,0,0,0))); 
        }
    }    
    public TimeCounter(){ // default constructor
        timeBoard = 60000;
    }
}
