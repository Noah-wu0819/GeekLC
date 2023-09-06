public class greedy_122 {

        public int maxProfit(int[] prices) {

            int reve = 0;

            for (int i =1; i < prices.length; i++){
                if(prices[i]>prices[i-1]){
                    reve += prices[i]-prices[i-1];
                }
            }
            return reve;
        }
}


