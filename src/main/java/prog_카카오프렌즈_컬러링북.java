import java.util.*;

class prog_카카오프렌즈_컬러링북 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int area = 0;
        int maxSize = 0;
        boolean[][] visit=new boolean[m][n];
        for (int i=0; i<m; i++){
            for (int j=0;j<n;j++){
                if (!visit[i][j] && picture[i][j]!=0){
                    maxSize=Math.max(bfs(i,j,picture,visit),maxSize);
                    area++;
                }
            }
        }
        return new int[]{area, maxSize};
    }
    private static int bfs(int a, int b, int[][] picture, boolean[][] visit){
        visit[a][b]=true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(a,b));
        int cnt=1;
        while (!q.isEmpty()){
            Point p=q.poll();
            for(int i=0;i<4;i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if (0<=nx&&nx<picture.length && 0<=ny&&ny<picture[0].length && !visit[nx][ny] && picture[a][b]==picture[nx][ny]){
                    q.offer(new Point(nx,ny));
                    visit[nx][ny]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}