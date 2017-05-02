import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Start extends World
{
    public static int level; // variable that contain stage 0-1-2-3
    public Start()
    {    
        super(670, 500, 1);  // Create a new world with 670x500 cells with a cell size of 1x1 pixels.
        level=0; // stage 0 = Start
        addObject(new Buttons("startBut.png", "MyWorld"), getWidth()/2, 390); // add Start button
        addObject(new Buttons("ttrBut.png", "ttr"), getWidth()/2, 460); // add Tutorial button
        addObject(new Easy(), 258, 322); // add button stage 1 = easy
        addObject(new Medium(), getWidth()/2, 322); // add button stage 2 = normal
        addObject(new Hard(), 410, 322); // add button stage 3 = hard
    }
}
