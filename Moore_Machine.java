import java.util.Scanner;

public class Moore_Machine {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		System.out.println("Enter value of divisor: ");
		int divisor = input.nextInt();
		int tran[][] = new int[divisor][2];
		
		System.out.print("Enter Starting state No: ");
		int start = input.nextInt();
		
		getTransitions(tran);
		
		while(true)
		{
			System.out.print("Enter Divident: ");
			int divident = input.nextInt();
			System.out.println(divident + " mode " + divisor + " = " + getReminder(tran, Integer.toBinaryString(divident), start));
		}//while
		
	}//main()
	
	
	static void getTransitions(int[][] tran)
	{
		int i=0;
		for(int[] row : tran)
		{
			System.out.println("Enter transitions at State " + i + ":");
			int j=0;
			
			for(int col : row)
			{
				System.out.print("\tFor " + j + ": ");
				tran[i][j] = input.nextInt();
				j++;
			}//for
			i++;
		}//for
	}//getTransitions()
	
	
	static int getReminder(int[][] tran, String str, int start)
	{
		int state = start;
		int i=0;
		
		while(i<str.length())
		{
			if(str.charAt(i) == '1')
				state = tran[state][1];
			else
				state = tran[state][0];
			i++;
		}//while
		
		return state;
	}//getReminder
}//class
