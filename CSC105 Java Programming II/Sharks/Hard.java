import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Hard extends Actor
{
    public void act() 
    {
     if(Greenfoot.mouseClicked(this)){ // if clicked on this
            setImage("button_3_press.png"); // set pressed image
            Start.level=3; // level = 3 = hard
     }
     if(Start.level!=3){ // if not lv hard
         setImage("button_3.png"); // set released image
     }
    }    
}
