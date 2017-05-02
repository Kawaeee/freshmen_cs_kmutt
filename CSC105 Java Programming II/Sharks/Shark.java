import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Shark extends Actor
{
    public static boolean isDown;
    public static boolean stopMover = false; // stop moving
    public static boolean mudPower = false; // powerup boolean
    public static int poweruptime;
    public void act() 
    {
        checkKey();
        pressA();
        jump();
        if(mudPower==true){
        poweruptime++;
        if(poweruptime>=500){
            mudPower=false;
            poweruptime = 0;
        }
        } 
        if(Game.HP.value>=2010){
            Game.HP.value = 2000;
        }
        //jumpMovement();
        //timeJump++;
    }  
    
    public void checkKey(){
        if(getX()>=60) move(-3);
        if(Game.HP.value>0 && stopMover==false){
            if(Greenfoot.isKeyDown("left")) move(-5);
            if(Greenfoot.isKeyDown("right")) move(5);
            if(Greenfoot.isKeyDown("down")) setLocation(getX(), getY()+2);
            if(Greenfoot.isKeyDown("up")){
                if(getY() >= 390){
                    setLocation(getX(), getY()-2); 
                }
            }
        } 
  } 
  public void pressA(){
        if(Timer.playtime>0 && stopMover==false){
            if ( !isDown && Greenfoot.isKeyDown("space") ) {
                if(mudPower==true){
                setImage ("mud_shark2.png");
                }else if(mudPower==false){
                setImage ("shark2.png");
                }
                isDown = true;
            }
            if ( isDown && !Greenfoot.isKeyDown("space") ) {
            if(mudPower==true){
                setImage ("mud_shark.png");
                }else if(mudPower==false){
                setImage ("shark.png");
            }
                isDown = false;
            }
        }
    }
    public int goUp;
    public int groundLevel=450;
    boolean isJump = false;
    public void jump()
    {
        if(stopMover==true){
            setLocation(getX(),groundLevel);
        }
        boolean onGround = (getY() == groundLevel);
        if (!onGround && isJump && stopMover==false)
        {
           goUp++;
           setLocation(getX()+5, getY()+goUp);
           if (getY()>=groundLevel)
           {
                setLocation(getX(), groundLevel);
                isJump = false;
            if(mudPower==true){
                setImage("mud_shark.png");
            } 
            else if(mudPower==false){
                setImage("shark.png");
            }
           }
        }
        else
        {
            if (Greenfoot.isKeyDown("control") && !isJump)
            {
                goUp = -23;
                setLocation(getX()+5, getY()+goUp);
             if(mudPower==true){
                setImage("mud_sharkup.png");
            } 
            else if(mudPower==false){
                 setImage("sharkup.png");
            }
                //turn(45);
                isJump=true;
                //setImage(new GreenfootImage("sharkup.png"));
            }
        }
    }
    
    int timeJump = 0;
    public void jumpMovement(){
        if(isJump == true){
            timeJump++;
            if(timeJump <= 10){
             if(mudPower==true){
                setImage("mud_sharkup.png");
            } 
            else if(mudPower==false){
                 setImage("sharkup.png");
            }
            } /*else if(timeJump > 10 && timeJump < 13){
                setImage(new GreenfootImage("shark.png"));
            }**/ else if(timeJump >= 13){
             if(mudPower==true){
                setImage("mud_sharkdown.png");
            } 
            else if(mudPower==false){
                 setImage("sharkdown.png");
            }
                timeJump=0;
            }
        }
    }
   
}
