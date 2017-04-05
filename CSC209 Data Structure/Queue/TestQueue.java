public class TestQueue{
  public static void main(String [] args){
    Queue q1 = new Queue(3);
    q1.enqueue("Siri");
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    q1.enqueue("Siri");
    q1.enqueue("Siri");
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());   
  }
}