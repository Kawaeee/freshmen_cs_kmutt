import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Timer extends Actor
{
    static int playtime; // create int to keep time fo rplaying
    private static final Color transparent = new Color(0,0,0,0); // create transparent color
    public Timer(){ //default constructor
      playtime = 0; // start at 0
    }
     public void act() {
        setImage(new GreenfootImage("Time :  "+((playtime/60)), 18, Color.BLACK, transparent)); // always show the time you play
    }     
}
