import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Tutorial extends Actor
{
    public void act() 
    { 
        getWorld().addObject(new Buttons("home2.png", "StartWorld"), 530, 410); // tell world to add object home buttons
    }    
}
