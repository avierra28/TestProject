package advancedDatastructures;

public class Student implements Comparable<Student> {

	private String fName, lName, address;
	private int age;
	
	

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", address=" + address + ", age=" + age + "]";
	}

	public Student() {
		super();
	}

	public Student(String fName, String lName, String address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}
	
	

	public Student(String fName, String lName, String address, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Student o) {
		
//		if(this.age == o.age)
//			return 0;
//		else if(this.age > o.age)
//			return 1;
//		else {
//			return -1;
//		}
		
		return fName.compareTo(o.fName);
	}
	
	
}







