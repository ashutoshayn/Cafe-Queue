
/**
 * @author Ashutosh Aryan
 * @version 03/06/2026
 */
public class Person
{
   private String name;
   private boolean isTeacher;
   
   public Person(String name, boolean isTeacher){
       this.name = name;
       this.isTeacher = isTeacher;
   }
   
   public String name(){
       return name;
   }
   
   public boolean isTeacher(){
       return isTeacher;
   }
   
   public String toString() {
        if (isTeacher) {
            return name + " (Teacher)";
        } else {
            return name + " (Student)";
        }
   }
}