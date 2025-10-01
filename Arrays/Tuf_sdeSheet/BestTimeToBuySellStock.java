package Arrays.Tuf_sdeSheet;

public class BestTimeToBuySellStock {
    

    public static int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;

        int minCost = prices[0];
        int maxProfit = 0;

        for(int i = 0; i<prices.length; i++){
            int currentCost = prices[i];
            int currentProfit = currentCost - minCost;
            
            maxProfit = Integer.max(maxProfit,currentProfit);
            minCost = Integer.min(minCost, currentCost);
        }
        return maxProfit;
        
    }
}
