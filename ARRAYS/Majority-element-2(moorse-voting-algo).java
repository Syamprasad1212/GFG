class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        
        int count0=0,count1=0;
        int ele=0;
        int ele2=0;
        for(int i=0;i<arr.length;i++){
            if(count0==0 && arr[i]!=ele2){
                ele=arr[i];
                count0=1;
            }else if(count1==0 && arr[i]!=ele){
                    ele2=arr[i];
                    count1=1;
            }else if(arr[i]==ele){
                count0++;
            }else if(arr[i]==ele2){
                count1++;
            }else{
                count0--;
                count1--;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        int count2=0,count3=0;
        for(int i=0;i<arr.length;i++){
            if(ele==arr[i]){
                count2++;
            }
            else if(ele2==arr[i]){
                count3++;
            }
        }
        if(count2>(arr.length)/3){
            ans.add(ele);
        }
         if(count3>(arr.length)/3){
            ans.add(ele2);
        }
        
        Collections.sort(ans);
        return ans;
    
    }
}
