class Solution {
    
    public static void backtrack(ArrayList<String> res,StringBuilder curr,String s,int temp){
        if(temp==s.length()){
            res.add(curr.toString());
            return ;
        }

        curr.append(s.charAt(temp));
        backtrack(res,curr,s,temp+1);

        curr.deleteCharAt(curr.length()-1);
        backtrack(res,curr,s,temp+1);
    }
    public ArrayList<String> powerSet(String s) {
        ArrayList<String>result=new ArrayList<>();
        backtrack(result,new StringBuilder(),s,0);
        return result;
    }
}



/*First, we call the recursive helper function with the resultant list, an empty StringBuilder, the given string, and temp = 0. The StringBuilder is used to build the current subset.

At each recursive call, we have two choices for the current character. First, we include the character by appending it to the StringBuilder and make a recursive call with the next index.

After that recursive call is completed, we backtrack by deleting the last character that we added. This allows us to explore the second possibility, which is excluding the current character. We then make another recursive call with the next index.

When temp becomes equal to the length of the string, it means we have considered all the characters. At that point, we convert the current StringBuilder into a string and add it to the resultant list.

We continue this include-and-exclude process until all possible combinations are explored. Since every character has two choices — include or exclude — we get all 2ⁿ possible subsets.

Time Complexity: O(n × 2ⁿ)

There are 2ⁿ possible subsets, and converting the current StringBuilder to a String can take up to O(n) time.

Space Complexity: O(n) auxiliary space for the recursion depth and the StringBuilder.

Including the space required to store the final result, the total space complexity is O(n × 2ⁿ).*/
