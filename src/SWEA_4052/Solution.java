package SWEA_4052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,M;
	static work arr[];
	static int DP[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new work[N];
			DP=new int[M+1];
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				int price=Integer.parseInt(st.nextToken());
				
				arr[i]=new work(start,end,price);
			}
			Arrays.sort(arr);
			

			DP[0]=arr[0].price;
			for(int i=1;i<N;i++)
			{
				DP[i]=Math.max(DP[i-1], arr[i].price+solve(i));
					
			}
			System.out.println("#"+tc+" "+DP[N-1]);
		}
	}
	private static int solve(int target) {
        int ret = 0;
        int idx = -1;
        for(int i=0; i < target; i++) {
            // 대상(taget)이 끝나는 시간이 이후로 시작하는 job인지 확인
            if(arr[i].end >= arr[target].start) {
                break;
            }
            idx = i;
        }
         
        if(idx >= 0)
            ret = DP[idx];
         
        return ret;
    }
	static class work implements Comparable<work>{
		int start;
		int end;
		int price;
		public work(int start, int end, int price) {
			super();
			this.start = start;
			this.end = end;
			this.price = price;
		}
		@Override
		public int compareTo(work o) {
			// TODO Auto-generated method stub
			if(this.end!=o.end)
			return this.end-o.end;
			else
				return this.start-o.start;
		}
	}
}
