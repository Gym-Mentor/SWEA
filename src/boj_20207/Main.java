package boj_20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N,result=0;
	static PriorityQueue<Day> pq=new PriorityQueue<>();
	static boolean check[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			pq.offer(new Day(num1,num2));
		}
		
		
		check=new boolean[1001][366];
		
		// pq에 있는 날들을 모두 배열에 체크
		while(!pq.isEmpty())
		{
			Day day=pq.poll();
			for(int i=1;i<=1000;i++)
			{
				if(!check[i][day.start])
				{
					for(int j=day.start;j<=day.end;j++)
					{
						check[i][j]=true;
					}
					break;
				}
			}
		}
		
		int maxX=0;
		int maxY=0;
		boolean flag=false;
		for (int j = 1; j <= 365; j++)  // X만큼 반복
		{
			flag = false;
			for (int i = 1; i <= 1000; i++)  //Y만큼 반복
			{
				if (check[i][j]) 
				{
					flag = true;
					maxY = Math.max(maxY, i); // 제일 큰 Y
				}
			}
			if (!flag) // 값더하기
			{
				result +=  ((maxY)*maxX);
				maxY = 0;
				maxX = 0;
			} else // 제일 큰 X구하기
				maxX++;
		}
		
		if(flag) { // 값더하기
			result +=  ((maxY)*maxX);
		}
		
		System.out.println(result);
	}
	
	// 일정 클래스
	static class Day implements Comparable<Day>
	{
		int start;
		int end;
		public Day(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Day o) {
			if(this.start==o.start)
				return o.start-this.start;
			return this.start-o.start;
		}
		
	}
}
