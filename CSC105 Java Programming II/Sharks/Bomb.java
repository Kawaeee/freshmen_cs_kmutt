import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bomb extends Actor
{
    public static int bombtime;
    public static boolean bombcheck;
    public Bomb(){
        bombtime = 0;
        bombcheck = false;
    }
    public void act() 
    {
        if(Start.level == 1){ //level 1
            setLocation(getX(), getY()+2); // set bomb go down
            //setRotation(getRotation()+5);;
            turn(10); //make the bomb turn
        } else if (Start.level == 2){ //level 2
            setLocation(getX(), getY()+3); 
            setRotation(getRotation()+6);
        } else if (Start.level == 3){ //level 3
            setLocation(getX(), getY()+4);
            setRotation(getRotation()+7);
        }
        if(bombcheck==true){ //check if bomb is created 
            bombtime++; //add bombtime 1
        }    
       sharkTouch(); //call shark touch
}
    int randomBomb = Greenfoot.getRandomNumber(80)+370;
    public void sharkTouch(){ //create sharktouch method to do when thw bomb is touching w/ the shark
        if(isTouching(Shark.class)){ //check touch with shark
           if(Shark.mudPower==true){ //check ifthe shark ate puffle
            setRotation(360-getRotation()); 
            move(getRotation());
            bombcheck = true;
            setImage("redbomb.png"); //set to the red bomb
                    if(bombtime>=100){ //make thebomb burst at the time
                        Burst b1 = new Burst("bursttt.png");
                        getWorld().addObject(b1, getX(), getY());
                        Greenfoot.playSound("bomb_sound.mp3");
                        bombcheck = false;
                        bombtime = 0;
                     }
           } else { //touch the shark when itdidnot ate puffle, the shark died
               Burst b1 = new Burst("bursttt.png"); 
               getWorld().addObject(b1, getX(), getY());
               Greenfoot.playSound("bomb_sound.mp3");
               Game.HP.subtract(Game.HP.value); 
               Game.HP.value = 0;
               Shark.stopMover = true;
               if(Game.isPlaying == true){ //show scoreboard
                   getWorld().addObject(new ScoreBoard(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                   getWorld().addObject(new Score(), getWorld().getWidth()/2, 230);
                   getWorld().addObject(new PlayTime(), 315, 287);
                   getWorld().addObject(new EatStuff(), 300, 321);
                   getWorld().addObject(new eatGarbage(),  340, 360);
                   getWorld().addObject(new Buttons("replayBut.png","MyWorld"),430,340);
                   getWorld().addObject(new Buttons("homeBut.png","StartWorld"),515,340);
                   Game.isPlaying = false;
                }
                getWorld().removeObject(this);
            }
          }
           else if(getY() >= randomBomb){ //check if bomb didnot touch the shark, make it burst
            Burst b1 = new Burst("burst.png");
            getWorld().addObject(b1, getX(), getY());
            Greenfoot.playSound("bomb_sound.mp3");
            getWorld().removeObject(this);
        }  
    }
   }

