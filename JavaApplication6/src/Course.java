public class Course {

    private int ID;
    private String name;
    
    public Course(){ this(0,null);}
    
    public Course(int ID, String name)
    {
        this.name=name ;
        this.ID=ID; 
    }//end of counstructor with arguments

    public String getName() { return name;  }
    public void setName(String name) {  this.name = name;   }

    public int getID() {  return ID;   }
    public void setID(int ID) { this.ID = ID;  }

    @Override
    public String toString() {
        return "( ID: "+ID + ", Name: " + name +" )"; 
    }//end of toString

    @Override
    public boolean equals(Object o) {
      return (this.ID==((Course)o).ID);    
    }//end equals    
    
}//end of class
//------------------------------------
