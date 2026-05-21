class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer>pos=new ArrayList<>();
        ArrayList<Integer>neg=new ArrayList<>();
        
        for(int num:arr){
            
            if(num>=0){
                pos.add(num);
            }else{
                neg.add(num);
            }
        }
        arr.clear();
        int i=0,j=0;
        
        while(i<pos.size() && j<neg.size()){
            arr.add(pos.get(i++));
            arr.add(neg.get(j++));
        }
        
        while(i<pos.size()){
            arr.add(pos.get(i++));
        }
        
         while(j<neg.size()){
            arr.add(neg.get(j++));
        }
    }
}
/* In this problem we got some array cot containing positive and negative elements we want to rearrange it 
like that like one positive one negative in that format we have to preserve the order also so in order to do 
that we can here take a list of positive and for -2 and we just run it through the array and if 
we find any positive element we store it in the positive string builder Sorry I realist and 
if you found any negative element we just store it in negative Then later we clear the whole array Then we re accessing the array and justice
put one positive element 1 negative element like that and here zero also considered as a positive element*/
