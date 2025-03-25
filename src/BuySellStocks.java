public class BuySellStocks {

    public static void main(String[] args) {

        int[] nums = {7, 2, 11, 15};
        int[] nums2 = {7,6,4,3,1};
        int[] nums3 = {7,1,5,3,6,4};
        int result;
        result = maxProfitBruteForce(nums2);
        System.out.println(result);


    }

    public static int maxProfitBruteForce(int[] prices) {
        int buy;
        int sell;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                sell = prices[j];
                if (profit < sell - buy) {
                    profit = sell - buy;
                }
            }
        }
        return profit;
    }

    public int maxProfitOptimal(int[] prices) {

        int buy = prices[0];
        int maxProfit = 0;

        for (int i=1; i<prices.length; i++){
            int currProfit = prices[i]-buy;
            if(currProfit > maxProfit){
                maxProfit = currProfit;
            }
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return maxProfit;
    }

}
