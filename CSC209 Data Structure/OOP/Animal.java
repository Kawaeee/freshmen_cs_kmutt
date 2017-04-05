public class Animal{
  String name;
  String type;
  String food;
  public Animal(){
    type = "-";
    name = "-";
    food = "-";
  }
  public Animal(String name,String type,String food){ 
    this.name = name;
    this.type = type;
    this.food = food;
  }
  public void setName(){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setType(){
    this.type = type;
  }
  public String getType(){
    return type;
  }
  public void setFood(){
    this.food = food;
  }
  public String getFood(){
    return food;
  }
  
  
}