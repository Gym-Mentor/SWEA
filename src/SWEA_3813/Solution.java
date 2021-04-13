 package SWEA_3813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,K;
	static int[] arr1,arr2;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			arr1=new int[N];
			arr2=new int[K];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<K;i++)
			{
				arr2[i]=Integer.parseInt(st.nextToken());
			}
			int start=1;
			int end=200000;
			int mid=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(check(mid)) // 최대값이 mid보다 작을 때 
				{
					end=mid-1;
				}
				else // 최대값이 mid보다 클 때
				{
					start=mid+1;
				}
			}
			System.out.println("#"+tc+" "+start);
		}
		
	}

	static boolean check(int num)
	{
		int count=0;
		int idx=0;
		for(int i=0;i<N;i++)
		{
			if(num>=arr1[i])
				count++;
			else
				count=0;
			if(count==arr2[idx])
			{
				idx++;
				count=0;
			}
			if(idx==K)
			{
				return true;
			}
		}
		
		return false;
	}
}
