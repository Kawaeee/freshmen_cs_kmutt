import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RunLengthCoding{
  public static void main(String[] kawae){
    RunLengthCoding r = new RunLengthCoding();
  }
  public RunLengthCoding(){
    Scanner sc = new Scanner(System.in);
    System.out.println("## Run-Length Codec Menu");
    System.out.println();
    System.out.println("   Enter 1 to Encode");
    System.out.println("   Enter 2 to Decode");
    System.out.println("   Enter Any Integer to Exit ");
    System.out.println();
    int choice = sc.nextInt();
    if(choice==1){
      System.out.println();
      System.out.print("[Encode] Enter the file name: ");
      encode(sc.next());
    }else if(choice==2){
      System.out.println();
      System.out.print("[Decode] Enter the file name: ");
      decode(sc.next());
      
    }
    else{
      System.out.println("--------------------------");
      System.out.println("Thank for using");
      System.out.println("--------------------------");
      System.exit(0);
    }
  }
  
  public void encode(String name){
    Scanner sc = new Scanner(System.in);
    String data= "";
    try{
      FileReader input = new FileReader(new File(name));
      BufferedReader br = new BufferedReader(input); 
      try{
        data = br.readLine();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("--------------------------");
      System.out.println("File not found, Try again");
      System.out.println("--------------------------");
      RunLengthCoding r = new RunLengthCoding();
    }
    
    try{
      FileWriter output = new FileWriter(new File("en_out.txt"));
      String answer = "";
      boolean check = false;
      int count = 1;
      if(data.charAt(0)=='1'){
        answer += "0";
      }
      for(int i =1; i<data.length(); i++){
        if(data.charAt(i)==data.charAt(i-1)){
          count++;
          check = false;
        } else {
          answer += count;
          count = 1;
          check = true;
        }
      }
      if (!check){ 
        answer += count;
      }
      System.out.println();
      System.out.println(" Finish encoding... ");
      System.out.println();
      output.write(answer);
      output.close();
      RunLengthCoding r = new RunLengthCoding();
    }
    catch(IOException e){
      System.out.println("ERROR !!");
    }
  }
  
  public void decode(String name){
    Scanner sc = new Scanner(System.in);
    String data= "";
    try{
      FileReader input = new FileReader(new File(name));
      BufferedReader br = new BufferedReader(input); 
      try{
        data = br.readLine();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("--------------------------");
      System.out.println("File not found, Try again");
      System.out.println("--------------------------");
      RunLengthCoding r = new RunLengthCoding();
    }
    try{
      FileWriter output = new FileWriter(new File("de_out.txt"));
      String answer = "";
      int code;
      for (int i = 0; i < data.length(); i++) {
        if(i%2==0 && i/2%2==0) {
          code = 0;
        }
        else if(i%2==0 && i/2%2==1) {
          code = 1;
        }
        else {
          continue;
        }
        for (int j = 0; j < Integer.parseInt("" + data.charAt(i)); j++) {
          answer += code;
        }
      }
      
      System.out.println();
      System.out.println(" Finish decoding... ");
      System.out.println();
      output.write(answer);
      output.close();
      RunLengthCoding r = new RunLengthCoding();
    }
    catch(IOException e){
      System.out.println("ERROR !!");
    }
  }
}