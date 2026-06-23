class Solution {
    public int maxProfit(int[] prices) {
      int i = 0, j = 1;
int maxProfit = 0;

while(j < prices.length){
    if(prices[i] < prices[j]){
        maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        j++;
    } else {
        i = j;  
        j++;    
    }
}
return maxProfit;
}
}