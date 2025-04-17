package ja.ch04;

// TODO 테스트 필요
public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public IntAryQueue(int capacity) {
        max = capacity;
        num = 0;
        que = new int[max];
    }

    public int enqueue(int x) {
        if (x >= max) return -1;
        return que[num++] = x;
    }

    public int dequeue() {
        if (num <= 0) return -1;
        int result = que[0];

        for (int i = 1; i < num; i++) {
            que[i - 1] = que[i];
        }
        num -= 1;
        
        return result;
    }
}
