package SWEA_5432;
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
			int result=0,now=0;  //  전체 잘린 막대기 , 현재 레이저가 자를 수 있는 막대기
			String input;
			input=sc.next();
			
			for(int i=0;i<input.length()-1;i++) {
				if(input.charAt(i)=='('&&input.charAt(i+1)==')')   ////  레이저일때 ()
				{
					result+=now;
				}
				else if(input.charAt(i)=='(') {  // 새로운 막대기  (
					result++;
					now++;
				}
				else if(i!=0&&input.charAt(i)==')'&&input.charAt(i-1)!='(')  // 막대기 끝  )
				{
					if(now>0)
					now--;
				}
			}
			System.out.println("#"+test_case+" "+result);
			
		}
	}
}