package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// NewMap聖 照彰 獄穿
public class Boj2239什亀庭_re {
	
	static int N = 9;
	static int[][] map;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		go(0,0);
		
	}
	
	// map (i,j)亜 0 戚 焼艦虞檎 収切研 辰酔走省壱 陥製仙瑛稽 角嬢亜壱, 収切亜 0 戚虞檎 収切研 辰酔澗 仙瑛敗呪
	private static boolean go(int i, int j) {
		
		if(i==8 && j==9) {
			// 舛岩 窒径
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			return true;
		}
		
		if(j==9) {
			if(go(i+1, 0)) return true;
			return false;
		}
		
		if(map[i][j]!=0) {
			if(go(i, j+1)) return true;
		}else {
			
			// 走榎  map壕伸拭 亜稽, 室稽, 3x3拭 嬢彊廃 収切亜 赤澗走研 arr 軒什闘拭 乞焼神澗 敗呪
			check(i, j); 
			
			int[] count = new int[10];
			for(int t=0; t<arr.size(); t++) {
				count[arr.get(t)]++; // 収切亜 赤澗 依精 count壕伸拭辞 収切亜 装亜鞠嬢赤製
			}
			
			for(int t=1; t<=9; t++) {
				if(count[t]==0) { // arr 軒什闘拭 蒸澗 収切澗 隔嬢瑳 呪 赤製
					map[i][j] = t; // map拭 級嬢赤澗 葵聖 郊荷嬢辞 仙瑛研 殿趨左切.
					if(go(i, j+1)) return true; // 益 壕伸聖 亜走壱 仙瑛殿酔切.
				}
			}
			/* 戚暗 是帖戚びびびびびびびびびびびびびび */
			map[i][j] = 0;
			
		}
		
		return false;
		
	}

	private static void check(int i, int j) {
		arr = new ArrayList<Integer>();
		
		int c = 0;
		while(true) {
			if(map[i][c]!=0) arr.add(map[i][c]);
			if(++c==9) break;
		}
		int r = 0;
		while(true) {
			if(map[r][j]!=0) arr.add(map[r][j]);
			if(++r==9) break;
		}
		int si = 0, sj = 0;
		if(0<=i && i<3) si = 0;
		if(0<=j && j<3) sj = 0;
		if(3<=i && i<6) si = 3;
		if(3<=j && j<6) sj = 3;
		if(6<=i && i<9) si = 6;
		if(6<=j && j<9) sj = 6;
		
		for(int starti=si; starti<si+3; starti++) {
			for(int startj=sj; startj<sj+3; startj++) {
				if(map[starti][startj]!=0) {
					arr.add(map[starti][startj]);
				}
			}
		}
	}
	
	
}