package SWEA_4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,M,result;
	static Node[] list=new Node[200001];
	static int dist[]=new int[50001];
	static boolean visited[]=new boolean[50001];
	static PriorityQueue<Node> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			
			Arrays.fill(list, null);
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			result=0;
			N=Integer.parseInt(br.readLine());
			M=Integer.parseInt(br.readLine());
			for(int i=0;i<M;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				int weight=Integer.parseInt(st.nextToken());
				
				list[from]=new Node(to,weight,list[from]);
				list[to]=new Node(from,weight,list[to]);
			}
			
			prim();
			System.out.println("#"+tc+" "+result);
		}
	}
	static void prim()
	{
		dist[1]=0;
		pq.offer(new Node(1,0,list[1]));
		while(!pq.isEmpty())
		{
			Node node=pq.poll();
			if(visited[node.to])continue;
			visited[node.to]=true;
			result+=node.weight;
			for(Node temp=node.next;temp!=null;temp=temp.next)
			{
				if(!visited[temp.to])
				{
					pq.offer(new Node(temp.to,temp.weight,list[temp.to]));
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		Node next;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
}
