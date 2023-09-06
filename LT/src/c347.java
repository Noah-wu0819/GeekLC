import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class c347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put( nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                ((o1, o2) -> o1[1]- o2[1])
        );

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if (queue.size() == k){
                if (queue.peek()[1] < value){
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            }else {
                queue.offer(new int[]{key, value});
            }
        }

        for (int i = 0; i < k; i++){
            ans[i] = queue.poll()[0];
        }


        return ans;
    }

    public int[] heapSort(int[] heap, int heapsize, int[] nums){
        int ans[] = new int[heapsize];
        for (int i = heapsize-1; i >= 0; i--){
            heapify(heap, i, heapsize);
        }

        return ans;
    }

    public void heapify(int[] heap, int index, int heapsize){

        int left = 2 * index + 1;

        while (left < heapsize){
            int min = left + 1 < heapsize && heap[left] < heap[left + 1]? left: left+1;

            min = heap[min] < heap[index]? min: index;
            if (index == min) break;
            swap(heap, index, min);
            index = min;
            left = 2 * index + 1;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
