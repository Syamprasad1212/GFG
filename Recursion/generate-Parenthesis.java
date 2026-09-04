class Solution {
    public  static void check(int openc,int closec,int n,StringBuilder cur,List<String>res){
        if(openc==n && closec==n){
            res.add(cur.toString());
            return;
        }

    if(openc<n){
        cur.append("(");
        check(openc+1,closec,n,cur,res);
        cur.deleteCharAt(cur.length()-1);
    }

    if(closec<openc){
        cur.append(")");
        check(openc,closec+1,n,cur,res);
        cur.deleteCharAt(cur.length()-1);
    }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ress=new ArrayList<>();
        check(0,0,n,new StringBuilder(),ress);
        return ress;
    }
}


/*To solve this problem, first, we create a result list in the main function and make a recursive function call starting with open = 0 and close = 0.

Inside the recursive function, we first check the base case. If both the opening parenthesis count and closing parenthesis count become equal to n, 

it means we have formed one valid combination. So, we add the current string to our result list and return.

When return is executed, the current recursive call ends and execution goes back to the previous recursive call, right after the recursive function call.

Next, we have two possible choices.

First, we can add an opening parenthesis if the number of opening parentheses used is less than n.

Second, we can add a closing parenthesis only when the number of closing parentheses is less than the number of opening parentheses. This ensures that we never create an invalid combination.

For every choice, we first add the parenthesis to our current string, make the recursive call to explore that path, and once the recursive call finishes, we delete the last character.

This deletion is the backtracking step. It restores the string to its previous state so that we can explore other possible valid combinations.

So, the overall process is:

Choose a parenthesis → Make a recursive call → Explore that path → Remove the parenthesis → Explore another possible path.

This way, we generate all possible valid combinations of parentheses without generating invalid ones.

T.C:- 4ⁿ / √n
S:C:- O(n)*/
