package SWEA_4007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,M,X,result;
	static Node[] originList=new Node[50001];
	static Node[] reverseList=new Node[50001];
	static PriorityQueue<Node> pq=new PriorityQueue<>();
	static int dist[],rDist[];
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			
			result=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			
			dist=new int[N+1];
			rDist=new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(rDist, Integer.MAX_VALUE);
			Arrays.fill(originList, null);
			Arrays.fill(reverseList, null);
			visited=new boolean[N+1];
			for(int i=0;i<M;i++)
			{
				st= new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				int weight=Integer.parseInt(st.nextToken());
				originList[from]=new Node(to,weight,originList[from]);
				reverseList[to]=new Node(from,weight,reverseList[to]);
			}
			dijkstra();
			Arrays.fill(visited, false);
			rDijkstra();
			for(int i=1;i<=N;i++)
			{
				result=Math.max(result, (dist[i]+rDist[i]));
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void dijkstra()
	{
		pq.offer(new Node(X,0,originList[X]));
		dist[X]=0;
		
		while(!pq.isEmpty())
		{
			Node node=pq.poll();
			if(visited[node.to])continue;
			visited[node.to]=true;
			
			for(Node temp=node.next;temp!=null;temp=temp.next)
			{
				if(dist[temp.to]>temp.weight+dist[node.to])
				{
					dist[temp.to]=temp.weight+dist[node.to];
					pq.offer(new Node(temp.to,dist[temp.to],originList[temp.to]));
				}
			}
		}
	}
	static void rDijkstra()
	{
		pq.offer(new Node(X,0,reverseList[X]));
		rDist[X]=0;
		
		while(!pq.isEmpty())
		{
			Node node=pq.poll();
			if(visited[node.to])continue;
			visited[node.to]=true;
			
			for(Node temp=node.next;temp!=null;temp=temp.next)
			{
				if(rDist[temp.to]>temp.weight+rDist[node.to])
				{
					rDist[temp.to]=temp.weight+rDist[node.to];
					pq.offer(new Node(temp.to,rDist[temp.to],reverseList[temp.to]));
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
