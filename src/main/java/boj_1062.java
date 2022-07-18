import java.io.*;
import java.util.Arrays;

public class boj_1062 {
    static int N,K;
    static String[] str;
    static boolean[] visit = new boolean[26];
    static int maxNum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        System.setIn(new FileInputStream("src/main/java/input.txt"));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        K = Integer.parseInt(arr[1]);
        str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        visit['a'-97]=true;
        visit['c'-97]=true;
        visit['i'-97]=true;
        visit['t'-97]=true;
        visit['n'-97]=true;
//        System.out.println("str = " + Arrays.toString(str));
        dfs(0,0);
        bw.write(maxNum+"\n");
        bw.flush();
    }
    static void dfs(int alp, int cnt){

        //1. 체크인
        if (cnt==K-5){
            int res=0;
            for (int i = 0; i < N; i++) {
                boolean isTrue=true;
                for (int j = 0; j < str[i].length(); j++) {
                    if(!visit[str[i].charAt(j)-97]) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue){
                    res++;
                }
            }
            maxNum = Math.max(res,maxNum);
            return;
        }

        for (int i = alp; i < 26; i++) {
            if(!visit[i]){
                visit[i]=true;
                dfs(i, cnt + 1);
                visit[i]=false;
            }
        }
        //2. 목적지: 깊이 k
        //3. 연결된 곳: 26 또는 나보다 큰 것
        //4. 갈 수 있는가?: 방문하지 않은 곳
        //5. 간다.
        //6. 체크아웃
    }
}
