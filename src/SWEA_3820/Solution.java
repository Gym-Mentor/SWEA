package SWEA_3820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T,N;
	static pair[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new pair[N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				arr[i]=new pair(a,b);
			}
			Arrays.sort(arr);
			
			long result=1;
			for(int i=0;i<N;i++)
			{
				result=(result*arr[i].a)%1000000007;
				result=(result+arr[i].b)%1000000007;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static class pair implements Comparable<pair>{
		long a;
		long b;
		public pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(pair o) {
			if((this.b)*(o.a-1)<o.b*(this.a-1))
			{
				return -1;
			}
			else
			{
				return 1;
			}
			
		}
		
	}
}
