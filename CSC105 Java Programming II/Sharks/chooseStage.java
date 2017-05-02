import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class chooseStage extends Actor
{
    private static final Color transparent = new Color(0,0,0,0); // create color variable to transparent
    public chooseStage(){ // default constructor
        
    }
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() {
        setImage(new GreenfootImage("Please select the level!", 18, Color.BLACK, transparent)); // set image for notice "You should select the level before press this button"
    }     
}
