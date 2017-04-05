public class TestStack{
  public static void main(String [] args){
    Stack s1 = new Stack(5);
    s1.push("10");
    s1.push("5");
    s1.push("0");
    s1.push("5");
    s1.push("10");
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    s1.push("Siri");
    System.out.println(s1.pop());
  } 
}