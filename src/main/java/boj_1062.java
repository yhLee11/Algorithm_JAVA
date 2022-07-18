import java.io.*;

public class boj_1062 {
    static int N,K;
    static String[] str;
    static boolean[] visit = new boolean[26];
    static int maxNum = 0;
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        System.setIn(new FileInputStream("src/main/java/input.txt"));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        K = Integer.parseInt(arr[1]);
        str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine().replaceAll("[antic]","");
        }
        visit['a'-'a']=true;
        visit['c'-'a']=true;
        visit['i'-'a']=true;
        visit['t'-'a']=true;
        visit['n'-'a']=true;

        count=5;
        maxNum = countWords();
        for (int i = 0; i < 26; i++) {
            if (!visit[i]) {
                dfs(i);
            }
        }
        bw.write(maxNum+"\n");
        bw.flush();
    }
    static void dfs(int index){

        //1. 체크인
        visit[index]=true;
        count++;
        //2. 목적지: 깊이 k, cnt==K이면 탈출
        if (count == K) {
            maxNum=Math.max(countWords(),maxNum);
        }else{
            //3. 연결된 곳: 26 또는 나보다 큰 것, index+1~25
            for (int i = index+1; i < 26; i++) {
                //4. 갈 수 있는가?: 방문하지 않은 곳
                if (!visit[i]) {
                    //5. 간다. dfs()
                    dfs(i);
                }
            }
        }
        //6. 체크아웃
        visit[index]=false;
        count--;
    }
    static int countWords(){
        int cnt=0;
        for (int i = 0; i < N; i++) {
            boolean isPoss=true;
            String word=str[i];
            for (int j = 0; j < word.length(); j++) {
                if (!visit[word.charAt(j) - 'a']) {
                    isPoss=false;
                    break;
                }
            }
            if (isPoss) {
                cnt++;
            }
        }
        return cnt;
    }
}
