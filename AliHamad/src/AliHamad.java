
public class AliHamad {

  
    public static void main(String[] args) {
        CircularDoubleLinked myList = new CircularDoubleLinked();
         myList.addLast(-15);
         myList.displayForward();
        myList.lock();
        myList.removeFirst();
        myList.addLast(3);
         myList.unlock();
         myList.displayForward();
       myList.addLast(5);
       myList.addLast(3);
       myList.addLast(4);
       myList.displayForward();
       myList.addLast(7);
       myList.addLast(5);
        myList.addLast(7);
       myList.displayBackward();
       myList.displayForward();
       

       
    }
    
}

   