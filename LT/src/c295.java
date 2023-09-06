import java.util.PriorityQueue;

public class c295 {
    static class MedianFinder {

        private PriorityQueue<Integer> minQueue;
        private PriorityQueue<Integer> maxQueue;
        public MedianFinder() {
            maxQueue = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
            minQueue = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
        }

        public void addNum(int num) {
            if (minQueue.size() == maxQueue.size()){
                maxQueue.offer(num);
                minQueue.offer(maxQueue.poll());
            }else {
                minQueue.offer(num);
                maxQueue.offer(minQueue.poll());
            }
        }

        public double findMedian() {
            if (minQueue.size() == maxQueue.size())
                return (minQueue.peek() + maxQueue.peek())/2.0;
            else return minQueue.peek();
        }
    }

    public static void main(String[] args) {
        c295 c = new c295();
        MedianFinder m = new  MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
