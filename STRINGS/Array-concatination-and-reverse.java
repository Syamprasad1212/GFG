class Solution {
    static String conRevstr(String s1, String s2) {
        String str=s1+s2;
        int l=0,h=str.length()-1;
        char []arr=str.toCharArray();
        while(l<h){
            char temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
        
        return new String(arr);
    }
}