package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1261알고스팟_BFS간략 {
	
	static int N, M;
	static int[][] map;
	static int[][] wallCnt;
	static Queue<Point> queue;
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	static class Point{
		int i, j; // 좌표와 벽을 부순 횟수
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 가로(열)
		M = Integer.parseInt(st.nextToken()); // 세로(행)
		
		map = new int[M][N]; 
		wallCnt = new int[M][N];
		queue = new LinkedList<>();
		
		for(int i=0; i<M; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		for(int i=0; i<M; i++) {
			Arrays.fill(wallCnt[i], Integer.MAX_VALUE);
		}
		
		bfs();
		
		System.out.println(wallCnt[M-1][N-1]);
	}
	
	static void bfs(){
		
		queue.add(new Point(0, 0));
		wallCnt[0][0] = 0;
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=M || nj<0 || nj>=N) continue;
				if(wallCnt[ni][nj]>wallCnt[n.i][n.j]+map[ni][nj]) {
					wallCnt[ni][nj] = wallCnt[n.i][n.j]+map[ni][nj];
					queue.add(new Point(ni, nj));
				}
			}
		}
		
		
	}
}
