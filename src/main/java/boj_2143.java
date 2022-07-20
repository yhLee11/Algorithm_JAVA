import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2143 {
    static int T,n,m;
    static int[] A,B;
    static List<> sumA,sumB;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());;
        st = new StringTokenizer(br.readLine());
        B = new int[m];
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        sumA = new ArrayList<>();
        sumB = new ArrayList<>();

        //subA 구하기
        for (int i = 0; i < n; i++) {
            long sum = A[i];
            sumA.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }
        //subB 구하기
        for (int i = 0; i < m; i++) {
            long sum = B[i];
            sumB.add(sum);
            for (int j = i + 1; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }
        //sumA, sumB 정렬
        Collections.sort(sumA);
        Collections.sort(sumB, Comparator.reverseOrder());

        long res=0;
        int pa=0;
        int pb=0;
        while (true) {
            long curA = sumA.get(pa);
            long target = T - curA;
            //curB==target -> sumA, sumB 같은 수 개수 체크 -> 답 구하기 pa+ pb+
            //curB > target -> pb++
            //curB < target -> pa++

        }



    }
}
