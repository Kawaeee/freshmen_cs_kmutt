//oop vector stack queue singly doubly raf recursion
public class Queue{
 String[] name;
 int first,last;
 public Queue(int size){
  name =  new String[size];
  first = last = -1;
 }
 public boolean isEmpty(){
   return last < 0 ;
 }
 public boolean isFull(){
    return ((first==0 && last == name.length-1) || (last==first-1));
 }
 public void enqueue(String newName){
   if(!isFull()){
     last++;
     if(last==name.length){
       last = 0;
     }
   }
   name[last] = newName;
   if(first==-1){
     first = 0;
   }
 }
 public String dequeue(){
   String x = "null"; 
   if(!isEmpty()){
      x = name[first];
      if(first==last){
       first = last = -1; 
      } else {
       first++;
       if(first==name.length){
         first = 0;
       }
      }
   }
   return x;
 }
}