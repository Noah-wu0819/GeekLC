import java.util.List;
import java.util.PriorityQueue;

public class c11_TwoHeaps {

    //TODO Find the Median of a Number Stream (medium)
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
//    public Solution() {
//        // TODO: Write your code here
//        minHeap = new PriorityQueue<>((o1, o2)-> o1- o2);
//        maxHeap = new PriorityQueue<>((o1, o2)-> o2- o1);
//    }

    //Do not modify this
    public double executeFindMedian(List<Integer> nums) {
        for (int num : nums) {
            insertNum(num);
        }
        return findMedian();
    }

    public void insertNum(int num) {
        // TODO: Write your code here
        if (!maxHeap.isEmpty() && num > maxHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        // TODO: Write your code here
        double median = 0;
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.poll().doubleValue() + minHeap.poll().doubleValue()) / 2.0;
        else
            return maxHeap.size() > minHeap.size()? maxHeap.poll().doubleValue(): minHeap.poll().doubleValue();
    }

    //TODO Sliding Window Median (hard)
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // TODO: Write your code here
        return result;
    }

    public static int findMax(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int countRotations(int[] arr) {
        // TODO: Write your code here
        int max = findMax(arr);
        if (max == arr.length - 1) return 0;
        return max + 1;
    }
    public static void main(String[] args) {
        System.out.println(c11_TwoHeaps.countRotations(
                new int[] { 10, 15, 1, 3, 8 }));

    }
}
