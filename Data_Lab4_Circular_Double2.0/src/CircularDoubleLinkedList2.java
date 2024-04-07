public class CircularDoubleLinkedList2<E> {
    
    //Nested Node inner-class:
    private static class Node<E> {
        private int data;            //reference to the data in the Node
        private Node<E> next;      //reference to the next Node in the list
        private Node<E> prev;      //reference to the previos Node in the list
        
        Node(int data, Node<E> next, Node<E> prev) {  
            this.data = data;
            this.next = next;
            this.prev = prev;
        }//end of Node constructor

        int getData() { return data;  }
        Node<E> getNext() {  return next;  }
        Node<E> getPrev() {  return prev;  }
        
        void setData(int data) {  this.data = data; }
        void setNext(Node<E> next) { this.next = next; }
        void setPrev(Node<E> prev) { this.prev = prev; }
    }//end of Node class
    //--------------------------------------------------
    
    //Attributes
    private Node<E> head = null;   
    private Node<E> tail = null;   
    private int size = 0;    
    private boolean open=true;
    
   public void lock (){
   open=false;
   }
   
   public void unlock (){
   open=true;
   }
    
   
    
  
    
    //Constructor(s)
    public CircularDoubleLinkedList2() { }
    
    //Accessor methods
    public int size() { return size; }
    public boolean isEmpty() {return (size == 0);}
    
    public int first() {  
        if (isEmpty()) return -1;
        return head.getData();  
    }//end of first
    
    public int last() {
        if (isEmpty()) return -1;
        return tail.getData(); 
    }//end of last
   
    //--------------------------------------------------
    //Operations on Circular Double linked List: 
    
    public void displayForward(){
        if(isEmpty()){
           System.out.println("\nEmpty List.. ");
           return;
        }//end if
        
        System.out.print("\n********** Display List ***************\n");
        Node<E> current = head;
        int count=1;
        do{
            System.out.println("Node "+count+" :"+current.getData());
            current = current.next;
            count++;
        }while(current!=head); 
        System.out.println("***************************************\n");       
    }//end displayF
    
    public void displayBackward() {
        if(isEmpty()){
           System.out.println("\nEmpty List.. ");
           return;
        }//end if
        
        System.out.print("\n********** Display List ***************\n");
        Node<E> current = tail;
        int count=1;
        do{
            System.out.println("Node "+count+" :"+current.getData());
            current = current.prev;
            count++;
        }while(current!=tail); 
        System.out.println("***************************************\n");          
    }//end displayB
    //--------------------------------------------------
    
    public void findNode(int key) {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if
        
        Node<E> current = head;
        int counter = 1;
        do{  
            if ((current.getData() == key)) 
            {
                System.out.println("Found in position# " + counter);
                return;
            }//end if
            
            counter++;
            current = current.next;
        }while(current!=head); //end loop
        
        //if not found i.e. current==head again
        System.out.println("\nNot found...");      
    }//end find

    public void findDuplicate() { //works only with LL of similar data types 
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        if (size==1) {
            System.out.println("\nNo duplicates...");
            return;
        }//end if 
       
        Node<E> current1 = head;
        boolean flag=false;
        
        do {
            Node<E> current2 = current1.next;
            while (current2 != head) {
                if ((current1.getData() == current2.getData())) 
                {
                    flag=true;
                    System.out.println("Duplicate nodes for " + current1.getData() + ">> " + current2.getData() );
                    break;  //with break it will find one duplicate only
                }//end if
                current2 = current2.next;
            }//end inner loop
            current1 = current1.next;
        } while (current1 != head); //end outer loop
        
        //if not found i.e. flag is never true
        if (!flag)
            System.out.println("There are no duplicates in the doubly circular linked list...");  
        
    }//end findDuplicate    
    //--------------------------------------------------
    
  

    public void addLast(int data) { 
        if (!open){
            System.out.println("\n The linked list is locked; you must remove the locking before adding");
            return;
        }
        if(data < 0){
               System.out.println("\n The linked list cannot accept any number divided by 5 ");
               return;
        }
        Node<E> newNode = new Node(data, null, null);
         if (size>=5) {
            System.out.println("\nThe linked list cannot accept more than five nodes");
            return;}
         
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next=head;
            newNode.prev=head;
        } 
        else{
            newNode.prev=tail;
            tail.next=newNode;
            head.prev=newNode;
            newNode.next=head;
            tail = newNode;
        }//end if-else
        size++;
       //System.out.println("\nThe last node has been added successfully.. ");   
       
    }//end of addLast
    //--------------------------------------------------
    
    public void removeFirst() {
         if (!open){
            System.out.println("\n The linked list is locked; you must remove the locking before adding");
            return;
        }
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if
        
        head = head.next;
        tail.next=head;
        head.prev=tail;
        size--;
        System.out.println("\nThe 1st node has been deleted successfully.. ");
        
        if (size == 0) { tail =head = null; }   //if this was the last and only node.. ﬁx tail& head
    }//end of removeFirst
    
    
    
}//end of CircularDoubleLinkedList class

//----------------------------------
