package java2novice;

public class Deadlock 
{
	String str1 = "Java";
	String str2 = "Language";
	
	Thread thread1 = new Thread("First Thread")
			{
	public void run()
	{
		while(true)
		{
			synchronized (str1) {
				synchronized (str2) {
					System.out.println(str1 + " " + str2);
				}
				
			}
		}
	}
			};
	
	Thread thread2 = new Thread("Second Thread") {
	public void run()
	{
		while(true)
		{
			synchronized (str2) {
				synchronized (str1) {
					System.out.println(str2 + " " + str1);
				}
				
			}
		}
	}
	};

	public static void main(String[] args)
	{
		Deadlock obj1 = new Deadlock(), obj2 = new Deadlock();
		obj1.thread1.start();
		obj2.thread2.start();
	}

}
