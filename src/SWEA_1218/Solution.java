package SWEA_1218;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		//T=Integer.parseInt(br.readLine());
		boolean result;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			result=true;
			int N = Integer.parseInt(br.readLine());
			Stack<Character> st = new Stack<>();
			String str=br.readLine();
			//'()', '[]', '{}', '<>
			for(int i=0;i<N;i++)
			{
				if(!st.empty())
				{
					if(str.charAt(i)==')')
					{
						if(st.pop()!='(')
						{
							result=false;
							break;
						}
					}
					else if(str.charAt(i)=='>')
					{
						if(st.pop()!='<')
						{
							result=false;
							break;
						}
					}
					else if(str.charAt(i)==']')
					{
						if(st.pop()!='[')
						{
							result=false;
							break;
						}
					}
					else if(str.charAt(i)=='}')
					{
						if(st.pop()!='{')
						{
							result=false;
							break;
						}
					}
					else
					{
						st.push(str.charAt(i));
					}
				}
				else
				{
					if(str.charAt(i)=='('||str.charAt(i)=='<'||str.charAt(i)=='{'||str.charAt(i)=='[')
					{
						st.push(str.charAt(i));
					}
					else
					{
						result=false;
						break;
					}
				}
			}
			System.out.print("#"+test_case);
			System.out.println(result==true?" 1":" 0");
		}
	}
}