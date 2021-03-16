package SWEA_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
		
	}
	static int N,start;
	static Node arr[];
	static boolean visited[];
	static int nowOrder=0;
	static int nowMax=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			arr=new Node[N];
			visited=new boolean[N];
			nowOrder=0;
			nowMax=0;
			st= new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N/2;i++)
			{
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				
				arr[from]=new Node(to,arr[from]);
			}
			bfs(start);
			System.out.println("#"+tc+" "+nowMax);
		}
	}
	
	static void bfs(int start)
	{
		Queue<int[]> q=new LinkedList<>();
		
		q.offer(new int[] {start,0});
		visited[start]=true;
		
		while(!q.isEmpty()) {
			
			int current=q.peek()[0];
			int order=q.peek()[1];
			q.poll();
			if(order==nowOrder)
			{
				nowMax=Math.max(nowMax, current);
			}
			else if(order>nowOrder)
			{
				nowOrder=order;
				nowMax=current;
			}
			for(Node temp = arr[current]; temp != null; temp = temp.next) {
                if(!visited[temp.vertex]) {
                    q.offer(new int[] {temp.vertex,order+1});
                    visited[temp.vertex] = true;
                }
			}
			
		}
	}

}
