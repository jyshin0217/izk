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
    
    static int N;                    // ����ũ��
    static int M;                    // ����ũ��
    static int map[][];                // �� ����
    static boolean isvisisted[][];    // �湮����Ȯ��
    
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
        // �� �����
        
        bfs(new POINT(0,0,1));    // (1,1)���� �����ε�
                                // ���� (0,0)�����̹Ƿ�
 
        
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
            if(p.x==M-1 && p.y==N-1)        // ��ǥ������ �����������
            {
                System.out.println(p.depth);
                return;
            }
            for(int i=0; i<4; i++)
            {
                int p_x=x[i]+p.x;
                int p_y=y[i]+p.y;
                
                // �� �����ȿ��ְ� �湮�����ʾҾ��� �����ִ� ���ϰ��
                if(p_x>=0 && p_x<M && p_y>=0 && p_y<N && isvisisted[p_y][p_x]==false && map[p_y][p_x]==1)
                {
                    isvisisted[p_y][p_x]=true;
                    // bfs �� ť���־��ٶ� �湮üũ���ش�.
                    q.offer(new POINT(p_x,p_y,p.depth+1));
                }
            }
        }
    }
}
