class Solution {
    int stockBuySell(int arr[]) {
        int profit=0;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                profit+=arr[i]-arr[i-1];
            }
        }
        return profit;
        
    }
}
/*In this problem multiple transactions are allowed. So instead of finding only one maximum profit, we need to find every profitable interval.

First find a local minimum and mark it as the buying day. Then keep moving forward while prices are increasing. When the increasing sequence breaks, mark the previous day as the selling day.

Repeat this process until the end of the array. The main idea is to buy at local minima and sell at local maxima.*/
