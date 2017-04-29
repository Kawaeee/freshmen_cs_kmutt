import java.util.Random; 
import java.util.Scanner;
import java.util.Stack; 

public class Gameplay{
  public int shotperRound;
  public int brainperRound; 
  Random random; 
  private static Scanner sc;
  final int DICEINHAND = 3; 
  final int KILLSHOT = 3; 
  Stack<Dice> theCup; 
  Stack<Dice> alreadyUse; 
  Stack<Dice> runDice;
  
  public Gameplay(Stack<Dice> theCup,Random random){ 
    this.theCup = theCup;
    this.random = random;
    sc = new Scanner(System.in); 
    alreadyUse = new Stack<Dice>(); 
    runDice = new Stack<Dice>(); 
  }
  
  public int plays(){ //Play
    
    System.out.println("------------------------------------WELCOME TO ZOMBIE DICE---------------------------------------");
    System.out.println("In Zombie Dice, you are a zombie. You want braaains – more brains than any of your zombie buddies.");
    System.out.println("-----------------------------We have a different 13 type of the dice------------------------------");
    System.out.println("--------------------------------------------------------------------------------------------------");
    
    boolean loop = false;
    while(loop==false){
      printinstruction();
      System.out.println("DID YOU READ IT CLEARLY? // TYPE Y for YES, N for NO");
      String ins = sc.next();
      if(ins.toUpperCase().equals("Y")){
        loop = true;
      }
      else if(ins.toUpperCase().equals("N")){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("TRY TO READ IT AGAIN PLEASE");
        System.out.println("--------------------------------------------------------------------------------------------------");
      }
      else {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("PLEASE INPUT CORRECTLY PLEASE");
        System.out.println("--------------------------------------------------------------------------------------------------");
      }
    }
    
    boolean loop0 = false;
    int replayer = 0;
    
    while(loop0==false){
      System.out.println("HOW MANY PLAYER DO YOU WANT TO PLAY? //PLEASE TYPE ONLY POSITIVE NUMBER");
      int player = sc.nextInt();
      String thisdoesnotmatter = sc.nextLine();//not matter
      if(player<=1){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("PLEASE INPUT CORRECTLY PLEASE");
        System.out.println("--------------------------------------------------------------------------------------------------");
      }
      else{
        loop0 = true;
        replayer = player;
      }
    }
    
    int players[] = new int[replayer];
    int scores[] = new int[replayer];
    int amountplayer[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    String playernames[] = new String[replayer];
    
    for(int i =0; i<replayer; i++){
      System.out.print("PLAYER "+(i+1)+" NAME : "); 
      playernames[i] = sc.nextLine();
    }
    
    int turn = 1;
    int playerpass = 0;
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("-------------------------------------------ZOMBIE DICE--------------------------------------------");
    System.out.println("TURN "+turn+" "+" PLAYER "+amountplayer[playerpass]);
    System.out.println("PLAYER NAME : "+playernames[playerpass]);
    System.out.println("TOTAL BRAINS IN GAME : "+ scores[playerpass]);
    System.out.println("TOTAL BRAINS IN TURN : "+ brainperRound);
    System.out.println("--------------------------------------------------------------------------------------------------");
    boolean rolling = true; 
    brainperRound = 0;
    shotperRound = 0;
    changetheCup();
    
    while(rolling){
      boolean loop2 = true;
      int rollDice = DICEINHAND; 
      if(rollDice > theCup.size()){ 
        rollDice = theCup.size();
      }
      roll(rollDice); 
      scoreinOneRound(); 
      if(shotperRound >= KILLSHOT){ //shot>= 3 end
        System.out.println(playernames[playerpass]+" DIED HAHAHAHAHA");
        brainperRound = 0;
        shotperRound = 0;
        turn = 0;
        changetheCup();
        playerpass++;
        loop2 = false;
      }
      else{
        while(loop2==true){
          System.out.println("KEEP ROLLING? // TYPE Y for YES, N for NO");
          String keepRoll = sc.next();
          String thisdoesnotmatter = sc.nextLine();//not matter
          if(keepRoll.toUpperCase().equals("Y")){
            while(runDice.elements().hasMoreElements()){ 
              theCup.push(runDice.pop());
            }
            while(alreadyUse.elements().hasMoreElements()){ 
              theCup.push(alreadyUse.pop());
            }
            loop2 = false;
          }
          else if(keepRoll.toUpperCase().equals("N")){
            scores[playerpass] += brainperRound;
            brainperRound = 0;
            shotperRound = 0;
            turn = 0;
            playerpass++;
            changetheCup();
            loop2 = false;
          }
          else{
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("PLEASE INPUT CORRECTLY PLEASE");
            System.out.println("--------------------------------------------------------------------------------------------------");
          }
        }
      }
      turn++;
      
      if(playerpass>replayer-1){
        playerpass = 0;
        changetheCup();
      }
      
      if(scores[playerpass]>=13){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println(playernames[playerpass]+" WIN THE GAME !!!!");
        System.out.println("--------------------------------------------------------------------------------------------------");
        checkagain();
      }
      
      System.out.println("--------------------------------------------------------------------------------------------------");
      System.out.println("-------------------------------------------ZOMBIE DICE--------------------------------------------");
      System.out.println("TURN "+turn+" "+"PLAYER "+amountplayer[playerpass]);
      System.out.println("PLAYER NAME : "+playernames[playerpass]);
      System.out.println("TOTAL BRAINS IN GAME : "+ scores[playerpass]);
      System.out.println("TOTAL BRAINS IN TURN : "+ brainperRound);
      System.out.println("--------------------------------------------------------------------------------------------------"); 
      
    }
    
    while(runDice.elements().hasMoreElements()){ 
      theCup.push(runDice.pop());
    }
    while(alreadyUse.elements().hasMoreElements()){ 
      theCup.push(alreadyUse.pop());
    }
    return brainperRound;  
  }   
  
  public void printinstruction(){ //show the instruction
    System.out.println("-----------------------------PLEASE READDD INSTRUCTIONS CAREFULYYYYY------------------------------");
    System.out.println("------------------------------------------RULE & ADVICE-------------------------------------------");
    System.out.println("Each turn, you take three dice from the box and roll them.");
    System.out.println("A brain symbol is worth one point at the end of the round.");
    System.out.println("A run symbol allow you to reroll this particular dice.");
    System.out.println("A shot on the other hand are rather bad.");
    System.out.println("if you collect three shot during your turn, it is over for you and you get no points."); 
    System.out.println("After rolling three dice, you may decide if you want to score your current brain collection.");
    System.out.println("or if you want to push your luck by grabbing new dice so you have three again and roll once more.");
    System.out.println("Push your luck to eat their brains, but stop rolling before the shotgun blasts end your turn!.");
    System.out.println("Whoever first collects 13 brains first wins.");
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("---------------------------WE RECOMMEND TO PLAY WITH FRIEND 2-5 PEOPLE----------------------------");
    System.out.println("--------------------------------------------------------------------------------------------------");
  }  
  
  private void scoreinOneRound(){//show brain and shot in this turn
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("BRAINS : "+ brainperRound);
    System.out.println("SHOTS : "+ shotperRound); 
    System.out.println("--------------------------------------------------------------------------------------------------");
  }
  
  public void checkagain(){
    System.out.println("DO YOU WANT TO PLAY AGAIN ?");
    String answer = sc.next();
    if(answer.equalsIgnoreCase("Y")){
      plays();
    }
    else {
      System.out.println("--------------------------------------------------------------------------------------------------");
      System.out.println("THANK FOR PLAYING");
      System.out.println("--------------------------------------------------------------------------------------------------");
      System.out.println("CREATED BY KASIDECH CHUMKUN ID: 59130500202");
      System.out.println("--------------------------------------------------------------------------------------------------");
    }
  }
  
  private void roll(int rolldice){ //roll the dice
    for(int i =0; i<rolldice; i++){
      Dice theDice = theCup.pop(); 
      String theSide = theDice.rolltheDice();
      showResult(theDice,theSide);
      
      switch(theSide){
        case "Run" :  runDice.push(theDice); break;
        case "Shot" :  alreadyUse.push(theDice); shotperRound++; break;  
        case "Brain" :  alreadyUse.push(theDice); brainperRound++; break;
        default : break; 
      }      
    }
    while(runDice.elements().hasMoreElements())
    {
      theCup.push(runDice.pop());
    }
  }
  
  private void showResult(Dice theDice,String theSide){ //show diceroll
    System.out.println(theDice.diceType+" dice rolled a "+theSide);
  }
  
  public void changeOneTime(Stack<Dice> c1,Stack<Dice> c2){
    boolean isEmpty = false; 
    while(!isEmpty){ 
      for(int i =0; i<=(random.nextInt(2)+1); i++){
        theCup.push(c1.pop());
        if(c1.isEmpty()){
          break;
        }
      }
      for(int i =0; i<= (random.nextInt(2)+1); i++){
        theCup.push(c2.pop());
        if(c2.isEmpty()){
          break;
        }
      }
      isEmpty = c1.isEmpty() || c2.isEmpty();
    }
    while(!c1.isEmpty()){
      theCup.push(c1.pop());
    }
    while(!c2.isEmpty()){
      theCup.push(c2.pop());
    }
  }
  
  public void changetheCup(){
    Stack<Dice> c1 = new Stack<Dice>(); 
    Stack<Dice> c2 = new Stack<Dice>(); 
    for(int i = 0; i<(random.nextInt(3)+4); i++){
      for(int j =0; j< theCup.size()/2; j++){
        c1.push(theCup.pop());
      }
      while(!theCup.isEmpty()){
        c2.push(theCup.pop());
      }
      changeOneTime(c1,c2);
    }
  }
}