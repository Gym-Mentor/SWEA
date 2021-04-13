package SWEA_3814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,K,result=0;
	static int arr[],copyArr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			arr=new int[N];
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			parametricSearch();
			
			System.out.println("#"+tc+" "+result);
		}
	}
	static void parametricSearch()
	{
		int start=0;
		int end=1000000000;
		
		while(start<=end)
		{
			int mid=(start+end)>>1;
			
			if(check(mid)) // 더 줄일 수 있을 때
			{
				end=mid-1;
				
			}
			else
			{
				start=mid+1;
				result=start;
			}
		}
	}
	static boolean check(int num)
	{
		copyArr=arr.clone();
		int result=0;
		for(int i=0;i<N-1;i++)
		{
			int diff=copyArr[i+1]-copyArr[i];
			
			if(diff>=num)
			{
				result+=(diff-num);
				copyArr[i+1]-=(diff-num);
				
				if(result>K)return false;
			}
		}
		
		for(int i=N-1;i>0;i--)
		{
			int diff=copyArr[i-1]-copyArr[i];
			
			if(diff>=num)
			{
				result+=(diff-num);
				copyArr[i-1]-=(diff-num);
				
				if(result>K)return false;
			}
		}
		return true;
	}
}
