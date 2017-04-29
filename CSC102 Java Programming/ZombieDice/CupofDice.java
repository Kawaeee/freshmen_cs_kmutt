import java.util.Random; 
import java.util.Stack; 

public class CupofDice {
  private Random random; 
  private Stack<Dice> theCup; 
  
  public CupofDice(Stack<Dice> theCup){
    this.theCup = theCup;
    random = new Random(System.currentTimeMillis());
  }
  
  public CupofDice(){
    random = new Random(System.currentTimeMillis()); 
    theCup = new Stack<Dice>(); 
    
    for(int i =0; i<3; i++){ //Red Dice
      theCup.push(new Dice(2,1,3,"Red",random)); 
    }
    for(int i =0; i<4; i++){ // Yellow Dice
      theCup.push(new Dice(2,2,2,"Yellow",random)); 
    }
    for(int i =0; i<6; i++){ //Green Dice
      theCup.push(new Dice(2,3,1,"Green",random)); 
    }
  }
  public Random randomtheDice(){ 
    return random;
  }
  public Stack<Dice> getCup(){ 
    return theCup;
  }
  
}