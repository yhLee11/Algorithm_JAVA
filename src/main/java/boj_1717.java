import java.io.*;
import java.util.StringTokenizer;

public class boj_1717 {
    static int n,m;
    static int[] parent,depth;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        depth = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
            depth[i]=1;
        }
        int cm,a,b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cm = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (cm == 0) {
                union(a, b);
            } else if (cm == 1) {
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
        System.out.println(sb);
        br.close();
    }
    public static int find(int x){
//        if (x==parent[x]) return parent[x]=x;
//        return parent[x] = find(parent[x]);
        return parent[x] = (x == parent[x]) ? x : find(parent[x]);
    }

    public static void union(int x,int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y]=x;
        }
    }
    public static void union2(int x, int y) {//최적화
        x = find(x);
        y = find(y);
        if (x != y) {
            if (depth[x] < depth[y]) {
                int tmp=x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            if(depth[x]==depth[y]) depth[x]++;
        }
    }
}
