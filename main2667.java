package chapter4;

import java.util.*;





public class main2667 {

	static int N;

	static int[][] map = new int[25][25];

	static boolean[][] visit = new boolean[25][25];

	static int[] dx = {0,1,0,-1};

	static int[] dy = {1,0,-1,0};

	static int cnt = 1;

	static int len = 0;



	public static void main(String[] args) {



		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for(int i=0;i<N;i++){

			String str = sc.next();

			for(int j=0;j<str.length();j++){

				map[i][j] = str.charAt(j)-'0';

			}

		}

		for(int i=0;i<N;i++){

			for(int j=0;j<N;j++){

				if(map[i][j]==1 && visit[i][j]==false){

					dfs(i,j);

					cnt++;

				}

			}

		}

		System.out.println(cnt-1);

		int[] sort = new int[cnt];

		for(int i=0;i<N;i++){

			for(int j=0;j<N;j++){

				if(map[i][j]!=0){

					sort[map[i][j]]++;

				}

			}

		}

		Arrays.sort(sort);

		for(int i=1;i<cnt;i++){

			System.out.println(sort[i]);

		}

	}

	public static void dfs(int x, int y){

		

		map[x][y]=cnt;

		visit[x][y] = true;

		for(int i=0;i<4;i++){

			int nx = x + dx[i];

			int ny = y + dy[i];

			

			if(nx>=0 && ny>=0 && nx<N && ny<N){

				if(map[nx][ny]==1 && visit[nx][ny]==false){

					dfs(nx,ny);

				}

			}

		}

	}

	

	



	

}
