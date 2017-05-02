import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Cans extends FloatObjects
{
    int timeFloat;
    public void act() 
    {
        timeFloat++;
        moving();
        eaten();
    }    
    public Cans(){ //set pic of can
        GreenfootImage can1 = new GreenfootImage("can.png");
        setImage(can1);
    }
    public void moving(){ //make the can moving, floating
        if(Start.level==1){ //level 1
            move(-2);
        } else if (Start.level==2){ //level 2
            move(-3);
        } else if (Start.level==3){ // level 3
            move(-4);
        } 
        if(timeFloat%30==0){ //make the can floating (up and down)
            setLocation(getX(), getY()+3);
        } else if (timeFloat%59==0){
            setLocation(getX(), getY()-3);
            timeFloat=0;
        }
    }
    public void eaten(){ //check if the can got eaten
        if(Shark.isDown & isTouching(Shark.class)){ //shark eat the can
            Burst b1 = new Burst("poisonSmoke2.png");
            getWorld().addObject(b1, getX(), getY());
            Game.eatGarbage++;
            if(Game.HP.value>0){ //set hp
                Game.HP.subtract(150);
            }
            Greenfoot.playSound("ouch_sound.mp3");
            getWorld().removeObject(this);
        } else if (isAtEdge()){ //remove if not touch shark
            getWorld().removeObject(this);
        }
    }
}
