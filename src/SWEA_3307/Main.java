package SWEA_3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,N,result,input[],DP[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			
			N=Integer.parseInt(br.readLine());
			input=new int[N];
			DP=new int[N];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				input[i]=Integer.parseInt(st.nextToken());
			}
			
			int size=0;
			DP[0]=input[0];
			
			for(int i=1;i<N;i++)
			{
				if(DP[size]<input[i])
				{
					DP[++size]=input[i];
				}
				else
				{
					int idx=binarysearch(0,size,input[i]);
					DP[idx]=input[i];
				}
			}
			
			
			System.out.println("#"+tc+" "+(size+1));
		}
		
	}
	static int binarysearch(int start,int end, int target)
	{
		int mid=0;
		while(start<end)
		{
			mid=(start+end)/2;
			if(DP[mid]>target)
			{
				end=mid;
			}
			else
			{
				start=mid+1;
			}
		}
		return end;
	}
}
