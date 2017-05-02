import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Goldfish extends FloatObjects
{
    int timeFloat;
    public void act() 
    {
        timeFloat++;
        moving();
        eaten();
    }    
    public Goldfish(){ //setpic of glodfish
       GreenfootImage can1 = new GreenfootImage("goldfish.png");
       setImage(can1);
    }
    public void moving(){ //make it move and float
        if(Start.level==1){ //moving left
            move(-2);
        } else if (Start.level==2){
            move(-3);
        } else if (Start.level==3){
            move(-4);
        } 
        if(timeFloat%30==0){ //float up anf down
            setLocation(getX(), getY()+3);
        } else if (timeFloat%59==0){
            setLocation(getX(), getY()-3);
            timeFloat=0;
        }
    }
    public void eaten(){
        if(Shark.isDown & isTouching(Shark.class)){ //touch shark
            Burst b1 = new Burst("blood.png");
            getWorld().addObject(b1, getX(), getY()+70);
            Game.eatStuff++;
            if(Game.HP.value>0){ //set HP
                Game.HP.add(2000);
            }
            Greenfoot.playSound("powerup_sound.mp3");
            getWorld().removeObject(this);
        } else if (isAtEdge()){ //not touch the shark
            getWorld().removeObject(this);
        }
    }
}
