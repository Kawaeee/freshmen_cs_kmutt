import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
//import javax.swing.JOptionPane;
public class PlayerName extends Actor
{
    static String playername;
    private static final Color transparent = new Color(0,0,0,0);
    boolean check1;
    int check;
    String inputValue;
    public PlayerName(){
        check1 = false;
        while(check1!=true){
        if(check==0 || check>8){
          inputValue = JOptionPane.showInputDialog("Please input your name..(1-8 characters)");
          check = inputValue.length();
          if(check==0){
              inputValue = "Untitled";
              check = inputValue.length();
            }
    }
     else{
            check1 = true;
        }
        playername = inputValue;
    }
}
     public void act() {
        setImage(new GreenfootImage("Player name :  "+playername, 18, Color.BLACK, transparent));
}     
}
