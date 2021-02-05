package SWEA_3499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static String[]	str;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());

		
		for(int test_case=1;test_case<=T;test_case++)
		{
			N=Integer.parseInt(br.readLine());
			str=new String[N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				str[i]=st.nextToken();
			}
			System.out.print("#" +test_case+" ");
			for(int i=0;i<N/2;i++)
			{
				System.out.print(str[i]+" ");
				System.out.print(str[i+N/2+N%2]+" ");
			}
			if(N%2==1)
			{
				System.out.print(str[N/2]);
			}
			System.out.println();

		}
	}
}
