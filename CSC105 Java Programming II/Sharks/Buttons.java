import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Buttons extends Actor
{
    GreenfootImage img; // create variable for image
    String world; // input to check world
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && world.equals("MyWorld")){ // if clicked on it and input = MyWorld
            if(Start.level > 0){
                Greenfoot.setWorld(new Game()); //set new Game
            } else if(Start.level == 0){
                getWorld().addObject(new chooseStage(),getWorld().getWidth()/2, 285); //warning that you wasn't choose th satge
            }
        } else if(Greenfoot.mouseClicked(this) && world.equals("StartWorld")){ // if clicked on it and input = StartWorld
            Greenfoot.setWorld(new Start()); // back to menu
        } else if(Greenfoot.mouseClicked(this) && world.equals("ttr")){ // if clicked on it and input = ttr
            getWorld().addObject(new Tutorial(), getWorld().getWidth()/2, getWorld().getHeight()/2); // add Tutorial to the screen
        }
    }    
    public Buttons(String fileName, String world){ // constructor require 2 parameter that is name of world and pic
        img = new GreenfootImage(fileName); // read from constuctor
        setImage(img); // set picture
        this.world = world;
    }
}
