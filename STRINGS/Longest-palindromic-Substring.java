class Solution {
    public String getLongestPal(String s) {
        int n=s.length();
        int maxlen=0,start=0;

        for(int i=0;i<n;i++){
            int l=i,h=i;
            while(l>=0 && h<n){
                if(s.charAt(l)==s.charAt(h)){
                l--;
                h++;
                }else{
                    break;
                }
            }
           int oddlen=h-l-1;
           if(oddlen>maxlen){
            maxlen=oddlen;
            start=l+1;
           }

             l=i;
             h=i+1;
             while(l>=0 && h<n){
                if(s.charAt(l)==s.charAt(h)){
                l--;
                h++;
                }else{
                    break;
                }
            }
            int evenlen=h-l-1;
            if(evenlen>maxlen){
                maxlen=evenlen;
                start=l+1;
            }
        }
        return s.substring(start,start+maxlen);
    }
}
