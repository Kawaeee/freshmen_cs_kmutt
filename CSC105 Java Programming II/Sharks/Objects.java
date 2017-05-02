import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Objects extends SmoothMover
{
    public void moving(int speed){ // method for move the object
        move(speed);
        if(isAtEdge()){ // at world edge
            getWorld().removeObject(this); // remove it
        }
    }
}
