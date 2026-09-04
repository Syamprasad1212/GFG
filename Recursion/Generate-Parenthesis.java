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
    
    public ArrayList<String> generateParentheses(int n) {
        ArrayList<String>ress=new ArrayList<>();
        int pair=n/2;
        check(0,0,pair,new StringBuilder(),ress);
        return ress;
    }
}
