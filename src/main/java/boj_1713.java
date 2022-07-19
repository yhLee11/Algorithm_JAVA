import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class boj_1713 {
    static int N,M;
    static List<Student> list = new ArrayList<>();
    static Student[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] candi = new int[M];
        for (int i = 0; i < arr.length; i++) {
            candi[i] = Integer.parseInt(arr[i]);
        }

        students = new Student[101];
        for (int i = 0; i < M; i++) {
            //해당 후보가 최초 호출 시
            if (students[candi[i]] == null) {
                students[candi[i]] = new Student(0, candi[i], 0, false);
            }
            //해당 후보가 사진틀에 있을 경우
            if (students[candi[i]].isIn == true) {
                students[candi[i]].count++;
            }else {
                //해당 후보가 사진틀에 없음
                //사지틀이 가득 찬 경우
                if (list.size() == N) {
                    //정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    Student student = list.remove(0);
                    student.isIn=false;
                }
                //사진들에 여유가 있는 경우
                students[candi[i]].count=1;
                students[candi[i]].isIn=true;
                students[candi[i]].timeStamp=i;
                list.add(students[i]);
            }
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });
    }
    static class Student implements Comparable<Student>{
        int count;
        int num;
        int timeStamp;
        boolean isIn;

        public Student(int count, int num, int timeStamp, boolean isIn) {
            this.count = count;
            this.num = num;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }
        //1. 추천수, 2. 시간
        @Override
        public int compareTo(Student o) {
            int comp = Integer.compare(count, o.count);
            if (comp == 0) {
                return Integer.compare(timeStamp,o.timeStamp);
            }else{
                return comp;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "count=" + count +
                    ", num=" + num +
                    ", timeStamp=" + timeStamp +
                    ", isIn=" + isIn +
                    '}';
        }
    }
}
