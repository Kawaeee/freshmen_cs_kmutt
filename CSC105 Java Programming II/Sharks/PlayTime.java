import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class PlayTime extends ScoreBoard
{  
    public PlayTime(){ // default constructor
        setImage(new GreenfootImage(""+(Timer.playtime/60), 35, Color.WHITE,  new Color(0,0,0,0))); //always show playtime you play
    }
}
