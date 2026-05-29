class Solution {
     public List<Integer> generateRow(int rowNum){
        long ans=1;
        List<Integer>ansrow=new ArrayList<>();
         ansrow.add(1);
        for(int col=1;col<rowNum;col++){
            ans=ans*(rowNum-col);
            ans=ans/col;
            ansrow.add((int)ans);
        }
        return ansrow;
    }
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
       return new ArrayList<>(generateRow(n));
    }
    }
/*In this particular Pascal triangle question we are using We're just passing the row number to the helper 
function and the helper function is generating the particular row value and we are And we are generating that 
particular row for example if we send the row number as 2 we generate triangle row number two entirely for that 
we are using a hamper function in that helper function we just write the logic right We are multiplying our previous answer 
or previous element with the current row number and the column number and we get a little formula and by using that we can
generate entire row and we are just written After returning we are adding it to the resultant another list in the main function 
and after that we are asking to find another row with a row number we just again send it to the helper function and we are keep on doing this*/
