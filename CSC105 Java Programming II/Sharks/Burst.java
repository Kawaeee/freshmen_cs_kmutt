import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Burst extends Actor
{
    /**
     * Act - do whatever the Burst wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int timeBurst = 0;
    public void act(){
       timeBurst++;
       if(timeBurst==40){ //setthe time when the burst is going to be gone
               getWorld().removeObject(this);
       }
    }
    public Burst(String fileName){ //set burst image
        setImage(new GreenfootImage(fileName));
    }
}
