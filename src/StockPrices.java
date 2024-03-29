public class StockPrices {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
