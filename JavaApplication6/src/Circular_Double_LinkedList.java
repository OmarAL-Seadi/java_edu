
public class Circular_Double_LinkedList {

  
    public static void main(String[] args) {
        CircularDoubleLinkedList<Course> list=new CircularDoubleLinkedList<Course>();
        
        list.addFirst(new Course(121, "OOP1"));
        list.addFirst(new Course(333, "OOP2"));
        list.addFirst(new Course(444, "AI"));
        list.addFirst(new Course(512, "Data Structures"));
        list.addFirst(new Course(616, "Digital Hardware"));
        list.addLast(new Course(333, "Math1"));
        list.addFirst(new Course(512, "Math2"));
        list.addFirst(new Course(300, "Islamic"));
        list.addLast(new Course(444, "Physics"));
       
        list.displayForward();
        list.displayBackward();
        
        list.findDuplicate();

        System.out.print("\n** Find ID (333) : ");
        list.findNode(new Course(333,""));
        
        System.out.println("\nFirst Node :"+ list.first());
        System.out.println("Last Node :"+ list.last());
        System.out.println("----------------------------------------");
        
        list.removeNode(new Course(333,""));
        list.removeNode(new Course(333,""));
        list.displayForward();
        
        System.out.println("First Node: "+ list.first());
        System.out.println("Last Node: "+ list.last());
    
    }//end of main   
    
}//end of class 



    
