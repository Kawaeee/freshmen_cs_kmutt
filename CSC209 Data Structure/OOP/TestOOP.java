public class TestOOP{
  public static void main(String [] args){
    Animal a1 = new Animal();
    Animal a2 = new Animal("Tiger","Mammalia","Carnivore");
    System.out.println("Name : "+a2.getName());
    System.out.println("Type : "+a2.getType());
    System.out.println("Food : "+a2.getFood());
    System.out.println("---------------------------------");
    Cow c1 = new Cow();
    System.out.println("---------------------------------");
    Lion l1 = new Lion();
    System.out.println("Type : "+l1.getType());
    System.out.println("---------------------------------");
  }
}