import java.io.*;
import java.util.*;

public class boj_2252 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] inDegree;
    static Queue<Integer> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }
        que = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int num = que.poll();
            bw.write(String.valueOf(num)+" ");

            List<Integer> lst = graph.get(num);
            for (int i = 0; i < lst.size(); i++) {
                int tmp = lst.get(i);
                inDegree[tmp]--;
                if (inDegree[tmp] == 0) {
                    que.add(tmp);
                }
            }
        }
        bw.flush();
    }
}
