import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Medium extends Actor
{
    boolean mouseOver; // boolean check click
    public void act()  
    {
     if(Greenfoot.mouseClicked(this)){ // if clicked on this
            setImage("button_2_press.png"); // set pressed image
            Start.level=2;
     }
     if(Start.level!=2){ // if not
         setImage("button_2.png"); // set to released image
     }
    }    
}
