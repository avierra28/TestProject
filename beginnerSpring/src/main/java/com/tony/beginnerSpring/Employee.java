package com.tony.beginnerSpring;

public class Employee 
{
	private int eid;
	private String ename, eaddressString;
	
	
	public Employee() 
	{
		super();
		System.out.println("Class instance created.");
	}
	public Employee(int eid, String ename, String eaddressString) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddressString = eaddressString;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddressString() {
		return eaddressString;
	}
	public void setEaddressString(String eaddressString) {
		this.eaddressString = eaddressString;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddressString=" + eaddressString + "]";
	}
	
	public void myInit()
	{
		System.out.println("In my init");
	}
	
	public void myDestroy()
	{
		System.out.println("In my destroy");
	}
	
}
