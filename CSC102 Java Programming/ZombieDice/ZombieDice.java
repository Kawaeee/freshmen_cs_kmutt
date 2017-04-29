import java.util.Random; 
import java.util.Stack; 
import java.util.Scanner;
public class ZombieDice{
  public static void main(String[] args){
    CupofDice game = new CupofDice(); 
    Gameplay gameplay = new Gameplay(game.getCup(),game.randomtheDice());
    gameplay.plays();
  }
}
  
  