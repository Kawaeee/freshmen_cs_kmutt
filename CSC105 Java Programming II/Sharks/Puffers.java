import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Puffers extends FloatObjects
{
    int timeFloat;  
    public void act() 
    {
        timeFloat++;
        moving();
        eaten();
        //setRotation(getRotation()+20);
    }    
    public Puffers(){
       GreenfootImage can1 = new GreenfootImage("puffers.png");
       setImage(can1);
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
            Burst b1 = new Burst("blood.png");
            getWorld().addObject(b1, getX(), getY()+70);
            Game.eatStuff++;
            if(Game.HP.value>0){
                Game.HP.add(300);
            }
            Shark.mudPower = true;
            Greenfoot.playSound("powerup_sound.mp3");
            getWorld().removeObject(this);
        } else if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
