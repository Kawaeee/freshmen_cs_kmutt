import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Boats extends FloatObjects
{
    int timeFloat;
    public void act() 
    {
        // Add your action code here.
        timeFloat++;
        moving();
        eaten();
    }    
    public Boats(){
        int randomHouse = Greenfoot.getRandomNumber(3);
        if(randomHouse == 0){
            GreenfootImage boat1 = new GreenfootImage("boat1.png");
            setImage(boat1);
        } else if(randomHouse == 1){
            GreenfootImage boat2 = new GreenfootImage("boat5.png");
            setImage(boat2);
        } else if(randomHouse == 2){
            GreenfootImage boat3 = new GreenfootImage("boat3.png");
            setImage(boat3);
        } else if(randomHouse == 3){
            GreenfootImage boat4 = new GreenfootImage("boat4.png");
            setImage(boat4);
        }
    }
    public void moving(){
        if(Start.level==1){
            move(-2);
        } else if (Start.level==2){
            move(-3);
        } else if (Start.level==3){
            move(-4);
        } 
        
        if(timeFloat%30==0){
            setLocation(getX(), getY()+3);
        } else if (timeFloat%59==0){
            setLocation(getX(), getY()-3);
            timeFloat=0;
        }
    }
    public void eaten(){
        if(Shark.isDown & isTouching(Shark.class)){
            Burst b1 = new Burst("bursttt.png");
            getWorld().addObject(b1, getX(), getY()+20);
            Game.eatStuff++;
            //Game.eatBoat++;
            if(Game.HP.value>0){
                Game.HP.add(150);
            }
            Greenfoot.playSound("bite_sound.mp3");
            getWorld().removeObject(this);
        } else if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
