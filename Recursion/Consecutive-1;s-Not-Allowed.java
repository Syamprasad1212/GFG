class Solution {
    static int generateString(int n,String s,int prev){
        if(s.length()==n) return 1;
        
        int count=0;
        
        count+=generateString(n,s+"0",0);
        
        if(prev==0){
            count+=generateString(n,s+"1",1);
        }
        return count;
    }
    int countStrings(int n) {
        return generateString(n,"",0);
        
    }
}




/*Using recursion, we can solve this problem by generating all possible binary strings of length N and making sure that no two consecutive 1s occur.

Initially, we take the length N, an empty string, and a prev variable. The prev variable stores whether the previous character that we added was 0 or 1.

We start the recursion by calling:

generateString(N, "", 0);

First, we check the base condition. If the length of the current string becomes equal to N, it means we have successfully generated one valid string, so we return 1.

If the length is not N, we create a count variable and start generating possibilities.

First, we always add 0 to the current string because adding 0 is always valid. At the same time, we set prev to 0 and recursively call the function again.

The recursion keeps going deeper until the string reaches length N. When that happens, the function returns 1 to its previous recursive call. That returned value is added to the count.

After the first recursive call finishes, execution comes back to the point where that recursive call was made. Then we check:

if (prev == 0)

If the previous character was 0, we are allowed to add 1. So we recursively call the function again by adding 1 to the string and setting prev to 1.

However, if prev is already 1, we don't make this second recursive call because adding another 1 would create consecutive 1s.

This process continues until all possible valid combinations are generated.

Whenever a valid string of length N is reached, the function returns 1. These returned values are added together using:

count += generateString(...);

Finally, the total count is returned back through the recursive calls to the original function call.

For example, when N = 3, the valid strings are:

000
001
010
100
101

Therefore, the answer is 5.

The important recursion flow is:

Go deeper
   ↓
Reach length N
   ↓
return 1
   ↓
Come back to previous call
   ↓
Add returned value to count
   ↓
Try the next possible choice
   ↓
Return total count

Time Complexity: O(2ⁿ)
Space Complexity: O(n) for the recursion stack*/
