class Solution {
    public static int countSubstring(String s) {
        int l=0,r=0;
        int n=s.length();
        int a=0,b=0,c=0,count=0;
        
        while(r<n){
            if(s.charAt(r)=='a'){
                a++;
            }else if(s.charAt(r)=='b'){
                b++;
            }else {
                c++;
            }
            
            while(a>0 && b>0 && c>0){
                count+=n-r;
            
            if(s.charAt(l)=='a'){
                a--;a
            }else if(s.charAt(l)=='b'){
                b--;
            }else {
                c--;
            }
            l++;
            }
            r++;
        }
        return count;
    }
}
/*Initially, I solved this problem using the brute-force approach by generating every possible substring and checking whether each substring contained at least one 'a', one 'b', and one 'c'. Although this works, it takes O(n²) time.

To optimize it, I used the sliding window technique.

I maintained a sliding window using two pointers (left and right) along with the frequency of 'a', 'b', and 'c' present inside the current window.

As I expanded the window by moving the right pointer, I updated the frequency of the current character. Whenever the window contained at least one 'a', one 'b', and one 'c', the window became valid.

The key observation is that once the current window is valid, every substring starting from the current left pointer and ending at the current right pointer or any position after it will also be valid, 

because extending the window cannot remove the required characters. Therefore, instead of counting each substring individually, I directly added:

n - right

to the answer, where n is the length of the string.

After counting these valid substrings, I started shrinking the window from the left. Before moving the left pointer, I decreased the frequency of the character leaving the window.

If the window still remained valid after shrinking, I again added n - right to the answer and continued shrinking. Once the window became invalid, I stopped shrinking and continued expanding the window by moving the right pointer.

This approach ensures that every valid substring is counted exactly once while traversing the string only once.

Time Complexity
O(n) — Each character is added to the window at most once and removed from the window at most once.
Space Complexity
O(1) — Only the frequencies of the three characters ('a', 'b', and 'c') and a few pointer variables are used.*/
