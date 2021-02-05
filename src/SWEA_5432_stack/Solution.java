package SWEA_5432_stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{		
			int result=0,now=0;
			String str=br.readLine();
			Stack<Character> st=new Stack<>();
			for(int i=0;i<str.length();i++)
			{
					if(str.charAt(i)=='(') //새로운 막대기 
					{
						st.push(str.charAt(i));
						result++;
						now++;
					}
					else
					{
						if(!st.empty()&&st.peek()=='(') // 레이저일 때
						{
							if(result>0)
							result--;
							if(now>0)
							now--;
							result+=now;
						}
						else // 막대기 끝날 때
						{
							if(now>0)
							now--;
							
						}
						st.push(str.charAt(i));
					}
				
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}