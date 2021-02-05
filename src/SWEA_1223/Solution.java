package SWEA_1223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	static Stack<Integer> st;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1;test_case<=10;test_case++)
		{
			int N=Integer.parseInt(br.readLine());
			String str=br.readLine();
			char[] input=new char[N];
			char[] convInput=new char[N];
			Stack<Character> s= new Stack<>();
			////////////////////////수식 입력 받기//////////////////////////
			for(int i=0;i<N;i++)
			{
				input[i]=str.charAt(i);
			}
			int n=0;
			int cnt=0;
			///////////////////////입력 받은 수식 후위 표기식으로 저장 /////////////////////
			for(int i=0;i<N;i++)
			{
				if('0'<=input[i]&&input[i]<='9')
				{
					convInput[cnt++]=input[i];
					
				}
				else
				{
					if(input[i]=='*')
					s.push(input[i]);
					else
					{
						while(!s.isEmpty())
						{
							convInput[cnt++]=s.pop();
						}
						s.push(input[i]);
					}
				}
			}
			
			while(!s.isEmpty())
			{
				convInput[cnt++]=s.pop();
			}
			

			Stack<Integer> stack=new Stack<Integer>();
			for(int i=0;i<N;i++)
			{

				if('0'<=convInput[i]&&convInput[i]<='9')
				{
					stack.push(convInput[i]-'0');
				}
				else
				{
					int num1=stack.pop(),num2=stack.pop();
					if(convInput[i]=='+')
					stack.push(num1+num2);
					else if(convInput[i]=='*')
					stack.push(num1*num2);
				}

			}
			System.out.println("#"+test_case+" "+stack.pop());
		}
	}
}
