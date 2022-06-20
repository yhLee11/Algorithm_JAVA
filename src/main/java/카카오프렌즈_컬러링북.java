import java.util.*;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class 카카오프렌즈_컬러링북 {
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};
    boolean[][] visit;
    public int[] solution(int m, int n, int[][] picture) {
        int area = 0;
        int maxSize = 0;
        visit=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if (picture[i][j]!=0 && !visit[i][j]){
                    maxSize=Math.max(bfs(m,n,picture,visit),maxSize);
                    area++;
                }
            }
        }
        return new int[]{area,maxSize};
    }
    public int bfs(int a, int b,int[][] picture, boolean[][] visit){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(a,b));
        visit[a][b]=true;
        int cnt=1;
        while (!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if (0<=nx&&nx<picture.length && 0<=ny&&ny<picture[0].length &&picture[nx][ny]==picture[a][b]&& !visit[nx][ny]){
                    q.offer(new Point(nx,ny));
                    visit[nx][ny]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}