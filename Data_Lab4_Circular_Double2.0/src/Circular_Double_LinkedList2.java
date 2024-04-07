
public class Circular_Double_LinkedList2 {

  
    public static void main(String[] args) {
           CircularDoubleLinkedList2 myList = new CircularDoubleLinkedList2();
       
       myList.lock ();
        myList.addLast(-20);
        myList.unlock();
        myList.addLast(-20);
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(50);
        myList.addLast(50);
         myList.displayBackward();
        myList.addLast(50);
        myList.addLast(20);
        myList.displayForward();
        
       System.out.println("\n"+myList.last());
       myList.findNode(2);
        
    }//end of main   
    
}//end of class


    
