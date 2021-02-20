package SWEA_3234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N,T;
	static int arr[];
	static int ret=0,total=0;
	static int Exp[] = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
	static int Factorial[] = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	//Exp * Factorial은 N!*

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();

		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			ret=0;
			total=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
				total+=arr[i];
			}
			
			init(0,0,0);
			System.out.println("#"+tc+" "+ret);

		}

	}
	
	static void init(int cnt,int sum,int flag)
	{
		if(sum<0)return;
		if(cnt==N)
		{
			ret++;
			return;
		}
		
		//지금 무게 추의 무게가 나머지보다 크면 더이상 탐색안함
		if(total-sum<=sum)
		{
			ret+=Exp[N-cnt]*Factorial[N-cnt];
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if((flag&1<<i)==0)
			{
				init(cnt+1,sum+arr[i],flag|1<<i);
				init(cnt+1,sum-arr[i],flag|1<<i);
			}
		}
		
	}
	
}
