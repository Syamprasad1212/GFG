class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int sum=0;

        for(int i=0;i<n;i++){
             int fre[]=new int[26];
            for(int j=i;j<n;j++){
                 fre[s.charAt(j)-'a']++;
                int max=0;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(fre[k]==0) continue;
                    max=Math.max(max,fre[k]);
                    min=Math.min(min,fre[k]);
                }
                sum+=max-min;
            }
        }
        return sum;
    }
}

/*In this problem, we know a few things:

We need to generate all possible substrings.
For every substring, we need to count the frequency of each character.
Using those frequencies, we find the maximum frequency and the minimum non-zero frequency.
The beauty of that substring is maxFrequency - minFrequency.
We keep adding the beauty of every substring to the final answer.

To achieve this, we use two nested loops to generate all substrings.

The outer loop (i) represents the starting index of the substring.
For every new starting index, we create a new frequency array of size 26.
The inner loop (j) extends the current substring one character at a time. Whenever we include a new character, we increment its frequency in the array.
After updating the frequency array, we iterate over all 26 characters to find the maximum frequency and the minimum frequency (ignoring characters with frequency 0).
We compute the beauty as max - min and add it to the final answer.
We repeat this process for every possible substring.
Time Complexity
The outer loop runs n times.
The inner loop also runs up to n times.
For every substring, we scan the frequency array of size 26 to find the maximum and minimum frequencies.

Time Complexity: O(n² × 26), which simplifies to O(n²) since 26 is a constant.

Space Complexity

We use a frequency array of size 26.

Space Complexity: O(26) = O(1)*/
