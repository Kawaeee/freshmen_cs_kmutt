import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Ground extends Objects
{
    public void act() 
    {
        moving(-1); // move the ground
    }    
    public Ground(String fileName){
        setImage(fileName); // set picture by using file name
    }
    public Ground(){
        int randomGround = Greenfoot.getRandomNumber(4); // random number from 0-3
        if(randomGround == 0){ // if = 0
            GreenfootImage ground1 = new GreenfootImage("gound1.png"); 
            setImage(ground1); // set image 0
        } else { // if not
            GreenfootImage ground2 = new GreenfootImage("gound2.png"); 
            setImage(ground2); // set image 1
        }
    }
}
