package com.tony.beginnerSpring;

public class Client 
{
	private int cid;
	private String fName, lName;
	
	
	public Client() 
	{
		super();
	}

	public Client(int cid, String fName, String lName)
	{
		super();
		this.cid = cid;
		this.fName = fName;
		this.lName = lName;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	@Override
	public String toString() {
		return "Client [cid=" + cid + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	
}
