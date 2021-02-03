package SWEA_1289;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String s=sc.next();
			char[] input = new char[s.length()];
			input=s.toCharArray();
			char[] now = new char[s.length()];
			for(int i=0;i<s.length();i++)
			{
				now[i]='0';
			}
			int result=0;
			for(int i=0;i<s.length();i++)
			{
				if(now[i]!=input[i])
				{result++;
					for(int j=i;j<s.length();j++)
					{
						input[j]=input[j]=='1'?'0':'1';
						
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}