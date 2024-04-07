
public class CircularList {

  
    public static void main(String[] args) {
        
        CircularLinkedList list = new CircularLinkedList();
        
        list.addLast(10);
        list.addFirst(20);
        list.addFirst("DS");

        list.addLast("Java");
        list.addLast(7);
        list.display();
        System.out.println("\nFirst element: " + list.first());
        System.out.println("\nLast element: " + list.last());
        System.out.println("\nAdd At Position 8: ");
        list.addNode(600,8);
        System.out.println("\nAdd At Position 2: ");
        list.addNode(50, 2);
        list.display();
        System.out.println("\ncalling Rotate Method 1st time: ");
        list.rotate();
        list.display();
        System.out.println("\ncalling Rotate Method 2nd time: ");
        list.rotate();
        list.display();
        
      
        list.display();
    }//end of main
    
}//end of class


        
 
 