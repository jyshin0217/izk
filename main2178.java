package chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
class POINT
{
    int x,y,depth;
 
    POINT(int x,int y,int depth)
    {
        this.x=x;
        this.y=y;
        this.depth=depth;
    }
 
 
}
public class main2178 {
    
    static int N;                    // 세로크기
    static int M;                    // 가로크기
    static int map[][];                // 맵 저장
    static boolean isvisisted[][];    // 방문여부확인
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        String word=input.nextLine();
        String arr[]=word.split(" ");
        
        N=Integer.parseInt(arr[0]);
        M=Integer.parseInt(arr[1]);
        
        map=new int[N][M];
        isvisisted=new boolean[N][M];
        
        for(int i=0; i<N; i++)
        {
            word=input.nextLine();
            for(int j=0; j<M; j++)
            {
                map[i][j]=(word.charAt(j)-'0');
            }
        }
        // 맵 만들기
        
        bfs(new POINT(0,0,1));    // (1,1)부터 시작인데
                                // 맵은 (0,0)부터이므로
 
        
    }
    
    public static void bfs(POINT P)
    {
        Queue<POINT> q=new LinkedList<>();
        
        q.offer(P);
        isvisisted[P.y][P.x]=true;
        
        int x[]= {1,0,-1,0};
        int y[]= {0,1,0,-1};
        
        while(!q.isEmpty())
        {
            
            POINT p=q.poll();
            if(p.x==M-1 && p.y==N-1)        // 목표지점에 도착했을경우
            {
                System.out.println(p.depth);
                return;
            }
            for(int i=0; i<4; i++)
            {
                int p_x=x[i]+p.x;
                int p_y=y[i]+p.y;
                
                // 맵 범위안에있고 방문하지않았었고 갈수있는 길일경우
                if(p_x>=0 && p_x<M && p_y>=0 && p_y<N && isvisisted[p_y][p_x]==false && map[p_y][p_x]==1)
                {
                    isvisisted[p_y][p_x]=true;
                    // bfs 는 큐에넣어줄때 방문체크해준다.
                    q.offer(new POINT(p_x,p_y,p.depth+1));
                }
            }
        }
    }
}
