import java.util.*;
import java.io.*;
public class Hangman{
  
  private String secretWord = "";
  private int guessCount;
  private String dashLine = "";
  private String letterGuessHistory = "";
  private char letterGuess; //pointer
  private String[] word = new String[127142]; //127142 words
  private int wordCount = 0; //count only possible word that you choose the length
  private int secretWordLength;
  private boolean guessResult = false;
  public boolean isPlay = true;
  public static boolean checkLength = false;
  boolean check = false;
  File dict = new File("dictionary.txt");
  
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    Hangman h = new Hangman();
    h.play();
  }
  
  public Hangman(){ //created object 
    
  }
  
  public Hangman(int secretWordLength,int guessCount){
    this.guessCount = guessCount;
    this.secretWordLength = secretWordLength;
    Scanner readdict = null;
    try{
      readdict = new Scanner(dict); // read dictionary
    } catch(Exception e){
      throw new RuntimeException(e);
    }
    int i = 0; 
    while(readdict.hasNext()) { // have next
      String temp = readdict.nextLine();
      if(temp.length()==secretWordLength){
        word[i] = temp;
        i++;
        wordCount++;
      }
    }
    
    for(i = 0; i< secretWordLength; i++){
      dashLine += "_ ";
    }
    
    readdict.close();
  }
  
  public void play(){
    Scanner sc = new Scanner(System.in);
    
    isPlay = true;
    
    while(isPlay==true){
      //checkLength = false;
      
      while(checkLength==false){
        System.out.println("Welcome to Evil Hangman !!!");
        System.out.print("Enter word length :");
        int length = sc.nextInt();
        if(length > 1 && (length != 23 && length != 25 && length != 26 && length != 27) && length < 30){ //no length 1 23 25 26 27
          System.out.print("Enter number of your guess :");
          int count =  sc.nextInt();
          Hangman h = new Hangman(length,count);
          checkLength = true;
          h.play();
        } else {
          System.out.println("Don't have word with that length. Please try again");
        }
      }
      
      if(guessCount==0){
        System.out.println("LOSE !!");
        System.out.println("Your word is : "+getSecretWord());
        isPlay = false;
        playAgain();
        break;
      }

      String temp = dashLine.replaceAll(" ","");
      if(temp.equals(getSecretWord())){
        System.out.println("WIN !!");
        System.out.println("Your word is : "+getSecretWord());
        playAgain();
        break;
      } 
      
      while(guessCount>0){
        System.out.println("Word length : "+secretWordLength);
        System.out.println("Word count : "+wordCount);
        System.out.println("Word : "+displayDashline());
        System.out.println("Guess remaining : "+guessCount());
        System.out.println("Letter that you already used :"+showLetterGuess());
        System.out.println(getSecretWord());
        //String temp = dashLine.replaceAll(" ","");
        System.out.println(temp);
        makeGuess(sc.next().charAt(0));
        break;
      }
      break;
    }
  }
  
  public boolean makeGuess(char ch) {
    guessResult = false;
    letterGuess = ch;
    checkHistory(letterGuess);
    if(checkWord(letterGuess)){
      guessCount--;
      guessResult = false;
    }
    else{
      for(int i = 0; i < secretWord.length(); i++){
        if(secretWord.charAt(i) == ch){
          String temp = "";
          for(int j = 0; j < secretWord.length(); j++){
            if(secretWord.charAt(j) == ch)
            {
              temp = temp + ch + " ";
            }
            else
            {
              temp = temp + dashLine.charAt(2*j) + dashLine.charAt(2*j+1);              
            }
          }
          dashLine = temp;
          guessResult = true;
          break;
        }
      }
    } 
    return guessResult;
  }
  
  public boolean checkWord(char ch) {
    int tempWordCount = 0;
    for (int i = 0; i < wordCount; i++) {
      for (int j = 0; j < secretWordLength; j++) {
        if (word[i].charAt(j) == ch){ 
          break;
        } else {  
          if (j == secretWordLength - 1){
            if (word[i].charAt(j) != ch) {
              tempWordCount++;
            }
          }
        }
      }
    }
    String[] temp = new String[tempWordCount];
    int tempIndex = 0;
    for (int i = 0; i < wordCount; i++) {
      for (int j = 0; j < secretWordLength; j++) {
        if (word[i].charAt(j) == ch) {
          break;
        } else {
          if (j == secretWordLength - 1) {
            if (word[i].charAt(j) != ch) {
              temp[tempIndex] = word[i];
              tempIndex++;
            }
          }
        }
      }
    }
    if(tempWordCount==0){
      secretWord = word[0];
      return false;
    } else {
      secretWord = temp[0];
      wordCount = tempWordCount;
      word = temp;
      return true;
    }
  }
  
  public void playAgain(){
    Scanner sc = new Scanner(System.in);
    
    while(check==false){
      System.out.println("Do you want to play again ? // type y for yes,type n for no");
      char input = sc.next().charAt(0);
      if(input=='y' || input=='Y'){
        check = true;
        checkLength = false;
        play();
        break;
      }
      else if(input=='n' || input=='N'){ 
        isPlay = false;
        checkLength = true;
        check = true;
        System.out.println("Thank for playing !!");
      }
      else {
        System.out.println("Invalid input, Try again !!");
        playAgain();
      }
    }
    
  }
  
  public void checkHistory(char ch){
    String temp = letterGuessHistory.replaceAll(" ","");
    for(int i = 0; i< temp.length(); i++){
      if(temp.charAt(i)==ch){
        System.out.println("Please input again // Be careful if you always answer wrong but you know about it, it will decrease you guesscount");
        Scanner sc = new Scanner(System.in);
        makeGuess(sc.next().charAt(0));
      }
    }
  }
  
  public String getSecretWord() {
    return secretWord;
  }
  
  public int guessCount() {
    return guessCount;
  }
  
  public String displayDashline() {
    return dashLine;
  }
  
  public String showLetterGuess() {
    if (!guessResult) {
      letterGuessHistory = letterGuessHistory +" "+ letterGuess;
    }
    return letterGuessHistory;
  }
  
}