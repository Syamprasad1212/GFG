class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long sum = 0;

        for(int bit = 0; bit < 32; bit++) {
            int count1 = 0;

            for(int num : arr) {
                if((num & (1 << bit)) != 0) {
                    count1++;
                }
            }

            int count0 = n - count1;
            sum += (long) count1 * count0 * (1 << bit);
        }

        return sum;
    }
}
