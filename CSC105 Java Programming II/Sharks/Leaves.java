import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Leaves extends Objects
{
    public void act() 
    {
        moveRandom();
    }    
    public Leaves(){
        int randomHouse = Greenfoot.getRandomNumber(2);
        if(randomHouse == 0){
            GreenfootImage b1 = new GreenfootImage("b3.png");
            setImage(b1);
        } else if(randomHouse == 1){
            GreenfootImage b2 = new GreenfootImage("b4.png");
            setImage(b2);
        }
    }
    public void moveRandom(){
        if(isAtEdge() || getY() > 300){
            turn(5);
        }
        if(Greenfoot.getRandomNumber(100) < 10){
            turn(Greenfoot.getRandomNumber(90)-45);
        }
        move(1);
    }
}
