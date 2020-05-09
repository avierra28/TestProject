package holder;


//Begin the class.
public class students
{
 // Declare the attributes.
 private String firstName, lastName, major;
 private int age;

 // Base constructor.
 students()
 {
     this.firstName = "";
     this.lastName = "";
     this.major = "";
     this.age = 0;
 }
 // Overloaded constructor.
 students(String f, String l, String m, int a)
 {
     this.firstName = f;
     this.lastName = l;
     this.major = m;
     this.age = a;
 }
 
 
 
public void hello()
 {
     System.out.println("\nHello World!\n");
 }

 // Getter methods.
 public String getfName()
 {
     return firstName;
 }
 public String getlName()
 {
     return lastName;
 }
 public String getMajor()
 {
     return major;
 }
 public int getAge()
 {
     return age;
 }

 public void setfName(String f)
 {
     this.firstName = f;
 }
 public void setlName(String l)
 {
     this.lastName = l;
 }
 public void setMajor(String m)
 {
     this.major = m;
 }
 public void setAge(int a)
 {
     this.age = a;
 }

}




