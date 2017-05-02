import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Sign extends Actor
{
    public GreenfootImage img; 
    public GreenfootImage img2; 
    int time=0; //warning time
    public void act() 
    {
        warning();
    }    
    public Sign(){
        img = new GreenfootImage("sign.png"); // declare it equal to name of picture file
        img2 = new GreenfootImage("sign2.png");
        setImage(img);
    }
    public void warning(){
       int tempX = getX(); // get x coor
       int tempY = getY(); // get y coor
       time++; 
       if(time%7==0){ // if it %7 equal to 0
           if(getImage() == img){
               setImage(img2); //set sign
           } else {
                setImage(img);
           }
       }
       if(time%200==0){
           getWorld().addObject(new Bomb(), getX(), 0); // add the bomb on warning position
           getWorld().removeObject(this); // remove it
           time=0; // reset warning time
        }
    }
}
