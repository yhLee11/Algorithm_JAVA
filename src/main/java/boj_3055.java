import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055 {
    static int R,C;
    static char[][] arr;
    static int[][] visit;
    static int ans = Integer.MAX_VALUE;
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> wq = new LinkedList<>();
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static class Node{
        int x;
        int y;
        int move;
        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        visit=new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j]=line[j].charAt(0);
            }
        }
        int sx=0;
        int sy=0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') {
                    wq.add(new Node(i, j, 0));
                }else if(arr[i][j]=='S'){
                    sx=i;
                    sy=j;
                    q.add(new Node(i, j, 0));
                }
            }
        }
        bfs(sx, sy);
        System.out.println(ans);
    }

    public static void bfs(int x, int y) {//water
        while (!q.isEmpty()) {
            int length = wq.size();
            for (int i = 0; i < length; i++) {
                Node w = wq.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + w.x;
                    int ny = dy[k] + w.y;
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny]=='.') {
                        arr[nx][ny]='*';
                        wq.add(new Node(nx, ny, 0));
                    }
                }
            }

            length = q.size();
            for (int i = 0; i < length; i++) {
                Node n = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < R && ny >= 0 && ny > C) {
                        if (arr[nx][ny] == 'D') {
                            ans = Math.min(ans, n.move);
                            return;
                        } else if (arr[nx][ny] == '.') {
                            arr[nx][ny] = 'S';
                            q.add(new Node(nx, ny, n.move + 1));
                        }
                    }
                }
            }
        }
    }
}
