import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Building extends Objects
{
    public Building(){ // defalut constructor
        int randomHouse = Greenfoot.getRandomNumber(3); // random number from 0-2
        if(randomHouse == 0){ //if = 0
            GreenfootImage house1 = new GreenfootImage("house1edited.png");
            setImage(house1); // set image 0
        } else if(randomHouse == 1){ // if = 1
            GreenfootImage house2 = new GreenfootImage("house2edited.png");
            setImage(house2); // set image 2
        } else if(randomHouse == 2){ // if = 2
            GreenfootImage house3 = new GreenfootImage("house3edited.png");
            setImage(house3); // set image 3
        }
    }
    public Building(String fileName){ // set image by using file name
        setImage(fileName);
    }
}
