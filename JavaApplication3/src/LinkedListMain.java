
public class LinkedListMain {

   
    public static void main(String[] args) {
        
               LinkedList myList = new LinkedList();
        
        myList.findNode(2);
        
        myList.addFirst("Nada");
        myList.addFirst(10);
        myList.addFirst('X');
        myList.addFirst(50.5);
        myList.display();
        
        myList.addFirst("Sara");
        myList.display();
        
        myList.removeNode('X');
        myList.display();
        
        myList.addNode("hi", 2);
        myList.display();
        
        myList.removeNode("Nada");
        myList.display();
        
       System.out.println("\n"+myList.last());
       myList.findNode(2);
        
    }//end of main   
    
}//end of class

    
    

