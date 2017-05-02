import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Easy extends Actor
{
    public void act() 
    {
     if(Greenfoot.mouseClicked(this)){ // if click on this
            setImage("button_1_press.png"); // set pic to already click
            Start.level=1; // level = easy
     }
     if(Start.level!=1){ // if level is not easy
         setImage("button_1.png"); // release click
     }
        
    }
    
}
