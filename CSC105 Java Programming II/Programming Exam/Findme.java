import java.util.Scanner;
public class Findme{
  boolean checkUse = false;
  public static void main(String[] xSiri){
    Findme f = new Findme();
  }
  public Findme(){
    Scanner sc = new Scanner(System.in);
    boolean isUse = true;
    System.out.println("----------------------------------------------------------------");
    System.out.println("                   Welcome to Findme program                    ");
    System.out.println("                 Find your number through array                 ");
    System.out.println("----------------------------------------------------------------");
    while(isUse==true){
      System.out.println("----------------------------------------------------------------");
      System.out.print("Enter size of array : ");
      int size = sc.nextInt();
      int arr [] = new int [size];
      System.out.println("----------------------------------------------------------------");
      System.out.print("Enter value : ");
      for(int i =0; i<arr.length; i++){
        int input = sc.nextInt();
        arr[i] = input;
      }
      System.out.println("----------------------------------------------------------------");
      System.out.print("Enter key : ");
      int key = sc.nextInt();
      System.out.println("----------------------------------------------------------------");
      
      int post = 0;
      boolean checkpos = false;
      for(int i = 0; i<arr.length; i++){
        if(key==arr[i]){
          post = i;
          checkpos = true;
          break;
        }
      }
      if(checkpos==true){
        System.out.println("We found "+key+" at position "+post+" !!");
        System.out.println("----------------------------------------------------------------");
        useAgain();
      }else {
        System.out.println("Not Found !!");
        System.out.println("----------------------------------------------------------------");
        useAgain();
      }
    }
  }
  
  public void useAgain(){ 
    Scanner sc = new Scanner(System.in);
    while(checkUse==false){
      System.out.println("                 Do you want to use again ? (y/n)               ");
      System.out.println("----------------------------------------------------------------");
      char input = sc.next().charAt(0);
      if(input=='y' || input=='Y'){ // Yes
        checkUse = true;
        Findme f = new Findme();
        break;
      }
      else if(input=='n' || input=='N'){ // No
        System.out.println("----------------------------------------------------------------");
        System.out.println("                       Thank for using !!                       ");
        System.out.println("----------------------------------------------------------------");
        checkUse = true;
        break;
      }
      else { // not Y or N
        System.out.println("----------------------------------------------------------------");
        System.out.println("                  Invalid input, Try again !!"                   );
        System.out.println("----------------------------------------------------------------");
        checkUse = false;
        useAgain();
      }
    }
  }
}