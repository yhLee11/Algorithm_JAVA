import java.util.ArrayList;
import java.util.List;

public class boj_11279 {
    public static void main(String[] args) {

    }
    class MinHeap{
        List<Integer> list;

        public MinHeap() {
            list = new ArrayList<>();
            list.add(0);
        }

        public void insert(int val){
            //1. leaf 마지막에 삽입
            list.add(val);
            //2. 부모와 비교 후 조건에 맞지 않으면 Swap
            //3. 조건이 만족되거나 root 까지 반복
            int cur = list.size()-1;
            int par = cur/2;
            while (true) {
                if (par == 0 || list.get(par) <= list.get(cur)) {
                    break;
                }
                int tmp = list.get(par);
                list.set(par, list.get(cur));
                list.set(cur, tmp);

                cur=par;
                par = cur / 2;
            }
        }

        public int delete(){
            if (list.size() == 1) {
                return 0;
            }
            //1. Root에 leaf 마지막 데이터 가져옴
            int top = list.get(1);
            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            //2. 자식과 비교 후 조건이 맞지 않으면 swap
            //3. 조건이 만족되거나 leaf까지 반복
            int curPos=1;
            while (true) {
                int leftPos = curPos * 2;
                int rightPos = curPos * 2 + 1;
                // 왼쪽 자식 먼저 확인
                if (leftPos >= list.size()) {
                    break;
                }
                int minValue = list.get(leftPos);
                int minPos = leftPos;

                // 오른쪽 자식 확인
                if (rightPos <= list.size() && minValue > list.get(rightPos)) {
                    minValue = list.get(rightPos);
                    minPos = rightPos;
                }
                // swqp
                if (list.get(curPos) > minValue) {
                    int tmp = list.get(curPos);
                    list.set(curPos, list.get(minPos));
                    list.set(minPos, tmp);
                    curPos=minPos;
                }
            }
            return top;
        }
    }
}
