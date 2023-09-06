public class c11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right){
           int curArea = Math.min(height[left],height[right]) * (right - left);
           if (curArea > max){
               max = curArea;
           }
           if (height[left] > height[right]){
               right--;
           }else {
               left++;
           }
        }
        return max;
    }
}
