import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Garbage extends FloatObjects
{
    int timeFloat;
    public void act() 
    {
        timeFloat++;
        moving();
        eaten();
        
    }    
    public Garbage(){
        setImage(new GreenfootImage("garbage.png"));
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
            Burst b1 = new Burst("poisonSmoke.png");
            getWorld().addObject(b1, getX(), getY());
            Game.eatGarbage++;
            if(Game.HP.value>0){
             Game.HP.subtract(300);
            }
            Greenfoot.playSound("ouch_sound.mp3");
            getWorld().removeObject(this);
        } else if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
