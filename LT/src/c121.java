/*
* 少用多个变量，能少用就少用，多一个最大值变量总是把过去值带进来很不好。
* */
public class c121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int value = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
//217
    public static void main(String[] args) {
        c121 c = new c121();
        int[] a = {7,1,5,3,6,4};
        System.out.println(c.maxProfit(a));
    }
}
