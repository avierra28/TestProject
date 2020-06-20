package mathWork;

public class BinaryDecimal 
{
	
	
	public static int conversion(int num)
	{
		int temp = 1, temp2 = 2, total = 0, counter = 0;
		
		while(num > 0)
		{
			int holder = num % 10;
			
			if(counter == 0)
			{
				if(holder == 1)
					total += 1;
				else {
					total = 0;
				}
				num = num/10;
				counter++;
				
				continue;
			}
			
			if(holder == 1)
			{
				total += (temp2 * temp);
				temp2 = (temp2 * 2);
				num = num/10;
			}
			else {
				temp2 = (temp2 * 2);
				num = num/10;
			}
			
			counter++;
		}
		
		return total;
	}	
	
	public static void main(String[] args) 
	{	
		System.out.println(conversion(101));
		System.out.println(conversion(11110101));
		System.out.println(conversion(111001));
		System.out.println(conversion(10));
		System.out.println(conversion(11101));
		System.out.println(conversion(100000001));
	}

}










