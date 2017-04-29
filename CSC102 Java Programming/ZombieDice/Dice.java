import java.util.Random; 
import java.util.ArrayList; 
public class Dice {
  ArrayList<String> sides; 
  String diceType; 
  private Random random; 
  public Dice(ArrayList<String> sides,String diceType,Random random){ 
    this.sides = sides;
    this.diceType = diceType;
    this.random = random;
  }
  public Dice(int run,int brain,int shot,String diceType,Random random){ 
    this.diceType = diceType;
    ArrayList<String> sides = new ArrayList<>(run+brain+shot); 
    for(int i = 0; i<run; i++){
      sides.add("Run"); 
    }
    for(int i = 0; i<brain; i++){
      sides.add("Brain"); 
    }
    for(int i = 0; i<shot; i++){
      sides.add("Shot"); 
    }
    this.sides = sides;
    this.random = random;
  }
  
  public String rolltheDice(){ 
    int roll = random.nextInt(sides.size()); 
    return sides.get(roll); 
  }
  public String getDiceType(){ 
    return diceType;
  }
  
}