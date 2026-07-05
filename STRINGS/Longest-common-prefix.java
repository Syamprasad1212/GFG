class Solution {
    public String longestCommonPrefix(String arr[]) {
        int n=0;
        String res="";
        Arrays.sort(arr);
        String first=arr[0];
        String last=arr[arr.length-1];
        
        if(first.length()<last.length()){
            n=first.length();
        }else{
            n=last.length();
        }
        
        for(int i=0;i<n;i++){
            if(first.charAt(i)!=last.charAt(i)){
                return res;
            }else{
                res+=first.charAt(i);
            }
        }
        return res;
    }
}
