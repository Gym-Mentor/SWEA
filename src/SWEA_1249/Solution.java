package SWEA_1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i ++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {	
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int cnt = bfs(0,0);
			
			System.out.println("#" + t + " " + cnt);
		}
		
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int bfs(int i, int j) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(j, i, 0));
		boolean[][] visited = new boolean[N][N];
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int x = p.x;
			int y = p.y;
			int w = p.weight;
			visited[y][x] = true;
			
			if(x == N-1 && y == N-1) return w;
			
			for(int a = 0 ; a < 4; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visited[ny][nx]) continue;//더 짧은 거리로 온 적이 있을때
				
				
				int nw = w + map[ny][nx];
				
				pq.add(new Pos(nx, ny, nw));	
			}

		}
		
		return -1;// somewhat wrong code
	}
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int weight;
		
		Pos(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.weight = w;
		}
		@Override
		public int compareTo(Pos o) {
			
			return this.weight - o.weight;
		}
	}	
}