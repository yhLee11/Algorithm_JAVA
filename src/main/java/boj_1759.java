import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1759 {
    static int L,C;
    static char[] arr;
    static boolean[] visit;
    static String[] vowel=new String[]{"a","e","i","o","u"};
    static List<String> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        res = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        visit=new boolean[C];
        visit[0]=true;
        dfs2(0, 0, 0, -1, "");
//        dfs1(0, "");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


//        dfs(0,Character.toString(arr[0]));
//        System.out.println(Arrays.toString(arr));
    }

    public static void dfs2(int length, int ja, int mo, int current, String pwd) {
        //1. 체크인 생략가능
        //2. 목적지인가> :  length == L => ja, mo 개수 확인
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                //정답처리
                res.add(pwd);
            }
        }else {
            //3. 연결된 곳을 순회: current+1~C
            for (int i = current+1; i <C ; i++) {
                //4. 갈 수 있는가? : 다 갈 수 있음
                //5. 간다 -> Ja, mo
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    dfs2(length + 1, ja, mo + 1, i, pwd + arr[i]);
                }else{
                    dfs2(length + 1, ja + 1, mo, i, pwd + arr[i]);
                }
            }
        }
        //6. 체크아웃 생략가능
    }
    public static void dfs1(int idx,String str) {
        //1. 체크인 visit
        visit[idx]=true;
        System.out.println(idx);
        System.out.println(str);
        //2. 목적지 L, 자음2이상+모음1
        if (str.length()==L){
            int v=0;
            int c=0;
            for (int i = 0; i < L; i++) {
                if (Arrays.asList(vowel).contains(str.charAt(i))) v++;
                else c++;
            }
            if (v>=1 && c>=2){
                res.add(str);
            }
            return;
        }else{
            //3. 연결된 곳 순회: 0~C or index+1~C
            for (int i = idx+1; i < C; i++) {
                //4. 갈 수 있는가?: visit
                if (!visit[i]) {
                    //5. 간다: dfs()
                    visit[i]=true;
                    dfs1(i,str+arr[i]);
                    visit[i]=false;
                }
            }
        }
        //6. 체크아웃
    }
}
