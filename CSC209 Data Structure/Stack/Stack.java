public class Stack{
  private String [] data;
  private int top;
  public Stack(int size){
    data = new String [size];
    top = -1;
  }
  public boolean isEmpty(){
   return top < 0;
  }
  public boolean isFull(){
    return top == data.length-1;
  }
  public void push(String p){
    if(!isFull()){
       top++;
       data[top] = p;
    }
  }
  public String pop(){
    String x = "null";
    if(!isEmpty()){
      x = data[top];
      top--;
    }
    return x;
  }
  public String peek(){
    String x = "null";
    if(!isEmpty()){
      x = data[top];
      //top--; //just see number that we contain
    }
    return x;
  }
}